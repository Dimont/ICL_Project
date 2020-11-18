public class ASTNum implements ASTNode {

double val;

        public double eval() { return val; }

        public ASTNum(double d)
        {
	   val = d;
        }

}

