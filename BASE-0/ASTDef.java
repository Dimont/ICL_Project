import java.util.ArrayList;
import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import valores.IValue;


public class ASTDef implements ASTNode{
	ArrayList<Binding> def;
	ASTNode exp;
	
	public ASTDef(ArrayList<Binding> id, ASTNode exp) {
		this.def = id;
		this.exp = exp;
	}

	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IValue value;
		Environment<IValue> newEnvironment = e.beginScope();
		//TODO: dynamic type checking
		for(Binding df: def) {
			IValue idVal = df.getExp().eval(e);
			newEnvironment.assoc(df.getId(), idVal);
		}
		value = exp.eval(newEnvironment);
		newEnvironment.endScope();
		return value;
	}

	/*public void compile(CodeBlock c, Environment e) {
		// TODO Auto-generated method stub
	}*/

	public IType typecheck(Environment<IType> e)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IType value;
		Environment<IType> newEnvironment = e.beginScope();
		for( Binding df: def) {
			IType idValue = df.getExp().typecheck(e);
			newEnvironment.assoc(df.getId(), idValue);
		}
		value = exp.typecheck(newEnvironment);
		newEnvironment.endScope();
		return value;
	}	

	public String toString() {
		String str = "";
    	for(Binding bind: def)
    		str += bind.getId() + " = " + bind.getExp().toString();
    	return "def " + str + " in " + exp.toString() + " end";
	}
}
