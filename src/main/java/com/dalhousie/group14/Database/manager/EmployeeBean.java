package com.dalhousie.group14.Database.manager;

import java.sql.Date;

/*Author- Jainam Shah(B00883898)*/
public class EmployeeBean {

  int EmployeeID, Basicsalary, bonus, lastmonthsalary;
  String UserName, ContactName, gender, ProjectHistory;
  Date DOB;
  Double CTC, EPF;

  public int getEmployeeID() {

    return EmployeeID;
  }

  public void setEmployeeID(int employeeID) {

    EmployeeID = employeeID;
  }

  public int getBasicsalary() {

    return Basicsalary;
  }

  public void setBasicsalary(int basicsalary) {

    Basicsalary = basicsalary;
  }

  public int getBonus() {

    return bonus;
  }

  public void setBonus(int bonus) {

    this.bonus = bonus;
  }

  public int getLastmonthsalary() {

    return lastmonthsalary;
  }

  public void setLastmonthsalary(int lastmonthsalary) {

    this.lastmonthsalary = lastmonthsalary;
  }

  public String getUserName() {

    return UserName;
  }

  public void setUserName(String userName) {

    UserName = userName;
  }

  public String getContactName() {

    return ContactName;
  }

  public void setContactName(String contactName) {

    ContactName = contactName;
  }

  public String getGender() {

    return gender;
  }

  public void setGender(String gender) {

    this.gender = gender;
  }

  public String getProjectHistory() {

    return ProjectHistory;
  }

  public void setProjectHistory(String projectHistory) {

    ProjectHistory = projectHistory;
  }

  public Date getDOB() {

    return DOB;
  }

  public void setDOB(Date DOB) {

    this.DOB = DOB;
  }

  public Double getCTC() {

    return CTC;
  }

  public void setCTC(Double CTC) {

    this.CTC = CTC;
  }

  public Double getEPF() {

    return EPF;
  }

  public void setEPF(Double EPF) {

    this.EPF = EPF;
  }
}
