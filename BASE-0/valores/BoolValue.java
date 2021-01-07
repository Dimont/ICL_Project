package valores;

public class BoolValue implements IValue{

	final boolean val;
	
	public BoolValue(boolean val) {
		this.val = val;
	}
	
	public boolean getValue() {
		return val;
	}
	
	public boolean equals(Object value) {
		return (value instanceof BoolValue) && ((BoolValue) value).val == this.val; 
	}
	
	public String toString() {
		return Boolean.toString(val);
	}
}
