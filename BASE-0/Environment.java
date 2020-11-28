import java.util.HashMap;
import java.util.Stack;

public class Environment {

	static Stack<Environment> s;
	HashMap<String,Integer> currentLevel;

	//push level
	Environment	beginScope() {
		return s.push(new Environment());
	}


	//pop top level
	Environment	endScope() {
		s.pop();
		return s.peek();
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
		for(Environment e : s)
			if(e.currentLevel.containsKey(id)) {
				return currentLevel.get(id);
			}
		
		return 0; 
	}


	public Environment() {
		currentLevel = new HashMap<String,Integer>();
		
		if(s == null) {
			s = new Stack<Environment>();
			s.push(this);
		}
	}
}
