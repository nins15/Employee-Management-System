package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Author- Jainam Shah(B00883898)*/
public class DisplayEmployeeLoginInfo implements IDisplayEmployeeLoginInfo {

  /* This method Display Employee information.
   */

  public void displayEmployeeLoginInfo(String username) {

    Statement statement;
    ResultSet resultSet;
    String query = "select * from LoginInfo where UserName ='" + username + "'";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println("EmployeeUserName:" + resultSet.getString(
            "UserName"));
        System.out.println("Password:" + resultSet.getString("Password"));
        System.out.println("userType:" + resultSet.getString("userType"));
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
