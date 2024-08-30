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
 private static final  String updatePhone = "UPDATE phones SET ownerphone = ?, phonenumber = ? WHERE id = ? ";
 private static final  String findPhoneById = "SELECT id, ownerphone, phonenumber FROM phones WHERE id = ? ";

 private Connection getConnection() throws SQLException {
  return DriverManager.getConnection(URL, USERNAME, PASSWORD);
 }

 public Phone findEntityById(int id) throws SQLException {
  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  PreparedStatement preparedStatement = connection.prepareStatement(findPhoneById);
  preparedStatement.setInt(1, id);
  preparedStatement.setInt(1, id);
  ResultSet resultSet = preparedStatement.executeQuery();

  if (resultSet.next()) {
   Phone newPhone = new Phone();
   newPhone.setId(resultSet.getInt("id"));
   newPhone.setOwnerPhone(resultSet.getString("ownerPhone"));
   newPhone.setPhoneNumber(resultSet.getString("phoneNumber"));
   return newPhone;
  }else {
   System.out.println("This phone is not in the table");
   return null;
  }
 }


 public  void setAddNewPhone(int id, String ownerPhone, String phoneNumber) throws SQLException {
connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  PreparedStatement preparedStatement = connection.prepareStatement(addNewPhone);
  preparedStatement.setInt(1, id);
  preparedStatement.setString(2, ownerPhone);
  preparedStatement.setString(3, phoneNumber);
  preparedStatement.executeUpdate();
 }

 public  void updatePhone(Phone phone) throws SQLException {
  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  PreparedStatement preparedStatement = connection.prepareStatement(updatePhone);
  preparedStatement.setString(1, phone.getOwnerPhone());
  preparedStatement.setString(2, phone.getPhoneNumber());
  preparedStatement.setInt(3, phone.getId());
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
  public boolean deleteById(int id) throws SQLException {
   connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
   PreparedStatement preparedStatement = connection.prepareStatement(deletePhone);
   preparedStatement.setInt(1, id);
   int resultDeleted = preparedStatement.executeUpdate();
   if (resultDeleted > 0) {
    System.out.println("Успешно удалена запись с id: " + id);
    return true;
   } else {
    System.out.println("Запись с id: " + "id не найдена.");
    return false;
   }
  }
 public boolean deleteByObject(Phone phone) throws SQLException {
  return deleteById(phone.getId());
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
