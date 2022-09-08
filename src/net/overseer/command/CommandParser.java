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
	
	public void parseMessage(String message) {
		if(!isCommandMessage(message)) throw;
		
		message = message.substring(COMMAND_PREFIX_LENGTH);
		
		LogUtil.log(Formatting.WHITE + "> %s", message);
		
		String name = StringUtil.firstWord(message);
		
		Command command = getCommand(name);
		
		if(command == null) {
			
			LogUtil.logError("Command not found!");
			
			return;
		}
		
		message = StringUtil.trimFirstWord(message);
		
		MessageReader reader = new MessageReader(message);
		
		CommandMessage m = new CommandMessage(command, reader);
		
		boolean parsed = command.parseMessage(m);
		
		if(!parsed) {
			
			Exception exception = m.getException();
			
			throw exception;
			
			LogUtil.logError("Command exception occured: %s", exception);
		}
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
