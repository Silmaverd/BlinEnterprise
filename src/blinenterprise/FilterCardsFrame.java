package blinenterprise;

import java.awt.event.ActionListener;
import javax.swing.JCheckBox;


public class FilterCardsFrame extends javax.swing.JFrame {
            
    public FilterCardsFrame(DatabaseClient db) {
        initComponents();
        initializeCardPropertiesListener(db);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        greenCardCheckBox = new javax.swing.JCheckBox();
        redCardCheckBox = new javax.swing.JCheckBox();
        whiteCardCheckBox = new javax.swing.JCheckBox();
        colorlessCardCheckBox = new javax.swing.JCheckBox();
        blackCardCheckBox = new javax.swing.JCheckBox();
        blueCardCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        greenCardCheckBox.setText("Zielony");

        redCardCheckBox.setText("Czerwony");

        whiteCardCheckBox.setText("Biały");

        colorlessCardCheckBox.setText("Bezkoloru");

        blackCardCheckBox.setText("Czarny");

        blueCardCheckBox.setText("Niebieski");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(blackCardCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(blueCardCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(greenCardCheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(redCardCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colorlessCardCheckBox)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(whiteCardCheckBox)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blackCardCheckBox)
                    .addComponent(blueCardCheckBox)
                    .addComponent(greenCardCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redCardCheckBox)
                    .addComponent(colorlessCardCheckBox))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(whiteCardCheckBox)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 336, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void initializeCardPropertiesListener(DatabaseClient db) {       

        ActionListener actionListenerCardFilter = new FilterCardPropertiesActionHandler(blackCardCheckBox, 
                blueCardCheckBox, greenCardCheckBox, redCardCheckBox, 
                whiteCardCheckBox, colorlessCardCheckBox, db);
        
        blackCardCheckBox.addActionListener(actionListenerCardFilter);
        blueCardCheckBox.addActionListener(actionListenerCardFilter);
        greenCardCheckBox.addActionListener(actionListenerCardFilter);
        redCardCheckBox.addActionListener(actionListenerCardFilter);
        whiteCardCheckBox.addActionListener(actionListenerCardFilter);
        colorlessCardCheckBox.addActionListener(actionListenerCardFilter);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox blackCardCheckBox;
    private javax.swing.JCheckBox blueCardCheckBox;
    private javax.swing.JCheckBox colorlessCardCheckBox;
    private javax.swing.JCheckBox greenCardCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox redCardCheckBox;
    private javax.swing.JCheckBox whiteCardCheckBox;
    // End of variables declaration//GEN-END:variables
}
