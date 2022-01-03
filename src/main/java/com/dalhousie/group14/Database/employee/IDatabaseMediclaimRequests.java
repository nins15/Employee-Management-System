package com.dalhousie.group14.Database.employee;

/**
 * @Author: Ria Shah
 * @NameofFile: IDatabaseMediclaimRequests.java
 * @InterfaceDescription: This interface will declare
 * the employeeMediclaimRequests method implemented
 * in the DatabaseMediclaimRequests class.
 */
public interface IDatabaseMediclaimRequests {

  void employeeMediclaimRequests(String name, int number, int amount,
                                 String reason, String status);

}
