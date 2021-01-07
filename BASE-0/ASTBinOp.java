import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TInt;

public abstract class ASTBinOp implements ASTNode {

	ASTNode lhs, rhs;
	
	public ASTBinOp(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public IType typecheck(Environment<IType> e) throws DuplicateIdentifierException, TypeErrorException, UndeclaredIdentifierException {
		IType t1 = lhs.typecheck(e);
		IType t2 = rhs.typecheck(e);
		if(t1==TInt.value && t2==TInt.value) {
			return TInt.value;
		}
		else {
			throw new TypeErrorException("I was expecting a number.");
		}
	}

}
