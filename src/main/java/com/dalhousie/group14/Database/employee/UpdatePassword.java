package com.dalhousie.group14.Database.employee;
/*Author- Jainam Shah(B00883898)*/

import com.dalhousie.group14.BusinessLogic.employee.ChangePassword;
import com.dalhousie.group14.BusinessLogic.employee.IChangePassword;
import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePassword {

  public void updatePassword(String userName, String password) {

    Statement statement;
    int resultSet;
    IChangePassword changePassword = new ChangePassword();
    String query = "UPDATE `ems`.`LoginInfo` SET `Password` = '" + password + "' WHERE (`UserName` = '" + userName + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update password Successfully");
      } else {
        System.out.println("Password not update please check your employee id.");
        changePassword.changePassword();
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}
