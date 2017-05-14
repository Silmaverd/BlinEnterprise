package blinenterprise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

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
        SampleHandButton.setToolTipText("Deck must be size 7 or greater to draw sample hand");
        reloadDeck(currentDeck);
    }
    
    public void reloadDeck(Deck deck){                      // Laduje nowy deck do analizowania
        try{
            currentDeck = deck;
            String[] cardListArray = currentDeck.getDeckAsArray();
            DeckList.setListData(cardListArray);
            DeckNameLabel.setText(currentDeck.getName());
            PaintManaChart(currentDeck, manaChartBackgroundPanel, "Main-deck mana chart");
            PaintTypeChart(currentDeck, typeChartBackgroundPanel, "Main-deck types chart");
            PaintManaChart(currentDeck.getSideboard(), manaChartBackgroundPanelSB, "Sideboard mana chart");
            PaintTypeChart(currentDeck.getSideboard(), typeChartBackgroundPanelSB, "Sideboard types chart");
        } catch (NullPointerException ex){
            
        }
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
        manaChartBackgroundPanel = new javax.swing.JPanel();
        typeChartBackgroundPanel = new javax.swing.JPanel();
        PriceLabel = new javax.swing.JLabel();
        typeChartBackgroundPanelSB = new javax.swing.JPanel();
        manaChartBackgroundPanelSB = new javax.swing.JPanel();
        SampleHandButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1618, 762));

        DeckList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        DeckList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DeckListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(DeckList);

        CardImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        card_description_field.setEditable(false);
        card_description_field.setColumns(20);
        card_description_field.setRows(5);
        jScrollPane2.setViewportView(card_description_field);

        ProbabilisticsButton.setText("Probalilistics calculator");
        ProbabilisticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProbabilisticsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manaChartBackgroundPanelLayout = new javax.swing.GroupLayout(manaChartBackgroundPanel);
        manaChartBackgroundPanel.setLayout(manaChartBackgroundPanelLayout);
        manaChartBackgroundPanelLayout.setHorizontalGroup(
            manaChartBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        manaChartBackgroundPanelLayout.setVerticalGroup(
            manaChartBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout typeChartBackgroundPanelLayout = new javax.swing.GroupLayout(typeChartBackgroundPanel);
        typeChartBackgroundPanel.setLayout(typeChartBackgroundPanelLayout);
        typeChartBackgroundPanelLayout.setHorizontalGroup(
            typeChartBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        typeChartBackgroundPanelLayout.setVerticalGroup(
            typeChartBackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout typeChartBackgroundPanelSBLayout = new javax.swing.GroupLayout(typeChartBackgroundPanelSB);
        typeChartBackgroundPanelSB.setLayout(typeChartBackgroundPanelSBLayout);
        typeChartBackgroundPanelSBLayout.setHorizontalGroup(
            typeChartBackgroundPanelSBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        typeChartBackgroundPanelSBLayout.setVerticalGroup(
            typeChartBackgroundPanelSBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout manaChartBackgroundPanelSBLayout = new javax.swing.GroupLayout(manaChartBackgroundPanelSB);
        manaChartBackgroundPanelSB.setLayout(manaChartBackgroundPanelSBLayout);
        manaChartBackgroundPanelSBLayout.setHorizontalGroup(
            manaChartBackgroundPanelSBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        manaChartBackgroundPanelSBLayout.setVerticalGroup(
            manaChartBackgroundPanelSBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        SampleHandButton.setText("Sample Hand");
        SampleHandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleHandButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeckNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CardImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeChartBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manaChartBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manaChartBackgroundPanelSB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeChartBackgroundPanelSB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProbabilisticsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(SampleHandButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(DeckNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(manaChartBackgroundPanelSB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CardImage, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                .addComponent(manaChartBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ProbabilisticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(SampleHandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeChartBackgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeChartBackgroundPanelSB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ProbabilisticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProbabilisticsButtonActionPerformed
        JFrame probabilisticsWindow = new Probablilistics();
        probabilisticsWindow.setVisible(true);
        ProbabilisticsButton.setEnabled(false);
        probabilisticsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        probabilisticsWindow.setTitle("MTG Deck Editor");
        probabilisticsWindow.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {}

            @Override
            public void windowClosed(WindowEvent we) {
                ProbabilisticsButton.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent we) {}

            @Override
            public void windowDeiconified(WindowEvent we) {}

            @Override
            public void windowActivated(WindowEvent we) {}

            @Override
            public void windowDeactivated(WindowEvent we) {}
        });
    }//GEN-LAST:event_ProbabilisticsButtonActionPerformed

    private void DeckListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DeckListValueChanged
        if (!evt.getValueIsAdjusting()) {//This line prevents double events
            try {
                String[] arr = DeckList.getSelectedValue().split("   ");
                if (arr.length == 1) return;
                String name = arr[1];
                Card currentCard = dbClient.getCardWithName(name);
                showCard(currentCard);
            }catch (CardNotFoundException ex) {
                
            }catch (NullPointerException ex){
                
            } catch (IOException ex) {
                Logger.getLogger(DeckAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DeckListValueChanged

    private void SampleHandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleHandButtonActionPerformed
        if (currentDeck.getSize() < 7) return;
        SampleHandFrame sampleHandWindow = new SampleHandFrame();
        sampleHandWindow.setVisible(true);
        SampleHandButton.setEnabled(false);
        sampleHandWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sampleHandWindow.setTitle("MTG Deck Editor");
        sampleHandWindow.loadDeckAndDB(currentDeck, dbClient);
        sampleHandWindow.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {}

            @Override
            public void windowClosed(WindowEvent we) {
                SampleHandButton.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent we) {}

            @Override
            public void windowDeiconified(WindowEvent we) {}

            @Override
            public void windowActivated(WindowEvent we) {}

            @Override
            public void windowDeactivated(WindowEvent we) {}
        });
    }//GEN-LAST:event_SampleHandButtonActionPerformed
    
    public void showCard(Card currentCard) throws IOException{                 // Wyswietla obrazek karty w jLabel
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
    
    public void PaintManaChart(Deck currentDeck, JPanel parent, String title){                                               // Funkcja rysuje wykres mana-costu
        int totalMC = 0, R = 0, G = 0, U = 0, B = 0, W = 0, C = 0;          // Symole reprezentujace kolory many
        Vector<CardStructure> cardsInDeck = currentDeck.getMainAsVector();
        for (CardStructure cs : cardsInDeck){                               // Zliczanie poszczegolnycb symboli many
            for(int i=0; i<cs.card.getManacost().length(); i++){
                if (cs.card.getManacost().charAt(i)== 'R') R += cs.amount;
                if (cs.card.getManacost().charAt(i)== 'G') G += cs.amount;
                if (cs.card.getManacost().charAt(i)== 'B') B += cs.amount;
                if (cs.card.getManacost().charAt(i)== 'U') U += cs.amount;
                if (cs.card.getManacost().charAt(i)== 'W') W += cs.amount;
                if (cs.card.getManacost().charAt(i)== 'C') C += cs.amount;
            }
        }
        
        totalMC = R + G + B + U + W;
        if (currentDeck.getSize() == 0) return;
        DefaultPieDataset pieSet = new DefaultPieDataset();
        pieSet.setValue("Red", R);
        pieSet.setValue("Blue", U);
        pieSet.setValue("Black", B);
        pieSet.setValue("White", W);
        pieSet.setValue("Green", G);
        pieSet.setValue("Gray", C);
        JFreeChart chart = ChartFactory.createPieChart(title, pieSet, true, true, true);
        PiePlot piePlot = (PiePlot)chart.getPlot();
        piePlot.setSectionPaint("Red", Color.RED);
        piePlot.setSectionPaint("Blue", Color.BLUE);
        piePlot.setSectionPaint("Black", Color.BLACK);
        piePlot.setSectionPaint("White", Color.YELLOW);
        piePlot.setSectionPaint("Green", Color.GREEN);
        piePlot.setSectionPaint("Gray", Color.GRAY);
        chart.setAntiAlias(true);
        chart.setBackgroundPaint(this.getBackground());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(parent.getWidth(), parent.getHeight());
        parent.setVisible(true);
        parent.removeAll();
        parent.add(chartPanel, BorderLayout.CENTER);   
        parent.setSize((int) (0.32*this.getWidth()), (int) (0.70*this.getHeight()));
    }
    
    public void PaintTypeChart(Deck currentDeck, JPanel parent, String title){
        if (currentDeck.getSize() == 0) return;
        DefaultPieDataset pieSet = new DefaultPieDataset();
        pieSet.setValue("Creature", currentDeck.getCreatures().size());
        pieSet.setValue("Instant", currentDeck.getInstants().size());
        pieSet.setValue("Sorcery", currentDeck.getSorceries().size());
        pieSet.setValue("Artifact", currentDeck.getArtifacts().size());
        pieSet.setValue("Enchantment", currentDeck.getEnchantments().size());
        pieSet.setValue("Land", currentDeck.getLands().size());
        pieSet.setValue("Planeswalker", currentDeck.getPlaneswalkers().size());
        pieSet.setValue("Other", currentDeck.getOther().size());
        JFreeChart chart = ChartFactory.createPieChart(title, pieSet, true, true, true);
        PiePlot piePlot = (PiePlot) chart.getPlot();
        chart.setAntiAlias(true);
        chart.setBackgroundPaint(this.getBackground());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(parent.getWidth(), parent.getHeight());
        parent.setVisible(true);
        parent.removeAll();
        parent.add(chartPanel, BorderLayout.CENTER);   
        parent.setSize((int) (0.32*this.getWidth()), (int) (0.70*this.getHeight()));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CardImage;
    private javax.swing.JList<String> DeckList;
    private javax.swing.JLabel DeckNameLabel;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JButton ProbabilisticsButton;
    private javax.swing.JButton SampleHandButton;
    private javax.swing.JTextArea card_description_field;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel manaChartBackgroundPanel;
    private javax.swing.JPanel manaChartBackgroundPanelSB;
    private javax.swing.JPanel typeChartBackgroundPanel;
    private javax.swing.JPanel typeChartBackgroundPanelSB;
    // End of variables declaration//GEN-END:variables
}
