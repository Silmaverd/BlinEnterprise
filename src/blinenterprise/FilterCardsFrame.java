package blinenterprise;

import java.awt.event.ActionListener;
import javax.swing.JCheckBox;


public class FilterCardsFrame extends javax.swing.JFrame {
    String[] cardTypes = { "Artifact", "Creature", "Enchantment", "Instant", "Land", "Planeswalker"};
    private DatabaseClient database;    
    
    
    public FilterCardsFrame(DatabaseClient db, Interface mainInterface) {
        initComponents();
        initializeCardPropertiesListener(db, mainInterface);
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
                        .addComponent(greenCardCheckBox))
                    .addComponent(matchColorsExactlyRadioButton)
                    .addComponent(ExcludeUnselectedColorsRadioButton))
                .addGap(0, 8, Short.MAX_VALUE))
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

        cardTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Card Type", "Artifact", "Creature", "Enchantment", "Instant", "Land", "Planeswalker" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cardTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(submitFiltersButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(submitFiltersButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void initializeCardPropertiesListener(DatabaseClient db, Interface mainInterface) {  
        /* Init Database access */
        database = db;
        
        /* Init card properties selection Listener */
        ActionListener actionListenerCardFilter = new FilterCardPropertiesActionHandler(blackCardCheckBox, 
                blueCardCheckBox, greenCardCheckBox, redCardCheckBox, 
                whiteCardCheckBox, matchColorsExactlyRadioButton, ExcludeUnselectedColorsRadioButton, submitFiltersButton, cardTypeComboBox, database, mainInterface, this);
        
        blackCardCheckBox.addActionListener(actionListenerCardFilter);
        blueCardCheckBox.addActionListener(actionListenerCardFilter);
        greenCardCheckBox.addActionListener(actionListenerCardFilter);
        redCardCheckBox.addActionListener(actionListenerCardFilter);
        whiteCardCheckBox.addActionListener(actionListenerCardFilter);
        matchColorsExactlyRadioButton.addActionListener(actionListenerCardFilter);
        ExcludeUnselectedColorsRadioButton.addActionListener(actionListenerCardFilter);
        submitFiltersButton.addActionListener(actionListenerCardFilter);
        cardTypeComboBox.addActionListener(actionListenerCardFilter);
    }
    
    public void removeAllFilters() {
        blackCardCheckBox.setSelected(false);
        blueCardCheckBox.setSelected(false);
        greenCardCheckBox.setSelected(false);
        redCardCheckBox.setSelected(false);
        whiteCardCheckBox.setSelected(false);
        matchColorsExactlyRadioButton.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ExcludeUnselectedColorsRadioButton;
    private javax.swing.JCheckBox blackCardCheckBox;
    private javax.swing.JCheckBox blueCardCheckBox;
    private javax.swing.JComboBox<String> cardTypeComboBox;
    private javax.swing.JCheckBox greenCardCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton matchColorsExactlyRadioButton;
    private javax.swing.JCheckBox redCardCheckBox;
    private javax.swing.JButton submitFiltersButton;
    private javax.swing.JCheckBox whiteCardCheckBox;
    // End of variables declaration//GEN-END:variables
}
