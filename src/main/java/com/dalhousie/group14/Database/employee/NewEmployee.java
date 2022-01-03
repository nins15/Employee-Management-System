package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Name:-Ninad Nitin Shukla
 * File:-NewEmployee
 * This  class is responsible for setting and getting information about new
 * employees
 * */
public class NewEmployee {

  Connection connection = null;

  public NewEmployee() {

    connection = DbConnection.connectDB();
  }

  public Boolean setNewEmployee(String username, String type, String value) {
    try {
      Statement stmt = this.connection.createStatement();
      String sql =
          "UPDATE joinrequest SET " + type + "='" + value + "' WHERE " +
              "TempUserName='" + username + "';";

      stmt.execute(sql);
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }

  public boolean setEmployee(Map<String, String> map) {

    Statement stmt = null;
    try {
      stmt = this.connection.createStatement();
      String sql =
          "insert ignore into Employee (UserName ,ContactName ,gender ," +
              "DOB ," +
              "Basicsalary ,CTC ,bonus ,lastmonthsalary ,EPF ,ProjectHistory) " +
              "values" +
              "('" + map.get("UserName") + "', '" + map.get("ContactName") +
              "', '" + map.get("gender") + "', '" + map.get("DOB") + "', '" + map.get(
              "Basicsalary") +
              "', '" + map.get("CTC") +
              "', '0', '0', '" + map.get("EPF") + "','null');";

      stmt.execute(sql);
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }
  }

  public boolean setLoginInfo(String userName, String Password) {
    Statement stmt = null;
    try {
      stmt = this.connection.createStatement();
      String sql =
          "Insert ignore into LoginInfo values ('" + userName + "', '" + Password +
              "'," +
              "'Employee" +
              "');";
      stmt.execute(sql);
      return true;
    } catch (SQLException throwables) {
      return false;
    }
  }

  public List<List<String>> getPendingNewEmployeeInfo() {
    Statement stmt = null;
    List<List<String>> info = new ArrayList<>();

    try {
      stmt = this.connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM joinrequest WHERE " +
          "approvalstatus='pending';");

      while (rs.next()) {
        List<String> information = new ArrayList<>();
        information.add(rs.getString("TempUserName"));
        information.add(rs.getString("ContactName"));
        information.add(rs.getString("gender"));
        information.add(rs.getString("DOB"));
        information.add(rs.getString("approvedBasicsalary"));
        information.add(rs.getString("approvedCTC"));
        information.add(rs.getString("approvedEPF"));
        information.add(rs.getString("requestedUserName"));
        information.add(rs.getString("requestedPassword"));
        info.add(information);

      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return info;

  }

  public Map<String, String> getNewEmployeeInfo(String username) {
    Statement stmt = null;
    Map<String, String> information = new HashMap<String, String>();
    try {
      stmt = this.connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM joinrequest WHERE " +
          "TempUserName='" + username + "';");

      while (rs.next()) {
        information.put("TempUserName", rs.getString("TempUserName"));
        information.put("ContactName", rs.getString("ContactName"));
        information.put("gender", rs.getString("gender"));
        information.put("DOB", rs.getString("DOB"));
        information.put("approvedBasicsalary", rs.getString("approvedBasicsalary"));
        information.put("approvedCTC", rs.getString("approvedCTC"));
        information.put("approvedEPF", rs.getString("approvedEPF"));
        information.put("Password", rs.getString("password"));
        information.put("approvalstatus", rs.getString("approvalstatus"));

      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return information;

  }

}



