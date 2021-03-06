package blinenterprise;

import java.util.HashSet;

public class Card {                                         // Klasa card przechowuje parametry pojedynczej karty
    private int power, toughness, cmc;
    private String name, manacost, cardtext, cardtype;
    private HashSet<String> colors;                         // Karta moze miec wiele kolorow
    private HashSet<Integer> muIDs;                         // muID to identyfikator dostepu do bazy danych Gatherer dla uzyskania obrazka karty
    
    public Card() {
        muIDs = new HashSet<>();
        colors = new HashSet<>();
    }

    public HashSet<String> getColors() {
        return colors;
    }

    public void addColor(String color) {
        this.colors.add(color);
    }

    public HashSet<Integer> getMuIDs() {
        return muIDs;
    }

    public void addMuID(String muID) {
        try{
            muIDs.add(Integer.parseInt(muID));
        }catch (NumberFormatException exc){
            
        }
    }

    public Card(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(String power) {
        try{
            this.power = Integer.parseInt(power);
        }catch(NumberFormatException ex){
            //this.power = 0;
        }
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        try{
            this.toughness = Integer.parseInt(toughness);
        }catch(NumberFormatException ex){
            //this.toughness= 0;
        }
    }

    public int getCmc() {
        return cmc;
    }
    
    public void calculateCmc(){                                     // CMC (Converted Mana Cost) to suma kosztow many na karcie
        String manacost = this.getManacost();
        String grey = Character.toString(manacost.charAt(0));
        this.cmc = Integer.parseInt(grey) + manacost.length()-1;
    }
    
    public void setCMC(String CMC){
        try{
        this.cmc = Integer.parseInt(CMC);
        } catch (NumberFormatException exc){
            this.cmc = 0;
        }
    }
    
    public void setCMC(int CMC){
        this.cmc = CMC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManacost() {
        return manacost;
    }

    public void setManacost(String manacost) {
        this.manacost = manacost;
    }

    public String getCardtext() {
        return cardtext;
    }

    public void setCardtext(String cardtext) {
        this.cardtext = cardtext;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    } 
    
    public void printCard(){                                       // Funkcja testowa
        System.out.println("Name: " + name);
        System.out.println("MuIds: " + muIDs);
        System.out.println("Type: " + cardtype);
        System.out.println("Manacost: " + manacost);
        System.out.println("CMC: " + cmc);
        System.out.println("Colors: " + colors);
        System.out.println("P/T: " + Integer.toString(power) + " / " + Integer.toString(toughness));
        System.out.println("Text: "+cardtext);
    }
    
    public String getCardDescription(){                            // Zwraca jako string parametry karty
        return ("Name: " + name + "\n" + 
                "Type: " + cardtype + "\n" + 
                "Manacost: " + manacost + "\n" +
                "CMC: " + cmc + "\n" +
                "Colors: " + colors + "\n" +
                "P/T: " + Integer.toString(power) + " / " + Integer.toString(toughness) + "\n" + 
                "Text: "+cardtext + "\n");
    }
    public HashSet<String> getCardColors() {
        return colors;
    }
}
