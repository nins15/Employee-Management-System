package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author- Jainam Shah
 * This class implements the IGetEmployeeUserNameUserID interface.
 * Take manager username and get the managerID.
 */
public class GetManagerUserNameUserID implements IGetManagerUserNameUserID {

  /*Take manager username and get the managerID.
   */
  public int getManagerUserIDFromUserName(String managerName) {

    Statement statement;
    ResultSet rs;
    int managerID = 0;

    String query = "select ManagerID from ems.Manager where UserName = '" + managerName + "'";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      rs = statement.executeQuery(query);
      while (rs.next()) {
        managerID = rs.getInt("ManagerID");
        // System.out.println(managerID);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return managerID;

  }
}
