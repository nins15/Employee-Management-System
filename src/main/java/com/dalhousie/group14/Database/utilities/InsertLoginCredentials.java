package com.dalhousie.group14.Database.utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertLoginCredentials implements IInsertCredentials {

  public void insertLoginCredentials(String emailID, String password,
                                     String userType) {
    try {
      DbConnection dbConnection = new DbConnection();
      Connection connection = null;
      connection = dbConnection.connectDB();
      String query = "insert into LoginInfo values('" + emailID + "', '" + password + "', '" + userType + "');";
      Statement stmt = connection.createStatement();
      stmt.execute(query);
      System.out.println("inserted in LoginInfo table");
      connection.close();
    } catch (SQLException throwables) {
      System.out.println(throwables);
    }

  }

}