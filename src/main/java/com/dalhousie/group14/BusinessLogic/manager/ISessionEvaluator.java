package com.dalhousie.group14.BusinessLogic.manager;

import java.util.Map;
/**
 * @Author: Harjot Singh
 * @NameofFile: IProjectPerformanceEvaluator.java
 * @InterfaceDescription: This interface defines the methods used for
 * determing in the discipline rating.
 */
public interface ISessionEvaluator {
  Map<String, Float> evaluateAllSessions();

  Float evaluateEmployeeSession(String userName);

  String topEmployees();

  String bottomEmployees();

}
