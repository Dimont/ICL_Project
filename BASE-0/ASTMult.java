
public class ASTMult implements ASTNode {

	ASTNode lhs, rhs;
	Environment e;
	
    public double eval()
    { 
		double v1 = lhs.eval(e);
		double v2 = rhs.eval(e);
		return v1*v2; 
	}


	public ASTMult(ASTNode t1, ASTNode t2) {
		lhs = t1; rhs = t2;
	}


	@Override
	public int eval(Environment e) {
		// TODO Auto-generated method stub
		return lhs.eval(e)*rhs.eval(e);
	}


	@Override
	public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("imul");
		// TODO Auto-generated method stub
		
	}
}
