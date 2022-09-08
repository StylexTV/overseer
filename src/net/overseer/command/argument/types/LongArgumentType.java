package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class LongArgumentType extends ArgumentType<Long> {
	
	@Override
	public Long parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return Long.parseLong(s);
	}
	
}
