import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LZWCompression {
	static int MAX_SIZE = 1024;
	
    public static ArrayList<Integer> compress(String rawString) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	
    	// enter all symbols into the table
        int tableSize = 256;
        Map<String,Integer> table = new HashMap<String,Integer>();
        for (int i = 0; i < 256; i++){
            table.put(Character.toString((char)i), i);
        }
        String s = "";
        
        for (char c : rawString.toCharArray()) {

            if (table.containsKey(s + c))
                s = s + c;
            else {
                ret.add(table.get(s));
                table.put(s + c, tableSize);
                tableSize++;
                s = Character.toString(c);
            }
        }
 
        // add the last char chunk to the result
        if (!s.equals(""))
            ret.add(table.get(s));
        return ret;
    }
 
    public static String deCompress(ArrayList<Integer> compressedCode) {
    	// set return buffer
    	StringBuffer ret = new StringBuffer();
    	String priorcodeword = "" + (char)(int)compressedCode.remove(0);
    	ret.append(priorcodeword);
    	
    	// enter all symbols into the table
        int tableSize = 256;
        String[] table = new String[MAX_SIZE];
        Arrays.fill(table, null);
        for (int i = 0; i < 256; i++)
        	table[i] =  "" + (char)i;
        
        
        for (int codeword : compressedCode) {
            String getString;
            if (table[codeword] == null){
            	getString = priorcodeword + priorcodeword.charAt(0);
                table[tableSize] = priorcodeword + getString.charAt(0);
                tableSize++;
            }
            else{
            	getString = table[codeword];
            	table[tableSize] = priorcodeword + getString.charAt(0);
            	tableSize++;
            }
            priorcodeword = getString;
            ret.append(getString);
            
        }
        return ret.toString();
    }
    
    public static void main(String[] args) {
    	String input = "ABABABA";
    	ArrayList<Integer> compressedWord = compress(input);
    	System.out.println("input: "+input);
        System.out.println("compressedWord: " +compressedWord);
        String decompressedWord = deCompress(compressedWord);
        System.out.println("decompressedWord: " + decompressedWord);
    }
}
