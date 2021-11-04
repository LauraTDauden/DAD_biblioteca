package model;

import connection.DataQueries;
import dto_entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LauraTD
 */
public class UsersModel {

    private DataQueries query;

    public UsersModel() throws SQLException {
        query = new DataQueries();
    }

    public DataQueries getQuery() {
        return query;
    }

    //CRUD  
    //alta (CREATE)
    public void add(User user) {
        try {
            query.SQLUpdate("INSERT INTO usuarios"
                    + "(usuario, clave)"
                    + "VALUES ('" + user.getUserName() + "', '" + user.getPass() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //buscar (READ)
    public void search(String fieldText) {
        try {
            query.SQLQuery("SELECT usuario FROM usuarios WHERE usuario LIKE '" + fieldText + "%'");
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //modificar (UPDATE)
    public void changePassword(User user) {
        try {
            query.SQLUpdate("UPDATE usuarios SET clave='" + user.getPass() + "'");
            JOptionPane.showMessageDialog(null, "Contraseña actualizada.");
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //baja (DELETE)
    public void delete(String name) {
        try {
            query.SQLUpdate("DELETE FROM usuarios WHERE usuario ='" + name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //TABLA
    public void populateTable(String text, DefaultTableModel table) {
        search(text);
        try {
            while (query.getResultset().next()) {
                String name = query.getResultset().getString("usuario");
                table.addRow(new Object[]{name});
            }
            query.closeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
