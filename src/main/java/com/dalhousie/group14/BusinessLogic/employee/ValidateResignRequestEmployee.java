package com.dalhousie.group14.BusinessLogic.employee;

/**
 * @Author: Ria Shah
 * @NameofFile: ValidateResignRequestEmployee.java
 * @ClassDescription: This class will perform the name and reason validation
 * entered by the user from the console and return true or false according to
 * the user input.
 */
public class ValidateResignRequestEmployee implements IValidateResignRequestEmployee {

  public boolean validateName(String name) {
    if (!name.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
      return false;
    } else {
      return true;
    }
  }

  public boolean validateReason(String reason) {
    if (!reason.matches("[a-zA-Z_\\s]*$")) {
      return false;
    } else {
      return true;
    }
  }

}