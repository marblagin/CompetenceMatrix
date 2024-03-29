
package Classes;

import GUI.*;

/**
 *
 * @author Llewellyn Craddock
 */
public class Main {
    
    /**
     * Main method ran at start up. Sets the main frame to full screen 
     * @param args 
     */
    public static void main(String[] args) {
        // This code is merely to initiate the GUI
        MainFrame mf = new MainFrame (0);
        mf.setExtendedState(MainFrame.MAXIMIZED_BOTH); // in fullscreen mode
        mf.setVisible(true);
    }

}
