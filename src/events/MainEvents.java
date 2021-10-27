
package events;

import controller.MainController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author LauraTD
 */
public class MainEvents implements MouseListener {
    
    MainController controller;
    
    public MainEvents(MainController controller){
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource().equals(controller.getView().getjMenu_Alumnos())) {
            controller.StudentsMenu();
        }
         
         if (e.getSource().equals(controller.getView().getjMenu_Usuarios())) {
            controller.UsersMenu();
        }
         
         if (e.getSource().equals(controller.getView().getjMenu_Libros())) {
            controller.BooksMenu();
        }
         
          if (e.getSource().equals(controller.getView().getjMenu_Prestamos())) {
            controller.LoansMenu();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /*  if (e.getSource().equals(controller.getView().getjMenu_Alumnos())) {
        controller.getView().getjMenu_Alumnos().setSelected(true);
        }
        if (e.getSource().equals(controller.getView().getjMenu_Libros())) {
        controller.getView().getjMenu_Libros().setSelected(true);
        }
        if (e.getSource().equals(controller.getView().getjMenu_Prestamos())) {
        controller.getView().getjMenu_Prestamos().setSelected(true);
        }
        if (e.getSource().equals(controller.getView().getjMenu_Usuarios())) {
        controller.getView().getjMenu_Usuarios().setSelected(true);
        }*/
    }

    @Override
    public void mouseExited(MouseEvent e) {
        /*if (e.getSource().equals(controller.getView().getjMenu_Alumnos())) {
        controller.getView().getjMenu_Alumnos().setSelected(false);
        if (e.getSource().equals(controller.getView().getjMenu_Libros())) {
        controller.getView().getjMenu_Libros().setSelected(false);
        }
        if (e.getSource().equals(controller.getView().getjMenu_Prestamos())) {
        controller.getView().getjMenu_Prestamos().setSelected(false);
        }
        if (e.getSource().equals(controller.getView().getjMenu_Usuarios())) {
        controller.getView().getjMenu_Usuarios().setSelected(false);
        }
        }*/
    }
    
}
