public class ASTNum implements ASTNode {

double val;

        public double eval() { return val; }

        public ASTNum(double d)
        {
        	val = d;
        }

		@Override
		public double eval(Environment e) {
			return val;
		}

		@Override
		public void compile(CodeBlock c, Environment e) {
			// TODO Auto-generated method stub
		}

}