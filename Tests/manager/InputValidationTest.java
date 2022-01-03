package manager;

import com.dalhousie.group14.BusinessLogic.manager.InputValidation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Ria Shah
 */
public class InputValidationTest {

  @Test
  public void validateSwitchCase() {
    int input1 = 0;
    InputValidation inputValidation = new InputValidation();
    assertNotEquals(input1, inputValidation.validateSwitchCase(input1));
    assertFalse(inputValidation.validateSwitchCase(input1));

    int input2 = 3;
    assertTrue(inputValidation.validateSwitchCase(input2));

    int input3 = -33434;
    assertFalse(inputValidation.validateSwitchCase(input3));
  }

  @Test
  public void validateInput() {
    String input1 = "Y";
    InputValidation inputValidation = new InputValidation();
    assertTrue(inputValidation.validateInput(input1));

    String input2 = "xyzsw";
    assertFalse(inputValidation.validateInput(input2));

    String input3 = "Yes";
    assertTrue(inputValidation.validateInput(input3));

    String input4 = "n";
    assertTrue(inputValidation.validateInput(input4));

    String input5 = "null";
    assertFalse(inputValidation.validateInput(input5));
  }

}