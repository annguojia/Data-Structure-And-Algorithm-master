package RPNCalculator;
/**
 * This class implements a parser for reverse polish notation expressions
 * using the class RPNCalc for evaluation of the expressions.
 * @author Jon Schlegel
 * @version 1.0
 */

import java.util.StringTokenizer;
import java.io.*;
public class RPNParser {
	/**
     * Given a token, determines what operation the token represents
     * and calls the appropriate method of the RPNCalc object.  If
     * the token does not represent a valid operation, prints an
     * error message.  Invalid tokens in an expression are ignored.
     * @param the_calc An initalized RPNCalc object which will
     * perform the given operation.
     * @param token A token hopefully representing an operation
     * to be performed.
     */
   public static void doOperation(RPNCalc the_calc, String token)
   {
           if (token.equals("+")) {
                           the_calc.add();
                           return;
           }
           if (token.equals("-")) {
                           the_calc.subtract();
                           return;
           }
           if (token.equals("/")) {
                           the_calc.divide();
                           return;
           }
           if (token.equals("*")) {
                           the_calc.multiply();
                           return;
           }
           if (token.equals("top")) {
                           System.out.println(the_calc.top());
                           return;
           }
           if (token.equals("quit")) {
                           System.out.println("Exiting...");
                           System.exit(0);
                           return;
           }                 
           System.out.println("Invalid token: " + token);                 
   }       

   /**
     * Continuously reads in user input until the user enters the token
     * "quit".  Valid tokens for use in an expression are: any floating
     * point number, +, -, *, /, quit (to quit the application),
     * and top (to examine the top value on the stack).  Invalid tokens
     * are ignored.
     */  
   public static void main(String[] argv)
   {
       BufferedReader input = new BufferedReader(
                                new InputStreamReader(System.in));
       RPNCalc the_calc = new RPNCalc();
       while (true)
       {
            StringTokenizer strtok = null;
            try {
                    strtok = new StringTokenizer(input.readLine(), " ");
            }
            catch (IOException i) { i.printStackTrace();
                                    break;}
            

            while (strtok.hasMoreTokens())
            {
                   String token = strtok.nextToken();
                   try {
                           float f = (new Float(token)).floatValue();
                           the_calc.number(f);
                   }
                   catch (NumberFormatException n)
                   {
                           doOperation(the_calc, token);
                   }
            }
       }
   }                    
}
