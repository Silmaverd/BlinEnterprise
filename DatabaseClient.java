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
        
        String pattern = cardname+"</name>";
        String pattern2 = "muId=\"";
        Pattern regex = Pattern.compile(pattern);
        
        Matcher searcher = regex.matcher(xmlContent);
        int foo = 0;
        if (searcher.find()){
      
            String numer = "0";
        
            while (numer.equals("0")) {
                numer = "";
                
                regex = Pattern.compile(pattern2);
                searcher.usePattern(regex);
                searcher.find();
                int indeks = searcher.end();
                
                System.out.println(xmlContent.charAt(indeks));

                while(xmlContent.charAt(indeks) != '"')
                {
                    numer += xmlContent.charAt(indeks);
                    indeks++;
                }

                System.out.println(numer);
                foo = Integer.parseInt(numer);  
            }
            
            return foo;
        }
        else{
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
