/**
 * This class adds an event to employee calendar
 * Author : Aadil Shaikh
 */

package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.InsertCalendarEventE;

import java.util.Scanner;


public class CalendarAddEvent implements ICalendarScreen {

  @Override
  public void displayScreen() {
    String event_name;
    String event_desc;
    String eventDate;
    String empID;
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("---------------ADD AN EVENT--------------");
      System.out.println("Enter the event name: ");
      event_name = scanner.nextLine();
      System.out.println("Enter the event description: ");
      event_desc = scanner.nextLine();
      System.out.println("Enter the event date: ");
      System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08]");
      eventDate = scanner.nextLine();
      System.out.println("Enter your employee ID: ");
      empID = scanner.nextLine();
      CalendarEvent calendarEvent = new CalendarEvent(event_name, event_desc, eventDate, empID);
      InsertCalendarEventE.insertEvent(calendarEvent);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Event added successfully to your calendar");
    CalendarMainScreen cs1 = new CalendarMainScreen();
    cs1.displayScreen();
  }
}
