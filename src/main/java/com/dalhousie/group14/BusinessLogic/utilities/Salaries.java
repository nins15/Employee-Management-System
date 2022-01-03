package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Database.employee.EmployeeDBOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Name:-Ninad Nitin Shukla
 * File Name:-Salaries :-It is responsible  for managing the salaries of the
 * employees by viewing and updating them
 * */
public class Salaries implements ISalaries {

  private String manager;
  private Map<String, String> info;

  public List<List<String>> viewEmployees() {
    EmployeeDBOperation d = new EmployeeDBOperation();
    Map<String, Double> salary_info = new HashMap<>();
    List<List<String>> info = new ArrayList<>();
    info = d.getALLEmployeeInfo();
    return info;
  }

  @Override
  public Map viewSalary(String emp) {

    EmployeeDBOperation dbOperation = new EmployeeDBOperation();
    Map<String, Double> salaryInfo = new HashMap<>();
    Map<String, String> info = new HashMap<>();
    info = dbOperation.getEmployeeInfo(emp);
    String ctcString = info.get("ctc");
    double ctc = Double.parseDouble(ctcString);
    salaryInfo.put("CTC", ctc);
    String epfString = info.get("epf");
    double epf = Double.parseDouble(epfString);
    salaryInfo.put("EPF", epf);
    String basicSalary = info.get("basic_salary");
    double basicSalaryDouble = Double.parseDouble(basicSalary);
    salaryInfo.put("basic_salary", basicSalaryDouble);
    double grossSalary;
    double gratuity = basicSalaryDouble * 15 / 26;
    salaryInfo.put("Gratuity", gratuity);
    TaxesIn2021 taxesIn2021 = new TaxesIn2021();
    double tax = taxesIn2021.computeTaxes(ctc, epf, basicSalaryDouble);
    salaryInfo.put("tax", tax);
    grossSalary = ctc - epf - gratuity;
    salaryInfo.put("gross_salary", grossSalary);
    String bonusString = info.get("bonus");
    double bonus = Double.parseDouble(bonusString);
    salaryInfo.put("bonus", bonus);
    double takeHomeSalary = grossSalary - tax - epf + bonus;
    salaryInfo.put("tax_home_salary", takeHomeSalary);
    return salaryInfo;

  }

  @Override
  public boolean updateSalary(String employee, double amount, String salaryType) {
    EmployeeDBOperation dbOperation = new EmployeeDBOperation();

    return ((EmployeeDBOperation) dbOperation).setEmployee(employee, salaryType, amount);

  }


}
