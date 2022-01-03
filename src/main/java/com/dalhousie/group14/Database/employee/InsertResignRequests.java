package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * @Author: Ria Shah
 * @NameofFile: InsertResignRequests.java
 * @ClassDescription: This class will insert employeeID, resignDate, reason
 * for resign, and default pending status in the ResignRequest table in the
 * ems Database.
 */
public class InsertResignRequests implements
    IInsertResignRequests {

  private static String approved_status = "pending";

  public void insertResignRequestDetails(int id, LocalDate date, String reason) {
    try {
      Connection connection = DbConnection.connectDB();
      String query1 = "SET FOREIGN_KEY_CHECKS =0";
      Statement stmt = connection.createStatement();
      stmt.execute(query1);
      String query = ("insert into ResignRequest(EmployeeID,ResignDate,Reason,ApprovedStatus)" +
          "values('" + id + "','" + date + "','" + reason + "','" + approved_status + "')");
      stmt.executeUpdate(query);
      String query2 = "SET FOREIGN_KEY_CHECKS =1";
      stmt.execute(query2);

    } catch (SQLException exception) {
      exception.printStackTrace();
    }

  }

}
