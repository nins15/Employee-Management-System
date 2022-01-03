package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author- Jainam Shah
 * This class implements the IGetEmployeeUserNameUserID interface.
 * Take employee username and get the userId.
 */
public class GetEmployeeUserNameUserID implements IGetEmployeeUserNameUserID {

  /* Take userName as a parameter and return the UserID.
   */
  public int getEmployeeUserIDFromUserName(String userName) {

    Statement statement;
    ResultSet rs;
    int userID = 0;

    String query = "select EmployeeID from ems.Employee where UserName = '" + userName + "'";

    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      rs = statement.executeQuery(query);
      while (rs.next()) {
        userID = rs.getInt("EmployeeID");
        System.out.println(userID);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return userID;
  }

  /* Take userID as a parameter and return the UserName.
   */
  public String getEmployeeUserNameFromUserID(int employeeID) {

    Statement statement;
    ResultSet rs;
    String username = "";
    String query = "select UserName from ems.Employee where EmployeeID = '" + employeeID + "'";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      rs = statement.executeQuery(query);
      while (rs.next()) {
        username = rs.getString("UserName");
        System.out.println(username);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return username;
  }

}
