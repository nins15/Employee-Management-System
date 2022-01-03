package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
/**
 * @Author: Harjot Singh
 * @NameofFile: IFinishedProjects.java
 * @InterfaceDescription: This interface is used for the purpose of providing
 * the screen for the finished projects module.
 */
public interface IFinishedProjects {

  void displayFinishedProjects(IProjectStatusRetrieve projectStatusRetrieve);
}
