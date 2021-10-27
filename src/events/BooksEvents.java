
package events;

import controller.BooksController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author LauraTD
 */
public class BooksEvents implements ActionListener, KeyListener {
    
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

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource().equals(controller.getView().getjTextField_searchBar())) {
            controller.addTableRows();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
