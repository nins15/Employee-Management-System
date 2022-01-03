package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Database.utilities.*;

import java.util.HashMap;

public class EnterCredentials implements IEnterCredentials {

  private String password = null;
  private String username = null;
  private String userType = null;
  private String time = null;
  private String date = null;

  // method to enter enter  login credentials //
  public void credentials(HashMap<String, String> map) {
    IInsertCredentials insertCredentials = new InsertLoginCredentials();
    IInsertLoginDateTime insertLoginTime = new InsertLoginDateTime();

    if (map.getOrDefault("Password", null) != null) {
      password = map.get("Password");

    }
    if (map.getOrDefault("UserName", null) != null) {
      username = map.get("UserName");

    }
    if (map.getOrDefault("userType", null) != null) {
      userType = map.get("userType");

    }
    if (map.getOrDefault("time", null) != null) {
      time = map.get("time");
    }
    if (map.getOrDefault("date", null) != null) {
      date = map.get("date");
    }
    if (password != null && username != null && userType != null && date != null && time != null) {
      insertCredentials.insertLoginCredentials(username, password, userType);
      insertLoginTime.insertLoginDateTime(time, username, date);

    }
  }

}
