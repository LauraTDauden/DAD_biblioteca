
package events;

import controller.UsersController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LauraTD
 */
public class UsersEvents implements ActionListener{

    UsersController controller;
    
    public UsersEvents(UsersController controller){
        this.controller = controller;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
