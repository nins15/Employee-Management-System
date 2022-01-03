/**
 * Author : Aadil Shaikh
 * Test for calendar event. It will pass if code runs without any error.
 */
package Employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


class CalendarEventTest {

  @Test
  void searchEvent() throws SQLException {
    CalendarEvent calendarEvent = CalendarEvent.searchEvent("2021-08-05");
    calendarEvent.display();
  }
}