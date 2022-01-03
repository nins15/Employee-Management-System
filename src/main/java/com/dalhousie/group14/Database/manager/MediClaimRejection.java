package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Ria Shah
 */
public class MediClaimRejection implements IMediclaimRejection {

  static int id = 0;

  public void rejectStatus(String name) {

    try {

      String query1 = "SELECT Medical_ID from MediclaimRequests WHERE name ='" + name + "';";
      ResultSet rs = QueryExecutor.readData(query1);
      while (rs.next()) {
        id = rs.getInt("Medical_ID");
      }
      String query2 = "UPDATE MediclaimRequests SET approved_status = " +
          "'rejected' WHERE Medical_ID ='" + id + "' ;";
      QueryExecutor.writeData(query2);
    } catch (SQLException throwables) {
      System.out.println("Exception caught " + throwables);
    }
  }

}
