package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IInputValidation;
import com.dalhousie.group14.BusinessLogic.manager.InputValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApproveRequests {

  public void selectOption() {
    IResignRequestManager resignrequestobject = new ResignRequest();
    IMediclaimRequest mr = new MediclaimRequests();
    IInputValidation inputValidation = new InputValidation();
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.println("Select any of the following tasks that you might want to perform :" + "" +
          "\n1. Joining Requests \n2. Leave Requests \n3. " +
          "Resign Requests \n4. Asset Requests \n5. Mediclaim Requests " +
          "\n6. Go back to the previous page ");
      int option = scanner.nextInt();
      if (!inputValidation.validateSwitchCase(option)) {
        System.out.println("you have entered wrong input. Please try again.");
        selectOption();
      } else {

      }
      switch (option) {
        case 1:
          System.out.println("You have selected joining requests");
          break;
        case 2:
          System.out.println("You have selected leave requests");
          break;
        case 3:
          System.out.println("You have selected resign requests");
          resignrequestobject.displayResignRequest();
          break;
        case 4:
          System.out.println("You have selected asset requests");
          break;
        case 5:
          System.out.println("You have selected mediclaim requests");
          mr.displayMediclaimRequests();
          break;
        case 6:
          System.out.println("You have selected go back to the previous page");
          System.exit(0);
          break;
      }
    } catch (NumberFormatException exception) {
      System.out.println("You have entered invalid input.Please try again.");
      selectOption();
    } catch (InputMismatchException exception) {
      System.out.println("you have entered mismatched input. Please try again.");
      selectOption();
    }
  }

}

