package co.edu.unbosque.escenario2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexionDB {
    private static final ResourceBundle RB = ResourceBundle.getBundle("db");
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName(RB.getString("db.driver"));
                conn = DriverManager.getConnection(
                    RB.getString("db.url"),
                    RB.getString("db.user"),
                    RB.getString("db.password")
                );
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver not found", e);
            }
        }
        return conn;
    }

    // opcional: cerrar
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException ignore) {}
    }
}
