package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.IValidateResignRequestEmployee;
import com.dalhousie.group14.BusinessLogic.employee.ValidateResignRequestEmployee;
import com.dalhousie.group14.Database.employee.GetEmployeeID;
import com.dalhousie.group14.Database.employee.IGetEmployeeID;
import com.dalhousie.group14.Database.employee.IInsertResignRequests;
import com.dalhousie.group14.Database.employee.InsertResignRequests;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @Author: Ria Shah
 * @NameofFile: MakeResignRequest.java
 * @ClassDescription: This class will provide the user to make the resign
 * request by entering the required details on the console.
 */
public class MakeResignRequest implements IResignRequest {

  Scanner scanner = new Scanner(System.in);
  IGetEmployeeID idobject = new GetEmployeeID();
  IInsertResignRequests insertobject = new InsertResignRequests();
  IValidateResignRequestEmployee validate = new ValidateResignRequestEmployee();


  public void resignRequest() {
    try {
      System.out.println("You are in the Apply for Resign Request Screen");
      System.out.println("Enter your username");
      String username = scanner.nextLine();
      if (validate.validateName(username) == false) {
        System.out.println("Username entered is invalid. Please try again.");
        resignRequest();
      } else if (validate.validateName(username) == true) {
        System.out.println("username is valid");

        idobject.getEmployeeID(username);
        System.out.println("Your ResignDate in yyyy/MM/dd format is:");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println("Enter the reason for resignation");
        Scanner scanner1 = new Scanner(System.in);
        String reason = scanner1.nextLine();
        if (!validate.validateReason(reason)) {
          System.out.println("Reason entered is not in proper format. Please try again later.");
        } else {
          System.out.println("You have successfully created the Resign Request.");
          insertobject.insertResignRequestDetails(idobject.getEmployeeID(username), localDate, reason);
        }
      }
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }

}
