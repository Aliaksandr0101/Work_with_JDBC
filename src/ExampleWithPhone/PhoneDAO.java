package ExampleWithPhone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {
 private static final String URL = "jdbc:postgresql://localhost:5432/Fierst_Database";
 private static final String USERNAME = "postgres";
 private static final String PASSWORD = "sasha";
 Class<Driver> driverClass = Driver.class;
 Connection connection = null;

 private static final  String addNewPhone = "INSERT INTO phones (id, ownerphone, phonenumber) VALUES (?, ?, ?)";
 private static final  String getAllPhone = "SELECT  id, ownerphone, phonenumber FROM phones";
 private static final  String deletePhone = "DELETE FROM phones WHERE id = ? ";

 private Connection getConnection() throws SQLException {
  return DriverManager.getConnection(URL, USERNAME, PASSWORD);
 }



 public  void setAddNewPhone(int id, String ownerPhone, String phoneNumber) throws SQLException {
connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  PreparedStatement preparedStatement = connection.prepareStatement(addNewPhone);
  preparedStatement.setInt(1, id);
  preparedStatement.setString(2, ownerPhone);
  preparedStatement.setString(3, phoneNumber);
  preparedStatement.executeUpdate();
 }


 public List<Phone> getAllPhone() throws SQLException {
  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  PreparedStatement preparedStatement = connection.prepareStatement(getAllPhone);
  ResultSet resultSet = preparedStatement.executeQuery();
  List<Phone>  phone = new ArrayList<>();
  while (resultSet.next()) {
   Phone newPhone = new Phone();
   newPhone.setId(resultSet.getInt("id"));
   newPhone.setOwnerPhone(resultSet.getString("ownerPhone"));
   newPhone.setPhoneNumber(resultSet.getString("phoneNumber"));
   phone.add(newPhone);
  } return phone;

 }
  public void delete(int id) throws SQLException {
   connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
   PreparedStatement preparedStatement = connection.prepareStatement(deletePhone);
   preparedStatement.setInt(1, id);
   preparedStatement.executeUpdate();
  }



 public boolean addNewPhone1(Phone phone) {
  String query = "INSERT INTO phones (id, ownerphone, phonenumber) VALUES (?, ?, ?)";

  try (Connection connection = getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement(query)) {

   preparedStatement.setInt(1, phone.getId());
   preparedStatement.setString(2, phone.getOwnerPhone());
   preparedStatement.setString(3, phone.getPhoneNumber());

   return preparedStatement.executeUpdate() > 0;
  } catch (SQLException e) {
   e.printStackTrace();
   return false;
  }
 }


}
