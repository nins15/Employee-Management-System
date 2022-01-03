package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

/**
 * @Author: Ria Shah
 * @NameofFile: ApprovedStatus.java
 * @ClassDescription: This class will update the ApprovedStatus field of
 * ResignRequest table to approved status from pending status by the manager.
 */
public class ApprovedStatus implements IApprovedStatusbyManager {

  public void approveStatus(int id) {
    String query = "UPDATE ResignRequest SET ApprovedStatus = 'approved' WHERE EmployeeID =" + id + ";";
    QueryExecutor.writeData(query);
    NoticePeriodDisplay npu = new NoticePeriodDisplay();
    npu.noticePeriodDisplay(id);

  }

}
