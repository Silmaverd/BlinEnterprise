package blinenterprise;

import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JSlider;


public class FilterCardsFrame extends javax.swing.JFrame {
    String[] cardTypes = { "Artifact", "Creature", "Enchantment", "Instant", "Land", "Planeswalker"};
    private DatabaseClient database;    
    private CardSearchFilter cardFilterMenager;
    
    public FilterCardsFrame(DatabaseClient db, Interface mainInterface) {
        initComponents();
        initializeCardPropertiesListener(db, mainInterface);
        cardFilterMenager = db.getCardFilterMenager();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        greenCardCheckBox = new javax.swing.JCheckBox();
        redCardCheckBox = new javax.swing.JCheckBox();
        whiteCardCheckBox = new javax.swing.JCheckBox();
        blackCardCheckBox = new javax.swing.JCheckBox();
        blueCardCheckBox = new javax.swing.JCheckBox();
        matchColorsExactlyRadioButton = new javax.swing.JRadioButton();
        ExcludeUnselectedColorsRadioButton = new javax.swing.JRadioButton();
        submitFiltersButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cardTypeComboBox = new javax.swing.JComboBox<>();
        convManaCostLabel = new javax.swing.JLabel();
        convManaCostComboBox = new javax.swing.JComboBox<>();
        convManaCostLabelSlider = new javax.swing.JSlider();
        showConvManaCostLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        greenCardCheckBox.setText("Green");

        redCardCheckBox.setText("Red");

        whiteCardCheckBox.setText("White");

        blackCardCheckBox.setText("Black");

        blueCardCheckBox.setText("Blue");

        matchColorsExactlyRadioButton.setText("Match Colors Exactly");

        ExcludeUnselectedColorsRadioButton.setText("Exclude Unselected Colors");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(redCardCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(whiteCardCheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(blackCardCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(blueCardCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(greenCardCheckBox)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(ExcludeUnselectedColorsRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(matchColorsExactlyRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blackCardCheckBox)
                    .addComponent(blueCardCheckBox)
                    .addComponent(greenCardCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redCardCheckBox)
                    .addComponent(whiteCardCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExcludeUnselectedColorsRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchColorsExactlyRadioButton))
        );

        submitFiltersButton.setText("submit");

        cardTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Types", "Creature", "Instant", "Sorcery", "Artifact", "Enchantment", "Land", "Planeswalker", "Tribal" }));

        convManaCostLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        convManaCostLabel.setText("Converted mana cost");

        convManaCostComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Greater Than", "Greater Equal To", "Less Than", "Less Equal To", "Equal To", "Not Equal To" }));

        convManaCostLabelSlider.setMaximum(15);
        convManaCostLabelSlider.setValue(0);
        convManaCostLabelSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                convManaCostLabelSliderStateChanged(evt);
            }
        });
        convManaCostLabelSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                convManaCostLabelSliderMouseReleased(evt);
            }
        });

        showConvManaCostLabel.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(convManaCostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(convManaCostComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(convManaCostLabelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showConvManaCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cardTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(convManaCostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(convManaCostComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(convManaCostLabelSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(showConvManaCostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(submitFiltersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitFiltersButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convManaCostLabelSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_convManaCostLabelSliderStateChanged
       showConvManaCostLabel.setText( Integer.toString(((JSlider) evt.getSource()).getValue()) );
    }//GEN-LAST:event_convManaCostLabelSliderStateChanged

    private void convManaCostLabelSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convManaCostLabelSliderMouseReleased
        cardFilterMenager.addFilter(new Filter(Filter.Commands.CONVERTEDMANACOST, 
                Integer.toString(((JSlider)evt.getSource()).getValue()), ((String) convManaCostComboBox.getSelectedItem())));
    }//GEN-LAST:event_convManaCostLabelSliderMouseReleased
    
    public void initializeCardPropertiesListener(DatabaseClient db, Interface mainInterface) {  
        /* Init Database access */
        database = db;
        
        /* Init card properties selection Listener */
        ActionListener actionListenerCardFilter = new FilterCardPropertiesActionHandler(
                blackCardCheckBox, blueCardCheckBox, greenCardCheckBox, redCardCheckBox, 
                whiteCardCheckBox, matchColorsExactlyRadioButton, 
                ExcludeUnselectedColorsRadioButton, submitFiltersButton, 
                cardTypeComboBox, database, mainInterface, this, 
                convManaCostComboBox, showConvManaCostLabel);
        
        blackCardCheckBox.addActionListener(actionListenerCardFilter);
        blueCardCheckBox.addActionListener(actionListenerCardFilter);
        greenCardCheckBox.addActionListener(actionListenerCardFilter);
        redCardCheckBox.addActionListener(actionListenerCardFilter);
        whiteCardCheckBox.addActionListener(actionListenerCardFilter);
        matchColorsExactlyRadioButton.addActionListener(actionListenerCardFilter);
        ExcludeUnselectedColorsRadioButton.addActionListener(actionListenerCardFilter);
        submitFiltersButton.addActionListener(actionListenerCardFilter);
        cardTypeComboBox.addActionListener(actionListenerCardFilter);
        convManaCostComboBox.addActionListener(actionListenerCardFilter);
    }
    
    public void removeAllFilters() {
        blackCardCheckBox.setSelected(false);
        blueCardCheckBox.setSelected(false);
        greenCardCheckBox.setSelected(false);
        redCardCheckBox.setSelected(false);
        whiteCardCheckBox.setSelected(false);
        matchColorsExactlyRadioButton.setSelected(false);
        ExcludeUnselectedColorsRadioButton.setSelected(false);
        cardTypeComboBox.setSelectedIndex(0);
        convManaCostComboBox.setSelectedIndex(0);
        convManaCostLabelSlider.setValue(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ExcludeUnselectedColorsRadioButton;
    private javax.swing.JCheckBox blackCardCheckBox;
    private javax.swing.JCheckBox blueCardCheckBox;
    private javax.swing.JComboBox<String> cardTypeComboBox;
    private javax.swing.JComboBox<String> convManaCostComboBox;
    private javax.swing.JLabel convManaCostLabel;
    private javax.swing.JSlider convManaCostLabelSlider;
    private javax.swing.JCheckBox greenCardCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton matchColorsExactlyRadioButton;
    private javax.swing.JCheckBox redCardCheckBox;
    private javax.swing.JLabel showConvManaCostLabel;
    private javax.swing.JButton submitFiltersButton;
    private javax.swing.JCheckBox whiteCardCheckBox;
    // End of variables declaration//GEN-END:variables
}
