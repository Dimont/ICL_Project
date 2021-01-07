import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import valores.IValue;
import valores.IntValue;

public class ASTPlus extends ASTBinOp {

	ASTNode lhs, rhs;

    public ASTPlus(ASTNode l, ASTNode r){
        super(l, r);
    	lhs = l; rhs = r;
    }
    
    public ASTPlus(ASTNode r){
    	super(r, r);
        rhs = r;
    }

	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException {
		// TODO Auto-generated method stub
		/*int f=0;
        if(lhs==null) {
        	int v2 = rhs.eval(e);
        	f=v2;
        }
        else{
        	int v1 = lhs.eval(e);
        	int v2 = rhs.eval(e);
        	f=v1+v2;
        }*/
        return new IntValue(((IntValue) lhs.eval(e)).getValue() + ((IntValue)rhs.eval(e)).getValue());
	}
	
	public String toString() {
    	return lhs.toString() + " + " + rhs.toString();
    }
	
	/*public void compile(CodeBlock c, Environment e) {
		lhs.compile(c, e);
		rhs.compile(c, e);
		c.emit("iadd");
		// TODO Auto-generated method stub
	}*/
	
	public IType typecheck(Environment<IType> environment) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		// TODO Auto-generated method stub
		return null;
	}
}

