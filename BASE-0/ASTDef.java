
public class ASTDef implements ASTNode{
	String id;
	ASTNode val;
	
	
	public ASTDef(String id, ASTNode t1) {
		this.id = id;
		val = t1;
	}


	@Override
	public int eval(Environment e) {
		e.assoc(id, val.eval(e));
		return val.eval(e);
	}


	@Override
	public void compile(CodeBlock c, Environment e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
