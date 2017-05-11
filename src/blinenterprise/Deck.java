package blinenterprise;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

class CardStructure{
        public Card card;
        public int amount;

        public CardStructure(Card card) {
            this.card = card;
            this.amount = 1;
        }
        
        public CardStructure(String s) throws CardNotFoundException{
            s = s.trim();
            String split[] = s.split("&");
            //System.out.println("XD" + s + "   " + Integer.toString(split.length));//+ split[0] + "   " + split[1]);
            DatabaseClient dbClient = new DatabaseClient();
            card = dbClient.getCardWithName(split[1]);
            amount = Integer.parseInt(split[0]);
        }
        
        public void add(){
            amount++;
        }
        
        public void remove(){
            amount--;
        }
        
        @Override
        public String toString(){
            return Integer.toString(amount)+"x   "+card.getName();
        }
        
        public String getSaveData(){
            return Integer.toString(amount)+"&"+card.getName()+"#"; //& rozdziela strukture karty, # rozdziela rozne struktury
        }
    }

public class Deck {
      
    private Vector<CardStructure> creatures, instants, sorceries, lands, enchantments, artifacts, planeswalkers, other;
    private String name;
    private int size;
    private String path;
    private Deck sideboard;
    private boolean isSaved;

    public Deck(String name, boolean side) {
        this.creatures = new Vector<>();
        this.instants = new Vector<>();
        this.sorceries = new Vector<>();
        this.lands = new Vector<>();
        this.enchantments = new Vector<>();
        this.artifacts = new Vector<>();
        this.planeswalkers = new Vector<>();
        this.other = new Vector<>();
        this.name = name;
        this.isSaved = false;
        this.path = null;
        this.size = 0;
        if (side == true) sideboard = new Deck("", false);
    }
    
