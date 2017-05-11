package blinenterprise;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler{

    boolean bname;
    boolean bmuId;
    boolean bcolor;
    boolean bmanacost;
    boolean bcmc;
    boolean btype;
    boolean bpt;
    boolean btablerow;
    boolean btext;
    Card card;
    Collection<String> muIDs;
    HashSet<Card> cards;

    public XMLHandler() {
        this.cards = new HashSet<>();
    }
    
    public HashSet<Card> getCardCollection(){
        return cards;
    }

    /**
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws org.xml.sax.SAXException
     */
    
   
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if (qName.equalsIgnoreCase("card")) {
            card = new Card();
            muIDs = new HashSet<String>();
            bmuId = true;
        } else if (qName.equalsIgnoreCase("set")) {
            String muId;
            if (attributes.getValue("muId") != null){
                muId = attributes.getValue("muId");
                //System.out.println(muId);
                card.addMuID(muId);
            }
        } else if (qName.equalsIgnoreCase("name")) {
            bname = true;
        } else if (qName.equalsIgnoreCase("color")) {
            bcolor = true;
        } else if (qName.equalsIgnoreCase("manacost")) {
            bmanacost = true;
        } else if (qName.equalsIgnoreCase("cmc")) {
            bcmc = true;
        } else if (qName.equalsIgnoreCase("type")) {
            btype = true;
        } else if (qName.equalsIgnoreCase("pt")) {
            bpt = true;
        } else if (qName.equalsIgnoreCase("tablerow")) {
            btablerow = true;
        } else if (qName.equalsIgnoreCase("text")) {
            btext = true;
        }
    }

    /**
     *
     * @param uri
     * @param localName
     * @param qName
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("card")) {
            //System.out.println(muIDs);
            cards.add(card);
            //System.out.println("End Element: " + qName);
        }
    }

    @Override
    public void characters(char chars[], int start, int length) {
        if (bname) {
                //System.out.println("Name: " + new String(chars, start, length));
                if (card != null) card.setName(new String(chars, start, length));
                bname = false;
        }else if (bcolor) {
            //System.out.println("Color: " + new String(chars, start, length));
            card.addColor(new String(chars, start, length));
            bcolor = false;
        } else if (bmanacost) {
            //System.out.println("Manacost: " + new String(chars, start, length));
            card.setManacost(new String(chars, start, length));
            bmanacost = false;
        } else if (bcmc) {
            //System.out.println("CMC: " + new String(chars, start, length));
            card.setCMC(new String(chars, start, length));
            bcmc = false;
        } else if (btype) {
            //System.out.println("Type: " + new String(chars, start, length));
            card.setCardtype(new String(chars, start, length));
            btype = false;
        } else if (bpt) {
            //System.out.println("P/T: " + new String(chars, start, length));
            String pt = new String(chars, start, length);
            String[] parts;
            parts = pt.split("/");
            card.setPower(parts[0]);
            card.setToughness(parts[1]);
            bpt = false;
        } else if (btablerow) {
            //System.out.println("Tablerow: " + new String(chars, start, length));
            btablerow = false;
        } else if (btext) {
            //System.out.println("Text: " + new String(chars, start, length));
            card.setCardtext(new String(chars, start, length));
            btext = false;
        }
    }
}
