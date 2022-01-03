package com.dalhousie.group14.BusinessLogic.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author: Harjot Singh
 * @NameofFile: Milestones.java
 * @ClassDescription: This class is responsible for validating the
 * information entered and passed by the user.
 */
public class Milestones implements IMilestones {
  boolean validinfo = false;
  Map<Date, String> milestones = new HashMap<>();

  public Map<Date, String> definemilestones(Integer m_no, Date start_date, Date end_date, Date milestone_date, String milestone_desc){
    if(milestone_date != null && milestone_date.after(start_date) && milestone_date.before(end_date)){
      milestones.put(milestone_date,milestone_desc);
      validinfo = true;
    }

    if(validinfo){
      return milestones;
    }else{

      return  null;
    }
  }
}
