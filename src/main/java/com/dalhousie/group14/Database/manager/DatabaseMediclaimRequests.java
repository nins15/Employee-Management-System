package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMediclaimRequests implements IManagerDatabaseMediclaimRequests {

  public void displayMediclaimRequestsManager() {
    try {

      String query = "SELECT * from MediclaimRequests";
      ResultSet rs = QueryExecutor.readData(query);
      while (rs != null && rs.next()) {
        System.out.printf("%20s %30s %35s %35s %35s %30s",
            rs.getString("name"), rs.getInt("policy_number"),
            rs.getInt("Medical_ID"), rs.getLong("money_claimed"),
            rs.getString("reason"), rs.getString("approved_status"));
        System.out.println();
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
