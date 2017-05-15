package blinenterprise;

import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Interface extends javax.swing.JFrame {

    private DatabaseClient dbClient;
    public Card currentCard;
    private Deck currentDeck;
    private TabbedPane deckPane;
    private TabbedPane sideboardPane;
    private JFrame filterFrame;
    
    public Interface() {
        initComponents();
        initialize();
    }

    public JList<String> getCardList() {
        return CardList;
    }

    public JTextField getCardNameInputLine() {
        return CardNameInputLine;
    }
    
    public void initialize(){
        this.setVisible(true);
        BackButton.setVisible(false);
        DeckEditorPanel.setVisible(false);
        DeckAnalyzerPane.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbClient = new DatabaseClient();
        CardList.setListData(dbClient.getCardNamesArray());
        currentCard = null;
        currentDeck = new Deck("Nowy deck", true);
        currentDeck.setIsSaved(true);
        deckPane = new TabbedPane();
        sideboardPane = new TabbedPane();
        DeckTabbedPanel.addTab("Deck", deckPane);
        DeckTabbedPanel.addTab("Sideboard", sideboardPane);
        DeckAnalyzer.initizlize(currentDeck, dbClient);
        
        initializeFilterCardsFrame();
    }
    
    public void initializeFilterCardsFrame() {
        filterFrame = new FilterCardsFrame(dbClient, this);
        filterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        filterFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                openFilterframe.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartMenu = new javax.swing.JPanel();
        DeckEditorButton = new javax.swing.JButton();
        DeckAnalyzerButton = new javax.swing.JButton();
        DeckEditorPanel = new javax.swing.JPanel();
        CardImage = new javax.swing.JLabel();
        CardNameInputLine = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        card_description_field = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        CardList = new javax.swing.JList<>();
        addCardButton = new javax.swing.JButton();
        currentDeckPanel = new javax.swing.JPanel();
        deckNameField = new javax.swing.JTextField();
        DeckTabbedPanel = new javax.swing.JTabbedPane();
        deckSizeLabel = new javax.swing.JLabel();
        sideboardSizeLabel = new javax.swing.JLabel();
        removeCardButton = new javax.swing.JButton();
        addCardToSideboardButton = new javax.swing.JButton();
        removeCardFromSideboardButton = new javax.swing.JButton();
        openFilterframe = new javax.swing.JButton();
        DeckAnalyzerPane = new javax.swing.JPanel();
        DeckAnalyzer = new blinenterprise.DeckAnalyzer();
        BackButton = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ProbabilisticsMenu = new javax.swing.JMenuItem();
        SampleHandMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();
        deckMenu = new javax.swing.JMenu();
        newDeck = new javax.swing.JMenuItem();
        saveDeck = new javax.swing.JMenuItem();
        loadDeck = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DeckEditorButton.setText("Deck Editor");
        DeckEditorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeckEditorButtonActionPerformed(evt);
            }
        });

        DeckAnalyzerButton.setText("Deck Analyzer");
        DeckAnalyzerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeckAnalyzerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StartMenuLayout = new javax.swing.GroupLayout(StartMenu);
        StartMenu.setLayout(StartMenuLayout);
        StartMenuLayout.setHorizontalGroup(
            StartMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartMenuLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(DeckEditorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 738, Short.MAX_VALUE)
                .addComponent(DeckAnalyzerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        StartMenuLayout.setVerticalGroup(
            StartMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartMenuLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(StartMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeckEditorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeckAnalyzerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(442, 442, 442))
        );

        CardImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardNameInputLine.setText("Wyszukaj kartę");
        CardNameInputLine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CardNameInputLineKeyReleased(evt);
            }
        });

        card_description_field.setEditable(false);
        card_description_field.setColumns(20);
        card_description_field.setRows(5);
        jScrollPane1.setViewportView(card_description_field);

        CardList.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        CardList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        CardList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CardListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(CardList);

        addCardButton.setText("Add");
        addCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCardButtonActionPerformed(evt);
            }
        });

        deckNameField.setText("Nowy deck");
        deckNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deckNameFieldKeyReleased(evt);
            }
        });

        deckSizeLabel.setText("Deck size:  ");

        sideboardSizeLabel.setText("Sideboard size:  ");

        javax.swing.GroupLayout currentDeckPanelLayout = new javax.swing.GroupLayout(currentDeckPanel);
        currentDeckPanel.setLayout(currentDeckPanelLayout);
        currentDeckPanelLayout.setHorizontalGroup(
            currentDeckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentDeckPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(currentDeckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeckTabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(currentDeckPanelLayout.createSequentialGroup()
                        .addComponent(deckNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(currentDeckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deckSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sideboardSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        currentDeckPanelLayout.setVerticalGroup(
            currentDeckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentDeckPanelLayout.createSequentialGroup()
                .addGroup(currentDeckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(currentDeckPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(deckNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(currentDeckPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(deckSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sideboardSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addComponent(DeckTabbedPanel))
        );

        removeCardButton.setText("Remove");
        removeCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCardButtonActionPerformed(evt);
            }
        });

        addCardToSideboardButton.setText("Add to sideboard");
        addCardToSideboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCardToSideboardButtonActionPerformed(evt);
            }
        });

        removeCardFromSideboardButton.setText("Remove from sideboard");
        removeCardFromSideboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCardFromSideboardButtonActionPerformed(evt);
            }
        });

        openFilterframe.setText("Filters");
        openFilterframe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFilterframeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeckEditorPanelLayout = new javax.swing.GroupLayout(DeckEditorPanel);
        DeckEditorPanel.setLayout(DeckEditorPanelLayout);
        DeckEditorPanelLayout.setHorizontalGroup(
            DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(CardImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addCardToSideboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeCardFromSideboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addComponent(currentDeckPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 113, Short.MAX_VALUE))
                    .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                        .addComponent(CardNameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        DeckEditorPanelLayout.setVerticalGroup(
            DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CardNameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentDeckPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                        .addComponent(openFilterframe)
                        .addGap(62, 62, 62)
                        .addComponent(addCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                                .addComponent(CardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                                .addComponent(removeCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(addCardToSideboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removeCardFromSideboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))

        );

        javax.swing.GroupLayout DeckAnalyzerPaneLayout = new javax.swing.GroupLayout(DeckAnalyzerPane);
        DeckAnalyzerPane.setLayout(DeckAnalyzerPaneLayout);
        DeckAnalyzerPaneLayout.setHorizontalGroup(
            DeckAnalyzerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckAnalyzerPaneLayout.createSequentialGroup()
                .addComponent(DeckAnalyzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        DeckAnalyzerPaneLayout.setVerticalGroup(
            DeckAnalyzerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckAnalyzerPaneLayout.createSequentialGroup()
                .addComponent(DeckAnalyzer, javax.swing.GroupLayout.PREFERRED_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
        );

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("Application");

        ProbabilisticsMenu.setText("Probabilistics");
        ProbabilisticsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProbabilisticsMenuActionPerformed(evt);
            }
        });
        jMenu1.add(ProbabilisticsMenu);

        SampleHandMenu.setText("Sample hand");
        SampleHandMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleHandMenuActionPerformed(evt);
            }
        });
        jMenu1.add(SampleHandMenu);

        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMenu);

        jMenuBar1.add(jMenu1);

        deckMenu.setText("Deck");

        newDeck.setText("New");
        newDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDeckActionPerformed(evt);
            }
        });
        deckMenu.add(newDeck);

        saveDeck.setText("Save");
        saveDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDeckActionPerformed(evt);
            }
        });
        deckMenu.add(saveDeck);

        loadDeck.setText("Load");
        loadDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDeckActionPerformed(evt);
            }
        });
        deckMenu.add(loadDeck);

        jMenuBar1.add(deckMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StartMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DeckEditorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DeckAnalyzerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1301, 1301, 1301)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(StartMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(DeckEditorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 51, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(DeckAnalyzerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 54, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(760, Short.MAX_VALUE)
                    .addComponent(BackButton)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeckEditorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeckEditorButtonActionPerformed
        StartMenu.setVisible(false);
        BackButton.setVisible(true);
        DeckEditorPanel.setVisible(true);     
    }//GEN-LAST:event_DeckEditorButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        DeckEditorPanel.setVisible(false);
        DeckAnalyzerPane.setVisible(false);
        StartMenu.setVisible(true);
        BackButton.setVisible(false);
        BackButton.setSelected(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CardListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CardListValueChanged
        if (!evt.getValueIsAdjusting()) {//This line prevents double events
            try {
                currentCard = dbClient.getCardWithName(CardList.getSelectedValue());
                showCurrentCard();
            } catch (CardNotFoundException ex) {
            
            }
        }
    }//GEN-LAST:event_CardListValueChanged

    private void CardNameInputLineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CardNameInputLineKeyReleased
        CardList.setListData(dbClient.getCardNamesArrayContaining(CardNameInputLine.getText().toLowerCase()));
    }//GEN-LAST:event_CardNameInputLineKeyReleased

    private void addCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCardButtonActionPerformed
        currentDeck.addCard(currentCard);
        deckPane.loadLists(currentDeck);
        deckSizeLabel.setText("Deck size:  "+Integer.toString(currentDeck.getSize()));
        DeckTabbedPanel.validate();
    }//GEN-LAST:event_addCardButtonActionPerformed

    private void removeCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCardButtonActionPerformed
        try {
            currentDeck.removeCard(currentCard);
            deckPane.loadLists(currentDeck);
            deckSizeLabel.setText("Deck size:  "+Integer.toString(currentDeck.getSize()));
        } catch (CardNotFoundException ex) {
            
        }
        
    }//GEN-LAST:event_removeCardButtonActionPerformed

    private void addCardToSideboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCardToSideboardButtonActionPerformed
        currentDeck.addCardToSideboard(currentCard);
        sideboardPane.loadLists(currentDeck.getSideboard());
        sideboardSizeLabel.setText("Sideboard size:  "+Integer.toString(currentDeck.getSideboardSize()));
        DeckTabbedPanel.validate();
    }//GEN-LAST:event_addCardToSideboardButtonActionPerformed

    private void removeCardFromSideboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCardFromSideboardButtonActionPerformed
        try {
            currentDeck.removeCardFromSideboard(currentCard);
            sideboardPane.loadLists(currentDeck.getSideboard());
            sideboardSizeLabel.setText("Sideboard size:  "+Integer.toString(currentDeck.getSideboardSize()));
        } catch (CardNotFoundException ex) {
            
        }
    }//GEN-LAST:event_removeCardFromSideboardButtonActionPerformed

    private void deckNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deckNameFieldKeyReleased
        currentDeck.setName(deckNameField.getText());
    }//GEN-LAST:event_deckNameFieldKeyReleased

    private void newDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDeckActionPerformed
        if (!currentDeck.getIsSaved()){
            Object[] options = {"Save", "Discard", "Cancel"};
            int n = JOptionPane.showOptionDialog(new JFrame(), "Save changes?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch(n){
                case 0:
                    try {
                        currentDeck.save();
                    } catch (IOException ex) {}
                    break;
                case 1:
                    break;
                case 2:
                    return;
            }
        }
        currentDeck.clear();
        currentDeck.setIsSaved(true);
        deckNameField.setText("New deck");
        deckSizeLabel.setText("Deck size:  0");
        sideboardSizeLabel.setText("Sideboard size:  0");
        deckPane.loadLists(currentDeck);
        sideboardPane.loadLists(currentDeck.getSideboard());
    }//GEN-LAST:event_newDeckActionPerformed

    private void saveDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDeckActionPerformed
        try {
            currentDeck.save();
        } catch (IOException ex) {
            System.out.println("shieeet");
        }
    }//GEN-LAST:event_saveDeckActionPerformed

    private void loadDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDeckActionPerformed
        try {
            currentDeck.load();
            deckPane.loadLists(currentDeck);
            sideboardPane.loadLists(currentDeck.getSideboard());
            deckNameField.setText(currentDeck.getName());
            deckSizeLabel.setText("Deck size:  " +Integer.toString(currentDeck.getSize()));
            sideboardSizeLabel.setText("Sideboard size:  " + Integer.toString(currentDeck.getSideboardSize()));
            DeckAnalyzer.reloadDeck(currentDeck);
        } catch (IOException ex) {
            
        } catch (CardNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadDeckActionPerformed

    private void DeckAnalyzerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeckAnalyzerButtonActionPerformed
        StartMenu.setVisible(false);
        BackButton.setVisible(true);
        DeckAnalyzerPane.setVisible(true);
        DeckAnalyzer.initizlize(currentDeck, dbClient);
    }//GEN-LAST:event_DeckAnalyzerButtonActionPerformed


    private void ProbabilisticsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProbabilisticsMenuActionPerformed
        JFrame probabilisticsWindow = new Probablilistics();
        probabilisticsWindow.setVisible(true);
        ProbabilisticsMenu.setEnabled(false);
        probabilisticsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        probabilisticsWindow.setTitle("MTG Deck Editor");
        probabilisticsWindow.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {}

            @Override
            public void windowClosed(WindowEvent we) {
                ProbabilisticsMenu.setEnabled(true);
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
    }//GEN-LAST:event_ProbabilisticsMenuActionPerformed

    private void SampleHandMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleHandMenuActionPerformed
        if (currentDeck.getSize() < 7) return;
        SampleHandFrame sampleHandWindow = new SampleHandFrame();
        sampleHandWindow.setVisible(true);
        SampleHandMenu.setEnabled(false);
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
                SampleHandMenu.setEnabled(true);
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
    }//GEN-LAST:event_SampleHandMenuActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        if (currentDeck == null) this.dispose();
        if (!currentDeck.getIsSaved()){                                  // Sprawdzenie, czy nie ma niezapisanych modyfikacji akualnie edytowanego decku
            Object[] options = {"Save", "Discard", "Cancel"};
            int n = JOptionPane.showOptionDialog(new JFrame(), "Save changes?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch(n){
                case 0:
                    try {
                        if (!currentDeck.save()){                                                             // Ewentualna mozliwosc zapisu
                            return;
                        }
                    } catch (IOException ex) {}
                    break;
                case 1:
                    currentDeck.clear();
                    currentDeck.getSideboard().clear();
                    break;
                case 2:
                    return;
            }         
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ExitMenuActionPerformed

    public void setCurrentCard(Card card){
        currentCard = card;
        showCurrentCard();
    }
    
    public void showCurrentCard(){
        Image cardImage;
        try {
            cardImage = dbClient.GetImage(currentCard);
            ImageIcon icon = new ImageIcon(cardImage);
            JLabel cardImageContainer = CardImage;
            cardImageContainer.setIcon(icon);
            //System.out.println(dbClient.getCardDescription(CardNameInputLine.getText()));
            card_description_field.setText(dbClient.getCardDescription(currentCard.getName()));
        } catch (CardNotFoundException ex) {
            CardNameInputLine.setText("Card not found");
        }   
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BackButton;
    private javax.swing.JLabel CardImage;
    private javax.swing.JList<String> CardList;
    private javax.swing.JTextField CardNameInputLine;
    private blinenterprise.DeckAnalyzer DeckAnalyzer;
    private javax.swing.JButton DeckAnalyzerButton;
    private javax.swing.JPanel DeckAnalyzerPane;
    private javax.swing.JButton DeckEditorButton;
    private javax.swing.JPanel DeckEditorPanel;
    private javax.swing.JTabbedPane DeckTabbedPanel;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenuItem ProbabilisticsMenu;
    private javax.swing.JMenuItem SampleHandMenu;
    private javax.swing.JPanel StartMenu;
    private javax.swing.JButton addCardButton;
    private javax.swing.JButton addCardToSideboardButton;
    private javax.swing.JTextArea card_description_field;
    private javax.swing.JPanel currentDeckPanel;
    private javax.swing.JMenu deckMenu;
    private javax.swing.JTextField deckNameField;
    private javax.swing.JLabel deckSizeLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadDeck;
    private javax.swing.JMenuItem newDeck;
    private javax.swing.JButton openFilterframe;
    private javax.swing.JButton removeCardButton;
    private javax.swing.JButton removeCardFromSideboardButton;
    private javax.swing.JMenuItem saveDeck;
    private javax.swing.JLabel sideboardSizeLabel;
    // End of variables declaration//GEN-END:variables
}
