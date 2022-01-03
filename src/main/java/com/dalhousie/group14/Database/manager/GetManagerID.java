package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetManagerID implements IGetManagerID {

  private static int id = 0;

  public int getManagerID(String username) {
    Connection connection = DbConnection.connectDB();

    try {
      Statement statement = connection.createStatement();
      String getquery = "select ManagerID from Manager where UserName='" + username + "';";
      ResultSet rs = statement.executeQuery(getquery);
      while (rs.next()) {
        id = rs.getInt("ManagerID");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return id;
  }

}
