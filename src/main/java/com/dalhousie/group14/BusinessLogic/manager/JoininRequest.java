package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.employee.NewEmployee;
import com.dalhousie.group14.Presentation.manager.JoinRequests;

import java.util.*;
/*Author:-Ninad Nitin Shukla
* Purpose:-Displaying all the Joining Request to the manager and giving
* option to
* */
public class JoininRequest implements IJoininRequest {

  @Override
  public void displayAllRequests() {
    String exit = "";


    do {
      List<List<String>> info = new ArrayList<>();
      NewEmployee newEmployee = new NewEmployee();
      info = newEmployee.getPendingNewEmployeeInfo();
      JoinRequests joinRequests = new JoinRequests();
      joinRequests.allPendingRequests(info);
      int index = joinRequests.enterRequest();


      Map<String, String> map = new HashMap<>();
      map.put("UserName", info.get(index).get(0));
      map.put("ContactName", info.get(index).get(1));
      map.put("gender", info.get(index).get(2));
      map.put("DOB", info.get(index).get(3));
      map.put("Basicsalary", info.get(index).get(4));
      map.put("CTC", info.get(index).get(5));
      map.put("bonus", "0");
      map.put("lastmonthsalary", "0");
      map.put("EPF", info.get(index).get(6));
      map.put("RequestedUserName", info.get(index).get(7));
      map.put("RequestedPassword", info.get(index).get(8));
      if (newEmployee.setLoginInfo(info.get(index).get(7),
          info.get(index).get(8)) && newEmployee.setEmployee(map)) {
        System.out.println(map.get("UserName"));
        newEmployee.setNewEmployee(map.get("UserName"), "approvalstatus",
            "approved");


      } else {
        System.out.println();
      }
      exit = joinRequests.wantToExit();


    } while (exit.equals("yes"));


  }

}
