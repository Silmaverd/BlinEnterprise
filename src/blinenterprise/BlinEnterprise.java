
package blinenterprise;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class BlinEnterprise {
    public static void main(String[] args) {
        JFrame _interface = new Interface();
        _interface.setTitle("MTG Deck Editor");
        _interface.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {}

            @Override
            public void windowClosed(WindowEvent we) {
                System.exit((0));
            }

            @Override
            public void windowIconified(WindowEvent we) {}

            @Override
            public void windowDeiconified(WindowEvent we) {}

            @Override
            public void windowActivated(WindowEvent we) {}

            @Override
            public void windowDeactivated(WindowEvent we) {}
        });
    }    
}
