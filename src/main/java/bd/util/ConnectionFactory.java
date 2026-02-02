package bd.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "127.0.0.1"; 
    private static final String USER = "postgres";
    private static final String PASS = "postgres";


    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
