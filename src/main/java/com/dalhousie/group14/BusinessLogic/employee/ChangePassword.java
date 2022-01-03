package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DisplayEmployeeLoginInfo;
import com.dalhousie.group14.Database.employee.IDisplayEmployeeLoginInfo;
import com.dalhousie.group14.Database.employee.UpdatePassword;
import com.dalhousie.group14.Presentation.employee.TakeInputsFromEmployee;

import java.util.HashMap;

/* Author- Jainam Shah(B00883898)
 * This class implement the IChangePassword interface.
 * This class for update the userName and Password.
 */
public class ChangePassword implements IChangePassword {

  UpdatePassword updatePassword = new UpdatePassword();

  IDisplayEmployeeLoginInfo displayEmployeeLoginInfo = new
      DisplayEmployeeLoginInfo();

  /* This method update the userName and Password.
   */
  public void changePassword() {

    HashMap<String, String> hashMap;
    TakeInputsFromEmployee inputsFromEmployee = new TakeInputsFromEmployee();
    String userName;
    String password;

    hashMap = inputsFromEmployee.getUserNamePassword();

    userName = hashMap.get("UserName");
    password = hashMap.get("Password");

    updatePassword.updatePassword(userName, password);
    displayEmployeeLoginInfo.displayEmployeeLoginInfo(userName);

  }
}

