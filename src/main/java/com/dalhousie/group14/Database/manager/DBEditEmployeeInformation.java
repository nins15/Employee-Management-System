package com.dalhousie.group14.Database.manager;
/*Author- Jainam Shah(B00883898)*/

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class DBEditEmployeeInformation implements IDBEditEmployeeInformation {

  public ArrayList<EmployeeBean> getAllEmployeeInformation() {

    String query = "SELECT * FROM ems.Employee";
    ResultSet rs;
    Statement statement;
    ArrayList<EmployeeBean> arrayList = new ArrayList<>();
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      rs = statement.executeQuery(query);
      EmployeeBean employeeBean;
      while (rs.next()) {
        employeeBean = new EmployeeBean();
        employeeBean.setEmployeeID(rs.getInt("EmployeeID"));
        employeeBean.setUserName(rs.getString("UserName"));
        employeeBean.setContactName(rs.getString("ContactName"));
        employeeBean.setGender(rs.getString("gender"));
        employeeBean.setDOB(rs.getDate("DOB"));
        employeeBean.setBasicsalary(rs.getInt("Basicsalary"));
        employeeBean.setCTC(rs.getDouble("CTC"));
        employeeBean.setBonus(rs.getInt("bonus"));
        employeeBean.setLastmonthsalary(rs.getInt("lastmonthsalary"));
        employeeBean.setEPF(rs.getDouble("EPF"));
        employeeBean.setProjectHistory(rs.getString("ProjectHistory"));
        arrayList.add(employeeBean);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return arrayList;
  }

  public EmployeeBean getAllEmployeeByID(int employeeID) {

    String query = "SELECT * FROM ems.Employee where EmployeeID='" + employeeID + "'";
    ResultSet rs;
    Statement statement;
    EmployeeBean employeeBean = null;
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      rs = statement.executeQuery(query);

      while (rs.next()) {
        employeeBean = new EmployeeBean();
        employeeBean.setEmployeeID(rs.getInt("EmployeeID"));
        employeeBean.setUserName(rs.getString("UserName"));
        employeeBean.setContactName(rs.getString("ContactName"));
        employeeBean.setGender(rs.getString("gender"));
        employeeBean.setDOB(rs.getDate("DOB"));
        employeeBean.setBasicsalary(rs.getInt("Basicsalary"));
        employeeBean.setCTC(rs.getDouble("CTC"));
        employeeBean.setBonus(rs.getInt("bonus"));
        employeeBean.setLastmonthsalary(rs.getInt("lastmonthsalary"));
        employeeBean.setEPF(rs.getDouble("EPF"));
        employeeBean.setProjectHistory(rs.getString("ProjectHistory"));
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return employeeBean;
  }

  public void employeeUpdate(EmployeeBean employeeBean) {

    String query =
        "UPDATE ems.Employee SET ContactName = '" + employeeBean.getContactName() + "' , gender ='" + employeeBean.getGender() + "', DOB='" + employeeBean.getDOB() + "' WHERE (`EmployeeID` = '" + employeeBean.getEmployeeID() + "')";
    int result;
    Statement statement;
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      result = statement.executeUpdate(query);

      if (result > 0) {
        System.out.println("successfully update employee information.");
      } else {
        System.out.println("Data not Inserted!! please, check your Username ");
      }
    } catch (Exception e) {
      System.out.println("Exception:" + e);
    }
  }

}


