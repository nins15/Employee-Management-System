package com.dalhousie.group14.Presentation.employee;
/*Author- Jainam Shah(B00883898)*/

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;
import com.dalhousie.group14.Database.employee.GetEmployeeUserNameUserID;
import com.dalhousie.group14.Database.employee.IDBSecurityQuestion;
import com.dalhousie.group14.Database.employee.IGetEmployeeUserNameUserID;

import java.util.Scanner;

public class SetLanguages implements ISetLanguages {

  public void setLanguages(String userName) {

    IDBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();
    int userID;
    IGetEmployeeUserNameUserID iGetEmployeeUserNameUserID =
        new GetEmployeeUserNameUserID();
    Scanner scanner = new Scanner(System.in);
    String techLanguage1;
    String techLanguage2;
    String techLanguage3;
    userID = iGetEmployeeUserNameUserID.getEmployeeUserIDFromUserName(userName);
    System.out.println("Enter your 1 Technical Language:");
    techLanguage1 = scanner.nextLine();
    System.out.println("Enter your 2 Technical Language:");
    techLanguage2 = scanner.nextLine();
    System.out.println("Enter your 3 Technical Language:");
    techLanguage3 = scanner.nextLine();
    dbSecurityQuestion.insertTechDetails(userID, techLanguage1, techLanguage2, techLanguage3);
  }
}
