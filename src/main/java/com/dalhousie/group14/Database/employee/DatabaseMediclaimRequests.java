package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Ria Shah
 * @NameofFile: DatabaseMediclaimRequests.java
 * @ClassDescription: This class will insert all the details entered by the
 * employee in the MediclaimRequests table like name, policy number, money
 * claimed, reason,and approved status.
 */
public class DatabaseMediclaimRequests implements IDatabaseMediclaimRequests {

  public void employeeMediclaimRequests(String name, int number, int amount, String reason, String status) {
    Connection connection = DbConnection.connectDB();
    try {
      Statement statement = connection.createStatement();
      String query = "insert into MediclaimRequests(name,policy_number," +
          "money_claimed,reason,approved_status) values('" + name + "', '" + number + "','" + amount + "','" + reason + "','" + status + "')";
      statement.executeUpdate(query);
      System.out.println("inserted");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
