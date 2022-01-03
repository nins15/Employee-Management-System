package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.employee.Employee;
import com.dalhousie.group14.BusinessLogic.utilities.ISalaries;
import com.dalhousie.group14.BusinessLogic.utilities.Salaries;
/*Name: Ninad Nitin Shukla
 * Salaries of employee can be seen here*/
import java.util.*;

public class SalaryOfEmployee implements ISalaryOfEmployee {

  @Override
  public void ViewAllEmployees() {
    String cont = "no";
    do {
      System.out.println("This is the list of all employees.Please choose the " +
          "option you want to edit salary for:-");
      Salaries salary = new Salaries();

      List<List<String>> display = new ArrayList<>();
      display = (List<List<String>>) salary.viewEmployees();
      for (int i = 0; i < display.size(); i++) {
        System.out.format("%10s%32s%32s", i, display.get(i).get(0),
            display.get(i).get(1));
        System.out.println();
      }
      Scanner sc = new Scanner(System.in);
      String emp = sc.next();
      int index = Integer.parseInt(emp);
      editSalary(display.get(index).get(0));
      System.out.println("Do you want to continue to edit other user " +
          "salaries?[yes/no]");
      Scanner sca = new Scanner(System.in);
      cont = sca.next();
    } while (cont.equals("yes"));
  }

  @Override
  public void editSalary(String userName) {
    ArrayList<String> toViewElements = new ArrayList<>();
    toViewElements.add("CTC");
    toViewElements.add("bonus");
    toViewElements.add("basic_salary");
    toViewElements.add("EPF");

    String exit = "";
    do {

      System.out.println("This is the breakdown of " + userName + "'s salary");
      Employee employee = new Employee(userName);
      ISalaries salary = new Salaries();
      Map<String, Double> map = new HashMap<String, Double>();
      map = salary.viewSalary(userName);
      int i = 0;
      for (String sal : toViewElements) {
        System.out.println(i + "------" + sal + "-----" + map.get(sal));
        i += 1;
      }
      Scanner sc = new Scanner(System.in);
      System.out.println("Please Enter the option you want to edit");

      int option = sc.nextInt();
      System.out.println("Please Enter the updated " + toViewElements.get(option));
      Double value = sc.nextDouble();
      ISalaries s = new Salaries();
      if (option > toViewElements.size() || option < 0) {
        System.out.println("Wrong option");
      }
      if (s.updateSalary(userName, value, toViewElements.get(option))) {

        System.out.println("Update Successful.Do you want to continue?[yes/no]");
        exit = sc.next();
      } else {
        System.out.println("Update UnSuccessful.Do you want to continue " +
            "?[yes/no].Or return back to the previous page?");
        exit = sc.next();
      }


    } while (exit.equalsIgnoreCase("yes"));
    return;


  }
}
