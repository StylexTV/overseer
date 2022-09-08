package net.overseer;

import net.overseer.command.CommandParser;
import net.overseer.command.CommandPreset;

public class Overseer {
	
	public static void main(String[] args) {
		CommandParser parser = new CommandParser();
		
		parser.addCommand("goto")
				.addExecutor(CommandPreset.ONE_INTEGER, (message, arguments) -> {
					
					int x = (int) arguments.first();
					
					System.out.println("Going to " + x);
					
				})
				.addExecutor(CommandPreset.EMPTY, (message, arguments) -> {
					
					int defaultValue = 100;
					
					message.forwardTo(CommandPreset.ONE_INTEGER, defaultValue);
					
				});
		
		try {
			
			parser.parseMessage("/goto");
			
		} catch(Exception exception) {
			
			System.err.println("An exception occured: " + exception);
			
		}
	}
	
}
