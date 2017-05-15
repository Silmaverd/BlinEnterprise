package blinenterprise;

import javax.swing.JList;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {                                   // Klasa jest rozszerzeniem JTabbedPane przeystosowanych do wyswietlania naszych obiektow

    private JList creatures, instants, sorceries, lands, enchantments, artifacts, planeswalkers, other;
    
    @Override
    public void validate(){
        //loadLists();
    }
    
    public void loadLists(Deck deck){                                           // Inicjaluje listy TabbedPane'u                 
        if (deck != null){
            creatures.setListData(deck.getCreatures());
            instants.setListData(deck.getInstants());
            sorceries.setListData(deck.getSorceries());
            lands.setListData(deck.getLands());
            artifacts.setListData(deck.getArtifacts());
            enchantments.setListData(deck.getEnchantments());
            planeswalkers.setListData(deck.getPlaneswalkers());
            other.setListData(deck.getOther());
        }
    }
    
    public void creatureSelected(javax.swing.event.ListSelectionEvent evt){     // Bardzo duzo fukcji wyswietlajace karty z roznych zakladek
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)creatures.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void instantSelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)instants.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void sorcerySelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)sorceries.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void landSelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)lands.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void artifactSelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)artifacts.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void enchantmentSelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)enchantments.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void planeswalkerSelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)planeswalkers.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
    
    public void otherSelected(javax.swing.event.ListSelectionEvent evt){
        try{        
            if (!evt.getValueIsAdjusting()) {//This line prevents double events
                Interface i = (Interface)this.getRootPane().getParent();
                i.setCurrentCard(((CardStructure)other.getSelectedValue()).card);
                i.showCurrentCard();
            }
        }catch (NullPointerException ex){
            
        }
    }
        
    public TabbedPane() {                                                       // Konstruktor inicjalizujacy listy dla zakladek
        super();
        this.creatures = new JList();
        creatures.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               creatureSelected(evt);
            }
        });
        this.instants = new JList();
        instants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               instantSelected(evt);
            }
        });
        this.sorceries = new JList();
        sorceries.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               sorcerySelected(evt);
            }
        });
        this.lands = new JList();
        lands.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               landSelected(evt);
            }
        });
        this.enchantments = new JList();
        enchantments.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               enchantmentSelected(evt);
            }
        });
        this.artifacts = new JList();
        artifacts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               artifactSelected(evt);
            }
        });
        this.planeswalkers = new JList();
        planeswalkers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               planeswalkerSelected(evt);
            }
        });
        this.other = new JList();
        other.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               otherSelected(evt);
            }
        });
        this.addTab("Creatures", creatures);                                    // Dodawnie zainicjowanych zakladek
        this.addTab("Instants", instants);
        this.addTab("Sorceries", sorceries);
        this.addTab("Lands", lands);
        this.addTab("Enchantments", enchantments);
        this.addTab("Artifacts", artifacts);
        this.addTab("Planeswalkers", planeswalkers);
        this.addTab("Others", other);
        
    }   
}
