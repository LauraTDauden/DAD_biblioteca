package model;

import connection.DataQueries;
import dto_entities.Student;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            query.SQLUpdate("INSERT INTO alumnos"
                    + "(dni, nombre, apellido1, apellido2)"
                    + "VALUES ('" + student.getDni() + "', '" + student.getName() + "','" + student.getSurname1() + "', '"
                    + student.getSurname2() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //buscar (READ)
    public void search(String fieldText) {
        try {
            query.SQLQuery("SELECT * FROM alumnos WHERE dni LIKE '" + fieldText + "%'"
                    + "OR nombre LIKE '" + fieldText + "%'"
                    + "OR apellido1 LIKE '" + fieldText + "%'"
                    + "OR apellido2 LIKE '" + fieldText + "%'");
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
        query.SQLUpdate("UPDATE alumnos SET nombre='" + student.getName() + "'"
                + "WHERE dni = '" + student.getDni() + "'");
    }

    private void updateSurname1(Student student) throws SQLException {
        query.SQLUpdate("UPDATE alumnos SET apellido1='" + student.getSurname1() + "'"
                + "WHERE dni = '" + student.getDni() + "'");
    }

    private void updateSurname2(Student student) throws SQLException {
        query.SQLUpdate("UPDATE alumnos SET apellido2='" + student.getSurname2() + "'"
                + "WHERE dni = '" + student.getDni() + "'");
    }

    //baja (DELETE)
    public void delete(String dni) {
        try {
            query.SQLUpdate("DELETE FROM alumnos WHERE dni ='" + dni + "'");
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
