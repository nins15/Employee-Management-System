package com.dalhousie.group14.Presentation.manager;
/*Author- Jainam Shah(B00883898)*/

import com.dalhousie.group14.BusinessLogic.manager.AssetRequests;
import com.dalhousie.group14.BusinessLogic.manager.IJoininRequest;
import com.dalhousie.group14.BusinessLogic.manager.JoininRequest;

import java.util.Scanner;

/**
 * Author- Jainam Shah
 * This class handle the all requests.
 */
public class RequestForApprovals implements IRequestForApprovals {

  public void requestForApprovals() {

    Scanner scanner = new Scanner(System.in);
    ManagerLoginDashBoard managerLoginDashBoard =
        new ManagerLoginDashBoard();

    System.out.println("Welcome... You can approve or reject following " +
        "requests.");

    System.out.println("Select 1 for Joining Requests\nSelect 2 for Leave " +
        "Request\nSelect 3 for Resign Request\nSelect 4 for Asset " +
        "Request\nSelect 5 for Mediclaim Request\nSelect 6 for goto Previous " +
        "Page.");

    int select;
    select = scanner.nextInt();
    switch (select) {
      case 1:
        System.out.println("Redirect to Joining Request Page.");
        IJoininRequest IJoininRequest = new JoininRequest();
        IJoininRequest.displayAllRequests();
        break;
      case 2:
        IRequestLeave requestLeave = new RequestLeave();
        requestLeave.requestLeave();
        System.out.println("Request for leave");
        break;
      case 3:
        System.out.println("Redirect to Resign Request Page.");
        ResignRequest obj = new ResignRequest();
        obj.displayResignRequest();
        break;
      case 4:
        System.out.println("Redirect to Asset Request Page.");
        AssetRequests assetRequests =
            new AssetRequests();
        assetRequests.viewRequests("fakeUser");
        break;
      case 5:
        System.out.println("Redirect to Mediclaim Request Page.");
        MediclaimRequests obj3 = new MediclaimRequests();
        obj3.displayMediclaimRequests();
        break;
      case 6:
        managerLoginDashBoard.managerLoginDashBoard();
        ManagerLoginDashBoard obj4 = new ManagerLoginDashBoard();
        obj4.managerLoginDashBoard();
      default:
        System.out.println("Enter valid number:");
    }
  }
}