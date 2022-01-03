package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.DBEditEmployeeInformation;
import com.dalhousie.group14.Database.manager.EmployeeBean;
import com.dalhousie.group14.Database.manager.IDBEditEmployeeInformation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import static java.sql.Date.valueOf;

/*Author- Jainam Shah(B00883898)
 * This class edit the employee information.
 */

public class EditEmployeeInformation implements IEditEmployeeInformation {

  public void editEmployeeInformation() {

    IDBEditEmployeeInformation dbEditEmployeeInformation =
        new DBEditEmployeeInformation();

    Scanner scanner = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    int select;
    int employeeID;
    String contactName;
    String gender;
    String birthDate;
    Date DOB;

    ArrayList<EmployeeBean> arrayList =
        dbEditEmployeeInformation.getAllEmployeeInformation();

    System.out.println("EmployeeID" + "          " + "UserName" + "      " +
        "ContactName" + "      " + "gender" + "      " + "DOB" + "      " +
        "Basicsalary" + "    " + "CTC" + "      " + "bonus" + "     "
        + "lastmonthsalary" + "    " + "EPF");

    for (EmployeeBean employeeBean : arrayList) {
      System.out.format("%1s%25s%18s%10s%15s%10s%12s%10s%20s%10s",
          employeeBean.getEmployeeID(), employeeBean.getUserName(),
          employeeBean.getContactName(), employeeBean.getGender(),
          employeeBean.getDOB(), employeeBean.getBasicsalary(),
          employeeBean.getCTC(), employeeBean.getBonus(),
          employeeBean.getLastmonthsalary(), employeeBean.getEPF());
      System.out.println();
    }
    boolean decision = true;
    do {

      try {
        System.out.println("Enter UserID of the employee that you want to edit.");
        employeeID = scanner.nextInt();

        EmployeeBean employeeBean =
            dbEditEmployeeInformation.getAllEmployeeByID(employeeID);

        System.out.println("Employee`s ID:" + employeeID);

        System.out.println("Select 1 to change the Contact Name\nSelect 2 to " +
            "change the Gender\nSelect 3 to change the Date Of Birth\nSelect " +
            "5 for exit.");
        select = scanner.nextInt();
        switch (select) {
          case 1:
            System.out.println("Enter Contact Name for update.");
            contactName = scannerString.nextLine();
            employeeBean.setContactName(contactName);
            dbEditEmployeeInformation.employeeUpdate(employeeBean);
            break;
          case 2:
            System.out.println("Enter Gender for update");
            gender = scannerString.nextLine();
            employeeBean.setGender(gender);
            dbEditEmployeeInformation.employeeUpdate(employeeBean);
            break;
          case 3:
            try {
              System.out.println("Enter DOB for the update in yyyy-mm-dd:");
              birthDate = scannerString.nextLine();
              DOB = valueOf(birthDate);
              employeeBean.setDOB(DOB);
              dbEditEmployeeInformation.employeeUpdate(employeeBean);
            } catch (IllegalArgumentException illegalArgumentException) {
              System.out.println("IllegalArgumentException" + illegalArgumentException);
              System.out.println("Please, Enter DOB in yyyy-mm-dd format.");
              editEmployeeInformation();
            }
            break;
          case 5:
            decision = false;
            break;
          default:
            System.out.println("Please, Enter valid number.:");
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (decision);
  }
}

