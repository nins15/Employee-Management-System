package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.IEmployeeProjectPerformance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: IProjectPerformanceEvaluator.java
 * @InterfaceDescription: This interface defines the methods used for the
 * determination of the project rating of all the employees and also declares
 * method for determing evaluation of a specific employee.
 */
public interface IProjectPerformanceEvaluator {
  Map<String, Float> evalProjPerformanceAll();

  default float projEvaluator(String[] projectsArray, String employeeID) {
    float MAX_RATING = 0;
    float final_proj_rating = 0;
    int NO_RATING = 0;
    String pattern = "yyyy-MM-dd";

    if (projectsArray.length >= ProjectPerformanceEvaluator.PROJECTS_CONSIDERING) {
      String clientfeedback;
      float cummulitative = 0;
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);
      sdf.setLenient(false);
      for (int i = 0; i < ProjectPerformanceEvaluator.PROJECTS_CONSIDERING; i++) {
        List<String> clientFeedbackList =
            IEmployeeProjectPerformance.projectPerformance(projectsArray[i]);
        Map<String, String> milestonesInfo =
            IEmployeeProjectPerformance.EmpProjectMilestones(projectsArray[i],
                employeeID);
        try {
          if (clientFeedbackList == null || milestonesInfo == null) {
            return NO_RATING;
          }
          clientfeedback = clientFeedbackList.get(NO_RATING);
          MAX_RATING = MAX_RATING + 10;
          Set<String> milestoneDates = milestonesInfo.keySet();
          for (String milestoneDeadlineDate : milestoneDates) {
            String completion_date = milestonesInfo.get(milestoneDeadlineDate);
            Date deadlinedate = sdf.parse(milestoneDeadlineDate);
            Date completiondate = sdf.parse(completion_date);
            boolean beforedeadline = Validations.datecomparison(completiondate, deadlinedate);
            if (beforedeadline) {
              float client_rating = Integer.parseInt(clientfeedback);
              cummulitative =
                  cummulitative + (float) ProjectPerformanceEvaluator.PROJ_FULL_RATING + client_rating;
            } else {
              if (Validations.addDaystoDate(deadlinedate, ProjectPerformanceEvaluator.MAX_DEADLINE).before(completiondate)) {
                float client_rating = Integer.parseInt(clientfeedback);
                float work_rating = ProjectPerformanceEvaluator.PROJ_FULL_RATING - ProjectPerformanceEvaluator.LATE_PENALTY;
                cummulitative = cummulitative + work_rating + client_rating;
              }
            }
          }
        } catch (ParseException e) {
          return NO_RATING;
        }
      }
      final_proj_rating = (cummulitative / MAX_RATING) * 10;
      final_proj_rating = ((int) ((final_proj_rating + 0.005f) * 100)) / 100f;
    }

    return final_proj_rating;
  }

  float evalProjPerformOne(String userName);
}
