import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import exceptions.DuplicateIdentifierException;
import exceptions.UndeclaredIdentifierException;


public class Environment<T> {

	//static Stack<Environment> s;
	//HashMap<String,Integer> currentLevel;
	
	Environment<T> env;
	ArrayList<Assoc<T>> assoc;

	//push level
	Environment<T>	beginScope() {
		//return s.push(new Environment());
		return new Environment<T>(this);
	}

	//pop top level
	Environment<T>	endScope() {
		//return s.pop();
		return env;
	}

	void assoc(String	id,	T val) throws DuplicateIdentifierException{
		for(Assoc<T> asso: assoc) {
			if(asso.id.equals(id)) {
				throw new DuplicateIdentifierException(id);
			}
		}
		assoc.add(new Assoc<T>(id, val));
		
		 /*try {
			if(currentLevel.containsKey(id))
				throw new IDDeclaredTwiceException();
			
			currentLevel.put(id, val);
		} catch(IDDeclaredTwiceException e) {
			e.printStackTrace();
		}*/
	}

	public T find(String id) throws UndeclaredIdentifierException {
		Environment<T> currentLevel = this;
		while(currentLevel!=null) {
			for(Assoc<T> assoc: currentLevel.assoc) {
				if(assoc.id.equals(id)) {
					return assoc.val;
				}
			}
			currentLevel = currentLevel.env;
		}
		throw new UndeclaredIdentifierException(id);
		
		/*if(currentLevel.containsKey(id))
			return currentLevel.get(id);
		else return 0; */
	}

	public Environment() {
		/*if(s == null)
			s = new Stack<Environment>();*/
		//currentLevel = new HashMap<String,Integer>();
		
		this.env=null;
		this.assoc = new ArrayList<Assoc<T>>();
	}
	
	public Environment(Environment<T> env) {
		this();
		this.env = env;
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
