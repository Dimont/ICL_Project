package tipos;

public class TRef implements IType {

	final IType type;
	
	public TRef(IType type) {
		this.type = type;
	}
	
	public String toString() { return "Ref("+type+")"; }

	public IType getRefType() {
		return type;
	}
	
	public boolean equals(Object tipo) {
		if( tipo instanceof TRef ) {
			IType TipoType = ((TRef) tipo).getRefType();
			return this.type.equals(TipoType);
		} 
		else {
			return false;
		}
	}
}
