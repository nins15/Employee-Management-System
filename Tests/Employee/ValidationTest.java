package Employee;

import com.dalhousie.group14.BusinessLogic.employee.Validation;
import com.dalhousie.group14.BusinessLogic.manager.InputValidation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Ria Shah
 */
public class ValidationTest {

  @Test
  public void validateNameTest() {
    String name = "shahria@gmail.com";
    Validation validation = new Validation();
    assertTrue("name is not  valid", validation.validateName(name));
  }

  @Test
  public void validatePolicyNumber() {
    int number1 = -3434;
    Validation validation = new Validation();
    assertFalse("policy number is valid", validation.validatePolicyNumber(number1));

    int number2 = 234;
    assertTrue("policy number is not valid", validation.validatePolicyNumber(number2));
  }

  @Test
  public void validateMoneyClaimed() {
    int amount1 = 50000;
    Validation validation = new Validation();
    assertTrue("amount entered is not valid", validation.validateMoneyClaimed(amount1));

    int amount2 = 0;
    assertFalse(validation.validateMoneyClaimed(amount2));

    int amount3 = -9876;
    assertFalse(validation.validateMoneyClaimed(amount3));

  }

  @Test
  public void validateReason() {
    Validation validation = new Validation();
    String reason1= "good job";
    assertTrue(validation.validateReason(reason1));

    String reason2 = "12345$%";
    assertFalse(validation.validateReason(reason2));

    String reason3 = "@#$%^^^^";
    assertFalse(validation.validateReason(reason3));


  }

  @Test
  public void validateSwitchCaseTest() {
    int option1 = 1;
    InputValidation inputValidation = new InputValidation();
    assertTrue(inputValidation.validateSwitchCase(option1));

    int option2 = 2;
    assertTrue(inputValidation.validateSwitchCase(option2));

    int option3 = 7;
    assertFalse(inputValidation.validateSwitchCase(option3));

    int option4 = 23243;
    assertFalse(inputValidation.validateSwitchCase(option4));
  }

}