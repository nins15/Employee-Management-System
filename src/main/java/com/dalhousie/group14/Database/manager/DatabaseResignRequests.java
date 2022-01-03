package com.dalhousie.group14.Database.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dalhousie.group14.Database.utilities.DbConnection;

public class DatabaseResignRequests implements IDatabaseResignRequests {

  public void selectResignRequests() {
    try {
      Connection connection = null;
      connection = DbConnection.connectDB();
      String query1 = "select rr.EmployeeID, rr.ManagerID, rr.RequestID, rr.ResignDate, rr.NoticePeriod, rr.Reason, rr.ApprovedStatus, e.UserName from Employee e inner join ResignRequest rr on rr.EmployeeID=e.EmployeeID; ";
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(query1);
      while (rs.next()) {
        System.out.printf("%10s %15s %30s %35s %30s %30s %30s %30s", rs.getInt("rr.EmployeeID"), rs.getInt("rr.ManagerID"),
            rs.getInt("rr.RequestID"), rs.getDate("rr.ResignDate"), rs.getInt("rr.NoticePeriod"),
            rs.getString("rr.Reason"), rs.getString("rr.ApprovedStatus"), rs.getString("e.UserName"));
        System.out.println();
      }
      stmt.close();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}

