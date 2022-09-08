package net.overseer.command;

import java.util.HashMap;

import net.overseer.util.text.StringUtil;

public class CommandParser {
	
	private static final String DEFAULT_COMMAND_PREFIX = "/";
	
	private String commandPrefix;
	
	private HashMap<String, Command> commands = new HashMap<>();
	
	public CommandParser() {
		this(DEFAULT_COMMAND_PREFIX);
	}
	
	// TODO option for argument name prefixes
	public CommandParser(String commandPrefix) {
		this.commandPrefix = commandPrefix;
	}
	
	public Command addCommand(String name) {
		Command command = new Command(name);
		
		return addCommand(command);
	}
	
	public Command addCommand(Command command) {
		String name = command.getName();
		
		commands.put(name, command);
		
		return command;
	}
	
	public void parseMessage(String message) throws Exception {
		message = trimCommandPrefix(message);
		
		String name = StringUtil.firstWord(message);
		
		Command command = getCommand(name);
		
		if(command == null) throw new RuntimeException("");
		
		message = StringUtil.trimFirstWord(message);
		
		MessageReader reader = new MessageReader(message);
		
		CommandMessage m = new CommandMessage(command, reader);
		
		boolean parsed = command.parseMessage(m);
		
		if(!parsed) {
			
			Exception exception = m.getException();
			
			throw exception;
		}
	}
	
	public String trimCommandPrefix(String message) {
		if(!isCommandMessage(message)) throw new RuntimeException("");
		
		int length = commandPrefix.length();
		
		return message.substring(length);
	}
	
	public boolean isCommandMessage(String message) {
		return message.startsWith(commandPrefix);
	}
	
	public Command getCommand(String name) {
		return commands.get(name);
	}
	
	public HashMap<String, Command> getCommands() {
		return commands;
	}
	
	public String getCommandPrefix() {
		return commandPrefix;
	}
	
}
