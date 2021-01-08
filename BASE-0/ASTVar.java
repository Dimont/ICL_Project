import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TRef;
import valores.IValue;
import valores.MemoryCellsValue;

public class ASTVar implements ASTNode {

	ASTNode exp;
	IType valType;
	
	public ASTVar(ASTNode lhs) {
		this.exp = lhs;
	}
	
	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue val = exp.eval(env);
		if(val instanceof MemoryCellsValue) {
			return new MemoryCellsValue(val);
		}
		throw new TypeErrorException("+: argument is not a reference.");
	}
	
	@Override
	public IType typecheck(Environment<IType> environment)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IType t1 = exp.typecheck(environment);
		this.valType = t1;
		
		return new TRef(t1);
	}
	
	public String toString() {
		return "var( " + exp.toString() + ")";
	}
	
	
}
