package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.IEmployeeProjectPerformance;

import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectPerformanceEvaluator.java
 * @ClassDescription: This class is responsible for performing the Employee
 * Evaluation, it has methods which serve the purpose of evaluating the
 * employees on the metrics like discipline and project performance.
 */
public class ProjectPerformanceEvaluator implements IProjectPerformanceEvaluator {
  public static final int PROJ_FULL_RATING = 5;
  public static final int PROJECTS_CONSIDERING = 2;
  public static final int MAX_DEADLINE = 5;
  public static final int LATE_PENALTY = 2;

  public Map<String, Float> evalProjPerformanceAll() {
    float final_proj_rating = 0;
    Map<String, String> empInfo =
        IEmployeeProjectPerformance.projectPerformanceAll();
    Map<String, Float> projPerformance = new HashMap<>();
    if (projPerformance == null) {
      return null;
    } else {
      Set<String> empIDs = empInfo.keySet();
      for (String empID : empIDs) {
        String projectsString = empInfo.get(empID);
        List<String> projectsList =
            Arrays.asList(projectsString.split(","));
        List<String> eligibleProjects =
            IEmployeeProjectPerformance.eligibleProjects(projectsList);
        String[] projectsArray =
            eligibleProjects.toArray(new String[eligibleProjects.size()]);
        if (eligibleProjects.size() >= PROJECTS_CONSIDERING) {
          final_proj_rating = projEvaluator(projectsArray, empID);
        }
        projPerformance.put(empID, final_proj_rating);
      }
    }

    return projPerformance;
  }


  public float evalProjPerformOne(String employeeID) {
    String projects =
        IEmployeeProjectPerformance.employeeProjectPerformance(employeeID);
    float final_rating = 0;
    if (projects == null) {
      return final_rating;
    } else {
      String[] projectsArray = projects.split(",");
      final_rating = projEvaluator(projectsArray, employeeID);
    }

    return final_rating;
  }


}
