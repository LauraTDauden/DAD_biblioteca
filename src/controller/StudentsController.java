package controller;

import dto_entities.Student;
import events.StudentsEvents;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.StudentsModel;
import view.StudentsView;

/**
 *
 * @author LauraTD
 */
public class StudentsController {

    private static StudentsView view;
    StudentsModel model;
    Student student;
    DefaultTableModel table;
    StudentsEvents events;

    public StudentsController(MainController mainController) throws SQLException {
        if (view == null) {
            view = new StudentsView();
            events = new StudentsEvents(this);
            mainController.getView().getDesktop().add(view).setVisible(true);
            initializeButtons();
            model = new StudentsModel();
        }
    }

    public StudentsView getView() {
        return view;
    }

    private void initializeButtons() {
        view.getjButton_alta().addActionListener(events);
        view.getjButton_baja().addActionListener(events);
        view.getjButton_modificar().addActionListener(events);
        view.getjButton_listar().addActionListener(events);
        view.getjButton_limpiar().addActionListener(events);
        view.getjTextField_searchBar().addKeyListener(events);
    }

    private void loadStudent() {
        student = new Student();
        student.setDni(view.getjTextField_dni().getText());
        student.setName(view.getjTextField_nombre().getText());
        student.setSurname1(view.getjTextField_apellido1().getText());
        student.setSurname2(view.getjTextField_apellido2().getText());
    }

    public void alta() {
        if (verifyFields()) {
            loadStudent();
            model.add(student);
            JOptionPane.showMessageDialog(view, "Alumno añadido con éxito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(view, "Debe rellenar todos los campos obligatorios.");
        }
    }

    public void baja() {
        if (verifyDNI()) {
            model.delete(view.getjTextField_dni().getText());
            limpiar();
            JOptionPane.showMessageDialog(view, "El alumno fue dado de baja con éxito.");
        } else {
            JOptionPane.showMessageDialog(view, "Debe indicar el DNI del registro que desea dar de baja.");
        }
    }

    public void modificar() {
        if (verifyDNI()) {
            loadStudent();
            model.modificarDatos(student);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(view, "Debe indicar el DNI del registro que desea modificar.");
        }
    }

    public void limpiar() {
        clearFields();
        clearTable();
    }

    private void clearFields() {
        view.getjTextField_nombre().setText("");
        view.getjTextField_dni().setText("");
        view.getjTextField_apellido1().setText("");
        view.getjTextField_apellido2().setText("");
    }

    private void clearTable() {
        table = (DefaultTableModel) view.getjTable_alumnos().getModel();
        table.setRowCount(0);
    }

    public void addTableRows() {
        clearTable();
        model.populateTable(view.getjTextField_searchBar().getText(), table);      
    }

    //verificar datos obligatorios
    private boolean verifyFields() {
        boolean valid = true;
        if (view.getjTextField_nombre().getText().isBlank()
                || view.getjTextField_dni().getText().isBlank()
                || view.getjTextField_apellido1().getText().isBlank()) {
            valid = false;
        }
        return valid;
    }

    private boolean verifyDNI() {
        return !view.getjTextField_dni().getText().isBlank();
    }

}
