package org.starmod.api.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public enum DataType {
	INT((byte) 1), 
	LONG((byte) 2), 
	FLOAT((byte) 3), 
	STRING((byte) 4), // short len, followed by len bytes in UTF8
	BOOLEAN((byte) 5), 
	BYTE((byte) 6), 
	SHORT((byte) 7), 
	/*ARRAY((byte)2)*/; // short len, followed by len raw bytes

	private final byte numBytes;

	DataType(byte numBytes) {

		this.numBytes = numBytes;
	}

	public int getID() {

		return this.ordinal() + 1;
	}

	public int numBytes() {

		return numBytes;
	}

	public static DataType valueOf(int i) {

		if (i <= 0 || i >= values().length) {
			return INT;
		}
		return DataType.values()[i - 1];
	}

	public static void write(Object[] params, DataOutputStream out) throws IOException {

		out.write(params.length);
		for (int i = 0; i < params.length; i++) {
			Object o = params[i];
			if (o instanceof Long) {
				out.write(DataType.LONG.getID());
				out.writeLong((long) o);
			} else if (o instanceof Float) {
				out.write(DataType.FLOAT.getID());
				out.writeFloat((float) o);
			} else if (o instanceof String) {
				out.write(DataType.STRING.getID());
				out.writeUTF((String) o);
			} else if (o instanceof Boolean) {
				out.write(DataType.BOOLEAN.getID());
				out.writeBoolean((boolean) o);
			} else if (o instanceof Byte) {
				out.write(DataType.BYTE.getID());
				out.writeByte((byte) o);
			} else if (o instanceof Short) {
				out.write(DataType.SHORT.getID());
				out.writeShort((short) o);
			} /*else if (o instanceof byte[]) {
				out.write(DataType.ARRAY.getID());
				out.write((byte[]) o);
			}*/ else {
				out.write(DataType.INT.getID());
				out.writeInt((int) o);
			}
		}

	}

	public Object read(DataInputStream dis) throws IOException {

		switch (this) {
			case LONG:
				return dis.readLong();
			case FLOAT:
				return dis.readFloat();
			case STRING:
				int len = dis.readShort();
				byte[] stringData = new byte[len];
				dis.read(stringData);
				try {
					return new String(stringData, "UTF8");
				} catch (UnsupportedEncodingException ex) {
					return "";
				}
			case BOOLEAN:
				return dis.readBoolean();
			case BYTE:
				return dis.read();
			case SHORT:
				return dis.readShort();
			/*case ARRAY:
				int arrayLen = dis.readShort();
				byte[] arrayData = new byte[arrayLen];
				dis.read(arrayData);
				return arrayData;
			*/default:
			case INT:
				return dis.readInt();
		}
	}
}