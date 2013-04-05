
///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  P2.java
// File           :  P2.java, Mini.jlex.java , Mini.jlex, sym.java, allTokens.out
// Semester       :  Spring 2013
//
// Instructor     :  Beck Hasti
// Author         :  Gooi Liang Zheng
// CS Login       :  gooi
//
// Pair Partner   :  Harshwardhan Newar
//     CS Login   :  harshwar
//
// Credits        :          none
//////////////////////////// 80 columns wide //////////////////////////////////




import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the Mini scanner.
 * This version is set up to test all tokens, but more code is needed to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */

/**
 * The program opens multiple test file for reading; then the program loops, calling the scanner's next_token method until the special end-of-file token is returned.
 *
 * Bugs: none known
 *
 * @author       Gooi Liang Zheng and Harsh Newar
 * @version      1.0
 * 
 */

// Class Begins
public class P2
 {

/*  
    *The program checks for test files then opens multiple test file for reading; then the program loops, calling the scanner's next_token method until the special end-of-file  token is 
    *@param args multiple file name which is being passed for testing  the tokens...
*/

    public static void main(String[] args) throws IOException 
      {
      
        CharNum.num = 1;
    
        // Check for the number of test files1
	if (args.length < 1) 
            {
        // If no file is supplied
	    System.err.println("please supply test file to be scanned.");
        // Exit if no file found
	    System.exit(-1);
	    }
        else
            {
		// Going through the test files one by one
		for(int i=0; i<args.length; i++)
                    {
                // Passing one by one each file for checking
			testAllTokens(args[i]);
                    }
	    } 
 }
// Function ends

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.txt
     * For each token read, write the corresponding string to allTokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     
     * @param arg a file name which is being passed for testing  the tokens...
     */
    private static void testAllTokens(String arg) throws IOException 
     {
	// open input file
	FileReader inFile = null;
	PrintWriter outFile = null;
     /**
       * Returns the file after testing to a .out file which contains the output else throws FileNotFoundException
      */
	try {
	    inFile = new FileReader(arg);
	    outFile = new PrintWriter(new FileWriter(arg+".out"));
	    } catch (FileNotFoundException ex) 
            {
	    System.err.println("File " + arg + " not found.");
	    System.exit(-1);
	    } catch (IOException ex)
            {
		System.err.println(arg + " cannot be opened. ------SKIPPED");
		return;
            }
   
        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
            case sym.INT:
                outFile.println("Type: INT\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.BOOL:
                outFile.println("Type: BOOL\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n"); 
                break;
            case sym.VOID:
                outFile.println("Type: VOID\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.TRUE:
                outFile.println("Type: TRUE\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.FALSE:
                outFile.println("Type: FALSE\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.IF:
                outFile.println("Type: IF\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.ELSE:
                outFile.println("Type: ELSE\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.WHILE:
                outFile.println("Type: WHILE\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RETURN:
                outFile.println("Type: RETURN\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.CIN:
                outFile.println("Type: CIN\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.COUT:
                outFile.println("Type: COUT\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.ID:
                outFile.println("Type: ID\nLineNum: " + ((IdTokenVal)token.value).linenum + "\nCharNum: " + ((IdTokenVal)token.value).charnum  
				+ "\nValue: " + ((IdTokenVal)token.value).idVal + "\n");
                break;
            case sym.INTLITERAL:  
                outFile.println("Type: INTLITERAL\nLineNum: " + ((IntLitTokenVal)token.value).linenum + "\nCharNum: " + ((IntLitTokenVal)token.value).charnum  
				+ "\nValue: " + ((IntLitTokenVal)token.value).intVal + "\n");
                break;
            case sym.STRINGLITERAL: 
                outFile.println("Type: STRINGLITERAL\nLineNum: " + ((StrLitTokenVal)token.value).linenum + "\nCharNum: " + ((StrLitTokenVal)token.value).charnum  
				+ "\nValue: " + ((StrLitTokenVal)token.value).strVal + "\n");
                break;    
            case sym.LCURLY:
                outFile.println("Type: LCURLY\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RCURLY:
                outFile.println("Type: RCURLY\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LPAREN:
                outFile.println("Type: LPAREN\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RPAREN:
                outFile.println("Type: RPAREN\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LSQBRACKET:
                outFile.println("Type: LSQBRACKET\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RSQBRACKET:
                outFile.println("Type: RSQBRACKET\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.COMMA:
                outFile.println("Type: COMMA\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.ASSIGN:
                outFile.println("Type: ASSIGN\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.SEMICOLON:
                outFile.println("Type: SEMICOLON\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.PLUS:
                outFile.println("Type: PLUS\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.MINUS:
                outFile.println("Type: MINUS\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.TIMES:
                outFile.println("Type: TIMES\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.DIVIDE:
                outFile.println("Type: DIVIDE\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.NOT:
                outFile.println("Type: NOT\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.AND:
                outFile.println("Type: AND\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.OR:
                outFile.println("Type: OR\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.EQUALS:
                outFile.println("Type: EQUALS\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.NOTEQUALS:
                outFile.println("Type: NOTEQUALS\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LESS:
                outFile.println("Type: LESS\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.GREATER:
                outFile.println("Type: GREATER\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LESSEQ:
                outFile.println("Type: LESSEQ\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.GREATEREQ:
                outFile.println("Type: GREATEREQ\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.WRITE:
                outFile.println("Type: WRITE\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.READ:
                outFile.println("Type: READ\nLineNum: " + ((TokenVal)token.value).linenum + "\nCharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            } // end switch

            token = scanner.next_token();
        } // end while
        outFile.close();
    }
}
