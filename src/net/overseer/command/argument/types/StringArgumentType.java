package net.overseer.command.argument.types;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class StringArgumentType extends ArgumentType<String> {
	
	@Override
	public String parseMessage(MessageReader reader) {
		String s = "";
		
		while(reader.hasNext()) {
			
			char ch = reader.next();
			
			if(Character.isWhitespace(ch)) break;
			
			s += ch;
		}
		
		return s;
	}
	
}
