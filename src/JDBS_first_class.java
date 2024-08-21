import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBS_first_class {
    public static void main(String[] args) throws SQLException {
    Class<Driver> driverClass = Driver.class;
        String password = "sasha";
        String userName = "postgres";
        String url = "jdbc:postgresql://localhost:5432/Fierst_Database";
        DriverManager.getConnection(url, userName, password);

    }
}
