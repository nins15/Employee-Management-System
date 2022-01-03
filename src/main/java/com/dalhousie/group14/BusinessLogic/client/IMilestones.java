package com.dalhousie.group14.BusinessLogic.client;

import java.util.Date;
import java.util.Map;
/**
 * @Author: Harjot Singh
 * @NameofFile: IMilestones.java
 * @InterfaceDescription: This interface defines the method definemilestones,
 * which validates the user input against the low and high range.
 */
public interface IMilestones {
  Map<Date, String> definemilestones(Integer m_no, Date start_date, Date end_date,
                                     Date milestone_date, String milestone_desc);
}
