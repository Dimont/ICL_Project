public class ASTPlus implements ASTNode {

ASTNode lhs, rhs;

        public int eval()
        { 
        	if(lhs==null) {
        		int v2 = rhs.eval();
        		return v2;
        	}
        	int v1 = lhs.eval();
        	int v2 = rhs.eval();
        	return v1+v2; 
        }
    
        public ASTPlus(ASTNode l, ASTNode r)
        {
        	lhs = l; rhs = r;
        }
        public ASTPlus(ASTNode r)
        {
        	rhs = r;
        }
}

