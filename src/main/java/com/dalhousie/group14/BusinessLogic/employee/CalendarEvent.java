/**
 * Author : Aadil Shaikh
 * This class is responsible for creating an event object.
 * It creates two types of event objects depending on type of request.
 */

package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.EventOperations;
import com.dalhousie.group14.Presentation.utilities.EventDisplay;

import java.sql.SQLException;
import java.util.List;

public class CalendarEvent {

  private String eventName;
  private String eventDescription;
  private String eventDate;
  private String empID;
  private String managerID;
  private int createdByManager;

  public CalendarEvent() {
  }

  public CalendarEvent(String eventName, String eventDescription, String eventDate, String empID, String managerID, int createdByManager) {
    this.eventName = eventName;
    this.eventDescription = eventDescription;
    this.eventDate = eventDate;
    this.empID = empID;
    this.managerID = managerID;
    this.createdByManager = createdByManager;
  }

  public CalendarEvent(String eventName, String eventDescription, String eventDate, String empID) {
    this.eventName = eventName;
    this.eventDescription = eventDescription;
    this.eventDate = eventDate;
    this.empID = empID;
    this.createdByManager = 0;
  }

  public CalendarEvent(String eventName, String eventDescription, String eventDate) {
    this.eventName = eventName;
    this.eventDescription = eventDescription;
    this.eventDate = eventDate;
  }

  public String getEventName() {
    return eventName;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public String getEventDate() {
    return eventDate;
  }

  public String getEmpID() {
    return empID;
  }

  public int getCreatedByManager() {
    return createdByManager;
  }

  public static CalendarEvent searchEvent(String eventDate) throws SQLException {
    List<String> eventInformation = EventOperations.searchEventByDate(eventDate);
    if (eventInformation.size() != 0) {
      return new CalendarEvent(eventInformation.get(0), eventInformation.get(1), eventDate);
    } else {
      System.out.println("Please enter a correct date. No event found for this date.");
    }
    return new CalendarEvent();
  }

  public void display() {
    EventDisplay eventDisplay = new EventDisplay();
    eventDisplay.display(this);
  }
}
