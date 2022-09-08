package net.overseer.command.argument.types;

import java.util.UUID;

import net.overseer.command.MessageReader;
import net.overseer.command.argument.ArgumentType;

public class UUIDArgumentType extends ArgumentType<UUID> {
	
	@Override
	public UUID parseMessage(MessageReader reader) {
		String s = ArgumentType.STRING.parseMessage(reader);
		
		return java.util.UUID.fromString(s);
	}
	
}
