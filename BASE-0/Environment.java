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


	void	assoc(String	id,	int	val) {
		try {
			if(currentLevel.containsKey(id))
				throw new IDDeclaredTwiceException();
			
			currentLevel.put(id, val);
		} catch(IDDeclaredTwiceException e) {
			e.printStackTrace();
		}
	}


	int	find(String	id) {
		if(currentLevel.containsKey(id))
			return currentLevel.get(id);
		else return 0; 
	}


	public Environment() {
		if(s == null)
			s = new Stack<Environment>();

		currentLevel = new HashMap<String,Integer>();
	}
}
