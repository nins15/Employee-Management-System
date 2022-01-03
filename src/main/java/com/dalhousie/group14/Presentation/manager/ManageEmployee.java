package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

/* Author- Jainam Shah*/
public class ManageEmployee {

  public void manageEmployee() {

    Scanner scanner = new Scanner(System.in);

    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Manage Employee Page:\t\t\t\t\t\t\t\t\t\t\t\t");

    System.out.println("Select any of the following task to perform on " +
        "Employee:");

    int select;
    boolean decision = true;
    do {
      try {
        System.out.println("Select 1 for Edit Employee Information:\nSelect 2" +
            " for Managing Employee's Calendar:\nSelect 3 for Send a " +
            "Notification:\nSelect 4 for go to the Manager DashBoard" +
            " Page:\nSelect" +
            " 5 for exit.");
        select = scanner.nextInt();

        switch (select) {
          case 1:
            IEditEmployeeInformation employeeInformation =
                new EditEmployeeInformation();
            employeeInformation.editEmployeeInformation();
            break;
          case 2:
            System.out.println("Update Calender");
            break;
          case 3:
            System.out.println("Send a Notification");
            break;
          case 4:
            System.out.println("Salary");
            break;
          case 5:
            decision = false;
            break;
          default:
            System.out.println("Enter Correct number:");
        }
      } catch (Exception e) {
        System.out.println("Exception in ManageEmployee class" + e);
      }
    } while (decision);
  }
}
