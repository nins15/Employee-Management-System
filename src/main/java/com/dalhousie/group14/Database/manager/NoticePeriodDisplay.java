package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.BusinessLogic.employee.INoticePeriod;
import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.BusinessLogic.employee.NoticePeriod;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @Author: Ria Shah
 */
public class NoticePeriodDisplay implements INoticePeriodDisplay {

  @Override
  public void noticePeriodDisplay(int id) {
    INoticePeriod np = new NoticePeriod();
    Connection connection = DbConnection.connectDB();
    long notice_period1 = np.noticePeriodCalculation();
    String query1 = "UPDATE ResignRequest SET NoticePeriod = " + notice_period1 + " WHERE EmployeeID =" + id + ";";
    Statement statement = null;
    try {
      assert connection != null;
      statement = connection.createStatement();
      statement.executeUpdate(query1);
      connection.close();
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
  }

}
