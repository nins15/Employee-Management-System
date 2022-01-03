/**
 * Author : Aadil Shaikh
 * This interface is responsible to get special dates for a specific employee.
 */
package com.dalhousie.group14.Database.utilities;

import java.util.List;

public interface IGetSpecialDatesEmployee {

  List<Long> getSpecialDatesForEmployee(String empID);
}
