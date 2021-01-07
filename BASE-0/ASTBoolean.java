import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TBool;
import valores.BoolValue;
import valores.IValue;

public class ASTBoolean implements ASTNode {

	boolean val;

    public ASTBoolean(boolean n)
    {
		val = n;
    }

	@Override
	public IValue eval(Environment<IValue> env) throws UndeclaredIdentifierException, DuplicateIdentifierException {

		return new BoolValue(val);
	}

	@Override
	public IType typecheck(Environment<IType> environment)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {

			return TBool.value;
	}

	public String toString() {
		return Boolean.toString(val);
	}
}