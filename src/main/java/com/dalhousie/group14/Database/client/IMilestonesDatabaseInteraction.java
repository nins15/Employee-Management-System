package com.dalhousie.group14.Database.client;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
/**
 * @Author: Harjot Singh
 * @NameofFile: IMilestonesDatabaseInteraction.java
 * @InterfaceDescription: This interface is used for the purpose of providing
 * database interaction for the milestones.
 */
public interface IMilestonesDatabaseInteraction {
  static void insertmilestones(int project_id, Map<Date, String> milestones) {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    Set<Date> mdates = milestones.keySet();
    for (Date s : mdates) {
      String query = "INSERT INTO milestones (milestoneDesc, ProjectID, Deadline)" + "Values('" + milestones.get(s) + "','" + project_id + "','" + sdf.format(s) + "');";
      QueryExecutor.writeData(query);
    }

  }
}
