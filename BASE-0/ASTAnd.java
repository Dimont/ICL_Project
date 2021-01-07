import exceptions.DuplicateIdentifierException;
import exceptions.UndeclaredIdentifierException;
import valores.BoolValue;
import valores.IValue;

public class ASTAnd extends ASTBinBOp{
	
	public ASTAnd(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException {
		return new BoolValue(((BoolValue) lhs.eval(env)).getValue() && ((BoolValue) rhs.eval(env)).getValue());
	}
	
	public String toString() {
    	return lhs.toString() + " && " + rhs.toString();
    }
}
