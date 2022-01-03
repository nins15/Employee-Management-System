package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectStatus.java
 * @ClassDescription: This class is used for the purpose of providing the
 * status of the projects.
 */
public class ProjectStatus {
  public static ResultSet checkStatus(String choice){
    String query = "Select * from Project where ProjectStatus='" + choice +
        "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if (resultSet == null){
      return null;
    }
    return resultSet;
  }

  public static Map<String,String> availableEmployees(){
    String query = "Select * from EmployeeTechDetails where Assigned='" + false + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    Map<String,String> availEmp = new HashMap<>();
    if (resultSet == null) {
      return null;
    } else {
      try {
        if (resultSet.isBeforeFirst()) {
          while (resultSet.next()) {
            String employeeID = resultSet.getString("EmployeeID");
            String languages = resultSet.getString("Languages");
            availEmp.put(employeeID, languages);
          }
        }
      } catch (SQLException sqlException) {
        return null;
      }
    }
    return availEmp;
  }
}
