package ExampleWithPhone;

import java.sql.*;

public class PhoneRunner {

    private static final String URL = "jdbc:postgresql://localhost:5432/Fierst_Database";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "sasha";

    /*public static void main(String[] args) throws SQLException {
        Phone phone = new Phone();

        Class<Driver> driverClass = Driver.class;
        Connection connection = null;
        String createTable = "CREATE TABLE IF NOT EXISTS phones ( " +
                " id INT PRIMARY KEY, " +
                " ownerPhone VARCHAR(50), " +
                " phoneNumber VARCHAR(50))" ;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(createTable);
            System.out.println("Таблица успешно создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PhoneDAO phoneDAO = new PhoneDAO();
        // Добавление нового телефона
        Phone newPhone = new Phone(1, "Petya", "+375257540828");
        boolean created = phoneDAO.addNewPhone1(newPhone);
        System.out.println("Телефон создан: " + created);

        // Вывод всех телефонов
        System.out.println(phoneDAO.getAllPhone());
        //Обновление телефона
        phoneDAO.updatePhone(new Phone(2, "Sasha", "+34578956133"));

    }*/
}
