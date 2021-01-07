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

	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, DuplicateIdentifierException {
		IValue value;
		Environment<IValue> newEnvironment = e.beginScope();
		
		for(Binding def: def) {
			IValue idVal = def.getExp().eval(e);
			newEnvironment.assoc(def.getId(), idVal);
		}
		value = exp.eval(newEnvironment);
		newEnvironment.endScope();
		return value;
		
		/*//def in
		e.beginScope();
		//shit between
		e.assoc(id, val.eval(e));
		//end
		e.endScope();		
		
		return val.eval(e);*/
	}

	/*public void compile(CodeBlock c, Environment e) {
		// TODO Auto-generated method stub
	}*/

	public IType typecheck(Environment<IType> e)
			throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		IType value;
		Environment<IType> newEnvironment = e.beginScope();
		for( Binding def: def) {
			IType idValue = def.getExp().typecheck(e);
			newEnvironment.assoc(def.getId(), idValue);
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
