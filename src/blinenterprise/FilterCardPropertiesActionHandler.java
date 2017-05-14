package blinenterprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

public class FilterCardPropertiesActionHandler implements ActionListener {

    JCheckBox blackCardRadioButton;
    JCheckBox blueCardRadioButton;
    JCheckBox greenCardRadioButton;
    JCheckBox redCardRadioButton;
    JCheckBox whiteCardRadioButton;
    JCheckBox colorlessCardRadioButton;
    
    public FilterCardPropertiesActionHandler(JCheckBox black, JCheckBox blue, 
            JCheckBox green, JCheckBox red, JCheckBox white, JCheckBox colorless) {
        
        blackCardRadioButton = black;
        blueCardRadioButton = blue;
        greenCardRadioButton = green;
        redCardRadioButton = red;
        whiteCardRadioButton = white;
        colorlessCardRadioButton = colorless;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox checkbox = (JCheckBox) e.getSource();
        if (checkbox == blackCardRadioButton) {
            System.out.println("Checkbox #1 is clicked");
        } else if (checkbox == blueCardRadioButton) {
            System.out.println("Checkbox #2 is clicked");
        } else if (checkbox == greenCardRadioButton) {
            System.out.println("Checkbox #3 is clicked");
        } else if (checkbox == redCardRadioButton) {
            System.out.println("Checkbox #4 is clicked");
        } else if (checkbox == whiteCardRadioButton) {
            System.out.println("Checkbox #5 is clicked");
        } else if (checkbox == colorlessCardRadioButton) {
            System.out.println("Checkbox #6 is clicked");
        }
    }  
}
