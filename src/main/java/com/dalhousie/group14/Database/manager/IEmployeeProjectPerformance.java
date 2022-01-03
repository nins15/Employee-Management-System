package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: EmployeeProjectPerformance.java
 * @InterfaceDescription: This class is used for the purpose of providing
 * database interaction for assigning the projects.
 */
public interface IEmployeeProjectPerformance {
  static Map<String, String> projectPerformanceAll() {
    ResultSet resultSet;
    Map<String, String> empProjInfo = new HashMap<>();
    String query = "select EmployeeID,ProjectHistory from EmployeeTechDetails where " +
        "ProjectHistory is not null";
    resultSet = QueryExecutor.readData(query);
    if (resultSet == null) {
      return null;
    } else {
      try {
        while (resultSet.next()) {
          String employeeID = resultSet.getString("EmployeeID");
          String projectsString = resultSet.getString("ProjectHistory");
          empProjInfo.put(employeeID, projectsString);
        }
      } catch (SQLException sqlException) {
        return null;
      }
    }
    return empProjInfo;
  }

  static void writeprojectPerformanceAll(Map<String, List<Float>> sortedEmpCompleteDetails) {
    Set<String> keys = sortedEmpCompleteDetails.keySet();
    int i = 0;
    for (String key : keys) {
      String employeeID = key;
      List<Float> ratings = sortedEmpCompleteDetails.get(employeeID);
      float disciplineRating = ratings.get(EmployeeProjectPerformance.DRATING_INDEX);
      float projectRating = ratings.get(EmployeeProjectPerformance.PRATING_INDEX);
      float evaluationRating = ratings.get(EmployeeProjectPerformance.ERATING_INDEX);
      boolean EoM = false;
      if (i == 0) {
        EoM = true;
      }
      String query = "INSERT INTO EmployeeRatings (EmployeeID, DisciplineRating," +
          " ProjectRating, EvaluationRating, EoM) VALUES('" + employeeID + "','"
          + disciplineRating + "','" + projectRating + "','" + evaluationRating +
          "'," + EoM + ") ON DUPLICATE KEY UPDATE DisciplineRating ='" + disciplineRating + "', ProjectRating ='" + projectRating + "', EvaluationRating ='" + evaluationRating + "', EoM =" + EoM + ";";
      QueryExecutor.writeData(query);
      i++;
    }
  }

  static String employeeProjectPerformance(String userID) {
    ResultSet resultSet;
    String projList = "";
    String query = "select ProjectHistory from EmployeeTechDetails where " +
        "EmployeeID='" + userID + "';";
    resultSet = QueryExecutor.readData(query);
    if (resultSet == null) {
      return null;
    }
    try {
      if (resultSet.isBeforeFirst()) {
        resultSet.next();
        projList = resultSet.getString("ProjectHistory");
      }


    } catch (SQLException sqlException) {
      return null;
    }
    return projList;
  }

  static List<String> projectPerformance(String projectID) {
    ResultSet resultSet = null;
    List<String> clientFeedbackList = new ArrayList<>();
    String query = "select ClientFeedback from Project where " +
        "ClientFeedbackStatus=true and ProjectID='" + projectID + "';";
    resultSet = QueryExecutor.readData(query);
    if (resultSet == null) {
      return null;
    } else {
      try {
        if (resultSet.isBeforeFirst()) {
          while (resultSet.next()) {
            String clientFeedback = resultSet.getString("ClientFeedback");
            clientFeedbackList.add(clientFeedback);
          }
        }
      } catch (SQLException sqlException) {
        return null;
      }
    }
    return clientFeedbackList;
  }

  static Map<String, String> EmpProjectMilestones(String projectID,
                                                  String employeeID) {

    String query = "Select Deadline,CompletionDate from milestones where " +
        "ProjectID='" + projectID + "'and AssignedTo='" + employeeID + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    Map<String, String> milestoneInfo = new HashMap<>();

    if (resultSet == null) {
      return null;
    } else {
      try {
        if (resultSet.isBeforeFirst()) {
          while (resultSet.next()) {
            String deadline_date = resultSet.getString("Deadline");
            String completion_date = resultSet.getString("CompletionDate");
            milestoneInfo.put(deadline_date, completion_date);
          }
        }
      } catch (SQLException sqlException) {
        return null;
      }
    }

    return milestoneInfo;
  }

  static String DisplayEoM() {
    String query = "Select EmployeeID, DisciplineRating, ProjectRating, EvaluationRating from EmployeeRatings " +
        "where EoM=" + true + ";";
    String employeeName = "";
    List<List<String>> displayEoMtable = new ArrayList<>();
    List<String> displayEoMheaders = Arrays.asList("Employee ID", "Employee " +
        "Name", "Discipline Rating", "Project Rating", "Evaluation Rating");
    displayEoMtable.add(displayEoMheaders);
    ResultSet resultSet = QueryExecutor.readData(query);
    try {
      if (resultSet != null && resultSet.isBeforeFirst()) {
        resultSet.next();
        String employeeID = resultSet.getString("EmployeeID");
        query =
            "Select ContactName from Employee where EmployeeID='" + employeeID +
                "';";
        ResultSet resultSet1 = QueryExecutor.readData(query);
        if (resultSet1 != null) {
          resultSet1.next();
          employeeName = resultSet1.getString("ContactName");
        }
        String disciplineRating = resultSet.getString("DisciplineRating");
        String projectRating = resultSet.getString("ProjectRating");
        String evaluationRating = resultSet.getString("EvaluationRating");
        List<String> displayEoMRow = Arrays.asList(employeeID, employeeName,
            disciplineRating, projectRating, evaluationRating);
        displayEoMtable.add(displayEoMRow);
      }
    } catch (SQLException throwables) {
      return null;
    }

    return TableFormatter.formatAsTable(displayEoMtable);
  }

  static List<String> eligibleProjects(List<String> projectsList) {
    List<String> eligibleProjects = new ArrayList<>();
    String projectStatus = "Finished";
    for (int i = 0; i < projectsList.size(); i++) {
      String query = "Select ClientFeedback from Project where " +
          "ProjectStatus='" + projectStatus + "' and ClientFeedbackStatus=true and " +
          "ProjectID='" + projectsList.get(i) + "';";
      ResultSet resultSet = QueryExecutor.readData(query);
      if (resultSet != null) {
        eligibleProjects.add(projectsList.get(i));
      }
    }
    return eligibleProjects;
  }
}
