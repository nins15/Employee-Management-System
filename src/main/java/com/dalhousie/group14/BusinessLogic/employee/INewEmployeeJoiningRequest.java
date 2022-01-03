package com.dalhousie.group14.BusinessLogic.employee;
/*Author:Ninad Nitin Shukla
*Name of the File:INewEmployeeJoiningRequest
* */
public interface INewEmployeeJoiningRequest {

  String checkIfRequestPendingOrApproved(String userName);

  Boolean login(String userName, String password);

  boolean applyJoinRequest(String oldUserName, String userName,
                           String password);

  boolean userNameValidtion(String userName);

  boolean passwordValidtion(String password);
}
