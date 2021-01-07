package tipos;

public class TBool implements IType {

	private TBool() {}
	
	public static final TBool value = new TBool();
	
	public String toString() { 
		return "Bool"; 
	}
}
