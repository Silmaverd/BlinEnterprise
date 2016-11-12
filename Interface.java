package blinenterprise;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Interface extends javax.swing.JFrame {

    private DatabaseClient dbClient;
    
    public Interface() {
        initComponents();
        initialize();
    }
    
    public void initialize(){
        this.setVisible(true);
        DeckEditorPanel.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbClient = new DatabaseClient();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        StartMenu = new javax.swing.JPanel();
        DeckEditorButton = new javax.swing.JButton();
        CardCreatorButton = new javax.swing.JButton();
        DeckEditorPanel = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        CardImage = new javax.swing.JLabel();
        CardNameInputLine = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DeckEditorButton.setText("Deck Edit");
        DeckEditorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeckEditorButtonActionPerformed(evt);
            }
        });

        CardCreatorButton.setText("Create Card");
        CardCreatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardCreatorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StartMenuLayout = new javax.swing.GroupLayout(StartMenu);
        StartMenu.setLayout(StartMenuLayout);
        StartMenuLayout.setHorizontalGroup(
            StartMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartMenuLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(DeckEditorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addComponent(CardCreatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        StartMenuLayout.setVerticalGroup(
            StartMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartMenuLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(StartMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CardCreatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeckEditorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        jToggleButton1.setText("Działa");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        CardImage.setText("ID: 0");

        CardNameInputLine.setText("Wyszukaj kartę");
        CardNameInputLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardNameInputLineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeckEditorPanelLayout = new javax.swing.GroupLayout(DeckEditorPanel);
        DeckEditorPanel.setLayout(DeckEditorPanelLayout);
        DeckEditorPanelLayout.setHorizontalGroup(
            DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CardNameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                        .addComponent(CardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(455, Short.MAX_VALUE))
        );
        DeckEditorPanelLayout.setVerticalGroup(
            DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeckEditorPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(CardNameInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeckEditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(CardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StartMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DeckEditorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StartMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DeckEditorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void DeckEditorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        StartMenu.setVisible(false);
        DeckEditorPanel.setVisible(true);     
    }                                                

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        DeckEditorPanel.setVisible(false);
        StartMenu.setVisible(true);
    }                                              

    private void CardCreatorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
    }                                                 

    private void CardNameInputLineActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        try {
            int CardID = dbClient.ImageQuery(CardNameInputLine.getText());
            if (CardID == 0) CardImage.setText("Card not found");
            else CardImage.setText("ID: "+Integer.toString(CardID));
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton CardCreatorButton;
    private javax.swing.JLabel CardImage;
    private javax.swing.JTextField CardNameInputLine;
    private javax.swing.JButton DeckEditorButton;
    private javax.swing.JPanel DeckEditorPanel;
    private javax.swing.JPanel StartMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration                   
}
