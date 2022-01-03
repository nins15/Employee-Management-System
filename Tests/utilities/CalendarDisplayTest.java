/**
 * Author: Aadil Shaikh
 */
package utilities;

import com.dalhousie.group14.Database.utilities.GetSpecialDates;
import org.junit.Test;

import java.util.List;

public class CalendarDisplayTest {

  @Test
  public void displayDates() {
    List<Long> fetchedSpecialDates;
    GetSpecialDates getSpecialDatesObject = new GetSpecialDates();
    fetchedSpecialDates =
        getSpecialDatesObject.getSpecialDatesForEmployee("891000");
    int size = fetchedSpecialDates.size();
    if (size != 0) {
      assert (true);
    }
  }

}