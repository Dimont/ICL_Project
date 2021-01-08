import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import valores.IValue;
import valores.IntValue;

public class ASTDiv extends ASTBinOp {

	ASTNode lhs, rhs;

	public ASTDiv(ASTNode t1, ASTNode t2) {
		super(t1, t2);
		lhs = t1; rhs = t2;
	}

	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue v1 = lhs.eval(e);
		if(v1 instanceof IntValue) {
			IValue v2 = rhs.eval(e);
			if(v2 instanceof IntValue) {
				return new IntValue(((IntValue) lhs.eval(e)).getValue() / ((IntValue) rhs.eval(e)).getValue());
			}
		}
        throw new TypeErrorException("+: argument is not an integer.");
		
	}

	/*public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("idiv");
		// TODO Auto-generated method stub
		
	}*/

}
