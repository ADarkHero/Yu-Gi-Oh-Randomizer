/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yugiohrandomizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ADarkHero
 */
public class YuGiOhRandomizer {

    private static String path, temp;
    private static int tempInt;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file=new File("pics");
        File f[]=file.listFiles();
        
        int fileSize = f.length;
        
        String[] cards = new String[75];
        
        for(int i=0; i<75; i++){           
            tempInt=(int) (Math.random() * fileSize); 
            temp=f[tempInt].getName();
            temp = temp.substring(0, temp.length()-4);
            cards[i] = temp;
        }
        
        
        
        double name = WriteDeck(cards);
    }
    
    public static double WriteDeck(String[] cards){
        PrintWriter pWriter = null; 
        double name = 0;
        try { 
            name = Math.random()*1000;
            pWriter = new PrintWriter(new FileWriter("deck/random" + name + ".ydk")); 
            for(int i=0; i<75; i++){
                pWriter.println(cards[i]); 
                if(i==60){ pWriter.println("!side"); }
            }  
            return name;
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } finally { 
            if (pWriter != null) { 
                pWriter.flush(); 
                pWriter.close(); 
            } 
        }
        return 0;
    }
    
    
}
