package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class IntegerArgumentType extends ArgumentType<Integer> {
	
	@Override
	public Integer parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return Integer.parseInt(s);
	}
	
}
