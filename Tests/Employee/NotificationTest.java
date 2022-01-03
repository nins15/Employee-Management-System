/**
 * Author : Aadil Shaikh
 * Test for notification object.
 */
package Employee;

import com.dalhousie.group14.BusinessLogic.utilities.Notification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

  @Test
  void getMsg() {
    Notification notification = new Notification("Hi","high");
    String notification_msg = notification.getMsg();
    assertEquals("Hi",notification_msg);
  }

  @Test
  void setMsg() {
    Notification notification = new Notification();
    notification.setMsg("Hello");
    assertEquals("Hello",notification.getMsg());
  }
}