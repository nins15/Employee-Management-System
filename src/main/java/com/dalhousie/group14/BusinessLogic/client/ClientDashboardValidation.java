package com.dalhousie.group14.BusinessLogic.client;

/**
 * @Author: Harjot Singh
 * @NameofFile: ClientDashboardValidation.java
 * @ClassDescription: This class is responsible for performing the
 * validations that are required by the ClientDashboard class.
 */
public class ClientDashboardValidation implements IClientDashboardValidation {

  public boolean clientInput(int input, int low_range, int high_range) {
    return input > low_range && input < high_range;
  }
}
