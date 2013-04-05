import java.util.*;

///////////////////////////////////////////
// Main Class File: P1.java
// File: Symbol.java
// Semester: CS536 Spring 2013
//
// Author: Liang Zheng Gooi lgooi@wisc.edu
// CS Login: gooi
// Lecturer's Name: Beck Hasti
//
//////////////////////////////////////////


/* Class that being use to store type of Symbol
 *
 * @author Liang Zheng Gooi
 * */

public class Symbol{
	String type;
	
	/* Constructor 
	 * @param type Type of the Symbol
	 * */
	public Symbol(String type){
		this.type = type;
	}

	/* Get the type of Symbol
	 * @return string of type
	 * */
	public String getType(){
		return type;
	}

	/* Return the string of type of the Symbol
	 * @return string of type
	 * */
	public String toString(){
		return type;
	}
}
