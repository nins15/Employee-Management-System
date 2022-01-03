/**
 * This class modifies an event in the calendar
 * Author : Aadil Shaikh
 */
package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.EventOperations;
import com.dalhousie.group14.Presentation.utilities.CalendarDisplay;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class CalendarModifyEvent implements ICalendarScreen {

  public void displayScreen() {
    Scanner scanner = new Scanner(System.in);
    String employeeID = "17";
    LocalDate currentDate = LocalDate.now();
    int currentYear = currentDate.getYear();
    int currentMonth = currentDate.getMonth().getValue();
    CalendarDisplay calendarDisplay = new CalendarDisplay();
    calendarDisplay.displayThreeMonths(currentYear, currentMonth,
        employeeID);
    System.out.println("-----------------------------MODIFY EVENT------------------");
    System.out.println("Enter the date of event to modify (FORMAT - YYYY-MM-DD): ");
    System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08]");
    String date = scanner.nextLine();
    try {
      CalendarEvent e = CalendarEvent.searchEvent(date);
      if (e.getEventName() != null) {
        System.out.println("Enter the new name of event: ");
        String newname = scanner.nextLine();
        System.out.println("Enter the date of event (FORMAT - YYYY-MM-DD): ");
        System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08].");
        System.out.println("Keep the date as it is if you dont want to change it.");
        String newdate = scanner.nextLine();
        System.out.println("Enter the new description name of event: ");
        String newdesc = scanner.nextLine();
        CalendarEvent enew = new CalendarEvent(newname, newdesc, newdate);
        EventOperations.searchEventAndModify(enew, date);
        System.out.println("Updated the event successfully");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    ICalendarScreen cs1 = new CalendarMainScreen();
    cs1.displayScreen();

  }
}
