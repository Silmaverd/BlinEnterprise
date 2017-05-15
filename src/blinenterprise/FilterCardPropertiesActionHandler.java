package blinenterprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class FilterCardPropertiesActionHandler implements ActionListener {

    JCheckBox blackCardCheckBox;
    JCheckBox blueCardCheckBox;
    JCheckBox greenCardCheckBox;
    JCheckBox redCardCheckBox;
    JCheckBox whiteCardCheckBox; 
    JRadioButton matchColorsExactlyRadioButton;
    JButton submitFiltersButton;
    private DatabaseClient database;
    private CardSearchFilter cardFilterMenager;
    private Interface mainInterfaceInstance; 
    private FilterCardsFrame filterFrame;
    
    public FilterCardPropertiesActionHandler(JCheckBox black, JCheckBox blue, 
            JCheckBox green, JCheckBox red, JCheckBox white,
            JRadioButton matchColorsExactly, JButton submit, DatabaseClient db, 
            Interface mainInterface, FilterCardsFrame frame) {
        
        blackCardCheckBox = black;
        blueCardCheckBox = blue;
        greenCardCheckBox = green;
        redCardCheckBox = red;
        whiteCardCheckBox = white;
        matchColorsExactlyRadioButton = matchColorsExactly;   
        submitFiltersButton = submit;
        database = db;
        cardFilterMenager = db.getCardFilterMenager();
        mainInterfaceInstance = mainInterface;
        filterFrame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Filter newFilter = new Filter();
        
        /* ################# Color select check box ################# */
        if(e.getSource().getClass() == JCheckBox.class) {        
            JCheckBox checkbox = (JCheckBox) e.getSource();
            
            if (e.getSource() == blackCardCheckBox) {
                newFilter.command = Filter.Commands.BLACK;  
            } else if (e.getSource() == blueCardCheckBox) {
                newFilter.command = Filter.Commands.BLUE;
            } else if (e.getSource() == greenCardCheckBox) {
                newFilter.command = Filter.Commands.GREEN;
            } else if (e.getSource() == redCardCheckBox) {
                newFilter.command = Filter.Commands.RED;
            } else if (e.getSource() == whiteCardCheckBox) {
                newFilter.command = Filter.Commands.WHITE;
            }
            
            if(checkbox.isSelected()) {
                cardFilterMenager.addFilter(newFilter);
            } else if(!checkbox.isSelected()) {
                cardFilterMenager.removeFilter(newFilter);
            }
        }
        
        /* ################# Multicolor radio button ################# */
        if (e.getSource() == matchColorsExactlyRadioButton) {
            JRadioButton radiobutton = (JRadioButton) e.getSource();
            newFilter.command = Filter.Commands.MATCHCOLORSEXACTLY;
            if(radiobutton.isSelected()) {
                cardFilterMenager.addFilter(newFilter);
            } else if(!radiobutton.isSelected()) {
                cardFilterMenager.removeFilter(newFilter);
            }
        }
        
        /* ################# Submit button ################# */
        if (e.getSource() == submitFiltersButton) {
            mainInterfaceInstance.getCardList().setListData(database.getFilteredCardNames(mainInterfaceInstance.getCardNameInputLine().getText()));
            filterFrame.dispatchEvent(new WindowEvent(filterFrame, WindowEvent.WINDOW_CLOSING));
        }
    }  
}
