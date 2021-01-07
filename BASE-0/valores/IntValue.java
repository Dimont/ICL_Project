package valores;

public class IntValue implements IValue{
	
	final int val;
	
	public IntValue(int val) {
		this.val = val;
	}
	
	public int getValue() {
		return val;
	}
	
	public boolean equals(Object value) {
		return (value instanceof IntValue) && ((IntValue) value).val == this.val; 
	}
	
	public String toString() {
		return Integer.toString(val);
	}
}
