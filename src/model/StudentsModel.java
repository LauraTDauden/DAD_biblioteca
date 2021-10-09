package model;

import connection.DataQueries;
import dto_entities.Student;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //baja (DELETE)
    public void delete(String dni){
        try {
            query.SQLUpdate("DELETE FROM alumnos WHERE dni ='" + dni + "'");
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
