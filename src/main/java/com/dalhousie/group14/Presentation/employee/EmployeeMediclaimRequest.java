package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.IValidation;
import com.dalhousie.group14.BusinessLogic.employee.Validation;
import com.dalhousie.group14.Database.employee.DatabaseMediclaimRequests;
import com.dalhousie.group14.Database.employee.IDatabaseMediclaimRequests;

import java.util.Scanner;

public class EmployeeMediclaimRequest implements IMediclaimRequest {

  static String name;
  static int policynumber;
  static int amount;
  static String reason;
  static String status = "pending";


  public void callALlMethods() {
    System.out.println("You are in the apply for mediclaim  screen");
    enterName();
    enterPolicyNumber();
    moneyClaimed();
    giveReason();
    IDatabaseMediclaimRequests obj = new DatabaseMediclaimRequests();
    obj.employeeMediclaimRequests(name, policynumber, amount, reason, status);
  }

  public void enterName() {
    System.out.println("Enter your Name");
    Scanner scanner = new Scanner(System.in);
    name = scanner.nextLine();
    IValidation validation = new Validation();
    if (validation.validateName(name)) {
      System.out.println("name is valid");
    } else {
      System.out.println("name entered cannot be null or empty or should not contain special characters or numbers");
      enterName();
    }
  }

  public void enterPolicyNumber() {
    System.out.println("Enter your policy number");
    Scanner scanner = new Scanner(System.in);
    policynumber = scanner.nextInt();
    IValidation validation = new Validation();
    if (validation.validatePolicyNumber(policynumber)) {
      System.out.println("the policynumber is valid");
    } else {
      System.out.println("policy number cannot be negative or zero");
      enterPolicyNumber();
    }
  }

  public void moneyClaimed() {
    System.out.println("Enter the amount you want to claim");
    Scanner scanner = new Scanner(System.in);
    amount = scanner.nextInt();
    IValidation validation = new Validation();
    if (validation.validateMoneyClaimed(amount)) {
      System.out.println("the amount is valid");
    } else {
      System.out.println("The claimed amount cannot be negative or zero");
      moneyClaimed();
    }

  }

  public void giveReason() {
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Enter your valid reason for mediclaim");
    reason = scanner1.nextLine();
    IValidation validation = new Validation();
    if (validation.validateReason(reason)) {
      System.out.println("You have entered valid input");
      System.out.println("You have successfully made the mediclaim request.");
    } else if (!validation.validateReason(reason)) {
      System.out.println("The reason should be of string type ");
      giveReason();

    }

  }

}
