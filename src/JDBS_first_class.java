import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBS_first_class {

    private static final String URL = "jdbc:postgresql://localhost:5432/Fierst_Database";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "sasha";

    public static void main(String[] args) {
        Class<Driver> driverClass = Driver.class;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}

