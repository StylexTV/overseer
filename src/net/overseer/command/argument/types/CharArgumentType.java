package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class CharArgumentType extends ArgumentType<Character> {
	
	@Override
	public Character parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		int length = s.length();
		
		if(length != 1) throw new IllegalArgumentException(); // TODO add exception message
		
		return s.charAt(0);
	}
	
}
