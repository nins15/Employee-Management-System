package com.dalhousie.group14.Database.client;

import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
import com.dalhousie.group14.Database.manager.ProjectStatusRetrieve;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectDatabaseInteraction.java
 * @ClassDescription: This class is used for the purpose of providing
 * database interaction for the projects.
 */
public class ProjectDatabaseInteraction implements IProjectDatabaseInteraction {
  public static final String pattern = "yyyy-MM-dd";
  public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

  public boolean insertProjectDB(String projectName, Date startDate,
                                 Date endDate, List<String> languages,
                                 Map<Date, String> milestones,
                                 String clientID) {
    System.out.println("Processing and validating your inputted data. Please " +
        "wait.");
    String projectLanguages = String.join(", ", languages);
    String projectStatus = "Initiation";
    boolean clientFeedbackStatus = false;
    String clientFeedback = "None";
    String query = "INSERT INTO Project (ProjectName, ProjectLanguages, " +
        "ProjectStartDate, ProjectEndDate, ProjectStatus, Assigned, " +
        "ClientID, ClientFeedbackStatus, ClientFeedback)"
        + "Values('" + projectName + "','" + projectLanguages + "','"
        + sdf.format(startDate) + "','" + sdf.format(endDate)
        + "','" + projectStatus +"',"+clientFeedbackStatus + ",'" + clientID +
        "',"+clientFeedbackStatus+",'"+clientFeedback+"');";

    QueryExecutor.writeData(query);
    query = "Select ProjectID from Project where ProjectName='" + projectName + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    int projectid;
    try {
      if (resultSet !=null && resultSet.isBeforeFirst()) {
        resultSet.next();
        String incoming = resultSet.getString("ProjectID");
        projectid = Integer.parseInt(incoming);
        IMilestonesDatabaseInteraction.insertmilestones(projectid, milestones);
        return true;
      }
    } catch (SQLException | NumberFormatException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }

  public boolean projectExistsCheck(String Projectname) {

    String query = "Select ProjectName from Project where ProjectName='" + Projectname + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if (resultSet == null) {
      return true;
    }
    return false;
  }

  public boolean projectStatusCheck(String clientID) {
    String query = "Select * from Project where ClientID='" + clientID + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if(resultSet == null){
      return false;
    }
    IProjectStatusRetrieve iProjectStatusRetrieve = new ProjectStatusRetrieve();
    iProjectStatusRetrieve.projectList(resultSet);
    return true;
  }

  public List<String> projectPendingFeedback(String clientID) {
    String projStatus = "Finished";
    String query = "Select * from Project where ClientID='"
        + clientID + "' " + "AND ProjectStatus='"+projStatus+
        "' AND ClientFeedbackStatus=false";
    ResultSet resultSet = QueryExecutor.readData(query);
    try {
      if(resultSet == null || !resultSet.isBeforeFirst()){
        return null;
      }
    } catch (SQLException throwables) {
      return null;
    }
    IProjectStatusRetrieve iProjectStatusRetrieve = new ProjectStatusRetrieve();
    List<String> feedbackProjectsList = iProjectStatusRetrieve.projectList(resultSet);
    return feedbackProjectsList;
  }

  public void projectFeedbackInsert(String projectID, int feedback){
    boolean feedbackStatus = true;
    String query = "UPDATE Project SET ClientFeedbackStatus="+feedbackStatus+
        ",ClientFeedback='"+feedback+"' WHERE ProjectID='"+projectID+"';";
    QueryExecutor.writeData(query);
  }
}
