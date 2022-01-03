package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.Employee;

import com.dalhousie.group14.BusinessLogic.utilities.ISalaries;
import com.dalhousie.group14.BusinessLogic.utilities.Salaries;

import java.util.Scanner;
/*Name:-Ninad Nitin Shukla
*
* */
public class Salary {
    public void view(String userName){
        System.out.println("Hello "+userName);

        System.out.println("Here is the breakdown of your salary");
        Employee employee= new Employee(userName);
        ISalaries salary=new Salaries();
        for(Object e:salary.viewSalary(userName).entrySet()){
            System.out.println(e.toString());

        }
        System.out.println("BACK TO the previous page?[yes/no]");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();
        if(input.equals("yes")){
            return;
        }

    }
}
