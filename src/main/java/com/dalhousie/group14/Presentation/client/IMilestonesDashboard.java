package com.dalhousie.group14.Presentation.client;

import java.util.Date;
import java.util.Map;
/**
 * @Author: Harjot Singh
 * @NameofFile: IMilestonesDashboard.java
 * @InterfaceDescription: This class is used for the purpose of providing
 * the screen for the client's milestones module.
 */
public interface IMilestonesDashboard {
  Map<Date, String> definemilestonescreen(Date start_date, Date end_date);
}
