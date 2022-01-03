package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.EmployeeDBOperation;
import com.dalhousie.group14.Database.employee.NewEmployee;
import com.dalhousie.group14.Presentation.employee.NewEmployeePresentation;

import java.util.HashMap;
import java.util.Map;

/*Name of the Author:Ninad Nitin Shukla
 *Name of the File:NewEmployeeJoiningRequest
 * Purpose:-This class is responsible for New employees joining request it
 * checks if request is pending or Approved and for login and for applying
 * joining request. It also validates username and password
 * */
public class NewEmployeeJoiningRequest implements INewEmployeeJoiningRequest {

  @Override
  public String checkIfRequestPendingOrApproved(String userName) {
    NewEmployee newEmployee = new NewEmployee();
    Map<String, String> info = new HashMap<>();

    info = newEmployee.getNewEmployeeInfo(userName);
    try {
      if (info.get("approvalstatus") != null && info.get(
          "approvalstatus").equals("pending")) {
        return "pending";
      } else if (info.get("approvalstatus") != null && info.get("approvalstatus").equals("approved")) {
        return "approved";
      } else {
        return " ";
      }
    } catch (NullPointerException e) {
      return null;
    }
  }


  @Override
  public Boolean login(String UserName, String Password) {
    Map<String, String> info = new HashMap<>();
    NewEmployee nd = new NewEmployee();
    info = nd.getNewEmployeeInfo(UserName);
    try {
      if (Password.equals(info.get("Password"))) {
        NewEmployeePresentation newEmployeePresentation = new NewEmployeePresentation();
        NewEmployeeJoiningRequest newEmployeeJoiningRequest = new NewEmployeeJoiningRequest();
        if (newEmployeeJoiningRequest.checkIfRequestPendingOrApproved(UserName).equals("pending")) {
          newEmployeePresentation.requestStillPending();
          return true;
        }
        if (newEmployeeJoiningRequest.checkIfRequestPendingOrApproved(UserName).equals("approved")) {
          newEmployeePresentation.requestApproved();
          return true;
        } else {
          newEmployeePresentation.applyRequestPresentation(UserName);
          return true;
        }
      } else {
        NewEmployeePresentation newEmployeePresentation = new NewEmployeePresentation();
        newEmployeePresentation.incorrectInfo();
        return false;
      }
    } catch (Exception e) {
      return false;
    }

  }

  @Override
  public boolean applyJoinRequest(String oldUserName, String userName,
                                  String password) {
    NewEmployee newEmployee = new NewEmployee();
    try {
      newEmployee.setNewEmployee(oldUserName, "requestedUserName",
          userName);
      newEmployee.setNewEmployee(oldUserName, "requestedPassword",
          password);
      newEmployee.setNewEmployee(oldUserName, "approvalstatus",
          "pending");
      return true;
    } catch (Exception e) {
      return false;
    }

  }

  @Override
  public boolean userNameValidtion(String userName) {
    if (userName != null) {
      NewEmployeePresentation newEmployeePresentation = new NewEmployeePresentation();
      EmployeeDBOperation employeeDBOperation = new EmployeeDBOperation();
      Map<String, String> info = new HashMap<>();
      info = employeeDBOperation.getEmployeeInfo(userName);

      if (!info.isEmpty()) {
        newEmployeePresentation.alreadyExists();

        return false;
      }
      for (int i = 0; i < userName.length(); i++) {
        if (Character.isWhitespace(userName.charAt(i)) || userName.charAt(i) == '@' || userName.charAt(i) == '!' || userName.charAt(i) == '#' || userName.charAt(i) == '$' || userName.charAt(i) == '%' || userName.charAt(i) == '^' || userName.charAt(i) == '&' || userName.charAt(i) == '*' || userName.charAt(i) == '(' || userName.charAt(i) == ')' || userName.charAt(i) == '-' || userName.charAt(i) == '_' || userName.charAt(i) == '+' || userName.charAt(i) == '=') {
          return false;
        }
      }
    }
    return true;
  }


  @Override
  public boolean passwordValidtion(String password) {
    int flag1 = 0;
    int flag2 = 0;

    if (password != null && password.length() >= 4) {

      for (int i = 0; i < password.length(); i++) {
        if (password.charAt(i) == '@' || password.charAt(i) == '!' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^' || password.charAt(i) == '&' || password.charAt(i) == '*' || password.charAt(i) == '(' || password.charAt(i) == ')' || password.charAt(i) == '-' || password.charAt(i) == '_' || password.charAt(i) == '+' || password.charAt(i) == '=') {

          flag1 = 1;
        }
        if (Character.isWhitespace(password.charAt(i))) {
          return false;
        }
        if (Character.isDigit(password.charAt(i))) {
          flag2 = 1;
        }
      }
      if (flag1 == 1 && flag2 == 1) {
        return true;

      }
    }

    return false;


  }

}
