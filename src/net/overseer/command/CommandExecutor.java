package net.overseer.command;

import net.overseer.command.argument.ArgumentList;

@FunctionalInterface
public interface CommandExecutor {
	
	void execute(CommandMessage message, ArgumentList arguments);
	
}
