package com.dalhousie.group14.Database.employee;
/*
* Name:-Ninad Nitin Shukla
* File:- IEmployeeDBOperation
* */
import java.util.List;
import java.util.Map;

public interface IEmployeeDBOperation {

  Boolean setEmployee(String username, String type, double value);

  Map<String, String> getEmployeeInfo(String username);

  List<List<String>> getALLEmployeeInfo();
}
