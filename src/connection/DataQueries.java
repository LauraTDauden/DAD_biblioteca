package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author LauraTD
 */
public class DataQueries {

    private ResultSet results;
    private PreparedStatement preparedStatement;
    Connect con;

    public DataQueries() throws SQLException {
        con = new Connect();
    }

    //GETTERS
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public ResultSet getResultset() {
        return results;
    }

    //MÉTODOS
    //Prepara el PreparedStatement, que se parametriza en el modelo antes de ejecutar la consulta o actualización 
    //Evita inyección de SQL
    public void prepareSQL(String sql) throws SQLException {
        preparedStatement = con.getCon().prepareStatement(sql);
    }

    //consulta
    public void SQLQuery() throws SQLException {
        results = preparedStatement.executeQuery();
    }

    //actualización
    public void SQLUpdate() throws SQLException {
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void closeQuery() throws SQLException {
        preparedStatement.close();
        results.close();
    }

}
