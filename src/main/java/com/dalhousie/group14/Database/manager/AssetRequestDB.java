package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*Ninad Nitin Shukla
 * File name:-AssetRequestDB
 * This file is responsible for getting the pending requests and setting new
 * asset requests
 * */
public class AssetRequestDB implements IAssetRequestDB {

  Connection connection = null;

  public AssetRequestDB() {

    connection = DbConnection.connectDB();
  }

  @Override
  public List<List<String>> getPendingAssetRequestInformation(String managerUserName) {
    Statement stmt = null;
    List<List<String>> info = new ArrayList<>();

    try {
      stmt = this.connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM AssetRequest WHERE " +
          "ApprovdStatus='pending';");

      while (rs.next()) {
        List<String> information = new ArrayList<>();
        information.add(rs.getString("EmployeeUserName"));
        information.add(rs.getString("Reason"));
        information.add(rs.getString("ApprovdStatus"));
        information.add(rs.getString("Asset"));
        info.add(information);

      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return info;


  }

  @Override
  public boolean setNewAsset(String userName, String type,
                             String value) {
    try {
      Statement stmt = this.connection.createStatement();
      String sql =
          "UPDATE AssetRequest SET " + type + "='" + value + "' WHERE " +
              "EmployeeUserName='" + userName + "';";

      stmt.execute(sql);
      return true;

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }

  }

  @Override
  public void insertNewAssetRequest(String employeeUserName, String item,
                                    String reason) {
    try {
      Statement statement = this.connection.createStatement();
      String sql =
          "insert into AssetRequest values('" + employeeUserName + "', '" + reason +
              "', 'pending','" + item + "');";
      statement.execute(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}
