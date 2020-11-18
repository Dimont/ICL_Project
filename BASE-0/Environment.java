import java.util.HashMap;
import java.util.Stack;

public class Environment {

	Stack<Environment> s;
	HashMap<String,Integer> currentLevel;
	
	//push level
	Environment	beginScope() {
		return s.push(new Environment());
	}


	//pop top level
	Environment	endScope() {
		return s.pop();
	}


	void	assoc(String	id,	int	val) throws IDDeclaredTwiceException {
		if(currentLevel.containsKey(id))
			throw new IDDeclaredTwiceException();
		currentLevel.put(id, val);
	}
	

	int	find(String	id) {
		return currentLevel.get(id);
	}


	public Environment() {
		if(s == null)
			s = new Stack<Environment>();
		
		currentLevel = new HashMap<String,Integer>();
	}
}
