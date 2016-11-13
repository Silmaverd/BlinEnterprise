package blinenterprise;

public class Card {
    private int power, toughness, cmc;
    private String name, manacost, cardtext, color, cardtype;

    public Card(String name, int power, int toughness, int cmc, String manacost, String cardtext, String color, String cardtype) {
        this.power = power;
        this.toughness = toughness;
        this.cmc = cmc;
        this.name = name;
        this.manacost = manacost;
        this.cardtext = cardtext;
        this.color = color;
        this.cardtype = cardtype;
    }

    public Card(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getCmc() {
        return cmc;
    }
    
    private void setCmc(){
        String manacost = this.getManacost();
        String grey = Character.toString(manacost.charAt(0));
        this.cmc = Integer.parseInt(grey) + manacost.length()-1;
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
        this.setCmc();
    }

    public String getCardtext() {
        return cardtext;
    }

    public void setCardtext(String cardtext) {
        this.cardtext = cardtext;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
    
    
    
    
}
