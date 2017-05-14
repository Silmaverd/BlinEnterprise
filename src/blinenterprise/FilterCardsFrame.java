package blinenterprise;

import java.awt.event.ActionListener;
import javax.swing.JCheckBox;


public class FilterCardsFrame extends javax.swing.JFrame {

    public FilterCardsFrame() {
        initComponents();
        Initialize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        greenCardRadioButton = new javax.swing.JCheckBox();
        redCardRadioButton = new javax.swing.JCheckBox();
        whiteCardRadioButton = new javax.swing.JCheckBox();
        colorlessCardRadioButton = new javax.swing.JCheckBox();
        blackCardRadioButton = new javax.swing.JCheckBox();
        blueCardRadioButton = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        greenCardRadioButton.setText("Zielony");

        redCardRadioButton.setText("Czerwony");

        whiteCardRadioButton.setText("Biały");

        colorlessCardRadioButton.setText("Bezkoloru");

        blackCardRadioButton.setText("Czarny");

        blueCardRadioButton.setText("Niebieski");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(blackCardRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(blueCardRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(greenCardRadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(redCardRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colorlessCardRadioButton)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(whiteCardRadioButton)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blackCardRadioButton)
                    .addComponent(blueCardRadioButton)
                    .addComponent(greenCardRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redCardRadioButton)
                    .addComponent(colorlessCardRadioButton))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(whiteCardRadioButton)
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
    
    public void Initialize(){       
        /* Init card color selection Listener*/
        ActionListener actionListenerCardFilter = new FilterCardPropertiesActionHandler(blackCardRadioButton, 
                blueCardRadioButton, greenCardRadioButton, redCardRadioButton, 
                whiteCardRadioButton, colorlessCardRadioButton);
        
        blackCardRadioButton.addActionListener(actionListenerCardFilter);
        blueCardRadioButton.addActionListener(actionListenerCardFilter);
        greenCardRadioButton.addActionListener(actionListenerCardFilter);
        redCardRadioButton.addActionListener(actionListenerCardFilter);
        whiteCardRadioButton.addActionListener(actionListenerCardFilter);
        colorlessCardRadioButton.addActionListener(actionListenerCardFilter);
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
            java.util.logging.Logger.getLogger(FilterCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilterCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilterCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilterCardsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilterCardsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox blackCardRadioButton;
    private javax.swing.JCheckBox blueCardRadioButton;
    private javax.swing.JCheckBox colorlessCardRadioButton;
    private javax.swing.JCheckBox greenCardRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox redCardRadioButton;
    private javax.swing.JCheckBox whiteCardRadioButton;
    // End of variables declaration//GEN-END:variables
}
