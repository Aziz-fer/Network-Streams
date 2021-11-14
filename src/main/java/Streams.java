import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Streams {
   
    public boolean writeArrayToStream(byte[] data, OutputStream os) {
    	
    	 try {
			os.write(data) ;
			os.flush();
			return true ; 
		} catch (IOException e) {	
			e.printStackTrace();
			return false ; 
		} 
    
    }

    public boolean writeArrayToStream(byte[] data, int offset, int length, OutputStream os) {
    
   	 try {
			os.write(data, offset, length); 
			os.flush();
			return true  ; 
		} catch (IOException e) {
		
			e.printStackTrace();
			return false ; 
		} 
  
   }

    public boolean writeInputToOutput(InputStream is, OutputStream os)  
    {  
    	Reader reader = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(reader);
    	int input ; 
    	 try {
    		do {input = br.read() ; 
    			os.write(input);
    		}
    		while (input != -1 ) ; 
    		 return true ;
    	 }
    	 catch (IOException e) {
    			
 			e.printStackTrace();
 			return false ; 
 		} 
    }
   
   
    public boolean writeUTF8TextToStream(String text, OutputStream os) {
    	
    	
        try {
			byte arr[] = text.getBytes("UTF-8");
			 writeArrayToStream(arr,os) ; 
			 return true ;
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return false ; 
		}
       
        
    }

    public boolean writeEncodedTextToStream(String text, Charset encoding, OutputStream os) {
    	
        byte arr[] = text.getBytes(encoding);
		
        return writeArrayToStream(arr,os) ;
    }

    
    public PrintStream asPrintStream(OutputStream os) {
        PrintStream ps = new PrintStream(os) ; 
       
        return ps ; 
    }

  
    public boolean writeToPrintStream(PrintStream os, String text, InputStream is) {
    	
    	try {
            os.print(text.split(" ", 0));
            writeInputToOutput(is,os) ;
            os.flush();
        }
        catch (Exception e ) {
            System.out.println(e);
        } 
    	return true ; 
    }
    	 
    
    /**
     * List aus dem übergebenen {@link String} den Wert von <code>param2</code>. Wenn <code>param2</code> nicht gegeben
     * ist oder ein Fehler auftritt, so soll {@link Double#NaN} zurückgegeben werden. Der übergebene String enthält
     * dabei Text nach diesen Beispielen: <br>
     * <code>command --param1 text --param2 123.456 --param3 asdf</code><br>
     * <code>andererCommand --param2 123.456</code><br>
     * <code>command --param3 Einhorn</code><br>
     * <code></code> (leerer String)<br>
     * @param text Zu parsender Text
     * @return Den ausgelesenen Wert. Oder {@link Double#NaN}, wenn dieser nicht existert oder ein Fehler aufgetreten ist.
     */
    public double parseParam2(String text) {
    
    	
        return Double.NaN;
    }
    
    public BufferedReader asBufferedReader(InputStream is) {
    	Reader reader = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(reader);
    	return br ; 
    }

    /**
     * Der übergebene {@link BufferedReader} enthält pro Zeile eine Zahl (sprich ein oder mehrere Ziffern). Diese Zahlen
     * sollen aufsummiert werden und am Ende der Daten zurückgegeben werden. Das Ende der Daten wird durch die Zeile
     * <code>end</code> markiert. <br>
     * <code>1234</code><br>
     * <code>4567</code><br>
     * <code>8901</code><br>
     * <code>2345</code><br>
     * <code>end</code><br>
     * @param br Eingabe
     * @return Die Summe der gelesenen Werte. <code>0</code> bei auftreten eines Fehlers
     * @implNote Achten Sie darauf, dass die Methode keine {@link Exception} wirft, falls eine Zeile mal etwas anderes als eine Zahl oder den Text <code>end</code> enthält.
     */
    public long sum(BufferedReader br) {
    	long sum = 0 ; 
    	String num ="" ;
        
    	while (num != "end" || !(num.contains("[0-9]"))) {
          	try {
				num = br.readLine();
				sum = Long.parseLong(num)+sum;
				
			} 
          	catch (IOException e) {
				e.printStackTrace();
			}
          
          }
    	
        return sum;
    }

    /**
     * Der übergebene {@link BufferedReader} enthält pro Zeile eine Zahl (sprich ein oder mehrere Ziffern). Diese Zahlen
     * sollen aufsummiert werden und am Ende der Daten zurückgegeben werden. Das Ende der Daten wird durch die Zeile
     * <code>end</code> markiert. <br>
     * <code>Es liegen 13 Früchte im Korb.</code><br>
     * <code>Es liegen 3 Früchte im Korb.</code><br>
     * <code>Es liegen 5 Früchte im Korb.</code><br>
     * <code>Es liegen n Früchte im Korb.</code><br>
     * <code>end</code><br>
     * @param br Eingabe
     * @return Die Liste der gelesenen Werte. <code>null</code> bei einem Fehler.
     * @see java.util.ArrayList
     */
    public List<Integer> getIntList(BufferedReader br) {
    	List<Integer> wiouw =  new ArrayList<Integer> () ; 
       String num ="" ;
        int x ; 
    	while (num != "end"  ) {
          	try {
				num = br.readLine();
				char[] chars = num.toCharArray();
				for (int i=0 ; i<num.length() ; i++)
				if (chars[i].isDigit())
						{ wiouw.add(x) ; 
						
					
						}
			} 
          	catch (IOException e) {
				e.printStackTrace();
			}
          
          }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        return null;
    }
}
