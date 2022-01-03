package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectOperations implements IProjectOperations {
  public List<String> getProjects(String empID) {
    String query =
        "SELECT * from `Project` where Assigned = '" + empID + "'";
    List<String> projectList = new ArrayList<>();
    try {
      ResultSet rs = QueryExecutor.readData(query);
      int i=0;
      while (rs != null && rs.next()) {
        projectList.add(0 + (i*6),rs.getString("ProjectID"));
        projectList.add(1 + (i*6),rs.getString("ProjectName"));
        projectList.add(2 + (i*6),rs.getString("ProjectLanguages"));
        projectList.add(3 + (i*6),rs.getString("ProjectStartDate"));
        projectList.add(4 + (i*6),rs.getString("ProjectEndDate"));
        projectList.add(5 + (i*6),rs.getString("ProjectStatus"));
      }
    } catch (SQLException e){
      e.printStackTrace();
    }
    return projectList;
  }
}
