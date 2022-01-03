package com.dalhousie.group14.Database.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @Author: Harjot Singh
 * @NameofFile: IProjectDatabaseInteraction.java
 * @InterfaceDescription: This interface is used for the purpose of providing
 * database interaction for the projects.
 */
public interface IProjectDatabaseInteraction {
  boolean insertProjectDB(String project_name, Date start_date, Date end_date
      , List<String> languages, Map<Date, String> milestones, String clientID);

  boolean projectExistsCheck(String Projectname);

  boolean projectStatusCheck(String clientID);

  List<String> projectPendingFeedback(String clientID);

  void projectFeedbackInsert(String projectID, int feedback);
}
