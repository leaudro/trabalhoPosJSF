package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leandro
 */
public class DaoUtil {
    private static final String URL = "jdbc:derby://localhost:1527/TrabJava";
    private static final String LOGIN = "SA";
    private static final String PASS = "sa";
    
    private Connection conn;
    
    public Connection getConnection() throws Exception {
        if (conn == null){
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(URL, LOGIN, PASS);
        }
        return conn;
    }
    
    public Statement getStatement() throws Exception {
        return getConnection().createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws Exception {
        return getConnection().prepareStatement(sql);
    }
    
    public PreparedStatement getPreparedStatementForCreate(String sql) throws Exception {
        return getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }
    
    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}