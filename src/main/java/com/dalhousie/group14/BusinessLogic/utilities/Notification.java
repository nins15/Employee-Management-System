/**
 * Author : Aadil Shaikh
 * This class is responsible for creating a notification object.
 * It creates two types of notification objects depending on type of request.
 */

package com.dalhousie.group14.BusinessLogic.utilities;

public class Notification {

  private String msg;
  private int seen;
  priority p;
  private String empID;
  private String managerID;


  public String getEmpID() {
    return empID;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getManagerID() {
    return managerID;
  }

  public void setManagerID(String managerID) {
    this.managerID = managerID;
  }


  public Notification() {

  }

  public Notification(String msg, String priorityLevel) {
    this.setMsg(msg);
    this.setSeen(0);
    this.setPriority(priorityLevel);
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getPriority() {
    return String.valueOf(p);
  }

  public void setPriority(String priorityLevel) {
    if (priorityLevel.toLowerCase().contains("low"))
      p = priority.LOW;
    else if (priorityLevel.toLowerCase().contains("medium"))
      p = priority.MEDIUM;
    else if (priorityLevel.toLowerCase().contains("high"))
      p = priority.HIGH;
    else
      p = priority.LOW;
  }

  public int getSeen() {
    return this.seen;
  }

  public void setSeen(int x) {
    this.seen = x;
  }

  enum priority {LOW, MEDIUM, HIGH}
}


