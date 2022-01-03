package com.dalhousie.group14.BusinessLogic.client;

import com.dalhousie.group14.Database.client.IProjectDatabaseInteraction;
import com.dalhousie.group14.Database.client.ProjectDatabaseInteraction;
/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectFeedback.java
 * @ClassDescription: This class is responsible for processing the client
 * feedback.
 */
public class ProjectFeedback implements IProjectFeedback {
  private static final int ID_INDEX = 1;

  public void processFeedback(int feedback, String projectInfo){
    String[] projectValues = projectInfo.split("~");
    String projectID = projectValues[ID_INDEX];

    IProjectDatabaseInteraction iProjectDatabaseInteraction =
        new ProjectDatabaseInteraction();

    iProjectDatabaseInteraction.projectFeedbackInsert(projectID,feedback);
  }
}
