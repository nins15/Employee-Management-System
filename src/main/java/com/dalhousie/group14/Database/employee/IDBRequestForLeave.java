package com.dalhousie.group14.Database.employee;

import java.sql.Date;
import java.util.HashMap;

/*Author- Jainam Shah(B00883898)*/

public interface IDBRequestForLeave {

  void insertRequestForLeave(int employeeID, int managerID, Date actualstartingLeaveDate,
                             Date actualendingLeaveDate, long days, int remainingleaves,
                             String reason, String status);

  int remainingLeaves(int userID);

  HashMap<Integer, HashMap<String, String>> getAllLeaveInfo();

  void updateLeaveRequest(String userName, String status, String days, int remainingLeaves);

  void cancelLeaveRequest(String userName, String status);

  void insertRemainingLeaves(int employeeID, int managerID);

}
