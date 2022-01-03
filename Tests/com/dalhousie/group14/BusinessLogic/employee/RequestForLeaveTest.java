package com.dalhousie.group14.BusinessLogic.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*Author- Jainam Shah*/
class RequestForLeaveTest {

  @Test
  @DisplayName("This method Return true if starting leaveDate is before " +
      "ending leaveDate")
  void trueDateValidation() {

    RequestForLeave request = new RequestForLeave();
    assertTrue(request.dateValidation("2021-05-21", "2021-05-25"));
  }

  @DisplayName("This method Return false if starting leaveDate is not before " +
      "ending leaveDate")
  @Test
  void falseDateValidation() {

    RequestForLeave request = new RequestForLeave();
    assertFalse(request.dateValidation("2021-05-28", "2021-05-25"));
  }

  @DisplayName("This method return false if starting leaveDate is equals to " +
      "ending leaveDate.")
  @Test
  void equalDateValidation() {

    RequestForLeave request = new RequestForLeave();

    assertFalse(request.dateValidation("2021-05-28", "2021-05-28"));
  }

}