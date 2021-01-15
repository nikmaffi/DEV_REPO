package command.input.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandInputSystem {
	private InputStreamReader isr;
	private BufferedReader br;
	
	public CommandInputSystem() {
		this.isr = new InputStreamReader(System.in);
		this.br = new BufferedReader(this.isr);
	}
	
	public String getString(String inputMessage) {
		String str = null;
		
		do {
			try {
				System.out.print(inputMessage);
				str = this.br.readLine();
			} catch(Exception ex) {
				System.out.println("Error: Forbidden input!\n");
			}
		} while(str == null);
		
		return str;
	}
	
	public byte getByte(String Inputmessage) {
		byte b = 0;
		
		try {
			b = Byte.parseByte(this.getString(Inputmessage));
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			b = this.getByte(Inputmessage);
		}
		
		return b;
	}
	
	public char getChar(String InputMessage) {
		char c = 0;
		
		try {
			System.out.print(InputMessage);
			c = (char)this.br.read();
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			c = this.getChar(InputMessage);
		}
		
		return c;
	}
	
	public boolean getBoolean(String InputMessage) {
		boolean b = false;
		
		switch(this.getString(InputMessage)) {
			case "T":
			case "t":
			case "Y":
			case "y":
				b = true;
				break;
				
			case "F":
			case "f":
			case "N":
			case "n":
				b = false;
				break;
				
			default:
				System.out.println("Error: Incorrect input! Only available [t, y] for true state and [f, n] for false state.\n");
				b = this.getBoolean(InputMessage);
		}
		
		return b;
	}
	
	public short getShort(String InputMessage) {
		short s = 0;

		try {
			s = Short.parseShort(this.getString(InputMessage));
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			s = this.getShort(InputMessage);
		}
		
		return s;
	}
	
	public int getInteger(String InputMessage) {
		int i = 0;
		
		try {
			i = Integer.parseInt(this.getString(InputMessage));
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			i = this.getInteger(InputMessage);
		}
		
		return i;
	}
	
	public long getLong(String InputMessage) {
		long l = 0;
		
		try {
			l = Long.parseLong(this.getString(InputMessage));
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			l = this.getLong(InputMessage);
		}
		
		return l;
	}
	
	public float getFloat(String InputMessage) {
		float f = 0;
		
		try {
			f = Float.parseFloat(this.getString(InputMessage));
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			f = this.getFloat(InputMessage);
		}
		
		return f;
	}
	
	public double getDouble(String InputMessage) {
		double d = 0;
		
		try {
			d = Double.parseDouble(this.getString(InputMessage));
		} catch(Exception e) {
			System.out.println("Error: Incorrect input!\n");
			d = this.getDouble(InputMessage);
		}
		
		return d;
	}
}