package bd.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "dbc:postgresql://db.bfpipvskszqukxdpxiaz.supabase.co:5432/postgres?sslmode=require";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";


    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
