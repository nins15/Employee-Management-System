package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBRequestForLeave;
import com.dalhousie.group14.Database.employee.GetEmployeeUserNameUserID;
import com.dalhousie.group14.Database.employee.IDBRequestForLeave;
import com.dalhousie.group14.Database.employee.IGetEmployeeUserNameUserID;
import com.dalhousie.group14.Database.manager.GetManagerUserNameUserID;
import com.dalhousie.group14.Database.manager.IGetManagerUserNameUserID;

import java.sql.Date;

import java.util.Scanner;

/* Author- Jainam Shah(B00883898)
 * This class implements IRequestForLeave interface.
 * Take data from employee like name, when want to leave start and end data
 * logically calculated the date difference between this. Take all data
 * process it if needed then send to the database Layer.
 */

public class RequestForLeave implements IRequestForLeave {

  /* Take data from employee like name, when want to leave start and end data
   * logically calculated the date difference between this. Take all data
   * process it if needed then send to the database Layer.
   */
  public void requestForLeave(String userNamee) {

    Scanner scanner = new Scanner(System.in);
    String userName = userNamee;
    String managerName;
    String startingLeaveDate;
    String endingLeaveDate;
    String reason;
    String status;
    status = "pending";
    long days;

    IGetEmployeeUserNameUserID getEmployeeUserNameUserID =
        new GetEmployeeUserNameUserID();

    IGetManagerUserNameUserID managerUserNameUserID =
        new GetManagerUserNameUserID();

    IDBRequestForLeave dbRequestForLeave = new DBRequestForLeave();
    IFindDistanceBettweenDates findDistanceBettweenDates =
        new FindDistanceBettweenDates();

    Date actualStartingLeaveDate;
    Date actualEndingLeaveDate;

    int employeeID;
    int managerID;
    int remainingLeaves;

    try {
      System.out.println("Enter your Username:");
      userName = scanner.nextLine();

      employeeID =
          getEmployeeUserNameUserID.getEmployeeUserIDFromUserName(userName);
      System.out.println("Your Employee ID is " + employeeID);

      System.out.println("Enter your Manager UserName:");
      managerName = scanner.nextLine();
      managerID = managerUserNameUserID.getManagerUserIDFromUserName(managerName);
      System.out.println("Your Manager ID" + managerID);

      System.out.println("Enter your starting leave date in yyyy-mm-dd format");
      startingLeaveDate = scanner.nextLine();
      actualStartingLeaveDate = Date.valueOf(startingLeaveDate);

      System.out.println("Enter your ending leave date in yyyy-mm-dd format");
      endingLeaveDate = scanner.nextLine();
      actualEndingLeaveDate = Date.valueOf(endingLeaveDate);

      boolean dateValidation = dateValidation(startingLeaveDate, endingLeaveDate);

      if (!dateValidation) {
        System.out.println("Please Write the correct data. Ending date is " +
            "before Starting date.");
        System.out.println("Let`s Start with again with beginning.");
        requestForLeave(userName);
      }
      days = findDistanceBettweenDates.findDistanceBettweenDates(startingLeaveDate, endingLeaveDate);
      System.out.println(days);

      dbRequestForLeave.insertRemainingLeaves(employeeID, managerID);
      remainingLeaves = dbRequestForLeave.remainingLeaves(employeeID);

      System.out.println("Please Enter the reason for your leave:");
      reason = scanner.nextLine();

      dbRequestForLeave.insertRequestForLeave(employeeID, managerID,
          actualStartingLeaveDate, actualEndingLeaveDate,
          days, remainingLeaves,
          reason, status);

    } catch (Exception e) {
      System.out.println("Exception:" + e);
      System.out.println("Please Write correct value.");
      requestForLeave(userName);
    }
  }

  /* this method logically validate that starting leave date is always before
   the starting end date.
   */
  public boolean dateValidation(String startingLeaveDate,
                                String endingLeaveDate) {
    Date actualStartingLeaveDate;
    Date actualEndingLeaveDate;
    actualStartingLeaveDate = Date.valueOf(startingLeaveDate);
    actualEndingLeaveDate = Date.valueOf(endingLeaveDate);
    return actualStartingLeaveDate.before(actualEndingLeaveDate);

  }
}
