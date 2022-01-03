package com.dalhousie.group14.BusinessLogic.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author- Jainam Shah(B00883898)
 * This class implement the IFindDistanceBetweenDates interface.
 * Take starting and ending date and calculate the distance between two dates.
 */

public class FindDistanceBettweenDates implements IFindDistanceBettweenDates {

  /*Take starting and ending date and calculate the distance between two dates.
   */
  public long findDistanceBettweenDates(String startingLeaveDate, String endingLeaveDate) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    long daysBetween = 0;
    try {
      Date dateBefore = sdf.parse(startingLeaveDate);
      Date dateAfter = sdf.parse(endingLeaveDate);
      long difference = dateAfter.getTime() - dateBefore.getTime();
      daysBetween = (difference / (1000 * 60 * 60 * 24));
      System.out.println("Number of Days between dates: " + daysBetween);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return daysBetween;
  }
}
