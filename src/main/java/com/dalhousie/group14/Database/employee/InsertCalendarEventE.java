/**
 * Author: Aadil Shaikh
 * This class is responsible to add an event to our database.
 * It inserts events that are created by employee.
 */
package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

public class InsertCalendarEventE {

  public static void insertEvent(CalendarEvent calendarEvent) {
    String query = "INSERT INTO `Calendar` (eventName,eventDescription,eventDate,empID,createdByManager) VALUES ('" + calendarEvent.getEventName() + "','" + calendarEvent.getEventDescription() + "','" + calendarEvent.getEventDate() + "'," + calendarEvent.getEmpID() + ",'" + calendarEvent.getCreatedByManager() + "')";
    QueryExecutor.writeData(query);
  }
}
