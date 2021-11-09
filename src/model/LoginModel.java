package model;

import connection.DataQueries;
import dto_entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LauraTD
 */
public class LoginModel {

    DataQueries query;

    public LoginModel() throws SQLException {
        query = new DataQueries();
    }

    public boolean validateUserPassword(User user) {
        boolean valid = false;
        try {           
            query.prepareSQL("SELECT * FROM usuarios WHERE usuario = ? and clave = ?");
            query.getPreparedStatement().setString(1, user.getUserName());
            query.getPreparedStatement().setString(2, user.getPass());
            query.SQLQuery();
            if (!query.getResultset().next()) {
                JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña introducidos no son correctos.");
            } else {
                valid = true;
            }  
            query.closeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return valid;
    }
}
