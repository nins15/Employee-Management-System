package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEmployeeID implements IGetEmployeeID {

  static int id = 0;

  public int getEmployeeID(String username) {

    try {
      Connection connection = DbConnection.connectDB();
      String query = "select EmployeeID from Employee where UserName='" + username + "';";
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        id = rs.getInt("EmployeeID");

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return id;
  }

}
