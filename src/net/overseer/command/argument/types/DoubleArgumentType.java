package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class DoubleArgumentType extends ArgumentType<Double> {
	
	@Override
	public Double parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return Double.parseDouble(s);
	}
	
}
