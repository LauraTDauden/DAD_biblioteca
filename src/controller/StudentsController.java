package controller;

import dto_entities.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.StudentsModel;
import view.StudentsView;

/**
 *
 * @author LauraTD
 */
public class StudentsController implements ActionListener{

    private static StudentsView view;
    StudentsModel model;
    Student student;
    DefaultTableModel table;

    public StudentsController() throws SQLException {
        if (view == null) {
            view = new StudentsView();
            MainController.getView().getDesktop().add(view).setVisible(true);
        }
        initializeButtons();
        model = new StudentsModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getjButton_alta())) {
            alta();
        }
        
        if(e.getSource().equals(view.getjButton_listar())){
                addTableRows();                     
        }
        
        if (e.getSource().equals(view.getjButton_limpiar())){
            limpiar();
        }
        
        if (e.getSource().equals(view.getjButton_baja())){
            baja();
        }
        
        if (e.getSource().equals(view.getjButton_modificar())){
            //modificar
        }
    }
    
    
    private void initializeButtons() {
        view.getjButton_alta().addActionListener(this);
        view.getjButton_baja().addActionListener(this);
        view.getjButton_modificar().addActionListener(this);
        view.getjButton_listar().addActionListener(this);
        view.getjButton_limpiar().addActionListener(this);
    }

    private void loadStudent() {
        student = new Student();
        student.setDni(view.getjTextField_dni().getText());
        student.setName(view.getjTextField_nombre().getText());
        student.setSurname1(view.getjTextField_apellido1().getText());
        student.setSurname2(view.getjTextField_apellido2().getText());
    }

    private void alta() {
        if (verifyFields()) {
            loadStudent();
                model.add(student);
                JOptionPane.showMessageDialog(view, "Alumno añadido con éxito.");
                clearFields();           
        } else {
            JOptionPane.showMessageDialog(view, "Debe rellenar todos los campos obligatorios.");
        }
    }
    
    private void baja(){
        if (verifyDNI()){
            model.delete(view.getjTextField_dni().getText());
            JOptionPane.showMessageDialog(view, "El alumno fue dado de baja con éxito.");
        } else {
            JOptionPane.showMessageDialog(view, "Debe indicar el DNI del registro que desea dar de baja.");
        }
    }
    
    private void limpiar(){
        clearFields();
        clearTable();
    }
    
    private void clearFields(){
        view.getjTextField_nombre().setText("");
        view.getjTextField_dni().setText("");
        view.getjTextField_apellido1().setText("");
        view.getjTextField_apellido2().setText("");
    }
    
    private void clearTable(){
       table = (DefaultTableModel) view.getjTable_alumnos().getModel();
            table.setRowCount(0);
    }
     
    public void addTableRows() {
        try {
            clearTable();
            model.search(view.getjTextField_searchBar().getText());
            while (model.getQuery().getResultset().next()) {
                String dni = model.getQuery().getResultset().getString("dni");
                String nombre = model.getQuery().getResultset().getString("nombre");
                String apellido1 = model.getQuery().getResultset().getString("apellido1");
                String apellido2 = model.getQuery().getResultset().getString("apellido2");
                
                table.addRow(new Object[]{dni, nombre, apellido1, apellido2});
            }
            model.getQuery().closeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    private boolean verifyDNI(){
        if (view.getjTextField_dni().getText().isBlank()){
            return false;
        } else return true;
    }
  
}
