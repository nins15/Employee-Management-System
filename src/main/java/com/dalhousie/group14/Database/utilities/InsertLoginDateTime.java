package com.dalhousie.group14.Database.utilities;

import com.dalhousie.group14.Database.employee.GetEmployeeID;
import com.dalhousie.group14.Database.employee.IGetEmployeeID;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Author: Ria Shah
 * @Name of File: InsertLoginDateTime.java
 * @Class Description: This class will insert the current local date, time and
 * username of the user in the LoginSession table of ems database.
 */
public class InsertLoginDateTime implements IInsertLoginDateTime {

  public void insertLoginDateTime(String time, String username, String date) {

    LocalTime localTime = LocalTime.parse(time);
    LocalDate localDate = LocalDate.parse(date);
    IGetEmployeeID iGetEmployeeID = new GetEmployeeID();
    int user = iGetEmployeeID.getEmployeeID(username);
    String userID = "" + user;
    String query =
        "insert into LoginSession(LoginTime,UserName,SessionDate) values('" + localTime +
            "','" + userID +
            "','" + localDate + "');";
    QueryExecutor.writeData(query);
  }

}
