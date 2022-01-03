package com.dalhousie.group14.Presentation.manager;

import java.util.List;
import java.util.Scanner;
/*Name:-Ninad Nitin Shukla
* Purpose:-Display of all the Joining Requests*/
public class JoinRequests {


  public void allPendingRequests(List<List<String>> info) {
    System.out.format("%10s%32s%32s%32s%32s%32s%32s%32s%32s", "Index", "Contact" +
            " Name",
        "Gender", "Date of" +
            " Birth",
        "Basic salary", "CTC", "EPF", "RequestedUserName", "RequestedPassword");
    System.out.println(info.size());
    int i = 0;
    for (List<String> item : info) {

      System.out.format("%10s%32s%32s%32s%32s%32s%32s%32s%32s", i,
          item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
          item.get(6), item.get(7), item.get(8));
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
