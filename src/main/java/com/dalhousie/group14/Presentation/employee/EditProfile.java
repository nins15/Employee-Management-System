package com.dalhousie.group14.Presentation.employee;

import java.util.Scanner;

import com.dalhousie.group14.BusinessLogic.employee.ChangePassword;
import com.dalhousie.group14.BusinessLogic.employee.ChangeSecurityQuestion;
import com.dalhousie.group14.BusinessLogic.employee.IChangePassword;
import com.dalhousie.group14.BusinessLogic.employee.IChangeSecurityQuestion;

/*Author Name-Jainam Shah
 */
public class EditProfile {

  public void editProfile(String userName) {

    IChangeSecurityQuestion changeSecurityQuestion =
        new ChangeSecurityQuestion();

    EmployeeLoginDashBoard employeeLoginDashBoard = new EmployeeLoginDashBoard();

    IChangePassword changePassword = new ChangePassword();
    Scanner scanner = new Scanner(System.in);
    int number;
    boolean decision = true;
    do {
      try {
        System.out.println("Press 1 for Edit Password: \n" +
            "Press 2 for Change Security Question: \n" +
            "Press 3 for Goto the Previous Page:\nPress 4 to exit this page.");
        number = scanner.nextInt();
        switch (number) {
          case 1:
            changePassword.changePassword();
            break;
          case 2:
            changeSecurityQuestion.changeSecurityQuestion();
            break;
          case 3:
            employeeLoginDashBoard.employeeLoginDashBoard(userName);
            break;
          case 4:
            decision = false;
          default:
            System.out.println("enter valid number:");
        }
      } catch (Exception e) {
        System.out.println("Exception in EditProfile:" + e);
      }
    } while (decision);
  }
}
