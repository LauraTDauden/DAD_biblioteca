
package events;

import controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LauraTD
 */
public class LoginEvents implements ActionListener{
    
    LoginController controller;
    
    public LoginEvents(LoginController controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(controller.getView().getjButton_Aceptar())) {
            controller.aceptar();
        }

        if (e.getSource().equals(controller.getView().getjButton_Cancelar())) {
            controller.cancelar();
        }
        
    }
    
}
