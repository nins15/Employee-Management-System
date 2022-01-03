package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.NewEmployeeJoiningRequest;

import java.util.Scanner;

/*
 * Author:-Ninad Nitin Shukla
 * FileName:-NewEmployee
 * Display of new employee
 *
 * */
public class NewEmployeePresentation {

  /*This page displays the login screen for new employee*/
  public void newEmployeeLogin() {

    boolean exit = false;
    do {
      System.out.println("Hello welcome to EMS.Please add your " +
              "temporary UserName and Password so that you can request for " +
              "permanent credentials");
      Scanner sc = new Scanner(System.in);

      String userName = sc.nextLine();
      String password = sc.nextLine();
      NewEmployeeJoiningRequest nb = new NewEmployeeJoiningRequest();

      nb.login(userName, password);
    } while (exit == false);

  }

  public void applyRequestPresentation(String old) {
    System.out.println("Please Enter your new permanent username.(Username " +
            "should be greater than 4 characters please avoid any spaces or " +
            "any special characters)");
    String userName = "";
    String password = "";
    String exit = " ";
    do {
      if (exit.equals("No")) {
        System.out.println("the user Name you added is incorrect please try " +
                "againUsername " + "should be greater than 4 characters " +
                "please avoid any spaces or " + "any special characters");
      }
      Scanner scanner = new Scanner(System.in);
      userName = scanner.nextLine();
      NewEmployeeJoiningRequest newEmployeeJoiningRequest = new NewEmployeeJoiningRequest();
      if (newEmployeeJoiningRequest.userNameValidtion(userName)) {
        exit = "yes";
      } else {
        exit = "No";
      }
    } while (exit.equals("No"));

    System.out.println("Please Enter your new permanent Password.(Password " +
            "should be more then 4 characters long and should contain 1 " +
            "special character and one digit");
    String exit1 = " ";
    do {
      if (exit1.equals("No")) {
        System.out.println("the Password you added is not strong please try " +
                "again Password should be more then 4 characters long and should contain 1 " +
                "special character and one digit");
      }
      Scanner scanner = new Scanner(System.in);
      password = scanner.nextLine();
      NewEmployeeJoiningRequest newEmployeeJoiningRequest = new NewEmployeeJoiningRequest();
      if (newEmployeeJoiningRequest.passwordValidtion(password)) {
        exit1 = "yes";
        if (newEmployeeJoiningRequest.applyJoinRequest(old, userName,
            password)) {

          System.out.println("Request Sent successfully");
          exit1="yes";
        }
      } else {
        exit1 = "No";
      }
    } while (exit1.equals("No"));


  }

  public void requestStillPending() {
    System.out.println("Your request is sent to the manager. It is still " +
        "pending");
    System.out.println("Do you want to return to the main page?[yes/No]");
    Scanner sc=new Scanner(System.in);
    String ans=sc.next();
    if (ans.equals("yes")){
      return;
    }

  }

  public void requestApproved() {
    System.out.println("Your Request has been approved by the manager. You " +
        "can now login to the main system with the permenant credentials you " +
        "entered");
    System.out.println("Do you want to return to the main page?[yes/No]");
    Scanner sc=new Scanner(System.in);
    String ans=sc.next();
    if (ans.equals("yes")){
      return;
    }
  }

  public void incorrectInfo() {
    System.out.println("Incorrect Login or Password Please Try again");
    return;
  }

  public void alreadyExists() {
    System.out.println("This user name already exists");
    return;
  }
}
