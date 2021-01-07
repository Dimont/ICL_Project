import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TBool;

public abstract class ASTBinBOp implements ASTNode {

	ASTNode lhs, rhs;
	
	public ASTBinBOp(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public IType typecheck(Environment<IType> env) throws DuplicateIdentifierException, TypeErrorException, UndeclaredIdentifierException {
		IType t1 = lhs.typecheck(env);
		IType t2 = rhs.typecheck(env);
		
		if( t1 == TBool.value && t2 == TBool.value ) {
			return TBool.value;
		}
			
		else 
			throw new TypeErrorException("Was expecting a Boolean but no...");
	}
}
