package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
/**
 * @Author: Harjot Singh
 * @NameofFile: IPendingProjects.java
 * @InterfaceDescription: This interface is used for the purpose of providing
 * the screen for the pending projects module.
 */
public interface IPendingProjects {
  void displayPendingProjects(IProjectStatusRetrieve projectStatusRetrieve);
}
