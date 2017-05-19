package blinenterprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class FilterCardPropertiesActionHandler implements ActionListener {

    private JCheckBox blackCardCheckBox;
    private JCheckBox blueCardCheckBox;
    private JCheckBox greenCardCheckBox;
    private JCheckBox redCardCheckBox;
    private JCheckBox whiteCardCheckBox; 
    private JRadioButton matchColorsExactlyRadioButton;
    private JRadioButton excludeUnselectedColorsRadioButton;
    private JButton submitFiltersButton;
    private JComboBox<String> cardTypeComboBox;
    private JComboBox<String> convManaCostComboBox;
    private JLabel showConvManaCostLabel;
    private DatabaseClient database;
    private CardSearchFilter cardFilterMenager;
    private Interface mainInterfaceInstance; 
    private FilterCardsFrame filterFrame;
    
    public FilterCardPropertiesActionHandler(JCheckBox black, JCheckBox blue, 
            JCheckBox green, JCheckBox red, JCheckBox white,
            JRadioButton matchColorsExactly, JRadioButton excludeUnselectedColors, JButton submit, JComboBox<String> cardtype, DatabaseClient db, 
            Interface mainInterface, FilterCardsFrame frame, JComboBox convManaCost, JLabel showConvMana) {
        
        blackCardCheckBox = black;
        blueCardCheckBox = blue;
        greenCardCheckBox = green;
        redCardCheckBox = red;
        whiteCardCheckBox = white;
        matchColorsExactlyRadioButton = matchColorsExactly;  
        excludeUnselectedColorsRadioButton = excludeUnselectedColors;
        submitFiltersButton = submit;
        database = db;
        cardFilterMenager = db.getCardFilterMenager();
        mainInterfaceInstance = mainInterface;
        filterFrame = frame;
        cardTypeComboBox = cardtype;
        convManaCostComboBox = convManaCost;
        showConvManaCostLabel = showConvMana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Filter newFilter = new Filter();
        
        /* ################# check box ################# */
        if(e.getSource().getClass() == JCheckBox.class) {        
            JCheckBox checkbox = (JCheckBox) e.getSource();
            
            if (e.getSource() == blackCardCheckBox) {
                newFilter.setCommand(Filter.Commands.BLACK);  
            } else if (e.getSource() == blueCardCheckBox) {
                newFilter.setCommand(Filter.Commands.BLUE);
            } else if (e.getSource() == greenCardCheckBox) {
                newFilter.setCommand(Filter.Commands.GREEN);
            } else if (e.getSource() == redCardCheckBox) {
                newFilter.setCommand(Filter.Commands.RED);
            } else if (e.getSource() == whiteCardCheckBox) {
                newFilter.setCommand(Filter.Commands.WHITE);
            }
            
            if(checkbox.isSelected()) {
                cardFilterMenager.addFilter(newFilter);
            } else if(!checkbox.isSelected()) {
                cardFilterMenager.removeFilter(newFilter);
            }
        }
        
        /* ################# radio button ################# */
        if(e.getSource().getClass() == JRadioButton.class) {        
            JRadioButton radiobutton = (JRadioButton) e.getSource();   
            
            if (e.getSource() == matchColorsExactlyRadioButton) {
                newFilter.setCommand(Filter.Commands.MATCHCOLORSEXACTLY);
                if(radiobutton.isSelected()) {
                    cardFilterMenager.addFilter(newFilter);
                } else if(!radiobutton.isSelected()) {
                    cardFilterMenager.removeFilter(newFilter);
                }
            } else if (e.getSource() == excludeUnselectedColorsRadioButton) {
                newFilter.setCommand(Filter.Commands.EXCLUDEUNSELECTEDCOLORS);
                if(radiobutton.isSelected()) {
                    cardFilterMenager.addFilter(newFilter);
                } else if(!radiobutton.isSelected()) {
                    cardFilterMenager.removeFilter(newFilter);
                }
            }
        }
        
        /* ################# Combobox ################# */
        if(e.getSource().getClass() == JComboBox.class) {        
            JComboBox combobox = (JComboBox)e.getSource();
            
            if (e.getSource() == cardTypeComboBox) {
                newFilter.setCommand(Filter.Commands.SELECTTYPE);
                newFilter.setValue((String) combobox.getSelectedItem());
                cardFilterMenager.addFilter(newFilter);
                if (((String) combobox.getSelectedItem()).equals("All Types")) {
                    cardFilterMenager.removeFilter(newFilter);
                }
            }
            if (e.getSource() == convManaCostComboBox) {
                cardFilterMenager.addFilter(new Filter(Filter.Commands.CONVERTEDMANACOST, 
                    showConvManaCostLabel.getText(), ((String) convManaCostComboBox.getSelectedItem())));
            }
        }
        /* ################# Submit button ################# */
        if (e.getSource() == submitFiltersButton) {
            mainInterfaceInstance.getCardList().setListData(database.getFilteredCardNames(mainInterfaceInstance.getCardNameInputLine().getText().toLowerCase()));
            filterFrame.dispatchEvent(new WindowEvent(filterFrame, WindowEvent.WINDOW_CLOSING));
        }
    }  
}
