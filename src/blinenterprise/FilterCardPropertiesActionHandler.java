package blinenterprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class FilterCardPropertiesActionHandler implements ActionListener {

    JCheckBox blackCardCheckBox;
    JCheckBox blueCardCheckBox;
    JCheckBox greenCardCheckBox;
    JCheckBox redCardCheckBox;
    JCheckBox whiteCardCheckBox; 
    JRadioButton matchColorsExactlyRadioButton;
    JRadioButton excludeUnselectedColorsRadioButton;
    JButton submitFiltersButton;
    JComboBox<String> cardTypeComboBox;
    private DatabaseClient database;
    private CardSearchFilter cardFilterMenager;
    private Interface mainInterfaceInstance; 
    private FilterCardsFrame filterFrame;
    
    public FilterCardPropertiesActionHandler(JCheckBox black, JCheckBox blue, 
            JCheckBox green, JCheckBox red, JCheckBox white,
            JRadioButton matchColorsExactly, JRadioButton excludeUnselectedColors, JButton submit, JComboBox<String> cardtype, DatabaseClient db, 
            Interface mainInterface, FilterCardsFrame frame) {
        
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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Filter newFilter = new Filter();
        
        /* ################# Color select check box ################# */
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
        
        /* ################# MATCHCOLORSEXACTLY radio button ################# */
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
        
        /* ################# Select card type combobox ################# */
        if (e.getSource() == cardTypeComboBox) {
            JComboBox combobox = (JComboBox)e.getSource();
            newFilter.setCommand(Filter.Commands.SELECTTYPE);
            newFilter.setValue((String) combobox.getSelectedItem());
            cardFilterMenager.addFilter(newFilter);
        }
        
        /* ################# Submit button ################# */
        if (e.getSource() == submitFiltersButton) {
            mainInterfaceInstance.getCardList().setListData(database.getFilteredCardNames(mainInterfaceInstance.getCardNameInputLine().getText().toLowerCase()));
            filterFrame.dispatchEvent(new WindowEvent(filterFrame, WindowEvent.WINDOW_CLOSING));
        }
    }  
}
