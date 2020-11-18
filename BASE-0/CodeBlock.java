import java.io.PrintStream;

public class CodeBlock {
	

	String code[];
	int pos;
	
	public CodeBlock(){
		pos=0;
	}
		
	void emit(String bytecode) {
		code[pos] = bytecode;
		pos++;
	}
	
	void dump(PrintStream f) {
		
	}
}
