package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.BusinessLogic.employee.Employee;
import com.dalhousie.group14.BusinessLogic.manager.Manager;
import com.dalhousie.group14.Presentation.manager.SalaryOfEmployee;

import static org.junit.Assert.*;

/*Name:-Ninad Nitin Shukla
 *
 * */
public class SalariesTest {

  //TEST SET 1 before the coding is done
  @org.junit.Test
  public void viewSalary() {
    Manager manager = new Manager("abc");
    Employee employee = new Employee("fakeUser");
    ISalaries salary = new Salaries();
    assertEquals(750000.0, salary.viewSalary("fakeUser").get("CTC"));
    assertEquals(633461.5384615385, salary.viewSalary("fakeUser").get("gross_salary"));
    assertEquals(0.0, salary.viewSalary("fakeUser").get("bonus"));
    assertEquals(150000.0, salary.viewSalary("fakeUser").get("basic_salary"));
    assertEquals(603461.5384615385, salary.viewSalary("fakeUser").get("tax_home_salary"));
    assertEquals(30000.0, salary.viewSalary("fakeUser").get("EPF"));
    assertEquals(0.0, salary.viewSalary("fakeUser").get("tax"));
    assertEquals(86538.46153846153, salary.viewSalary("fakeUser").get("Gratuity"));


  }

  @org.junit.Test
  public void updateSalary() {
    Manager manager = new Manager("abc");
    SalaryOfEmployee se = new SalaryOfEmployee();
    se.editSalary("fakeUser");
    Employee employee = new Employee("fakeUser");
    ISalaries salary = new Salaries();

    assertEquals(800000.0, salary.viewSalary("fakeUser").get("CTC"));
  }


}