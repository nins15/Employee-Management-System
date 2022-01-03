package com.dalhousie.group14.BusinessLogic.manager;

/**
 * @Author: Ria Shah
 * @NameofFile: IInputValidation.java
 */
public interface IInputValidation {

  boolean validateSwitchCase(int input);

  boolean validateInput(String input);

  void validateNameRequestApproval(String name);

  void validateNameRequestRejection(String name);

}
