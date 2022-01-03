/**
 * Author : Aadil Shaikh
 * This class is responsible for sending notifications
 * It also gets the notifications for a specific employee.
 */

package com.dalhousie.group14.Database.utilities;

import com.dalhousie.group14.BusinessLogic.utilities.Notification;
import com.dalhousie.group14.Presentation.utilities.NotificationDisplay;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificationManager implements INotificationManager {

  Connection connection = DbConnection.connectDB();

  public NotificationManager() {

  }

  // Use this method to send a notification by passing a notification object
  public void send(Notification notification, String empID, String managerID) {
    try {
      Statement statement = connection.createStatement();
      String sql = "INSERT INTO `notification`(msg,managerID,empID,seen,priority) VALUE ('" + notification.getMsg() + "','" + managerID + "','" + empID + "','" + notification.getSeen() + "','" + notification.getPriority() + "')";
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  // Use this method to get notifications by passing an employeeID.
  public void getNotifications(String empID) {
    try {
      Statement statement = connection.createStatement();
      String sql = "SELECT * from `notification` where empID ='" + empID + "'AND  seen=0";
      ResultSet rs = statement.executeQuery(sql);
      Notification notification1 = new Notification();
      while (rs.next()) {
        notification1.setMsg(rs.getString("msg"));
        notification1.setPriority(rs.getString("priority"));
        notification1.setSeen(1);
        notification1.setManagerID(rs.getString("managerID"));
        Statement statement2 = connection.createStatement();
        sql = "UPDATE `notification` set `seen` ='" + notification1.getSeen() + "'";
        statement2.executeUpdate(sql);
        NotificationDisplay nd = new NotificationDisplay();
        nd.display(notification1);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
