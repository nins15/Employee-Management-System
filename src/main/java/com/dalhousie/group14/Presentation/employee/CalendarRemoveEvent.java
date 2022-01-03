/**
 * This class removes an event from the employee calendar
 * Author : Aadil Shaikh
 */
package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.EventOperations;
import com.dalhousie.group14.Presentation.utilities.CalendarDisplay;
import com.dalhousie.group14.Presentation.utilities.ICalendarDisplay;

import java.time.LocalDate;
import java.util.Scanner;

public class CalendarRemoveEvent implements ICalendarScreen {

  public void displayScreen() {
    Scanner scanner = new Scanner(System.in);
    LocalDate currentDate = LocalDate.now();
    String employeeID = "17";
    int currentYear = currentDate.getYear();
    int currentMonth = currentDate.getMonth().getValue();
    ICalendarDisplay calendarDisplay = new CalendarDisplay();
    calendarDisplay.displayThreeMonths(currentYear, currentMonth, employeeID);
    System.out.println("-----------------------REMOVE EVENT--------------------");
    System.out.println("Enter the date of event to remove (FORMAT - YYYY-MM-DD): ");
    System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08]");
    String date = scanner.nextLine();
    try {
      CalendarEvent e = EventOperations.removeEvent(date);
      System.out.println("Successfully removed the event :-");
      e.display();
      promptEnterKey();
      ICalendarScreen calendarMainScreen = new CalendarMainScreen();
      calendarMainScreen.displayScreen();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void promptEnterKey() {
    System.out.println("Press \"ENTER\" to continue...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }
}
