
public class ASTDef implements ASTNode{
	String id;
	ASTNode val;
	
	
	public ASTDef(String id, ASTNode t1) {
		this.id = id;
		val = t1;
	}


	@Override
	public int eval(Environment e) {
		int res = 0;
		Environment env = e.beginScope();
		res = val.eval(env);
		env.assoc(id, res);
		env.endScope();
		return res;
	}


	@Override
	public void compile(CodeBlock c, Environment e) {
		val.compile(c, e);
		c.emit("");
	}
	
	
	
}
