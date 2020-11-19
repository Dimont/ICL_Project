
public class ASTDiv implements ASTNode {

	ASTNode lhs, rhs;

	public ASTDiv(ASTNode t1, ASTNode t2) {
		lhs = t1; rhs = t2;
	}


	@Override
	public int eval(Environment e) {
		// TODO Auto-generated method stub
		int v1 = lhs.eval(e);
    	int v2 = rhs.eval(e);
		return v1/v2; 
	}


	@Override
	public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("idiv");
		// TODO Auto-generated method stub
		
	}

}
