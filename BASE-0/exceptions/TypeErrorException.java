package exceptions;

public class TypeErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	String message; 
	
	public TypeErrorException(String message) {
		super(message);
	}
}
