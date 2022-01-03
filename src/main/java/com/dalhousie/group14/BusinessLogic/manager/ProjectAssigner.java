package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.EmployeeProjectAssign;
import com.dalhousie.group14.Database.manager.ProjectStatus;
import com.dalhousie.group14.Presentation.manager.ProjectManagementDashboard;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;

import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectAssigner.java
 * @ClassDescription: This class is responsible for performing the task of
 * assigning the projects to the best fitting employees.
 */
public class ProjectAssigner implements IProjectAssigner {
  private int assigned = 0;
  private static final int ID_INDEX = 1;
  private static final int NAME_INDEX = 1;
  private static final int LANG_INDEX = 3;
  private static final int COMPLETE_ASSIGNED = 3;
  private static final int MIN = 0;
  private static final int ONE = 1;
  boolean languageContains = false;
  Set<String> assignedemployees = new HashSet<>();
  Map<String, List<String>> empInfo = new HashMap<>();
  Map<String, List<String>> empInfo2 = new HashMap<>();



  public String assignProject(String projectInfo) {
    String[] projectValues = projectInfo.split("~");
    String projectID = projectValues[ID_INDEX];
    String projectName = projectValues[NAME_INDEX];
    String projectLanguages = projectValues[LANG_INDEX];
    List<String> requiredlanguages = languageformatter(projectLanguages);
    Map<String, String> availableEmployees= ProjectStatus.availableEmployees();
    if(availableEmployees == null){
      return null;
    }



    Set<String> assignedEmployees = empAssigner(requiredlanguages);
    if (assignedEmployees == null) {
      return null;
    }
    boolean assignStatus = EmployeeProjectAssign.assignEmp(projectID,
        assignedEmployees);
    if(assignStatus){
      String assignedEmpString =  assignedEmpDetails(assignedEmployees);
      String projectString = "Project Name : " + projectName + " - Project ID" +
          " : "+projectID+"\nProject Lanaguages : "+ projectLanguages;
      assignedEmpString = projectString + "\n"+ assignedEmpString;
      return assignedEmpString;
    }
    return null;
  }

  @Override
  public Set<String> empAssigner(List<String> requiredlanguages) {
    if (assignPerfectFit(requiredlanguages)) {
      return assignedemployees;
    } else if (assignDuoFit(requiredlanguages)) {
      return assignedemployees;
    } else {
      ProjectManagementDashboard obj = new ProjectManagementDashboard();
      if (obj.assignAny() && assignAnyFit()) {
        return assignedemployees;
      }
    }
    return null;
  }


  @Override
  public boolean assignPerfectFit(List<String> requiredlanguages) {
    Set<String> keys = empInfo.keySet();
    List<String> emplanguages;

    for (String key : keys) {
      emplanguages = empInfo.get(key);

      if (emplanguages.containsAll(requiredlanguages)) {
        assignedemployees.add(key);
        assigned++;
      }
      if (assigned == COMPLETE_ASSIGNED) {
        return true;
      }
    }
   removeDuplicates();
    return false;
  }

  @Override
  public boolean assignDuoFit(List<String> requiredlanguages) {
    Set<String> keys = empInfo.keySet();
    List<String> emplanguages;
    List<String> singleFitemployees = new ArrayList<>();
    for (String key : keys) {
      int lcount = MIN;
      emplanguages = empInfo.get(key);
      for (String emplanguage : emplanguages) {
        languageContains = false;
        if (requiredlanguages.contains(emplanguage)) {
          lcount++;
          languageContains = true;
        }
        if (lcount > 1 && languageContains) {
          assignedemployees.add(key);
          assigned++;
          singleFitemployees.remove(key);
        }
        if (assigned == COMPLETE_ASSIGNED) {
          return true;
        }
        if (lcount == ONE) {
          singleFitemployees.add(key);
        }
      }
    }
    removeDuplicates();
    return assignSingleFit(singleFitemployees);
  }

  @Override
  public boolean assignSingleFit(List<String> singleFitemployees) {
    int i = 0;
    while (i < singleFitemployees.size()) {
      assignedemployees.add(singleFitemployees.get(i));
      empInfo.remove(singleFitemployees.get(i));
      assigned++;
      i++;

      if (assigned == COMPLETE_ASSIGNED) {
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean assignAnyFit() {
    Set<String> keys = empInfo.keySet();
    for (String key : keys) {
      assignedemployees.add(key);
      assigned++;
      if (assigned == COMPLETE_ASSIGNED) {
        return true;
      }
    }
    return false;
  }

  public List<String> languageformatter(String languages) {
    String[] languageArray = languages.split(",");
    List<String> languageList = new ArrayList<>();
    for (String language : languageArray) {
      String formatLanguage = language.trim();
      languageList.add(formatLanguage);
    }

    return languageList;
  }

  private void removeDuplicates(){
    for(String employee: assignedemployees){
      if(empInfo.containsKey(employee)){
        empInfo.remove(employee);
      }
    }
  }

  public String assignedEmpDetails(Set<String> assignedemployees){
    List<List<String>> assignedEmployee = new ArrayList<>();
    List<String> headers = Arrays.asList("Employee ID", "Employee Languages");
    assignedEmployee.add(headers);
    for(String assignedEmp : assignedemployees){
      List<String> aassignedEmpLanguages = empInfo2.get(assignedEmp);
      String empLanguages = String.join(",",aassignedEmpLanguages);
      List<String> row = Arrays.asList(assignedEmp,empLanguages);
      assignedEmployee.add(row);
    }
    return TableFormatter.formatAsTable(assignedEmployee);
  }

}
