package utilities;

import com.dalhousie.group14.BusinessLogic.utilities.UserTypeCheck;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Ria Shah
 */
public class UserTypeCheckTest {

  @Test
  public void usertypeCheck() {
    int option1 = 5;
    UserTypeCheck userTypeCheck = new UserTypeCheck();
    assertFalse(userTypeCheck.usertypeCheck(option1));

    int option2 = 4;
    assertTrue(userTypeCheck.usertypeCheck(option2));

    int option3 = 0;
    assertFalse(userTypeCheck.usertypeCheck(option3));

  }

}