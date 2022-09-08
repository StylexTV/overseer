package net.overseer.command;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.overseer.command.argument.ArgumentList;
import net.overseer.util.exception.ExceptionUtil;

public class Command {
	
	private String name;
	
	private HashMap<CommandPreset, CommandExecutor> executors = new LinkedHashMap<>();
	
	public Command(String name) {
		this.name = name;
	}
	
	public Command addExecutor(CommandPreset preset, CommandExecutor executor) {
		executors.put(preset, executor);
		
		return this;
	}
	
	public boolean parseMessage(CommandMessage message) {
		for(CommandPreset preset : executors.keySet()) {
			
			boolean parsed = parseMessage(message, preset);
			
			if(parsed) return true;
		}
		
		return false;
	}
	
	public boolean parseMessage(CommandMessage message, CommandPreset preset) {
		return !ExceptionUtil.catchExceptions(() -> {
			
			ArgumentList arguments = preset.parseMessage(message);
			
			parseMessage(message, preset, arguments);
			
		}, (exception) -> message.setException(exception));
	}
	
	public void parseMessage(CommandMessage message, CommandPreset preset, ArgumentList arguments) {
		CommandExecutor executor = executors.get(preset);
		
		executor.execute(message, arguments);
	}
	
	public HashMap<CommandPreset, CommandExecutor> getExecutors() {
		return executors;
	}
	
	public String getName() {
		return name;
	}
	
}
