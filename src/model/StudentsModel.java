package model;

import connection.DataQueries;
import dto_entities.Student;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LauraTD
 */
public class StudentsModel {
    
    private DataQueries query;
    
    public StudentsModel() throws SQLException {
        query = new DataQueries();
    }
    
    public DataQueries getQuery() {
        return query;
    }

    //CRUD  
    //alta (CREATE)
    public void add(Student student) {
        try {
            query.prepareSQL("INSERT INTO alumnos"
                    + "(dni, nombre, apellido1, apellido2)"
                    + "VALUES (?,?,?,?)");
            query.getPreparedStatement().setString(1, student.getDni());
            query.getPreparedStatement().setString(2, student.getName());
            query.getPreparedStatement().setString(3, student.getSurname1());
            query.getPreparedStatement().setString(4, student.getSurname2());
            query.SQLUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //buscar (READ)
    public void search(String fieldText) {
        try {
            query.prepareSQL("SELECT * FROM alumnos WHERE dni LIKE ? "
                    + "OR nombre LIKE ? OR apellido1 LIKE ? "
                    + "OR apellido2 LIKE ?");
            for (int i = 1; i < 5; i++) {
                query.getPreparedStatement().setString(i, "%"+fieldText+"%");
            }
            query.SQLQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //modificar (UPDATE)
    public void modificarDatos(Student student) {
        boolean changes = false;
        try {
            if (!student.getName().isBlank()) {
                updateName(student);
                changes = true;
            }
            if (!student.getSurname1().isBlank()) {
                updateSurname1(student);
                changes = true;
            }
            if (!student.getSurname2().isBlank()) {
                updateSurname2(student);
                changes = true;
            }
            if (changes) {
                JOptionPane.showMessageDialog(null, "Datos actualizados con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No ha introducido ningún dato para modificar.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateName(Student student) throws SQLException {
        query.prepareSQL("UPDATE alumnos SET nombre=?"
                + "WHERE dni = ?");
        query.getPreparedStatement().setString(1, student.getName());
        query.getPreparedStatement().setString(2, student.getDni());
        query.SQLUpdate();
    }
    
    private void updateSurname1(Student student) throws SQLException {
        query.prepareSQL("UPDATE alumnos SET apellido1=?"
                + "WHERE dni = ?");
        query.getPreparedStatement().setString(1, student.getSurname1());
        query.getPreparedStatement().setString(2, student.getDni());
        query.SQLUpdate();
    }
    
    private void updateSurname2(Student student) throws SQLException {
        query.prepareSQL("UPDATE alumnos SET apellido2=?"
                + "WHERE dni = ?");
        query.getPreparedStatement().setString(1, student.getSurname2());
        query.getPreparedStatement().setString(2, student.getDni());
        query.SQLUpdate();
    }

    //baja (DELETE)
    public void delete(String dni) {
        try {
            query.prepareSQL("DELETE FROM alumnos WHERE dni =?");
            query.getPreparedStatement().setString(1, dni);
            query.SQLUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //TABLA
    public void populateTable(String text, DefaultTableModel table) {
        search(text);
        try {
            while (query.getResultset().next()) {
                String dni = query.getResultset().getString("dni");
                String nombre = query.getResultset().getString("nombre");
                String apellido1 = query.getResultset().getString("apellido1");
                String apellido2 = query.getResultset().getString("apellido2");
                
                table.addRow(new Object[]{dni, nombre, apellido1, apellido2});
            }
            query.closeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
