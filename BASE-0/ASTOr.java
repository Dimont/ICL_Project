import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import valores.BoolValue;
import valores.IValue;

public class ASTOr extends ASTBinBOp{

	public ASTOr(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue v1 = lhs.eval(env);
		if(v1 instanceof BoolValue) {
			IValue v2 = rhs.eval(env);
			if(v2 instanceof BoolValue) {
				return new BoolValue(((BoolValue) lhs.eval(env)).getValue() || ((BoolValue) rhs.eval(env)).getValue());
			}
		}
        throw new TypeErrorException("+: argument is not an boolean.");
		
	}
	
	public String toString() {
    	return lhs.toString() + " || " + rhs.toString();
    }	

}
