package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
import com.dalhousie.group14.Database.manager.ProjectStatus;

import java.sql.ResultSet;
/**
 * @Author: Harjot Singh
 * @NameofFile: FinishedProjects.java
 * @ClassDescription: This class is used for the purpose of providing
 * the screen for finished projects.
 */
public class FinishedProjects implements IFinishedProjects {

  public void displayFinishedProjects(IProjectStatusRetrieve projectStatusRetrieve){
    ResultSet resultSet = ProjectStatus.checkStatus("Finished");
    if (resultSet != null) {
      System.out.println("Here are the finished projects");
      projectStatusRetrieve.projectList(resultSet);
    }else{
      System.out.println("No finished projects.");
    }

  }
}
