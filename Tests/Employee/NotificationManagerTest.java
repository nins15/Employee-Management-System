/**
 * Author : Aadil Shaikh
 * Test for notification manager. It will pass if the function works for
 * getNotifications without any error.
 */
package Employee;

import com.dalhousie.group14.Database.utilities.NotificationManager;
import org.junit.Test;

import java.sql.SQLException;

public class NotificationManagerTest {

    @Test
    public void getNotifications() throws SQLException {
        NotificationManager nm = new NotificationManager();
        nm.getNotifications("891000");
    }
}