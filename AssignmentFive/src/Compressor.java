import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class Compressor {
	static int MAX_SIZE = 4096;
	
	public static void main( String args[]) throws IOException  {
		LZWCompression compressHandler = new LZWCompression();
		
        DataInputStream in =
                new DataInputStream(
                    new BufferedInputStream(
                          new FileInputStream("src/smallWords.txt")));
        DataOutputStream out =
                new DataOutputStream(
                    new BufferedOutputStream(
                          new FileOutputStream("src/compressedWords.txt")));
        ArrayList<Character> input = new ArrayList<Character>();
        
        byte byteIn;
        // read data from file
        try {
                while(true) {
                    byteIn = in.readByte();
                    input.add((char)byteIn);
                }
            }
            catch(EOFException e) {
                    in.close();
                    
            }   
        
        // compress data
        ArrayList<Integer> temp = (compressHandler.compress(getString(input)));
        System.out.print(temp);
        
        for(int i : temp){
        	// one integer for 4 bytes
	        byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();
	
	        for (byte b : bytes) {
	           out.writeByte(b);
	        }

        }
        
        out.close();
    	
     }
	
	public static String getString(ArrayList<Character> list)
	{    
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}	
}

