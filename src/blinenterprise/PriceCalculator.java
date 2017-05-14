package blinenterprise;

import com.sun.javafx.fxml.builder.URLBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import jdk.internal.util.xml.impl.Input;

public class PriceCalculator {
    public PriceCalculator(){
        
    }
    
    public static String getCardPriceTCG(String cardName) throws MalformedURLException, IOException{            /// TODO
        String urlNotParsed = new String("http://shop.tcgplayer.com/magic/product/show?ProductName=" + URLEncoder.encode(cardName, "UTF-8") + "&newSearch=false&ProductType=All&IsProductNameExact=true");
        URL url = new URL(urlNotParsed);
        
        URLConnection connection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = new String("");
        String all = new String("");
        boolean breakflag = false;
        while ((line = br.readLine()) != null){
            if (breakflag) break;
            if (line.contains(">Normal</td>")) breakflag = true;
            all += line;
        }
        
        System.out.println(urlNotParsed);
        
        if (all.contains(">Normal</td>")) return "JEST";
        System.out.println(all);
        
        return "NIE MA";
    }
}
