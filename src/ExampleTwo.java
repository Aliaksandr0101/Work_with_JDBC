import java.sql.*;

public class ExampleTwo {

    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        String password = "sasha";
        String userName = "postgres";
        String url = "jdbc:postgresql://localhost:5432/Fierst_Database";
        /*DriverManager.getConnection(url, userName, password);*/

        PreparedStatement preparedStatement = null;
        Connection connection = null;


          connection = DriverManager.getConnection(url, userName, password);
          System.out.println("Соединение с базой данных установлено.");
          String insertPet = "INSERT INTO pets " +
                  "(pets_id, kind_of_animal, name_of_animal, color_of_animal, age_of_animal) VALUES (?, ?, ? , ?, ?)";
        preparedStatement = connection.prepareStatement(insertPet);
        // Первое животное
        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, "Собака");
        preparedStatement.setString(3, "Барс");
        preparedStatement.setString(4, "Серый");
        preparedStatement.setInt(5, 3);
        preparedStatement.executeUpdate();
        // Второе животное
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Кот");
        preparedStatement.setString(3, "Пушистик");
        preparedStatement.setString(4, "Белый");
        preparedStatement.setInt(5, 9);
        preparedStatement.executeUpdate();
// Третье животное
        preparedStatement.setInt(1, 3);
        preparedStatement.setString(2, "Пингвин");
        preparedStatement.setString(3, "Антон");
        preparedStatement.setString(4, "Черно-белый");
        preparedStatement.setInt(5, 9);
        preparedStatement.executeUpdate();
    }
}

