package com.gravypod.starmadeapi.network;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StarmadePacket {
	private final String FORMAT_STRING = "Header[Type %d, Id %d, CommandID %d, CommandType %d] Parameters {%s}";
	private final Object[] parameters;
	private final short id;
	private final byte type, commandID, commandType;

	public StarmadePacket(int lenght, DataInputStream dis) throws IOException {
		this(dis.readByte(), dis.readShort(), dis.readByte(), dis.readByte(), readParameters(dis.readInt(), dis));
	}

	public StarmadePacket(byte type, short id, byte commandID, byte commandType, Object... parameters) {
		this.parameters = parameters;
		this.type = type;
		this.id = id;
		this.commandID = commandID;
		this.commandType = commandType;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public byte getCommandID() {
		return commandID;
	}

	public byte getCommandType() {
		return commandType;
	}

	public short getId() {
		return id;
	}

	public byte getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return String.format(FORMAT_STRING, getType(), getId(), getCommandID(), getCommandType(), Arrays.toString(getParameters()));
	}
	
	/**
	 * Read command parameters
	 * @param length Length of the packet.
	 * @param dis - The {@link DataInputStream} to read from.
	 * @return
	 * @throws IOException
	 */
	private static Object[] readParameters(int length, DataInputStream dis) throws IOException {
		Object[] parameters = new Object[length];
		
		for (int i = 0; i < length; i++) {
			byte paramType = dis.readByte();
			DataType dataType = DataType.valueOf(paramType);
			parameters[i] = dataType.read(dis);
		}
		return parameters;
	}

	public void send(DataOutputStream output) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.write(getType());
		dos.write(getId());
		dos.write(getCommandID());
		dos.write(getCommandType());
		DataType.write(getParameters(), dos);
		byte[] packet = os.toByteArray();
		output.writeInt(packet.length);
		output.write(packet);
		
	}

}
