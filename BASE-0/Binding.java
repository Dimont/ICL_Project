
public class Binding {
	private String id;
	private ASTNode exp;
	
	public Binding(String id, ASTNode exp) {
		this.id = id;
		this.exp = exp;
	}
	
	public String getId() {
		return this.id;
	}
	
	public ASTNode getExp() {
		return exp;
	}
}
