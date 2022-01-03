/**
 * Author : Aadil Shaikh
 * This class is responsible for event operations.
 * It searches and modifies the events as per request.
 */
package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventOperations {

  public static List<String> searchEventByDate(String eventDate) throws SQLException {
    String query = "SELECT `eventName`, `eventDescription` FROM `Calendar` WHERE eventDate = '" + eventDate + "'";
    ResultSet rs = QueryExecutor.readData(query);
    List<String> eventInfo = new ArrayList<>();
    while (rs != null && rs.next()) {
      eventInfo.add(rs.getString("eventName"));
      eventInfo.add(rs.getString("eventDescription"));
    }
    return eventInfo;
  }

  public static void searchEventAndModify(CalendarEvent e, String old_date) throws SQLException {
    String query = "UPDATE `Calendar` SET `eventName` = '" + e.getEventName() + "',"
        + " `eventDescription` = '" + e.getEventDescription() + "',"
        + "`eventDate` = '" + e.getEventDate() + "'" + "WHERE `eventDate` = '" + old_date + "'";
    QueryExecutor.writeData(query);
  }

  public static CalendarEvent removeEvent(String eventDate) throws SQLException {
    CalendarEvent e = CalendarEvent.searchEvent(eventDate);
    String query = "DELETE FROM `Calendar` where `eventDate` = '" + eventDate + "'";
    QueryExecutor.writeData(query);
    return e;
  }
}
