package blinenterprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

public class FilterCardPropertiesActionHandler implements ActionListener {

    JCheckBox blackCardCheckBox;
    JCheckBox blueCardCheckBox;
    JCheckBox greenCardCheckBox;
    JCheckBox redCardCheckBox;
    JCheckBox whiteCardCheckBox;
    JCheckBox colorlessCardCheckBox;   
    private DatabaseClient database;
    private CardSearchFilter cardFilterMenager;

    
    public FilterCardPropertiesActionHandler(JCheckBox black, JCheckBox blue, 
            JCheckBox green, JCheckBox red, JCheckBox white, JCheckBox colorless,
            DatabaseClient db) {
        
        blackCardCheckBox = black;
        blueCardCheckBox = blue;
        greenCardCheckBox = green;
        redCardCheckBox = red;
        whiteCardCheckBox = white;
        colorlessCardCheckBox = colorless;
        initDatabase(db);
    }

    public void initDatabase(DatabaseClient db) {
        database = db;
        cardFilterMenager = db.getCardFilterMenager();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox checkbox = (JCheckBox) e.getSource();
        if (checkbox == blackCardCheckBox) {
            System.out.println("Checkbox #1 is clicked");
        } else if (checkbox == blueCardCheckBox) {
            System.out.println("Checkbox #2 is clicked");
        } else if (checkbox == greenCardCheckBox) {
            System.out.println("Checkbox #3 is clicked");
        } else if (checkbox == redCardCheckBox) {
            System.out.println("Checkbox #4 is clicked");
        } else if (checkbox == whiteCardCheckBox) {
            System.out.println("Checkbox #5 is clicked");
        } else if (checkbox == colorlessCardCheckBox) {
            System.out.println("Checkbox #6 is clicked");
        }
    }  
}
