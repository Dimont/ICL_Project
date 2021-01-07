package tipos;

public class TInt implements IType{

	private TInt() {}
	
	public static final TInt value = new TInt();
	
	public String toString() { 
		return "Int"; 
	}
}
