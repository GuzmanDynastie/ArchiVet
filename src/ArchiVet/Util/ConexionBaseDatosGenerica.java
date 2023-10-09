package ArchiVet.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

public class ConexionBaseDatosGenerica {

    private Connection connection;
    private Statement stmt;
    private HashMap<Integer, Statement> statements = new HashMap<Integer, Statement>();
    private int statementKeyCounter = 0;
    public static final int INFORMIX = 0;
    public static final int MYSQL = 1;

    public ConexionBaseDatosGenerica(int databaseType, String machine, int port, String serverName, String databaseName, String user, String password) throws ClassNotFoundException, SQLException {

        String drivers[] = {"com.informix.jdbc.IfxDriver", "com.mysql.cj.jdbc.Driver"};
        String databaseTypes[] = {"informix-sqli", "mysql"};
        String connectString;

        switch (databaseType) {
            case INFORMIX:
                connectString = "jdbc:" + databaseTypes[databaseType] + "://" + machine + ":" + port + ":INFORMIXSERVER=" + serverName + ";Database=" + databaseName;
                break;
            case MYSQL:
                connectString = "jdbc:" + databaseTypes[databaseType] + "://" + machine + "/" + databaseName;
                break;
            default:
                connectString = "";
                break;
        }

        Class.forName(drivers[databaseType]);
        connection = DriverManager.getConnection(connectString, user, password);
        stmt = connection.createStatement();
    }

    public PreparedStatement prepare(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public ConexionBaseDatosGenerica(String machine, int port, String databaseName, String user, String password) throws ClassNotFoundException, SQLException {
        this(MYSQL, machine, 0, null, databaseName, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public boolean execute(String instruction) throws SQLException {
        return stmt.execute(instruction);
    }

    public int executeUpdate(String instruction) throws SQLException {
        return stmt.executeUpdate(instruction);
    }

    public void close() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (statements.size() > 0) {
            Iterator<Integer> i = statements.keySet().iterator();
            while (i.hasNext()) {
                statements.remove(i.next()).close();
            }
        }
        if (connection != null) {
            connection.close();
        }
    }

    public int createStatement() throws SQLException {
        statements.put(++statementKeyCounter, connection.createStatement());
        return statementKeyCounter;
    }

    public ResultSet executeQuery(int statementKey, String query) throws SQLException {
        return statements.get(statementKey).executeQuery(query);
    }

    public boolean execute(int statementKey, String instruction) throws SQLException {
        return statements.get(statementKey).execute(instruction);
    }

    public void closeStatement(int statementKey) throws SQLException {
        statements.remove(statementKey).close();
    }

}
