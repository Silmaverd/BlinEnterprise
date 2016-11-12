package blinenterprise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseClient {
    
    private File xml;
    private String xmlContent;
    
    public DatabaseClient(){
        xml = new File("cards.xml");
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
    
    public int ImageQuery(String cardname) throws IOException{
        xmlContent = this.readFile();
        String pattern = cardname+"</name>(\\s+)(<set rarity=)(\\D)(\\w+)(\\D)( muId=)(\\D)(\\d+)(\\D)(\\s?)(\\S*)(\\s+)(<set rarity=)(\\D)(\\w+)(\\D)( muId=)(\\D)(\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher searcher = regex.matcher(xmlContent);
        //System.out.println("Regex: "+pattern);
        if (searcher.find()){
            //System.out.println("Found value: "+ searcher.group(0));
            if (Integer.parseInt(searcher.group(8)) == 0) return Integer.parseInt(searcher.group(19));//System.out.println("Card's ID: "+searcher.group(19));
            else return Integer.parseInt(searcher.group(8));//System.out.println("Card's ID: "+ searcher.group(8));
        }else{
            System.out.println("Nothing found");
            return 0;
        }
    }
}
