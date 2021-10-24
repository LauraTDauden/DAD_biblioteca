
package events;

import controller.BooksController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LauraTD
 */
public class BooksEvents implements ActionListener {
    
    BooksController controller;
    
    public BooksEvents(BooksController controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(controller.getView().getjButton_alta())) {
            controller.alta();
        }

        if (e.getSource().equals(controller.getView().getjButton_listar())) {
            controller.addTableRows();
        }

        if (e.getSource().equals(controller.getView().getjButton_limpiar())) {
            controller.limpiar();
        }

        if (e.getSource().equals(controller.getView().getjButton_baja())) {
            controller.baja();
        }

        if (e.getSource().equals(controller.getView().getjButton_modificar())) {
            controller.modificar();
        }       
    }
    
}
