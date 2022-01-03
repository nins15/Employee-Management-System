package Employee;

import com.dalhousie.group14.BusinessLogic.employee.ValidateResignRequestEmployee;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Ria Shah
 */
public class ValidateResignRequestEmployeeTest {

  @Test
  public void validateName() {
    String username1 = "shahria75@gmail.com";
    ValidateResignRequestEmployee object = new ValidateResignRequestEmployee();
    assertTrue("not matching output", object.validateName(username1));

    String username2 = "123weee";
    assertFalse("output is matched", object.validateName(username2));

    String username3 = "#$$%%%%";
    assertFalse("output is matched", object.validateName(username3));
  }

  @Test
  public void validateReason() {
    String reason1 = "1234";
    ValidateResignRequestEmployee object = new ValidateResignRequestEmployee();
    assertFalse("same output", object.validateReason(reason1));

    String reason2 = "better job";
    assertTrue("mismatch output", object.validateReason(reason2));
  }

}