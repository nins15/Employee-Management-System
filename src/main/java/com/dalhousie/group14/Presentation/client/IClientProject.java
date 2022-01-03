package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.Database.client.IProjectDatabaseInteraction;
/**
 * @Author: Harjot Singh
 * @NameofFile: IClientProject.java
 * @InterfaceDescription: This class is used for the purpose of providing
 * the screen for the client's project module.
 */
public interface IClientProject {
  boolean defineproject(String clientID);

  boolean defineProjectName(IProjectDatabaseInteraction projectDatabaseInteraction);

  boolean defineProjectLanguages();

  boolean defineProjectDates();

  boolean defineProjectMilestones(IProjectDatabaseInteraction projectDatabaseInteraction, String clientID);
}
