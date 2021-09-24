
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.View;

/**
 *
 * @author Laura
 */
public class Controller implements ActionListener {
    View view;
    
    public Controller() {
        view = new View();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
}
