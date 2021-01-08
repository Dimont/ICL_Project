import exceptions.DuplicateIdentifierException;
import exceptions.TypeErrorException;
import exceptions.UndeclaredIdentifierException;

public class Interpretador {

	@SuppressWarnings("static-access")
	public static void main(String args[]) throws TypeErrorException {
		Parser parser = new Parser(System.in);
		ASTNode exp;
		
		while(true) {
			try {
				exp=parser.Start();
				System.out.println(exp.toString() + " = " + exp.eval(new Environment()));
				
			}
			catch(ParseException ex) {
				System.out.println("Syntax Error!");
				ex.printStackTrace();
				parser.ReInit(System.in);
			}
			catch(UndeclaredIdentifierException ex) {
				System.out.println("Undeclared identifier " + ex.getId());
				parser.ReInit(System.in);
			}
			catch(DuplicateIdentifierException ex) {
				System.out.println("Duplicate Identifier " + ex.getId());
				parser.ReInit(System.in);
			}
		}
	}
}
