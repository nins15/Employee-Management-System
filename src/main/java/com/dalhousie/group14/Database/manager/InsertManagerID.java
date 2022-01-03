package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @Author: Ria Shah
 */
public class InsertManagerID implements IInsertManagerID {

  public void insertManagerID(int employeeid, int managerid) {
    try {
      Connection connection = DbConnection.connectDB();
      Statement statement = connection.createStatement();
      String query1="SET FOREIGN_KEY_CHECKS =0";
      statement.executeQuery(query1);
      String query = "UPDATE ResignRequest SET ManagerID=" + managerid + " where EmployeeID=" + employeeid + ";";
      statement.executeUpdate(query);
      String query2="SET FOREIGN_KEY_CHECKS=1";
      statement.executeQuery(query2);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
