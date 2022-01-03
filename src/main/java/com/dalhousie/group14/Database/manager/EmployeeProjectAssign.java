package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
/**
 * @Author: Harjot Singh
 * @NameofFile: EmployeeProjectAssign.java
 * @ClassDescription: This class is used for the purpose of providing
 * database interaction for assigning the projects.
 */
public class EmployeeProjectAssign {
  public static boolean assignEmp(String projectID, Set<String> assignedEmployees){
    String query = "Select milestoneID from milestones where " +
        "ProjectID='"+projectID+"';";
    ResultSet resultSet = QueryExecutor.readData(query);
    for(String employeeID : assignedEmployees){
      query =
          "Update EmployeeTechDetails SET Assigned=true,CurrentProject='"+projectID+"' " +
          "where " + "EmployeeID='"+employeeID+"';";
      QueryExecutor.writeData(query);
      query = "Update Project SET ProjectStatus='Assigned' where ProjectID='"+projectID+"';";
      QueryExecutor.writeData(query);
      if(resultSet!=null){
        try {
          if(resultSet.next()){
            String milestoneID = resultSet.getString("milestoneID");
            query = "Update milestones SET AssignedTo='"+employeeID+"' where milestoneID='"+milestoneID+"';";
            QueryExecutor.writeData(query);
          }
        } catch (SQLException throwables) {
          return false;
        }
      }
    }
    return true;
  }
}
