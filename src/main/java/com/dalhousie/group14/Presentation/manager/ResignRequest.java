package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IInputValidation;
import com.dalhousie.group14.BusinessLogic.manager.InputValidation;
import com.dalhousie.group14.Database.manager.*;

import java.util.Scanner;

/**
 * @Author: Ria Shah
 * @NameofFile: ResignRequest.java
 * @ClassDescription: This class will display the list of resignation
 * requests to the manager and will allow the manager to approve or reject the
 * pending resign requests.
 */
public class ResignRequest implements IResignRequestManager {

  public void displayResignRequest() {
    IApprovedStatusbyManager object1 = new ApprovedStatus();
    IRejectedStatus object2 = new RejectedStatus();
    IDatabaseResignRequests object3 = new DatabaseResignRequests();
    IInsertManagerID insert_manager_id = new InsertManagerID();
    IGetManagerID getManagerId = new GetManagerID();
    IInputValidation object4 = new InputValidation();

    try {
      System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----List of Resignation Requests-----\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      System.out.printf("%10s %15s %30s %35s %30s %30s %30s %30s", "EMPLOYEE ID",
          "MANAGER ID", "REQUEST ID", "DATE OF RESIGNATION", "NOTICE PERIOD",
          "REASON FOR THE RESIGNATION", "APPROVED STATUS", "EMPLOYEE " +
              "USERNAME\n");
      object3.selectResignRequests();
      System.out.println("Do you want to approve the pending requests? Type Y for yes or N for no");
      Scanner scanner = new Scanner(System.in);
      String string = scanner.next();
      if (string.equalsIgnoreCase("Y")) {
        System.out.println("Please enter the Employee ID you want to approve");
        int employeeid = scanner.nextInt();
        System.out.println("Please enter your Manager Username");

        String username = scanner.next();
        int managerid = getManagerId.getManagerID(username);
        insert_manager_id.insertManagerID(employeeid, managerid);
        System.out.println("You have selected employeeid " + employeeid + " to approve");
        object1.approveStatus(employeeid);
      } else if (string.equalsIgnoreCase("N")) {
        System.out.println("Please enter the EmployeeID you want to reject");
        int employeeid = scanner.nextInt();

        System.out.println("You have selected employeeid " + employeeid + " to reject");
        object2.rejectStatus(employeeid);
      } else if (string != null) {
        object4.validateInput(string);
        displayResignRequest();
      }

    } catch (Exception exception) {
      System.out.println(exception);
    }
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t----------Below is " +
        "the updated list of Resign " +
        "Requests----------\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    System.out.printf("%10s %15s %30s %35s %30s %30s %30s %30s", "EMPLOYEE " +
            "ID", "MANAGER ID", "REQUEST ID", "DATE OF RESIGNATION", "NOTICE " +
            "PERIOD", "REASON FOR THE RESIGNATION", "APPROVED STATUS",
        "EMPLOYEE USERNAME\n");
    object3.selectResignRequests();
  }

}

