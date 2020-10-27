
public class ASTSub implements ASTNode {

	ASTNode lhs, rhs;

    public int eval()
    { 
    	if(lhs==null) {
    		int v2 = rhs.eval();
    		return -v2;
    	}
		int v1 = lhs.eval();
		int v2 = rhs.eval();
		return v1-v2; 
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
