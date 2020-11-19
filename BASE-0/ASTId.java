
public class ASTId implements ASTNode{
	String id;
	
	public ASTId(String id) {
		this.id = id;
	}
	
	@Override
	public int eval(Environment e) {
		return e.find(id);
	}
	
	@Override
	public void compile(CodeBlock c, Environment e) {
		// TODO Auto-generated method stub
		
	}
}
