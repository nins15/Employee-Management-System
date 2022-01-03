package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.InputValidation;
import com.dalhousie.group14.Database.manager.DatabaseMediclaimRequests;
import com.dalhousie.group14.Database.manager.IManagerDatabaseMediclaimRequests;

import java.util.Scanner;

/**
 * @Author: Ria Shah
 * @NameofFile: MediclaimRequests.java
 * @ClassDescription: This class will display the list of all the mediclaim
 * requests to the manager on his
 * manager dashboard such as Name, Policy Number,Medical
 * ID, Remaining Money, Money Claimed,Reason columns. It will also validate
 * all the user inputs.
 */
public class MediclaimRequests implements IMediclaimRequest {

  public void displayMediclaimRequests() {
    IManagerDatabaseMediclaimRequests mediclaimrequestsdb =
        new DatabaseMediclaimRequests();
    InputValidation object4 = new InputValidation();
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----LIST OF MEDICLAIM REQUESTS-----" +
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    System.out.printf("%20s %30s %35s %35s %35s %30s", "NAME", "POLICY NUMBER"
        , "MEDICAL ID", "MONEY CLAIMED", "REASON", "APPROVED STATUS\n\n");
    mediclaimrequestsdb.displayMediclaimRequestsManager();
    System.out.println("\nDo you want to approve or reject the pending " +
        "requests?\nType Y for yes or N for no");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();
    if (object4.validateInput(input)) {
      if (input.equalsIgnoreCase("Y")) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the name of employee you want to approve the request");
        String name = scanner1.nextLine();
        object4.validateNameRequestApproval(name);
        IDisplayUpdatedMediclaimRequests iDisplayUpdatedMediclaimRequests =
            new DisplayUpdatedMediclaimRequests();
        iDisplayUpdatedMediclaimRequests.displayUpdatedMediclaimRequests();

      } else if (input.equalsIgnoreCase("N")) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the name of employee you want to reject the request");
        String name = scanner1.nextLine();
        object4.validateNameRequestRejection(name);
        IDisplayUpdatedMediclaimRequests iDisplayUpdatedMediclaimRequests =
            new DisplayUpdatedMediclaimRequests();
        iDisplayUpdatedMediclaimRequests.displayUpdatedMediclaimRequests();

      }
    } else if (!object4.validateInput(input)) {
      System.out.println("You have entered wrong input.Please try again.");
      displayMediclaimRequests();
    }
  }

}



