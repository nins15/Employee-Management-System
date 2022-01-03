package com.dalhousie.group14.Database.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Ria Shah
 */
public class CheckUsernameExists implements ICheckUsernameExists {

  public boolean checkUsernameExists(String name) {
    Connection connection = DbConnection.connectDB();
    String query = "SELECT UserName FROM ems.LoginInfo WHERE EXISTS (SELECT UserName FROM ems.LoginInfo WHERE UserName ='" + name + "');";

    ResultSet rs = null;
    try {
      Statement statement = connection.createStatement();
      rs = statement.executeQuery(query);
      if (rs.next()) {
        return false;
      } else {
        return true;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return true;
  }

}
