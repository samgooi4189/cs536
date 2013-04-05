import java.util.*;

///////////////////////////////////////////
// Main Class File: P1.java
// File: SymbolTable.java
// Semester: CS536 Spring 2013
//
// Author: Liang Zheng Gooi lgooi@wisc.edu
// CS Login: gooi
// Lecturer's Name: Beck Hasti
//
//////////////////////////////////////////

/* Symbol Table
 * A data structure that holds the Symbol with corresponding keys and value using HashMap.
 * */

public class SymbolTable{

	private List<HashMap<String,Symbol>> tables; /**< List HashMap<String,Symbol> tables. */

	/* A constructor
	 * Create a LinkedList structure and also initiate an empty hashmap inside the list.
	 * */
	public SymbolTable(){
		tables = new LinkedList<HashMap<String, Symbol>>();
		this.addMap();
	}

	/* Insert new key and value into table
	 * @param name Key for Symbol
	 * @param sym Symbol
	 *
	 * */
	public void insert(String name, Symbol sym) throws DuplicateException, EmptySymbolTableException, NullPointerException{
		if(name == null || sym == null){
			throw new NullPointerException();
		}
		if(tables.isEmpty())
			throw new EmptySymbolTableException();
		else if(tables.get(0).containsKey(name)){
			throw new DuplicateException();
		}
		else{
			tables.get(0).put(name, sym);
		}
		

	}

	/* Initiate a new hashmap into the table
	 *
	 * */
	public void addMap(){
		tables.add(0, new HashMap<String, Symbol>());
	}

	/* Look for Symbol in the first hashmap in the table.
	 * @param name Key of the Symbol
	 * @return symbol that matched 
	 *
	 * */
	public Symbol localLookup(String name){
		if(tables.isEmpty()){
			return null;
		}
		else{
			if(tables.get(0).containsKey(name)){
				return tables.get(0).get(name);
			}
			else{
				return null;
			}
		}
	}

	/* Look for Symbol throughout all hashmap across the table
	 * @param name Key of Symbol
	 * @return the first symbol that matched in the list
	 * */
	public Symbol globalLookup(String name){
		HashMap<String, Symbol> tempHash;
		Iterator<HashMap<String, Symbol>> itr = tables.iterator();
		while(itr.hasNext()){
			tempHash = itr.next();
			if(tempHash.containsKey(name)){
				return tempHash.get(name);
			}
		}

		return null;
	}

	/* Remove the first hashmap from the table
	 * */
	public void removeMap() throws EmptySymbolTableException{
		if(tables.isEmpty()){	
			throw new EmptySymbolTableException();
		}
		
		tables.remove(0);
	}

	/* Print out the structure of this table
	 * (For debugging purposes)
	 *
	 * */
	public void print(){
		System.out.print("\nSymbol Table\n");
		HashMap<String, Symbol> hash_temp;
		Iterator<HashMap<String, Symbol>> itr = tables.iterator();
		while(itr.hasNext()){
			hash_temp = itr.next();
			System.out.println(hash_temp.toString());	
		}
		System.out.print("\n");
	}

}
