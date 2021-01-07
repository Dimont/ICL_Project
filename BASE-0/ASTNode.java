import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import valores.IValue;

public interface ASTNode {
	
    //void compile(CodeBlock c, Environment e);
    
    IValue eval(Environment<IValue> env) 
			throws UndeclaredIdentifierException, DuplicateIdentifierException;

	IType typecheck(Environment<IType> environment) 
			throws UndeclaredIdentifierException, 
				   DuplicateIdentifierException, 
				   TypeErrorException;
}

