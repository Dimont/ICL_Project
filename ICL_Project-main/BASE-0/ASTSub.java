
public class ASTSub implements ASTNode {

	ASTNode lhs, rhs;

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
	}

    /*public ASTSub(ASTNode l, ASTNode r)
    {
    	lhs = l; rhs = r;
    }*/

	public ASTSub(ASTNode t1, ASTNode t2) {
		lhs = t1; rhs = t2;
	}
	
	public ASTSub(ASTNode t2) {
		rhs = t2;
	}

}
