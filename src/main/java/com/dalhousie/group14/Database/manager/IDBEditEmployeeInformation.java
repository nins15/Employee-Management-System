package com.dalhousie.group14.Database.manager;

/*Author- Jainam Shah*/

import java.util.ArrayList;

public interface IDBEditEmployeeInformation {

  ArrayList<EmployeeBean> getAllEmployeeInformation();

  EmployeeBean getAllEmployeeByID(int employeeID);

  void employeeUpdate(EmployeeBean employeeBean);
}
