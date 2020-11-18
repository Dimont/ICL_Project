
public class ASTSub implements ASTNode {

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
		lhs = t1; rhs = t2;
	}
	
	public ASTSub(ASTNode t2) {
		rhs = t2;
	}


	@Override
	public double eval(Environment e) {
		// TODO Auto-generated method stub
		double f=0;
    	if(lhs==null) {
    		double v2 = rhs.eval(e);
    		f-=v2;
    	}
    	else{ 
    		double v1 = lhs.eval(e);
    		double v2 = rhs.eval(e);
    		f=v1-v2;
    	}
		return f; 
	}


	@Override
	public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("isub");
		// TODO Auto-generated method stub
		
	}

}
