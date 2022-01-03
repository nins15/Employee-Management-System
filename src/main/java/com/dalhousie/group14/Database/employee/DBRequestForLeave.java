package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.Presentation.employee.EmployeeLoginDashBoard;
import com.dalhousie.group14.Presentation.manager.RequestForApprovals;

import java.sql.*;
import java.util.HashMap;

/**
 * Author- Jainam Shah
 * This class implements the IDBRequestForLeave interface.
 * In this class have different method for send data into database.
 * inserting the Leave data, remaining Leaves,etc.
 */
public class DBRequestForLeave implements IDBRequestForLeave {

  /*This method insert the leave data into database.
   */
  public void insertRequestForLeave(int employeeID, int managerID, Date actualstartingLeaveDate,
                                    Date actualendingLeaveDate, long days, int remainingleaves,
                                    String reason, String status) {
    EmployeeLoginDashBoard employeeLoginDashBoard = new EmployeeLoginDashBoard();
    ResultSet resultSet;
    Statement statement;
    int result;
    String query = "INSERT INTO `ems`.`LeaveRequest` (EmployeeID, ManagerID," +
        "FromDate, ToDate, " +
        "days,RemainingLeaves, Reason,ApprovedStatus)" +
        " VALUES ('" + employeeID + "', '" + managerID + "'," +
        " '" + actualstartingLeaveDate + "', " +
        "'" + actualendingLeaveDate + "', '" + days + "', " +
        "'" + remainingleaves + "', '" + reason + "'," +
        "'" + status + "')";

    try {
      IGetEmployeeUserNameUserID obj = new GetEmployeeUserNameUserID();
      String userName = obj.getEmployeeUserNameFromUserID(employeeID);
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      result = statement.executeUpdate(query);
      if (result > 0) {
        System.out.println("successfully inserted");
        employeeLoginDashBoard.employeeLoginDashBoard(userName);
      } else {
        System.out.println("Data not inserted!! Please check your username: ");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /*
  This method insert the Remaining Leaves data into Reamining Leaves table.
   */
  public void insertRemainingLeaves(int employeeID, int managerID) {

    Statement statement;
    int RemainingLeaves;
    RemainingLeaves = 8;

    int result;
    String query = ("INSERT INTO `ems`.`RemainingLeaves` (`RemainingLeaves`, " +
        "`EmployeeID`, `ManagerID`) VALUES ('" + RemainingLeaves + "', '" + employeeID + "', '" + managerID + "')");
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      result = statement.executeUpdate(query);
      if (result > 0) {
        //System.out.println("successfully inserted.");
      } else {
        System.out.println("Data not inserted in Remaining Leaves Table: ");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  /* this method return the remaining leaves.
   */
  public int remainingLeaves(int userID) {

    Statement stmt;
    ResultSet rs;
    int leaves = 0;
    String query = "select RemainingLeaves FROM ems.RemainingLeaves where EmployeeID = '" + userID + "'";
    try {
      Connection connection = DbConnection.connectDB();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        leaves = rs.getInt("RemainingLeaves");
        System.out.println("Remaining Leaves: " + leaves);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return leaves;
  }

  /* This method return the pending request for leave request.
   */
  public HashMap<Integer, HashMap<String, String>> getAllLeaveInfo() {

    String status;
    status = "pending";
    String username;
    int userid = 0;
    HashMap<Integer, HashMap<String, String>> hashMap = new HashMap<>();
    HashMap<String, String> hashMap2 = new HashMap<>();

    String query = "select * from ems.LeaveRequest where ApprovedStatus ='" + status + "' ";

    ResultSet rs;
    Statement statement;
    IGetEmployeeUserNameUserID getEmployeeUserNameUserID =
        new GetEmployeeUserNameUserID();
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      rs = statement.executeQuery(query);
      while (rs.next()) {

        userid = rs.getInt("EmployeeID");
        username =
            getEmployeeUserNameUserID.getEmployeeUserNameFromUserID(userid);

        hashMap2.put("ManagerID", String.valueOf(rs.getInt("ManagerID")));
        hashMap2.put("FromDate", String.valueOf(rs.getDate("FromDate")));
        hashMap2.put("EmployeeUserName", username);
        hashMap2.put("ToDate", String.valueOf(rs.getDate("ToDate")));
        hashMap2.put("days", rs.getString("days"));
        hashMap2.put("RemainingLeaves", String.valueOf(rs.getInt("RemainingLeaves")));
        hashMap2.put("Reason", rs.getString("Reason"));
        hashMap2.put("ApprovedStatus", rs.getString("ApprovedStatus"));
        hashMap.put(rs.getInt("RequestID"), hashMap2);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return hashMap;
  }

  /*Update the leaveRequest table.
   */
  public void updateLeaveRequest(String userName, String status, String days, int remainingLeaves) {

    int resultSet, EmployeeID;
    Statement statement;
    IGetEmployeeUserNameUserID userNameUserID = new GetEmployeeUserNameUserID();
    RequestForApprovals request = new RequestForApprovals();
    EmployeeID = userNameUserID.getEmployeeUserIDFromUserName(userName);
    String query =
        "UPDATE ems.LeaveRequest SET ApprovedStatus = '" + status + "', " +
            "days='" + days + "'  WHERE (`EmployeeID` = '" + EmployeeID + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Leave Successfully");
        updateRemainingLeaves(EmployeeID, days, remainingLeaves);
        request.requestForApprovals();
      } else {
        System.out.println("Please write the correct UserName:");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /*Cancel the leave request.
   */
  public void cancelLeaveRequest(String userName, String status) {

    int resultSet, EmployeeID;
    Statement statement;
    IGetEmployeeUserNameUserID userNameUserID = new GetEmployeeUserNameUserID();
    EmployeeID = userNameUserID.getEmployeeUserIDFromUserName(userName);
    String query = "UPDATE ems.LeaveRequest SET ApprovedStatus = '" + status + "'WHERE (`EmployeeID` = '" + EmployeeID + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Leave has been Cancel Successfully for :" + userName);
      } else {
        System.out.println("Please write the correct UserName:");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /*Update the remaining leave request.
   */
  private void updateRemainingLeaves(int employeeID, String days, int remainingLeaves) {

    int updateLeavs;
    Statement statement1;
    int resultSet;
    updateLeavs = remainingLeaves - Integer.parseInt(days);
    String query = "UPDATE `ems`.`RemainingLeaves` SET `RemainingLeaves` = '" + updateLeavs + "' " +
        "WHERE (`EmployeeID` = '" + employeeID + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement1 = connection.createStatement();
      resultSet = statement1.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Remaining Leave Successfully");
      } else {
        System.out.println("Error in Update Leave Page, Please write the correct UserName:");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
