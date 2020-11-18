
public class ASTDiv implements ASTNode {

	ASTNode lhs, rhs;

    public double eval()
    { 
    	double v1 = lhs.eval();
    	double v2 = rhs.eval();
		return v1/v2; 
	}


	public ASTDiv(ASTNode t1, ASTNode t2) {
		lhs = t1; rhs = t2;
	}

}
