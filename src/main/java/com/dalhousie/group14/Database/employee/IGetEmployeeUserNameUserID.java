package com.dalhousie.group14.Database.employee;

/*Author- Jainam Shah(B00883898)*/
public interface IGetEmployeeUserNameUserID {

  /* Take userName as a parameter and return the UserID.
   */
  int getEmployeeUserIDFromUserName(String userName);

  /* Take userID as a parameter and return the UserName.
   */
  String getEmployeeUserNameFromUserID(int employeeID);
}
