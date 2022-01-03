package com.dalhousie.group14.BusinessLogic.manager;

import java.util.List;
import java.util.Set;
/**
 * @Author: Harjot Singh
 * @NameofFile: IProjectAssigner.java
 * @InterfaceDescription: This interface declares the methods which are used
 * to assign the projects to the best qualifying employees.
 */
public interface IProjectAssigner {

  String assignProject(String projectInfo);

  Set<String> empAssigner(List<String> requiredlanguages);

  boolean assignPerfectFit(List<String> requiredlanguages);

  boolean assignDuoFit(List<String> requiredlanguages);

  boolean assignSingleFit(List<String> singleFitemployees);

  boolean assignAnyFit();
  

}
