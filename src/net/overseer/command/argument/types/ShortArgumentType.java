package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class ShortArgumentType extends ArgumentType<Short> {
	
	@Override
	public Short parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return Short.parseShort(s);
	}
	
}
