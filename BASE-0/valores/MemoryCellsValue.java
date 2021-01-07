package valores;

public class MemoryCellsValue implements IValue {
	IValue val;
	
	public MemoryCellsValue(IValue val) {
		this.val = val;
	}
	
	public IValue getValue() {
		return val;
	}
	
	public void setValue(IValue val) {
		this.val = val;
	}

	public boolean equals(Object value) {
		return this == value; 
	}
	
	public String toString() {
		return "Ref("+val.toString()+")";
	}
	
}