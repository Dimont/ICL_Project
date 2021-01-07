import exceptions.DuplicateIdentifierException;
import exceptions.UndeclaredIdentifierException;
import valores.BoolValue;
import valores.IValue;

public class ASTOr extends ASTBinBOp{

	public ASTOr(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException {
		// TODO Auto-generated method stub
		return new BoolValue(((BoolValue) lhs.eval(env)).getValue() || ((BoolValue) rhs.eval(env)).getValue());
	}
	
	public String toString() {
    	return lhs.toString() + " || " + rhs.toString();
    }	

}
