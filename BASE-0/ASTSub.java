import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import valores.IValue;
import valores.IntValue;

public class ASTSub extends ASTBinOp {

	ASTNode lhs, rhs;

	/*
    public double eval()
    { 
    	double f=0;
    	if(lhs==null) {
    		double v2 = rhs.eval();
    		f-=v2;
    	}
    	else{ 
    		double v1 = lhs.eval();
    		double v2 = rhs.eval();
    		f=v1-v2;
    	}
		return f; 
	}*/


	public ASTSub(ASTNode t1, ASTNode t2) {
		super(t1, t2);
		lhs = t1; rhs = t2;
	}
	
	public ASTSub(ASTNode t2) {
		super(t2,t2);
		rhs = t2;
	}

	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue v1 = lhs.eval(e);
		if(v1 instanceof IntValue) {
			IValue v2 = rhs.eval(e);
			if(v2 instanceof IntValue) {
				return new IntValue(((IntValue) lhs.eval(e)).getValue() - ((IntValue) rhs.eval(e)).getValue());
			}
		}
        throw new TypeErrorException("+: argument is not an integer.");
	}
		
	
	public String toString() {
		return lhs.toString() + " - " + rhs.toString();
	}

	/*public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("isub");
	}*/

}
