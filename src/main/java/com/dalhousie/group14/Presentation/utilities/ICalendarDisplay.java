/**
 * Author : Aadil Shaikh
 * Interface for Calendar Display Screen.
 */
package com.dalhousie.group14.Presentation.utilities;

public interface ICalendarDisplay {

  void display(int year, String employeeID, int current_month,
               int total_months);

  void displayCurrentMonth(int year, int current_month,
                           String employeeID);

  void displayThreeMonths(int year, int current_month,
                          String EmployeeID);

}
