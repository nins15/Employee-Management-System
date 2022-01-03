/**
 * Author: Aadil Shaikh
 * This class is responsible for handling milestone operations.
 * It queries the database for respective operation.
 */
package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MilestoneOperations implements IMilestoneOperations {

  public List<String> getMilestone(String empID) {
    String query =
        "SELECT * from `milestones` where AssignedTo = '" + empID + "'";
    List<String> milestonesList = new ArrayList<>();
    try {
      ResultSet rs = QueryExecutor.readData(query);
      int i = 0;
      while (rs != null && rs.next()) {
        milestonesList.add(0 + (i * 4), rs.getString("milestoneID"));
        milestonesList.add(1 + (i * 4), rs.getString("milestoneDesc"));
        milestonesList.add(2 + (i * 4), rs.getString("ProjectID"));
        milestonesList.add(3 + (i * 4), rs.getString("Deadline"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return milestonesList;
  }

  public void completeMilestone(int milestoneID, String empID, Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String query =
        "UPDATE milestones SET CompletionDate = '" + sdf.format(date) + "'" +
            "WHERE milestoneID = '" + milestoneID + "'" + "AND AssignedTo = '" + empID + "'";
    QueryExecutor.writeData(query);
  }
}
