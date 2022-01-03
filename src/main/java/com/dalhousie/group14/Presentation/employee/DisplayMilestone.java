/**
 * Author: Aadil Shaikh
 * This class displays the milestones for employee
 */
package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Database.employee.MilestoneOperations;

import java.util.List;
import java.util.Scanner;

public class DisplayMilestone {

  public void display() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Milestone Deadlines: ");
    System.out.println();
    String empID = "17";
    List<String> milestoneInfo;
    MilestoneOperations milestoneOperations = new MilestoneOperations();
    milestoneInfo = milestoneOperations.getMilestone(empID);
    for (int i = 0; i < milestoneInfo.size() / 4; i++) {
      System.out.print("\nMilestone " + (i + 1));
      System.out.print("\nMilestone ID: ");
      System.out.print(milestoneInfo.get(0 + (i * 4)));
      System.out.print("\nMilestone Description: ");
      System.out.print(milestoneInfo.get(1 + (i * 4)));
      System.out.print("\nProjectID: ");
      System.out.print(milestoneInfo.get(2 + (i * 4)));
      System.out.print("\nDeadline: ");
      System.out.print(milestoneInfo.get(3 + (i * 4)) + "\n");
      System.out.println();
      System.out.println("Enter exit to go back to previous screen.");
      String input = scanner.nextLine();
      EmployeeProjectHandling employeeProjectHandling =
          new EmployeeProjectHandling();
      employeeProjectHandling.display();
    }
  }
}
