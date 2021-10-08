package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LauraTD
 */
public class DataQueries {

    private Statement statement;
    private ResultSet results;
    Connect con;

    public DataQueries() throws SQLException {
        con = new Connect();
    }
    
    public ResultSet getResultset() {
        return results;
    }    
    
    public void executeSQL(String sql) throws SQLException{
        statement = con.getCon().createStatement();
        results = statement.executeQuery(sql);
    }

    public void closeQuery() throws SQLException {
        statement.close();
        results.close();
    }
}
