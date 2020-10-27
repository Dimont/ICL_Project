
public class ASTMult implements ASTNode {

	ASTNode lhs, rhs;

    public int eval()
    { 
		int v1 = lhs.eval();
		int v2 = rhs.eval();
		return v1*v2; 
	}


	public ASTMult(ASTNode t1, ASTNode t2) {
		lhs = t1; rhs = t2;
	}

}
