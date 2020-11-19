public class ASTNum implements ASTNode {

int val;

        public ASTNum(int d)
        {
        	val = d;
        }

		@Override
		public int eval(Environment e) {
			return val;
		}

		@Override
		public void compile(CodeBlock c, Environment e) {
			// TODO Auto-generated method stub
		}

}