package com.dalhousie.group14.BusinessLogic.utilities;

import java.util.Map;
/*Name:-Ninad Nitin Shukla
* Interface for Salaries class*/
public interface ISalaries {

  Map viewSalary(String employee);

  boolean updateSalary(String employee, double amount, String salaryType);
}
