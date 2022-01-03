package com.dalhousie.group14.BusinessLogic.employee;

/**
 * @Author: Ria Shah
 * @Name of File: IValidation.java
 * @Interface Description: This interface will only declare the validateName,
 * validatePolicyNumber, validateMoneyClaimed,and validateReason methods
 * which the base class Validation will implement.
 */
public interface IValidation {

  boolean validateName(String name);

  boolean validatePolicyNumber(int policynumber);

  boolean validateMoneyClaimed(int amount);

  boolean validateReason(String reason);

}
