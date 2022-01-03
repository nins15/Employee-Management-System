/**
 * This class displays the main screen for calendar operations.
 * It gives various options to add,modify,remove events from the calendar.
 * Author : Aadil Shaikh
 */
package com.dalhousie.group14.Presentation.employee;

import java.util.Scanner;

public class CalendarMainScreen implements ICalendarScreen {

  public void displayScreen() {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("1. Display your schedule");
      System.out.println("2. Add an event in your calendar.");
      System.out.println("3. Modify an event in your calendar");
      System.out.println("4. Delete/Remove an event from your calendar");
      System.out.println("5. Exit");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          CalendarScheduleScreen cs2 = new CalendarScheduleScreen();
          cs2.displayScreen();
        case 2:
          CalendarAddEvent cs4 = new CalendarAddEvent();
          cs4.displayScreen();

        case 3:
          CalendarModifyEvent cs3 = new CalendarModifyEvent();
          cs3.displayScreen();

        case 4:
          CalendarRemoveEvent cs5 = new CalendarRemoveEvent();
          cs5.displayScreen();

        case 5:

          EmployeeLoginDashBoard employeeLoginDashBoard =
              new EmployeeLoginDashBoard();
          employeeLoginDashBoard.employeeLoginDashBoard("harjot@gmail.com");
        default:
          System.out.println("Enter a correct choice");
          displayScreen();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
