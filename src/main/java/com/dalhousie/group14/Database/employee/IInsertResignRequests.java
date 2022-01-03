package com.dalhousie.group14.Database.employee;

import java.time.LocalDate;

/**
 * @Author: Ria Shah
 * @NameofFile: IInsertResignRequests.java
 * @InterfaceDescription: This interface will declare the
 * insertResignRequestDetails method implemenetd in the
 * InsertResignRequests class.
 */
public interface IInsertResignRequests {

  void insertResignRequestDetails(int id, LocalDate date, String reason);

}
