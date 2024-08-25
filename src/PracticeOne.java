public class PracticeOne {

    /*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBS_first_class {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Замените на ваши параметры подключения
            String url = "jdbc:postgresql://localhost:5432/Fierst_Database";
            String user = "postgres";
            String password = "sasha";

            // Устанавливаем соединение
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // Ваши SQL операции

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Проверяем, не равен ли connection null, прежде чем закрывать его
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
}
