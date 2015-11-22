import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class DeCompressor {
	static int MAX_SIZE = 4096;
	
	public static void main( String args[]) throws IOException  {
		LZWCompression compressHandler = new LZWCompression();
		
        DataInputStream in =
                new DataInputStream(
                    new BufferedInputStream(
                          new FileInputStream("src/compressedWords.txt")));
        
        ArrayList<Character> input = new ArrayList<Character>();
        
        byte[] byteIn = new byte[4];
        int count = 0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // read data from file
        try {
                while(true) {
                	
                    byteIn[count%4] = in.readByte();
                    count++;
                    if(count>1 && count%4 == 0){
                    	temp.add(ByteBuffer.wrap(byteIn).getInt());
                    }
                }
            }
            catch(EOFException e) {
                    in.close();
                    
            }   
        
        // decompress data
        String decompressedWord = compressHandler.deCompress(temp);
        
        System.out.println(decompressedWord);
        // write decompressed content into txt file
        PrintWriter outPrinter = new PrintWriter("src/deCompressedWords.txt");
        outPrinter.println(decompressedWord);
        outPrinter.close();
        
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


