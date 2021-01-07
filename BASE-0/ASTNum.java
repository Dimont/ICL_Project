import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;
import tipos.IType;
import tipos.TInt;
import valores.IValue;
import valores.IntValue;

public class ASTNum implements ASTNode {

	int val;

    public ASTNum(int d){
        val = d;
    }

    public IValue eval(Environment<IValue> e) {
		return new IntValue(val);
	}

	public IType typecheck(Environment<IType> e) throws UndeclaredIdentifierException, DuplicateIdentifierException, TypeErrorException {
		return TInt.value;
	}
	
	public String toString() {
		return Integer.toString(val);
	}
	
	/*public void compile(CodeBlock c, Environment e) {
		// TODO Auto-generated method stub
	}*/

}