package com.dalhousie.group14.BusinessLogic.employee;

/**
 * @Author: Ria Shah
 * @NameofFile: Validation.java
 * @ClassDescription: This class will perform the name,policynumber, claimed
 * amount and reason validation
 * entered by the user from the console and return true or false according to
 * the user input.
 */
public class Validation implements IValidation {

  private int flag = 0;
  private final static String pattern5 = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^" +
      ".-]+@[a-zA-Z0-9.-]+$";
  private final static String pattern6 = "^[a-zA-Z\\s]+";

  public int getFlag() {
    return this.flag;
  }


  public boolean validateName(String name) {
    if (name.matches(pattern5)) {
      return true;
    } else {
      return false;
    }
  }

    public boolean validatePolicyNumber(int policynumber) {
    if (policynumber < 0 || policynumber == 0) {
      flag = 1;
      return false;
    } else {
      return true;
    }

  }

  public boolean validateMoneyClaimed(int amount) {
    if (amount < 0 || amount == 0) {
      return false;
    } else {
      return true;
    }
  }

  public boolean validateReason(String reason) {
    if (reason.matches(pattern6)) {
      return true;
    } else {
      return false;
    }
  }

}


