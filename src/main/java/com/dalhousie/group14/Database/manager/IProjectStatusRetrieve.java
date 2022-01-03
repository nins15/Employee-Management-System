package com.dalhousie.group14.Database.manager;

import java.sql.ResultSet;
import java.util.List;
/**
 * @Author: Harjot Singh
 * @NameofFile: IProjectPerformanceEvaluator.java
 * @InterfaceDescription: Used to retrieve the status of the projects
 */
public interface IProjectStatusRetrieve {
  List<String> projectList(ResultSet resultSet);
}
