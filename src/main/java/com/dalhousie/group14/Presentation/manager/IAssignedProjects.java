package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
/**
 * @Author: Harjot Singh
 * @NameofFile: IAssignedProjects.java
 * @InterfaceDescription: This interface is used for the purpose of providing
 * the screen for the assign projects module.
 */
public interface IAssignedProjects {
  void displayFinishedProjects(IProjectStatusRetrieve projectStatusRetrieve);
}
