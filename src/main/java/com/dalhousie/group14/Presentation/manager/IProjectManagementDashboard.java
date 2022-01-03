package com.dalhousie.group14.Presentation.manager;

import java.sql.ResultSet;
import java.util.List;

public interface IProjectManagementDashboard {
  void projDashboard();

  boolean assignAny();

  void displayProjects(String projectListString);
}
