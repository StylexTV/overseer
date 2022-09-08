package net.overseer;

import net.overseer.command.Command;
import net.overseer.command.CommandPreset;

public class Overseer {
	
	public static void main(String[] args) {
		Command command = new Command("goto");
		
		addExecutor(CommandPreset.ONE_INTEGER, (message, arguments) -> {
			
			int x = (int) arguments.first();
			
			System.out.println("Going to " + x);
			
		});
		
		addExecutor(CommandPreset.EMPTY, (message, arguments) -> {
			
			message.forwardTo(CommandPreset.ONE_INTEGER, DEFAULT_DISTANCE);
			
		});
		
		command.addExecutor(CommandPreset.ONE_INTEGER);
	}
	
}
