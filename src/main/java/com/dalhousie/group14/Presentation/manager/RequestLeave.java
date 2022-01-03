package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.employee.DBRequestForLeave;
import com.dalhousie.group14.Database.employee.IDBRequestForLeave;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Author Name-Jainam Shah
 * This class implement the IRequestLeave.
 * Manager see the all pending leave requests and manager can approve or
 * cancel the leave request.
 */
public class RequestLeave implements IRequestLeave {

  public void requestLeave() {

    IDBRequestForLeave dbRequestForLeave = new DBRequestForLeave();
    HashMap<Integer, HashMap<String, String>> hashMap;
    hashMap = dbRequestForLeave.getAllLeaveInfo();

    int RemainingLeaves;
    String username;
    String status;
    String days;
    boolean empty;
    Scanner scanner = new Scanner(System.in);
    System.out.println("All are Pending Request:");
    System.out.println("Pending Requests:" + hashMap);
    if (hashMap.isEmpty()) {
      System.out.println("No pending Requests");
    } else {
      try {
        do {
          System.out.println("Enter Username of the employee:");
          username = scanner.nextLine();
          System.out.println("Write Cancel or Approve:");
          status = scanner.nextLine();
          if (status.equalsIgnoreCase("Cancel")) {
            dbRequestForLeave.cancelLeaveRequest(username, status);
            break;
          } else {
            System.out.println("How many days of leaves you want to approved?");
            days = scanner.nextLine();
            System.out.println("Write How many leaves are available for " +
                "Employee:");
            RemainingLeaves = scanner.nextInt();
            dbRequestForLeave.updateLeaveRequest(username, status, days, RemainingLeaves);
          }
        } while (true);
      } catch (Exception e) {
        System.out.println("Exception" + e);
      }
    }
  }
}

