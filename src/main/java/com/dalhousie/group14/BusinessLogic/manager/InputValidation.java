package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.IMediclaimApproval;
import com.dalhousie.group14.Database.manager.IMediclaimRejection;
import com.dalhousie.group14.Database.manager.MediClaimApproval;
import com.dalhousie.group14.Database.manager.MediClaimRejection;
import com.dalhousie.group14.Presentation.manager.IMediclaimRequest;
import com.dalhousie.group14.Presentation.manager.MediclaimRequests;


public class InputValidation implements IInputValidation {

  public boolean validateSwitchCase(int input) {
    if (input == 1 || input == 2 || input == 3 || input ==
        4 || input == 5 || input == 6) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validateInput(String input) {
    if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N") || input.equalsIgnoreCase("yes")
        || input.equalsIgnoreCase("no")) {
      return true;
    } else if (!input.equalsIgnoreCase("Y") || !input.equalsIgnoreCase("N")) {
      return false;
    }
    return true;
  }

  public void validateNameRequestApproval(String name) {
    IMediclaimApproval mediapprove = new MediClaimApproval();
    if (name.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
      System.out.println("You have entered the name " + name + " for the mediclaim request approval");
      mediapprove.approveStatus(name);

    } else {
      System.out.println("You have entered bad input.Please try again");
      MediclaimRequests object1 = new MediclaimRequests();
      object1.displayMediclaimRequests();
    }
  }

  public void validateNameRequestRejection(String name) {
    IMediclaimRejection medireject = new MediClaimRejection();
    if (name.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
      System.out.println("You have entered the name " + name + " for the mediclaim request rejection");
      medireject.rejectStatus(name);

    } else {
      System.out.println("you have entered bad input.Please try again");
      IMediclaimRequest object1 = new MediclaimRequests();
      object1.displayMediclaimRequests();
    }
  }

}
