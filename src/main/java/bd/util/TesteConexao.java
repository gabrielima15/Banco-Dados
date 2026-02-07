package bd.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {

    private static final String URL =  "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            if (conn != null) {
                System.out.println("✅ Conectado com sucesso ao PostgreSQL!");
            }

        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar no banco");
            e.printStackTrace();
        }
    }
}
