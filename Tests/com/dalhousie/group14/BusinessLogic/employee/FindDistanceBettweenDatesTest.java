package com.dalhousie.group14.BusinessLogic.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*Author- Jainam Shah*/
class FindDistanceBettweenDatesTest {

  @Test
  void findDistanceBettweenDates() {
    FindDistanceBettweenDates findDistanceBettweenDates =
        new FindDistanceBettweenDates();
    assertEquals(3, findDistanceBettweenDates.findDistanceBettweenDates("2021" +
        "-12-12", "2021-12" +
        "-15"));
  }
}