package com.dalhousie.group14.Presentation.manager;
/*Name:-Ninad Nitin Shukla
* Purpose:- This is the display for Asset requests
* */
import java.util.List;
import java.util.Scanner;

public class AssetRequestPresentation {

  public void allPendingAssetRequests(List<List<String>> info) {
    System.out.format("%32s%32s%32s%32s%32s", "Index", "EmployeeUserName" ,
            "Reason",
        "ApprovdStatus", "Item");

    int i = 0;
    System.out.println();
    for (List<String> item : info) {

      System.out.format("%32s%32s%32s%32s%32s", i,
          item.get(0), item.get(1), item.get(2), item.get(3));
      System.out.println();
      i += 1;
    }

  }

  public int enterRequest() {
    System.out.println("Please enter the requests you want to accept");
    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();
    return option;
  }

  public String wantToExit() {
    String exit=" ";
    Scanner sc =new Scanner(System.in);
    System.out.println("Do you want to continue?[yes/no]");
    exit = sc.next();
    return exit;
  }
}
