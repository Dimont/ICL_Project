public class ASTPlus implements ASTNode {

ASTNode lhs, rhs;

        /*public double eval()
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
        }*/
    
        public ASTPlus(ASTNode l, ASTNode r)
        {
        	lhs = l; rhs = r;
        }
        public ASTPlus(ASTNode r)
        {
        	rhs = r;
        }

		@Override
		public int eval(Environment e) {
			// TODO Auto-generated method stub
			int f=0;
        	if(lhs==null) {
        		int v2 = rhs.eval(e);
        		f=v2;
        	}
        	else{
        		int v1 = lhs.eval(e);
        		int v2 = rhs.eval(e);
        		f=v1+v2;
        	}
        	return f; 
		}

		@Override
		public void compile(CodeBlock c, Environment e) {
			lhs.compile(c, e);
			rhs.compile(c, e);
			c.emit("iadd");
			// TODO Auto-generated method stub
			
		}
}

