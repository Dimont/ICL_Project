import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TBool;
import valores.BoolValue;
import valores.IValue;

public class ASTWhile implements ASTNode{

	ASTNode condition, expression;
	IType condType, expType;
	
	public ASTWhile(ASTNode lhs, ASTNode rhs) {
		this.condition = lhs;
		this.expression = rhs;
	}
	
	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue finalVal = null;
		IValue finalCond = condition.eval(env);
		if(finalCond instanceof BoolValue) {
			while(((BoolValue) condition.eval(env)).getValue()) {
				finalVal = expression.eval(env);
				finalCond = condition.eval(env); 
			}
			return finalVal;
		}
		throw new TypeErrorException("Condition is not a a boolean");
	}

	@Override
	public IType typecheck(Environment<IType> environment)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IType t1 = condition.typecheck(environment);
		if(t1 instanceof TBool) {
			return expression.typecheck(environment);
		}
		throw new TypeErrorException("Condition is not a boolean.");
	}

}
