/**
 * Author: Aadil Shaikh
 * This class shows the complete milestone screen.
 */
package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Database.employee.MilestoneOperations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CompleteMilestone {

  public void display() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Complete your milestone: ");
    String empID = "17";
    String date;
    int milestoneID;
    MilestoneOperations milestoneOperations = new MilestoneOperations();
    DisplayMilestone displayMilestone = new DisplayMilestone();
    displayMilestone.display();
    System.out.println("Enter the completion date: ");
    System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08]");
    date = scanner.nextLine();
    System.out.println("Enter your milestoneID: ");
    milestoneID = scanner.nextInt();
    System.out.println();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    Date date1 = new Date();
    try {
      date1 = sdf.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    milestoneOperations.completeMilestone(milestoneID, empID, date1);
    System.out.println("Updated the milestone successfully");
    System.out.println("Enter exit to go back to previous screen.");
    String input = scanner.nextLine();
    EmployeeProjectHandling employeeProjectHandling =
        new EmployeeProjectHandling();
    employeeProjectHandling.display();

  }


}
