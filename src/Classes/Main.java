/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.*;

/**
 *
 * @author Llewellyn Craddock
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainFrame mf = new MainFrame ();
        mf.setExtendedState(MainFrame.MAXIMIZED_BOTH);
        mf.setVisible(true);
        SearchFrame sf = new SearchFrame ();
        sf.setVisible(false);
        AddCompetenceFrame addComp = new AddCompetenceFrame();
        addComp.setVisible(false);
    }

}
