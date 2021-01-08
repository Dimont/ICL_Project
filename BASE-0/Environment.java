import java.util.HashMap;
import exceptions.DuplicateIdentifierException;
import exceptions.UndeclaredIdentifierException;

public class Environment<T> {
	HashMap<String, T> currentLevel;

	Environment<T> prev;

	//push level
	Environment<T>	beginScope() {
		return new Environment<T>(this);
	}

	//pop top level
	Environment<T>	endScope() {
		return prev;
	}

	void assoc(String	id,	T val) throws DuplicateIdentifierException {
		if(currentLevel.containsKey(id))
			throw new DuplicateIdentifierException(id);

		currentLevel.put(id, val);

	}

	public T find(String id) throws UndeclaredIdentifierException {
		if(currentLevel.containsKey(id))
			return currentLevel.get(id);
		else if(prev == null)
			throw new UndeclaredIdentifierException(id);
		else
			return prev.find(id);
	}

	public Environment() {
		currentLevel = new HashMap<String,T>();

		this.prev = null;
	}

	public Environment(Environment<T> env) {
		this();
		this.prev = env;
	}

	static class Assoc<T>{
		String id;
		T val;

		Assoc(String id, T val){
			this.id = id;
			this.val = val;
		}
	}
}