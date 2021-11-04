package controller;

import dto_entities.User;
import events.UsersEvents;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UsersModel;
import view.UsersView;

/**
 *
 * @author LauraTD
 */
public class UsersController {

    private static UsersView view;
    UsersModel model;
    User user;
    DefaultTableModel table;
    UsersEvents events;

    public UsersController(MainController mainController) throws SQLException {
        if (view == null) {
            view = new UsersView();
            events = new UsersEvents(this);
            mainController.getView().getDesktop().add(view).setVisible(true);
            initializeButtons();
            model = new UsersModel();
        }
    }

    public UsersView getView() {
        return view;
    }

    private void initializeButtons() {
        view.getjButton_nuevo().addActionListener(events);
        view.getjButton_eliminar().addActionListener(events);
        view.getjButton_modificar().addActionListener(events);
        view.getjButton_listar().addActionListener(events);
        view.getjButton_limpiar().addActionListener(events);
        view.getjTextField_searchBar().addKeyListener(events);
    }

    private void loadUser() {
        user = new User();
        user.setUserName(view.getjTextField_userName().getText());
        user.setPass(String.valueOf(view.getjPasswordField_pass().getPassword()));
    }

    public void alta() {
        if (verifyUserName() && verifyPassword()) {
            loadUser();
            model.add(user);
            JOptionPane.showMessageDialog(view, "Usuario creado con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(view, "Debe indicar el usuario y la contraseña.");
        }
    }

    public void modificar() {
        if (verifyPassword() && verifyUserName()) {
            loadUser();
            model.changePassword(user);
        } else {
            JOptionPane.showMessageDialog(view, "Debe introducir el usuario y su nueva contraseña");
        }
    }

    public void limpiar() {
        clearFields();
        clearTable();
    }

    public void baja() {
        if (verifyUserName()) {
            loadUser();
            model.delete(user.getUserName());
            JOptionPane.showMessageDialog(view, "Usuario eliminado.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(view, "Debe introducir el nombre de usuario.");
        }
    }

    public void addTableRows() {     
            clearTable();
            model.populateTable(view.getjTextField_searchBar().getText(), table);               
    }

    private void clearFields() {
        view.getjTextField_userName().setText("");
        view.getjPasswordField_pass().setText("");
    }

    private void clearTable() {
        table = (DefaultTableModel) view.getjTable_alumnos().getModel();
        table.setRowCount(0);
    }

    private boolean verifyUserName() {
        return !view.getjTextField_userName().getText().isBlank();
    }

    private boolean verifyPassword() {
        return !view.getjPasswordField_pass().getText().isBlank();
    }

}
