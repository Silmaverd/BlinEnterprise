package blinenterprise;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

public class DatabaseClient {
    
    private File xml;
    private String xmlContent;
    
    public DatabaseClient(){
        
        xml = new File("cards.xml");
        
        try {
            xmlContent = this.readFile();
        } catch (IOException ex) {
            System.out.println("ERROR: Nie przekopiowano pliku do stringa");
        }
    }
    
    private String readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (xml));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
    
    public int IdQuery(String cardname) throws IOException{
        
        String pattern_cardName = cardname+"</name>";
        String pattern_cardID = "muId=\""; 
        int int_cardIdNumber = 0;
        String str_cardIdNumber = "0";
        int indeks = 0; 
        
        Pattern regex = Pattern.compile(pattern_cardName);
        Matcher searcher = regex.matcher(xmlContent);
        
        if ( searcher.find() ) {
            while ( str_cardIdNumber.equals("0") ) {
                
                str_cardIdNumber = "";
                
                regex = Pattern.compile(pattern_cardID);
                searcher.usePattern(regex);
                searcher.find();
                indeks = searcher.end();

                while(xmlContent.charAt(indeks) != '"')
                {
                    str_cardIdNumber += xmlContent.charAt(indeks);
                    indeks++;
                }

                int_cardIdNumber = Integer.parseInt(str_cardIdNumber);  
            }
            
            return int_cardIdNumber;
            
        }else{
            System.out.println("Nothing found");
            return 0;
        }
    }
    
    public Image GetImage(int cardID) {
        Image image = null;
        try {
            URL url = new URL( "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid="+cardID+"&type=card");
            image = ImageIO.read(url);
            } catch (IOException e) {
                System.out.println("Shieeeeeeeeeeeeeeeet");
            }
        
        return image;
    }
}
