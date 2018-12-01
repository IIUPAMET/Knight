package db;

import java.sql.*;

public class DBConnect {

    private static String URL = "jdbc:mysql://127.0.0.1:3306/knight_db"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";;
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private Connection connection;

    public DBConnect(){
        try {
            connection = DriverManager.getConnection(URL , USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

}
