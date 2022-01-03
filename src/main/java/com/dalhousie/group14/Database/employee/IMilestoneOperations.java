/**
 * Author : Aadil Shaikh
 * This interface is responsible to define milestone operations.
 * getMilestone() : to get milestones of a specific employee.
 * completeMilestone() : to record a completed milestone.
 */
package com.dalhousie.group14.Database.employee;

import java.util.Date;
import java.util.List;

public interface IMilestoneOperations {

  List<String> getMilestone(String empID);

  void completeMilestone(int milestoneID, String empID, Date date);
}
