package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class FloatArgumentType extends ArgumentType<Float> {
	
	@Override
	public Float parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return Float.parseFloat(s);
	}
	
}
