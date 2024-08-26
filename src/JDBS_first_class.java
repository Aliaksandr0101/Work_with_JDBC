import java.sql.*;

public class JDBS_first_class {

    private static final String URL = "jdbc:postgresql://localhost:5432/Fierst_Database";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "sasha";

    public static void main(String[] args) {
        Class<Driver> driverClass = Driver.class;
        Connection connection = null;

        String createTable = "CREATE TABLE IF NOT EXISTS pets ( " +
                " pets_id INT PRIMARY KEY, " +
                " kind_of_animal VARCHAR(50), " +
                " name_of_animal VARCHAR(50), " +
                " color_of_animal VARCHAR(50), " +
                " age_of_animal INT ) " ;

        String insertPets = "INSERT INTO pets OVERRIDING SYSTEM VALUE VALUES " +
                "(1, 'dog', 'Barsik', 'black', 4 )," +
                " (2,'horse', 'Iva', 'white', 6 )," +
                "(3, 'duck', 'Happy', 'grey', 9 )" ;

        String insertPetsWhichBrownColor = "INSERT INTO pets OVERRIDING SYSTEM VALUE VALUES " +
                "(4, 'cat', 'Masha', 'brown', 5 )," +
                " (5, 'pig', 'Ivi', 'white', 4 )," +
                "(6, 'cow', 'Suny', 'brown', 5 )" ;

        String deletePet = "DELETE FROM pets WHERE color_of_animal = 'brown' ";



        String output = "SELECT pets_id, kind_of_animal, name_of_animal, color_of_animal, age_of_animal FROM pets where age_of_animal < 8";

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(createTable);
            statement.execute(insertPets);
            statement.execute(insertPetsWhichBrownColor);
            System.out.println("Number of pets added = " + statement.getUpdateCount());
            int rowsAffected = statement.executeUpdate(deletePet);
            System.out.println("Strings deleted = " + rowsAffected);

            ResultSet resultSet = statement.executeQuery(output);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + " - ");
                System.out.print(resultSet.getString(2) + " - ");
                System.out.print(resultSet.getString(3) + " - ");
                System.out.print(resultSet.getString(4) + " - ");
                System.out.println(resultSet.getInt(5));
            }


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

