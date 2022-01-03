package utilities;

import com.dalhousie.group14.Presentation.utilities.Print;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Ria Shah
 */
public class PrintTest {

  @Test
  public void displayMessage() {
    String string = "hello";
    Print object1 = new Print();
    assertEquals(string, object1.displayMessage(string));

    String string1= null;
    assertEquals(string1,object1.displayMessage(string1));
  }

}
