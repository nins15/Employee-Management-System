/**
 * This class contains the logic to display calendar.
 * Author : Aadil Shaikh
 */
package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.Database.utilities.GetSpecialDates;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class CalendarDisplay implements ICalendarDisplay {

  int start_month = 1;
  int total_months = 12;
  LocalDate currentDate = LocalDate.now();
  int currentYear = currentDate.getYear();
  int currentMonth = currentDate.getMonth().getValue();
  GetSpecialDates getSpecialDatesObject = new GetSpecialDates();
  List<Long> fetchedSpecialDates = new ArrayList<>();

  public void displayMonths(int year, int month) {
    YearMonth ym = YearMonth.of(year, month);

    int counter = 1;

    System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
    if (dayValue != 7) {
      for (int i = 0; i < dayValue; i++, counter++) {
        System.out.printf("%-4s", "");
      }
    }

    for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, counter++) {
      CRC32 hash = new CRC32();
      hash.reset();
      hash.update(String.format("%d_%d", ym.getMonth().getValue(), i).getBytes());

      if (fetchedSpecialDates.contains(hash.getValue()) && ym.getYear() == currentYear) {
        System.out.printf("\033[4m%-2s\033[0m", i);
        System.out.printf("%-2s", "");
      } else {
        System.out.printf("%-4d", i);
      }

      if (counter % 7 == 0) {
        System.out.println();
      }
    }
    System.out.println();
    System.out.println();

  }

  @Override
  public void display(int year, String employeeID, int current_month,
                      int total_months) {
    try {
      getSpecialDatesEmployee(employeeID);
      for (int i = current_month; i <= total_months; i++) {
        System.out.println(LocalDate.of(year, i, 1).getMonth().toString());
        displayMonths(year, i);
      }
      System.out.println("The dates having events have underlines beneath them.");
      System.out.println("Example: ");
      System.out.printf("\033[4m%-2s\033[0m", 12);
      System.out.println();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void displayCurrentMonth(int year, int current_month,
                                  String employeeID) {
    try {
      getSpecialDatesEmployee(employeeID);
      display(year, employeeID, current_month, current_month + 1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void displayThreeMonths(int year, int current_month,
                                 String EmployeeID) {
    try {
      getSpecialDatesEmployee(EmployeeID);
      display(year, EmployeeID, current_month, current_month + 2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void getAllSpecialDates() {
    fetchedSpecialDates = getSpecialDatesObject.getSpecialDates();
  }

  public void getSpecialDatesEmployee(String employeeID) {
    fetchedSpecialDates = getSpecialDatesObject.getSpecialDatesForEmployee(employeeID);
  }
}
