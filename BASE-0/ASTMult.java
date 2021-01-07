import exceptions.DuplicateIdentifierException;
import exceptions.UndeclaredIdentifierException;
import valores.IValue;
import valores.IntValue;

public class ASTMult extends ASTBinOp {

	ASTNode lhs, rhs;
	
    /*public double eval()
    { 
		double v1 = lhs.eval(e);
		double v2 = rhs.eval(e);
		return v1*v2; 
	}*/


	public ASTMult(ASTNode t1, ASTNode t2) {
		super(t1, t2);
		lhs = t1; rhs = t2;
	}

	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException {
		
		return new IntValue(((IntValue) lhs.eval(e)).getValue() * ((IntValue) rhs.eval(e)).getValue());
	}
	
	public String toString() {
		return lhs.toString() + " * " + rhs.toString();
	}

	/*public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("imul");
		// TODO Auto-generated method stub
		
	}*/
}
