package blinenterprise;

import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DeckAnalyzer extends javax.swing.JPanel {

    private Deck currentDeck;
    private DatabaseClient dbClient;
    
    public DeckAnalyzer() {
        initComponents();
        setVisible(true);
    }
    
    public void initizlize(Deck currentDeck, DatabaseClient dbClient){      // Inicjalizacja klienta bazy danych i aktualnego decku
        this.currentDeck = currentDeck;
        this.dbClient = dbClient;
        reloadDeck(currentDeck);
    }
    
    public void reloadDeck(Deck deck){                      // Laduje nowy deck do analizowania
        currentDeck = deck;
        String[] cardListArray = currentDeck.getDeckAsArray();
        DeckList.setListData(cardListArray);
        DeckNameLabel.setText(currentDeck.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DeckList = new javax.swing.JList<>();
        DeckNameLabel = new javax.swing.JLabel();
        CardImage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        card_description_field = new javax.swing.JTextArea();
        ProbabilisticsButton = new javax.swing.JButton();
        ChartPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1618, 762));

        DeckList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(DeckList);

        card_description_field.setColumns(20);
        card_description_field.setRows(5);
        jScrollPane2.setViewportView(card_description_field);

        ProbabilisticsButton.setText("Probalilistics calculator");
        ProbabilisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProbabilisticsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChartPanelLayout = new javax.swing.GroupLayout(ChartPanel);
        ChartPanel.setLayout(ChartPanelLayout);
        ChartPanelLayout.setHorizontalGroup(
            ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        ChartPanelLayout.setVerticalGroup(
            ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeckNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProbabilisticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(511, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(DeckNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ProbabilisticsButton)
                                .addGap(18, 18, 18)
                                .addComponent(ChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ProbabilisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProbabilisticsButtonActionPerformed
        JFrame probabilisticsWindow = new Probablilistics();
        probabilisticsWindow.setVisible(true);
    }//GEN-LAST:event_ProbabilisticsButtonActionPerformed

    public void showCard(Card currentCard){                 // Wyswietla obrazek karty w jLabel
        Image cardImage;
        try {
            cardImage = dbClient.GetImage(currentCard);
            ImageIcon icon = new ImageIcon(cardImage);
            JLabel cardImageContainer = CardImage;
            cardImageContainer.setIcon(icon);
            card_description_field.setText(dbClient.getCardDescription(currentCard.getName()));
        } catch (CardNotFoundException ex) {
            
        }       
    }
    
    public void PaintChart(){                                               // Funkcja rysuje wykres mana-costu
        int totalMC = 0, R = 0, G = 0, U = 0, B = 0, W = 0, C = 0;          // Symole reprezentujace kolory many
        Vector<CardStructure> cardsInDeck = currentDeck.getAllCardsAsVector();
        for (CardStructure cs : cardsInDeck){                               // Zliczanie poszczegolnycb symboli many
            for(int i=0; i<cs.card.getManacost().length(); i++){
                if (cs.card.getManacost().charAt(i)== 'R') R++;
                if (cs.card.getManacost().charAt(i)== 'G') G++;
                if (cs.card.getManacost().charAt(i)== 'B') B++;
                if (cs.card.getManacost().charAt(i)== 'U') U++;
                if (cs.card.getManacost().charAt(i)== 'W') W++;
                if (cs.card.getManacost().charAt(i)== 'C') C++;
            }
        }
        totalMC = R + G + B + U + W;
        //DefaultPieDataet pieSet = new DefaultPieDataset();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CardImage;
    private javax.swing.JPanel ChartPanel;
    private javax.swing.JList<String> DeckList;
    private javax.swing.JLabel DeckNameLabel;
    private javax.swing.JButton ProbabilisticsButton;
    private javax.swing.JTextArea card_description_field;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
