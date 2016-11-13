package blinenterprise;

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
            String muId = attributes.getValue("muId");
            System.out.println("");
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
        } else if (qName.equalsIgnoreCase("bpt")) {
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
            System.out.println("End Element: " + qName);
        }
    }

    @Override
    public void characters(char chars[], int start, int length) {
        if (bname) {
            System.out.println("Name: " + new String(chars, start, length));
            bname = false;
        } else if (bcolor) {
            System.out.println("Color: " + new String(chars, start, length));
            bcolor = false;
        } else if (bmanacost) {
            System.out.println("Manacost: " + new String(chars, start, length));
            bmanacost = false;
        } else if (bcmc) {
            System.out.println("CMC: " + new String(chars, start, length));
            bcmc = false;
        } else if (btype) {
            System.out.println("Type: " + new String(chars, start, length));
            btype = false;
        } else if (bpt) {
            System.out.println("P/T: " + new String(chars, start, length));
            bpt = false;
        } else if (btablerow) {
            System.out.println("Tablerow: " + new String(chars, start, length));
            btablerow = false;
        } else if (btext) {
            System.out.println("Text: " + new String(chars, start, length));
            btext = false;
        }
    }
}
