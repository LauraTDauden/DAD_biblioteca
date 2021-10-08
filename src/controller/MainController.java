package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.MainView;

/**
 *
 * @author Laura
 */
public class MainController implements MouseListener {

    private static MainView view;
    private StudentsController studentsController;

    public static MainView getView() {
        return view;
    }

    public MainController() {
        view = new MainView();
        initializeButtons();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(view.getjMenu_Alumnos())) {
            studentsController = new StudentsController();
        }
    }

    private void initializeButtons() {
        view.getjMenu_Alumnos().addMouseListener(this);
        view.getjMenu_Libros().addMouseListener(this);
        view.getjMenu_Usuarios().addMouseListener(this);
        view.getjMenu_Prestamos().addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {       
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
