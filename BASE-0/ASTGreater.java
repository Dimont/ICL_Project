import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import valores.BoolValue;
import valores.IValue;
import valores.IntValue;
import valores.MemoryCellsValue;

public class ASTGreater extends ASTBinBOp{

	public ASTGreater(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
		// TODO Auto-generated constructor stub
	}
	/*
	@Override
	public IValue eval(Environment<IValue> env)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue v1 = lhs.eval(env);
		if(v1 instanceof MemoryCellsValue) {
			IValue v2 = rhs.eval(env);
			if(v2 instanceof IntValue) {
				return new BoolValue(((MemoryCellsValue) lhs.eval(env)).getValue() => ((IntValue) rhs.eval(env)).getValue());
			}
		}
        throw new TypeErrorException("+: argument is not an boolean.");
	}
	
	public String toString() {
		return lhs.toString() + " > " + rhs.toString();
	}*/

	@Override
	public IValue eval(Environment<IValue> env)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		// TODO Auto-generated method stub
		return null;
	}

}
