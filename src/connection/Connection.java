
package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laura
 */
public class Connection {
    
    private static Connection con;
    private static String user = "root";
    private static String password = "admin1234";

    private static String url = "jdbc:mysql://localhost/dad_biblioteca";
    private static ResultSet rs;
    private static Statement s;
    
    public static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontró el driver de MySQL");
        }
    }

    public static java.sql.Connection connectDataBase(java.sql.Connection con) throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
}