    public void addCard(Card card){
        isSaved = false;
        if (card.getCardtype().toUpperCase().contains("INSTANT")){
            for(CardStructure cs : instants){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            instants.add(new CardStructure(card));
        }else if (card.getCardtype().toUpperCase().contains("SORCERY")){
            for(CardStructure cs : sorceries){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            sorceries.add(new CardStructure(card));
        }else if (card.getCardtype().toUpperCase().contains("LAND")){
            for(CardStructure cs : lands){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            lands.add(new CardStructure(card));
        }else if (card.getCardtype().toUpperCase().contains("CREATURE")){
            for(CardStructure cs : creatures){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            creatures.add(new CardStructure(card));
        }else if (card.getCardtype().toUpperCase().contains("ARTIFACT")){
            for(CardStructure cs : artifacts){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            artifacts.add(new CardStructure(card));
        }else if (card.getCardtype().toUpperCase().contains("ENCHANTMENT")){
            for(CardStructure cs : enchantments){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            enchantments.add(new CardStructure(card));
        }else if (card.getCardtype().toUpperCase().contains("PLANESWALKER")){
           for(CardStructure cs : planeswalkers){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            planeswalkers.add(new CardStructure(card));
        }else{
            for(CardStructure cs : other){
                if (cs.card.getName().equals(card.getName())){
                    cs.add();
                    this.size++;
                    return;
                }
            }
            other.add(new CardStructure(card));
        }
        this.size++;
    }
    
    public void clear(){
        creatures.clear();
        instants.clear();
        sorceries.clear();
        lands.clear();
        enchantments.clear();
        artifacts.clear();
        planeswalkers.clear();
        other.clear();
        size = 0;
        name = "";
        path = null;
        if (sideboard != null) sideboard.clear();
    }
    
    public void addCardToSideboard(Card card){
        sideboard.addCard(card);
        isSaved = false;
    }
    
    public int getSize(){
        int s = 0;
        if (sideboard != null) s += sideboard.getSize();
        s += size;
        return size;
    }
    
    public int getSideboardSize(){
        if (sideboard != null) return sideboard.getSize();
        else return 0;
    }
    
    public void removeCard(Card card) throws CardNotFoundException{
        isSaved = false;
        if (card.getCardtype().toUpperCase().contains("INSTANT")){
            for(CardStructure cs : instants){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) instants.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else if (card.getCardtype().toUpperCase().contains("SORCERY")){
            for(CardStructure cs : sorceries){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) sorceries.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else if (card.getCardtype().toUpperCase().contains("LAND")){
            for(CardStructure cs : lands){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) lands.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else if (card.getCardtype().toUpperCase().contains("CREATURE")){
            for(CardStructure cs : creatures){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) creatures.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else if (card.getCardtype().toUpperCase().contains("ARTIFACT")){
            for(CardStructure cs : artifacts){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) artifacts.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else if (card.getCardtype().toUpperCase().contains("ENCHANTMENT")){
            for(CardStructure cs : enchantments){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) enchantments.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else if (card.getCardtype().toUpperCase().contains("PLANESWALKER")){
           for(CardStructure cs : planeswalkers){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) planeswalkers.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }else{
            for(CardStructure cs : other){
                if (cs.card.getName().equals(card.getName())){
                    cs.remove();
                    this.size--;
                    if (cs.amount == 0) other.remove(cs);
                    return;
                }
            }
            throw new CardNotFoundException();
        }
    }

    public void removeCardFromSideboard(Card card) throws CardNotFoundException{
        this.sideboard.removeCard(card);
        isSaved = false;
    }
    
    private void writeToFile(FileWriter fw) throws IOException{
        for (CardStructure cs : creatures) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : instants) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : sorceries) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : artifacts) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : enchantments) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : planeswalkers) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : lands) fw.write(cs.getSaveData());
        fw.write("@\n");
        for (CardStructure cs : other) fw.write(cs.getSaveData());
        fw.flush();
    }
    
    public void save() throws IOException{
        if (path == null){
            int option;
            JFileChooser filechooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("ODE Files", new String[] {"ode"});
            filechooser.setFileFilter(filter);
            filechooser.setSelectedFile(new File(this.getName()+".ode"));
            option = filechooser.showSaveDialog(new JMenu());
            if (option == JFileChooser.APPROVE_OPTION){
                path = filechooser.getSelectedFile().getAbsolutePath();
            }
        }
        if (path == null) return;
        File file = new File(path);
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        writeToFile(fw);
        if (sideboard != null){
            fw.write("%");
            sideboard.writeToFile(fw);
        }
        fw.write("% \n" + name + "% \n" + Integer.toString(size) + "% \n" + Integer.toString(getSideboardSize()) + "  ");
        fw.flush();
        fw.close();
        this.isSaved = true;
    }
    
    private void loadDeck(String content) throws CardNotFoundException{
        String splitArray[] = content.split("@");
        String splitStructures[];
        splitStructures = splitArray[0].split("#");
        for (String s : splitStructures) if (s.contains("&")) creatures.add(new CardStructure(s));
        splitStructures = splitArray[1].split("#");
        for (String s : splitStructures) if (s.contains("&")) instants.add(new CardStructure(s));
        splitStructures = splitArray[2].split("#");
        for (String s : splitStructures) if (s.contains("&")) sorceries.add(new CardStructure(s));
        splitStructures = splitArray[3].split("#");
        for (String s : splitStructures) if (s.contains("&")) artifacts.add(new CardStructure(s));
        splitStructures = splitArray[4].split("#");
        for (String s : splitStructures) if (s.contains("&")) enchantments.add(new CardStructure(s));
        splitStructures = splitArray[5].split("#");
        for (String s : splitStructures) if (s.contains("&")) planeswalkers.add(new CardStructure(s));
        splitStructures = splitArray[6].split("#");
        for (String s : splitStructures) if (s.contains("&")) lands.add(new CardStructure(s));
        splitStructures = splitArray[7].split("#");
        for (String s : splitStructures) if (s.contains("&")) other.add(new CardStructure(s));
    }
    
    public void load() throws IOException, CardNotFoundException{
        if (!isSaved){
            Object[] options = {"Save", "Discard", "Cancel"};
            int n = JOptionPane.showOptionDialog(new JFrame(), "Save changes?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch(n){
                case 0:
                    save();
                    break;
                case 1:
                    break;
                case 2:
                    return;
            }         
        }
        int option;
            JFileChooser filechooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("ODE Files", new String[] {"ode"});
            filechooser.setFileFilter(filter);
            option = filechooser.showOpenDialog(new JMenu());
            if (option == JFileChooser.APPROVE_OPTION){
                path = filechooser.getSelectedFile().getAbsolutePath();
            }
        if (path == null) return;
        File file = new File(path);
        FileReader fr = new FileReader(file);
        String content = String.join("\n", Files.readAllLines(file.toPath()));
        String splitArray[] = content.split("%");
        this.clear();
        loadDeck(splitArray[0]);
        sideboard.loadDeck(splitArray[1]);
        name = splitArray[2].trim();
        size = Integer.parseInt(splitArray[3].trim());
        sideboard.size = Integer.parseInt(splitArray[4].trim());
        isSaved = true;
    }

    public Deck getSideboard() {
        return sideboard;
    }
    
    public Vector<CardStructure> getCreatures() {
        return creatures;
    }

    public Vector<CardStructure> getInstants() {
        return instants;
    }

    public Vector<CardStructure> getSorceries() {
        return sorceries;
    }

    public Vector<CardStructure> getLands() {
        return lands;
    }

    public Vector<CardStructure> getEnchantments() {
        return enchantments;
    }

    public Vector<CardStructure> getArtifacts() {
        return artifacts;
    }

    public Vector<CardStructure> getPlaneswalkers() {
        return planeswalkers;
    }

    public Vector<CardStructure> getOther() {
        return other;
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }
    
}
