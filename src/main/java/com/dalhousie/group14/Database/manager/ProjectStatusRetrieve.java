package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Presentation.manager.IProjectManagementDashboard;
import com.dalhousie.group14.Presentation.manager.ProjectManagementDashboard;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectStatus.java
 * @ClassDescription: This class is used for the purpose of retrieving the
 * status of the projects.
 */
public class ProjectStatusRetrieve implements IProjectStatusRetrieve {

  public List<String> projectList(ResultSet resultSet){
    List<String> projects = new ArrayList<>();
    List<List<String>> projectsList = new ArrayList<>();
    int sNo = 1;
    List<String> tableheaders = Arrays.asList("S.No", "Project ID",
        "Project Name",
        "Project Languages", "Project Start Date", "Project End Date",
        "Project Current Status");
    projectsList.add(tableheaders);

    try{
      while (resultSet.next()){
        String ProjectID = resultSet.getString("ProjectID");
        String ProjectName = resultSet.getString("ProjectName");
        String ProjectLanguages = resultSet.getString("ProjectLanguages");
        String ProjectStartDate = resultSet.getString("ProjectStartDate");
        String ProjectEndDate = resultSet.getString("ProjectEndDate");
        String ProjectStatus = resultSet.getString("ProjectStatus");
        String proj = sNo+ "~" + ProjectID + "~" + ProjectName +
          "~" + ProjectLanguages + "~" + ProjectStartDate + "~"
            + ProjectEndDate + "~" + ProjectStatus;

        List<String> tablerow = Arrays.asList(sNo+"", ProjectID,
            ProjectName, ProjectLanguages, ProjectStartDate, ProjectEndDate,
            ProjectStatus);
        projects.add(proj);
        projectsList.add(tablerow);
        sNo++;
      }
    }catch (SQLException throwables){
      return null;
    }
    String outputProjectString = TableFormatter.formatAsTable(projectsList);
    if(outputProjectString != null){
      IProjectManagementDashboard obj = new ProjectManagementDashboard();
      obj.displayProjects(outputProjectString);
    }

    return projects;
  }
}
