package com.dalhousie.group14.BusinessLogic.client;

/**
 * @Author: Harjot Singh
 * @NameofFile: ClientDashboardValidation.java
 * @InterfaceDescription: This interface defines the method clientInput,
 * which validates the user input against the low and high range.
 */
public interface IClientDashboardValidation {
  boolean clientInput(int input, int low_range, int high_range);
}
