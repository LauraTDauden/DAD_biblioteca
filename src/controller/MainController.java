package controller;

import events.MainEvents;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainView;

/**
 *
 * @author Laura
 */
public class MainController {

    private static MainView view;
    private StudentsController studentsController;
    private UsersController usersController;
    private MainEvents events;

    public MainController() {
        view = new MainView();
        events = new MainEvents(this);
        initializeButtons();
    }

    public MainView getView() {
        return view;
    }

    public StudentsController getStudentsController() {
        return studentsController;
    }

    private void initializeButtons() {
        view.getjMenu_Alumnos().addMouseListener(events);
        view.getjMenu_Libros().addMouseListener(events);
        view.getjMenu_Usuarios().addMouseListener(events);
        view.getjMenu_Prestamos().addMouseListener(events);
    }

    public void StudentsMenu() {
        if (studentsController == null) {
            try {
                studentsController = new StudentsController(this);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            studentsController.limpiar();
            studentsController.getView().setVisible(true);
        }
    }
    
    public void UsersMenu() {
        if (usersController == null) {
            try {
                usersController = new UsersController(this);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //usersController.limpiar();
            usersController.getView().setVisible(true);
        }
    }
}
