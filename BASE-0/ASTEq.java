import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TBool;
import tipos.TInt;
import valores.BoolValue;
import valores.IValue;
import valores.IntValue;

public class ASTEq implements ASTNode{

	ASTNode lhs, rhs;
	
	public ASTEq(ASTNode lhs, ASTNode rhs) {
		this.lhs=lhs;
		this.rhs=rhs;
	}
	
	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue v1 = lhs.eval(env);
		if(v1 instanceof IntValue) {
			IValue v2 = rhs.eval(env);
			if(v2 instanceof IntValue) {
				//BoolValue or IntValue ???
				return new BoolValue(((IntValue) lhs.eval(env)).getValue() == ((IntValue) rhs.eval(env)).getValue());
			}
		}
        throw new TypeErrorException("+: argument is not an integer.");
	}

	@Override
	public IType typecheck(Environment<IType> environment)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {

		IType t1 = lhs.typecheck(environment);
		IType t2 = rhs.typecheck(environment);
		if(t1==TInt.value && t2 == TInt.value) {
			return TBool.value;
		}
		else {
			throw new TypeErrorException("Expecting a number... but no.");
		}
	}
	
	public String toString() {
		return lhs.toString() + " == " + rhs.toString();
	}

}
