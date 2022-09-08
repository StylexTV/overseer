package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class BooleanArgumentType extends ArgumentType<Boolean> {
	
	@Override
	public Boolean parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return Boolean.parseBoolean(s);
	}
	
}
