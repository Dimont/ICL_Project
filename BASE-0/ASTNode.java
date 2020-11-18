public interface ASTNode {

    double eval(Environment e);
	
    void compile(CodeBlock c, Environment e);
}

