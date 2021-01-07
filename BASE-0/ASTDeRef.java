import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TRef;
import valores.IValue;
import valores.MemoryCellsValue;

public class ASTDeRef implements ASTNode{

	ASTNode exp;
	IType valType;
	
	public ASTDeRef(ASTNode exp) {
		this.exp = exp;
	}
	
	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException {
		MemoryCellsValue mcv = (MemoryCellsValue) exp.eval(env);
		return mcv.getValue();
	}
	@Override
	public IType typecheck(Environment<IType> environment)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {

		IType t1 = exp.typecheck(environment);
		if(t1 instanceof TRef) {
			this.valType=((TRef) t1).getRefType();
			return this.valType;
		}
		else {
			throw new TypeErrorException("You are trying to deref a non-ref value.");
		}
	}
	
	public String toString() {
		return "*" + exp.toString();
	}
	
}
