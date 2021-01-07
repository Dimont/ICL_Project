import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import valores.IValue;

public class ASTId implements ASTNode{
	String id;
	
	public ASTId(String id) {
		this.id = id;
	}
	
	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException {
		return e.find(id);
	}

	public IType typecheck(Environment<IType> environment)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		return environment.find(id);
	}
	
	public String toString() {
		return id;
	}
	
	/*public void compile(CodeBlock c, Environment e) {
		// TODO Auto-generated method stub
	}*/
}
