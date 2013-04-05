import java.util.*;
///////////////////////////
// Title:	P1
// Files:	Symbol.java SymbolTable.java DuplicateException.java EmptySymbolTable.java makefile
// Semester:	CS536 Spring 2013
//
// Author: 	Liang Zheng Gooi lgooi@wisc.edu
// CS Login:	gooi
// Lecturer's name:	Beck hasti
// Section:	1
//
//
//////////////////////////

/*	P1 - used to test stability of Symbol table, which includes:
 *
 *	public SymbolTable() : create an instance of list and an empty hashmap in it
 *	public void insert(String name, Symbol sym) : inseart a hash into first hashmap
 *	public void addMap() : insert new hashmap in the beginning of list
 *	public Symbol localLookup(String name) : return the symbol that fits the key in the first hashmap on the list
 *	public Symbol globalLookup(String name) : return the symbol that fits the key after found the first matching hash from the list
 *	public void removeMap() : remove the first hashmap from the list
 *	public voif print() : print the content of the list (for debugging)
 *
 * 	@author Liang Zheng Gooi
 * */

public class P1{
	public static void main (String args[]){

		SymbolTable list1 = new SymbolTable();	/**< SymbolTable list1 */

		printTestDesc("Test 1", "Inserting 10 keys and value into Symbol Table after initiation.");
		try{
			for(int i=0; i<10; i++){
				list1.insert(Integer.toString(i), new Symbol(Integer.toString(i)));
			}
			System.out.println("****SUCCESS****");
		}catch(DuplicateException ex){
			System.out.println("ERROR: There is same key in list 1.\t***FAIL***");
		}catch(EmptySymbolTableException ex){
			System.out.println("ERROR: There are no hashmap in list 1.\t***FAIL***");
		}
		list1.print();
		printTestEnd();
			
		//test for inserting without any hash
		printTestDesc("Test 2", "Inserting key and value after clearing existing hashmap in Symbol Table.");
		try{
			list1.removeMap();
			list1.insert("test1", new Symbol("ID"));
		}catch(EmptySymbolTableException ex){
			System.out.println("EXCEPTION: list 1 is empty.\t***SUCCESS***");
		}
		catch(DuplicateException ex){
			System.out.println("EXCEPTION: list already have test 1.\t***FAIL***");
		}
		printTestEnd();

		//delete multiple hashmap after initialize
		printTestDesc("Test 3", "Remove multiple hashmap after initialization.");
		SymbolTable list2 = new SymbolTable();	/**< SymbolTable list2 */
		try{
			for(int j=0; j<2; j++){
				list2.removeMap();
			}
		}catch(EmptySymbolTableException ex){
			System.out.println("EXCEPTION: remove fail in empty list\t***SUCCESS***");
		}
		printTestEnd();

		
		//search locally and globally while list is empty
		printTestDesc("Test 4", "search locally and globally while Symbol Table is empty.");
		try{
			Symbol val = list1.localLookup("1");
			if(val == null){
				System.out.println("null been successfully return for empty list for local search.\t***SUCCESS***");
			}

			val = list1.globalLookup("1");
			if(val == null){
				System.out.println("null been successfully return for empty list for global search.\t***SUCCESS***");
			}
		}catch(Exception ex){
			System.out.println("ERROR: Something wrong when searching key\t***FAIL***");
		}
		printTestEnd();

		//insert multiple hashmap
		printTestDesc("Test 5", "Insert multiple hashmap into Symbol Table.");
		try{
			for(int k=0; k<5; k++){
				list2.addMap();
			}
			System.out.println("****SUCCESS****");
		}catch(Exception ex){
			System.out.println("ERROR: fail to add hashmap\t***FAIL***");
		}
		list2.print();	
		printTestEnd();

		//clear all the hashmap in sysmbol table
		printTestDesc("Test 6", "Clear hashmap from symbol table");
		try{
			for(int l=0; l<5; l++){
				list2.removeMap();
			}
			System.out.println("****SUCCESS****");
		}catch(EmptySymbolTableException ex){
			System.out.println("ERROR: remove map does not work properly.\t***FAIL***");
		}
		printTestEnd();

		//run each functions normally
		printTestDesc("Test 7", "Run the code normally, using all the methods of symbol table");
		System.out.println("---------------------------Initialize a symbol table");
		SymbolTable list3 = new SymbolTable();
		try{
			int hash_number  = 5;
			for(int x=0; x<hash_number; x++){
				System.out.println("------------------add value");
				list3.insert("key1", new Symbol("key1"));
				System.out.println("-----------------add map");
				list3.addMap();
			}
			list3.print();
			
			//local lookup for key1
			System.out.println("------------Local look up for key1 ");
			if(list3.localLookup("key1") == null)
				System.out.println("return null\t***SUCCESS***");
			else
				System.out.println("It supposed to return null.\t ***FAIL***");

			//global lookup for key1
			System.out.println("-------------Global look up for key1");
			Symbol sym_compare = new Symbol("key1");
			if(list3.globalLookup("key1") == null)
				System.out.println("No key1 found in list3\t***FAIL***");
			else if(list3.globalLookup("key1").getType() == sym_compare.getType() )
				System.out.println("Got the symbol\t***SUCCESS***");
			else
				System.out.println("Wrong return\t***FAIL***");

			//insert key2 and symbol
			System.out.println("------------Inserting key2 and declared symbol");
			list3.insert("key2", sym_compare);
			System.out.println("------------Local look up for key2 ");

			//local lookup for key2
			if(list3.localLookup("key2") == null)
				System.out.println("No key2 found after insertion\t***FAIL***");
			else if(list3.localLookup("key2").toString() == sym_compare.toString())
				System.out.println("Correct symbol returned\t***SUCCESS***");
			else
				System.out.println("local hash does not have the key.\t ***FAIL***");
			
			//remove hashmap from list3
			System.out.println("------------Remove hashmap from head of list");
			try{
				list3.removeMap();
				
				//global lookup for key2 after remove
				System.out.println("-----------Global search for key2 after remove hashmap");
				if(list3.globalLookup("key2") == null)
					System.out.println("No key2 found\t***SUCCESS***");
				else
					System.out.println("key2 found, remove fault\t***FAIL***");

			}catch(EmptySymbolTableException ex){
				System.out.println("ERROR: list3 is empty!\t***FAIL***");
			}

		}catch(EmptySymbolTableException ex){
			System.out.println("ERROR: Empty table in normal operation.");
		}catch(DuplicateException ex){
			System.out.println("ERROR: There are duplicate in normal operation.");
		}catch(Exception ex){
			System.out.println("ERROR: unexpected other exception in normal operation");
		}
		printTestEnd();


	}

	/* Print header for each of the test.
	 * @param test The name of the test
	 * @param description The detail explaination of the test
	 * */
	public static void printTestDesc(String test, String description){
		System.out.println("========== " + test + " ==========\n" + "##" + description + "##");
	}

	/* Print the footer for each test.
	 * */
	public static void printTestEnd(){
		System.out.println("========== End ==========\n");
	}
}	
