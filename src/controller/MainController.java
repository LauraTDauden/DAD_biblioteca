package controller;

import events.MainEvents;
import java.beans.PropertyVetoException;
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
    private BooksController booksController;
    private LoansController loansController;
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
        try {
            iconize();
            if (studentsController == null) {
                try {
                    studentsController = new StudentsController(this);
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //studentsController.limpiar();
                studentsController.getView().setVisible(true);
                studentsController.getView().setIcon(false);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UsersMenu() {
        try {
            iconize();

            if (usersController == null) {
                try {
                    usersController = new UsersController(this);
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //usersController.limpiar();
                usersController.getView().setVisible(true);
                usersController.getView().setIcon(false);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BooksMenu() {
        try {
            iconize();

            if (booksController == null) {
                try {
                    booksController = new BooksController(this);
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //usersController.limpiar();
                booksController.getView().setVisible(true);
                booksController.getView().setIcon(false);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoansMenu() {
        try {
            iconize();

            if (loansController == null) {
                try {
                    loansController = new LoansController(this);
                } catch (SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //usersController.limpiar();
                loansController.getView().setVisible(true);
                loansController.getView().setIcon(false);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iconize() throws PropertyVetoException {
        if (studentsController != null) {
            if (studentsController.getView().isVisible()) {
                studentsController.getView().setIcon(true);
            }

        }
        if (booksController != null) {
            if (booksController.getView().isVisible()) {
                booksController.getView().setIcon(true);
            }

        }
        if (usersController != null) {
            if (usersController.getView().isVisible()) {
                usersController.getView().setIcon(true);
            }

        }
        if (loansController != null) {
            if (loansController.getView().isVisible()) {
                loansController.getView().setIcon(true);
            }
        }
    }
}
