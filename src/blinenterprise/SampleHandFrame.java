package blinenterprise;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SampleHandFrame extends javax.swing.JFrame {

    private Deck currentDeck;
    private ArrayList labels;                           // Kontener na JLabele
    private int currentMulligan;                        // Licznik ile kart dobieramy nastepnym mulliganem
    private DatabaseClient dbClient;
    
    public SampleHandFrame() {                          // W konstruktorze JLabele na obrazki są pogrupowane do ArrayListy
        initComponents();
        labels = new ArrayList<>();
        labels.add(CardImage1);
        labels.add(CardImage2);
        labels.add(CardImage3);
        labels.add(CardImage4);
        labels.add(CardImage5);
        labels.add(CardImage6);
        labels.add(CardImage7);
        currentMulligan = 6;
        mulliganButton.setEnabled(false);               // Nie mozna mulliganowac przed dobraniem reki startowej
        mulliganButton.setToolTipText("You can mulligan only after drawing starting hand");
    }
    
    private void clearLabels(){                                     // Funkcja usuwa wszystkie obrazki w Labelach
        for(int i=0;i<7;i++){
            ImageIcon icon = new ImageIcon();
            JLabel cardImageContainer = (JLabel) labels.get(i);
            cardImageContainer.setIcon(icon);
        }      
    }
    
    public void loadDeckAndDB(Deck deck, DatabaseClient dbc){                   // Wczytuje deck oraz klienta bazy (potrzebny do pobierania obrazkow)
        currentDeck = deck;
        dbClient = dbc;
    }
    
    public void RandomCards(int amount) throws CardNotFoundException{           // Funkcja losuje wskazana ilosc kart i wyswietla w labelach
        clearLabels();
        ArrayList<Card> deck = currentDeck.getDeckAsArrayListWithRepeats();     // Reprezentacja decku w postaci tablicy z powtorkami ulatwia losowanie
        Image cardImage;                                                        // Kazda karta dostaje swoj numer w decku, losujemy ten numer
        for (int i=0; i<amount; i++){
            Random r = new Random();
            ArrayList repeats = new ArrayList();                                // Przechowuje juz wylosowane karty
            int index=r.nextInt(deck.size());
            while(repeats.contains(index)){                                     // Zapobieganie powtorkom
                index = r.nextInt(deck.size());
            }
            repeats.add(index);
            Card c = deck.get(index);
            cardImage = dbClient.GetImage(c);
            cardImage = cardImage.getScaledInstance(173, 230, Image.SCALE_SMOOTH);  // Skalowanie SMOOTH nie jest zbyt wydajne, ale daje dobra jakosc
            ImageIcon icon = new ImageIcon(cardImage);
            JLabel cardImageContainer = (JLabel) labels.get(i);                 // Ustawianie przeskalowanego obrazka w odpowiednim labelu
            cardImageContainer.setIcon(icon);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CardImage1 = new javax.swing.JLabel();
        CardImage2 = new javax.swing.JLabel();
        CardImage3 = new javax.swing.JLabel();
        CardImage4 = new javax.swing.JLabel();
        CardImage5 = new javax.swing.JLabel();
        CardImage6 = new javax.swing.JLabel();
        CardImage7 = new javax.swing.JLabel();
        draw7Button = new javax.swing.JButton();
        mulliganButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CardImage1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardImage2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardImage3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardImage4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardImage5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardImage6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CardImage7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        draw7Button.setText("Draw 7");
        draw7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draw7ButtonActionPerformed(evt);
            }
        });

        mulliganButton.setText("Mulligan");
        mulliganButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulliganButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CardImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(draw7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mulliganButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CardImage7, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(CardImage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardImage5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardImage1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mulliganButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(draw7Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void draw7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draw7ButtonActionPerformed
        mulliganButton.setEnabled(true);                                        // Po dobraniu reki startowej mozna mulliganowac
        currentMulligan = 6;                                                    // Pierwszy mulligan do 6 kart
        try {
            RandomCards(7);
        } catch (CardNotFoundException ex) {
            
        }
    }//GEN-LAST:event_draw7ButtonActionPerformed

    private void mulliganButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulliganButtonActionPerformed
        try{                                                                    // W przypadku mulliganu ponizej 1 karty dobieramy zawsze 1
            if (currentMulligan < 1) RandomCards(1);
            else RandomCards(currentMulligan);
            currentMulligan--;                                                  // Kazdy kolejny mulligan jest o 1 karte mniejszy
        } catch (CardNotFoundException ex) {
            
        }
    }//GEN-LAST:event_mulliganButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SampleHandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SampleHandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SampleHandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SampleHandFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SampleHandFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CardImage1;
    private javax.swing.JLabel CardImage2;
    private javax.swing.JLabel CardImage3;
    private javax.swing.JLabel CardImage4;
    private javax.swing.JLabel CardImage5;
    private javax.swing.JLabel CardImage6;
    private javax.swing.JLabel CardImage7;
    private javax.swing.JButton draw7Button;
    private javax.swing.JButton mulliganButton;
    // End of variables declaration//GEN-END:variables
}
