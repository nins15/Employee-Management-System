/**
 * Author: Aadil Shaikh
 *
 */
package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Presentation.employee.ICalendarScreen;
import com.dalhousie.group14.Presentation.manager.CalendarManagerScreen;
import com.dalhousie.group14.Presentation.utilities.CalendarDisplay;
import com.dalhousie.group14.Presentation.utilities.ICalendarDisplay;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class DisplayEmployeeSchedule implements ICalendarScreen {

  public void displayScreen() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the employee's ID: ");
    String empID = scanner.nextLine();
    System.out.println("1. Display the current month schedule.");
    System.out.println("2. Display schedule for the next 3 months.");
    System.out.println("3. Display schedule for the entire year.");
    System.out.println("4. Go back to the previous screen.");
    try {
      int choice = scanner.nextInt();
      ICalendarDisplay calendarDisplay = new CalendarDisplay();
      LocalDate currentDate = LocalDate.now();
      int currentYear = currentDate.getYear();
      int currentMonth = currentDate.getMonth().getValue();
      switch (choice) {
        case 1:
          calendarDisplay.displayCurrentMonth(currentYear, currentMonth, empID);
          displayEvent();

        case 2:
          calendarDisplay.displayThreeMonths(currentYear, currentMonth, empID);
          displayEvent();

        case 3:
          calendarDisplay.display(currentYear, empID, 1, 12);
          displayEvent();

        case 4:
          CalendarManagerScreen calendarManagerScreen =
              new CalendarManagerScreen();
          calendarManagerScreen.displayScreen();

        default:
          System.out.println("Please enter a correct choice!");
          displayScreen();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void displayEvent() throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a date to look at the event details: ");
    System.out.println("Enter EXIT to return to previous screen");
    String date = scanner.nextLine();
    if (!date.equals("EXIT")) {
      CalendarEvent e = CalendarEvent.searchEvent(date);
      e.display();
      System.out.println("Press enter to continue...");
      promptEnterKey();
    }
    CalendarManagerScreen calendarManagerScreen = new CalendarManagerScreen();
    calendarManagerScreen.displayScreen();
  }

  public void promptEnterKey() {
    System.out.println("Press \"ENTER\" to continue...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }
}
