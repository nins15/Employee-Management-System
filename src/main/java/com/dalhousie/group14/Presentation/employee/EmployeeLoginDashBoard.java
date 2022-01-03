package com.dalhousie.group14.Presentation.employee;

/*Author- Jainam Shah(B00883898)*/
/*This page for Employee login dashboard where employee has options to
edit profile
request for leave
request for medicliam
request for asset
request for resign.
*/

import com.dalhousie.group14.BusinessLogic.employee.Employee;
import com.dalhousie.group14.BusinessLogic.employee.IRequestForLeave;
import com.dalhousie.group14.BusinessLogic.employee.RequestForLeave;
import com.dalhousie.group14.BusinessLogic.manager.AssetRequests;
import com.dalhousie.group14.Database.utilities.NotificationManager;
import com.dalhousie.group14.Database.employee.GetEmployeeUserNameUserID;
import com.dalhousie.group14.Database.employee.IGetEmployeeUserNameUserID;
import com.dalhousie.group14.Presentation.manager.ResignRequest;
import com.dalhousie.group14.Presentation.utilities.Login;

import java.util.Scanner;

public class EmployeeLoginDashBoard {

  public void employeeLoginDashBoard(String userName) {

    EditProfile editProfile = new EditProfile();
    IRequestForLeave request = new RequestForLeave();
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Login Dashboard\t\t\t\t\t\t\t\t\t\t\t\t");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Select any of the following task to perform.");

    int select;
    boolean decisoin = true;
    do {
      try {
        NotificationManager notificationManager = new NotificationManager();
        IGetEmployeeUserNameUserID iGetEmployeeUserNameUserID =
            new GetEmployeeUserNameUserID();
        notificationManager.getNotifications(String.valueOf(iGetEmployeeUserNameUserID.getEmployeeUserIDFromUserName(userName)));
        System.out.println("Enter 1 for Edit Profile:\nEnter 2 for " +
            "Schedule Management\nEnter 3 for Salary Management:\nEnter 4 for " +
            "Leave Request:\nEnter 5 for Mediclaim Request:\nEnter 6 for Asset " +
            "Request:\nEnter 7 for Resign From Your Position:\nEnter 8 for " +
            "Project Management");
        select = scanner.nextInt();
        switch (select) {
          case 1:
            editProfile.editProfile(userName);
            break;
          case 2:
            System.out.println("Schedule Management:");
            CalendarMainScreen calendarMainScreen = new CalendarMainScreen();
            calendarMainScreen.displayScreen();
            break;
          case 3:
            System.out.println("Salary Management");
            Employee employee= new Employee(userName);
            Salary salary=new Salary();
            salary.view(employee.getUserName());
            break;
          case 4:
            System.out.println("Request Leave");
            request.requestForLeave(userName);
            break;
          case 5:
            IMediclaimRequest iMediclaimRequest =
                new EmployeeMediclaimRequest();
            iMediclaimRequest.callALlMethods();
            System.out.println("Mediclaim Request");
            break;
          case 6:
            System.out.println("Asset Requests");
            AssetRequests assetRequests=
                new AssetRequests();
            assetRequests.viewRequests(userName);
            break;
          case 7:
            System.out.println("Resign Requests");
            ResignRequest resignRequest = new ResignRequest();
            resignRequest.displayResignRequest();
            break;
          case 8:
            System.out.println("Manage your projects.");
            EmployeeProjectHandling employeeProjectHandling = new EmployeeProjectHandling();
            employeeProjectHandling.display();
            break;
          case 9:
            System.out.println("LOGOUT");
            Login obj = new Login();
            obj.userType();
            break;
          case 10:
            decisoin = false;
          default:
            System.out.println("Enter Valid Number");
        }
      } catch (Exception e) {
        System.out.println("Your Exception:" + e);
        employeeLoginDashBoard(userName);
      }
    } while (decisoin);
  }
}
