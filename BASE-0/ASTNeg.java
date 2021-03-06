import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TInt;
import valores.IValue;
import valores.IntValue;

public class ASTNeg implements ASTNode {

	ASTNode exp;
	
	public ASTNeg(ASTNode lhs) {
		this.exp = lhs;
	}
	
	@Override
	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue v1 = exp.eval(e);
		if(v1 instanceof IntValue) {
			return new IntValue(- ((IntValue) exp.eval(e)).getValue());
		}
        throw new TypeErrorException("+: argument is not an integer.");
		
	}

	@Override
	public IType typecheck(Environment<IType> e)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IType type = exp.typecheck(e);
		if(type==exp.typecheck(e)) {
			return TInt.value;
		}
		else {
			throw new TypeErrorException("A number was expected, but no.");
		}
	}
	
	public String toString() {
		return "- " + exp.toString();
	}

}
