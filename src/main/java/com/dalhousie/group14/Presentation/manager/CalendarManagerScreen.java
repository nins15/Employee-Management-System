/**
 * Author: Aadil Shaikh
 * This displays the main screen for manager for employee schedule management.
 */
package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Presentation.employee.ICalendarScreen;

import java.util.Scanner;

public class CalendarManagerScreen implements ICalendarScreen {

  public void displayScreen() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Display an employee's schedule");
    System.out.println("2. Add an event to an employee's calendar.");
    System.out.println("3. Exit");
    int choice = scanner.nextInt();
    switch (choice) {
      case 1:
        DisplayEmployeeSchedule displayEmployeeSchedule =
            new DisplayEmployeeSchedule();
        displayEmployeeSchedule.displayScreen();

      case 2:
        AddEmployeeSchedule addEmployeeSchedule = new AddEmployeeSchedule();
        addEmployeeSchedule.displayScreen();
      default:
        System.out.println("Please enter a valid input!");
        displayScreen();
    }
  }

  public static void main(String[] args) {
    CalendarManagerScreen calendarManagerScreen = new CalendarManagerScreen();
    calendarManagerScreen.displayScreen();
  }
}
