public class ASTPlus implements ASTNode {

ASTNode lhs, rhs;

        public double eval()
        { 
        	double f=0;
        	if(lhs==null) {
        		double v2 = rhs.eval();
        		f=v2;
        	}
        	else{
        		double v1 = lhs.eval();
        		double v2 = rhs.eval();
        		f=v1+v2;
        	}
        	return f; 
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

