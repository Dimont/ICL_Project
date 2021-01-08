import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TRef;
import valores.IValue;
import valores.IntValue;
import valores.MemoryCellsValue;

public class ASTAssign implements ASTNode {

	ASTNode lhs, rhs;
	IType valType;
	
	public ASTAssign(ASTNode lhs, ASTNode rhs)
	{
		this.lhs = lhs; this.rhs = rhs;
	}
	
	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		MemoryCellsValue mc = (MemoryCellsValue) lhs.eval(e);
		if(mc instanceof MemoryCellsValue) {
			IValue val = rhs.eval(e);
			if(val instanceof IValue) {
				mc.setValue(val);
				return val; 
			}
		}
        throw new TypeErrorException("+: argument is not an reference.");		
	}
	
    public String toString() {
    	return lhs.toString() + " := " + rhs.toString();
    }

	public IType typecheck(Environment<IType> e)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {

		TRef reftype = (TRef) lhs.typecheck(e);
		IType type = rhs.typecheck(e);
		if( reftype.getRefType().equals(type)) {
			this.valType = type;
			return type;
		}
		else
			throw new TypeErrorException("Type error on assign.");
	}
}

