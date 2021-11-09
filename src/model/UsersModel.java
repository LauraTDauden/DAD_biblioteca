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
            query.prepareSQL("INSERT INTO usuarios"
                    + "(usuario, clave)"
                    + "VALUES (?,?)");
            query.getPreparedStatement().setString(1, user.getUserName());
            query.getPreparedStatement().setString(2, user.getPass());
            query.SQLUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //buscar (READ)
    public void search(String fieldText) {
        try {
            query.prepareSQL("SELECT usuario FROM usuarios WHERE usuario LIKE ?");
            query.getPreparedStatement().setString(1, "%" + fieldText + "%");
            query.SQLQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //modificar (UPDATE)
    public void changePassword(User user) {
        try {
            query.prepareSQL("UPDATE usuarios SET clave= ? WHERE usuario = ? ");
            query.getPreparedStatement().setString(1, user.getPass());
            query.getPreparedStatement().setString(2, user.getUserName());
            query.SQLUpdate();
            JOptionPane.showMessageDialog(null, "Contraseña actualizada.");
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //baja (DELETE)
    public void delete(String name) {
        try {
            query.prepareSQL("DELETE FROM usuarios WHERE usuario =?");
            query.getPreparedStatement().setString(1, name);
            query.SQLUpdate();
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
