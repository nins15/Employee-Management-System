package com.dalhousie.group14.BusinessLogic.manager;

import java.util.List;
import java.util.Map;
/**
 * @Author: Harjot Singh
 */
public interface IEmpEvaluation {
  String EvaluateAll();

  String EvaluateEmployee(String username);

  String mostDisciplined();

  String leastDisciplined();

  String EoMDisplay();
}
