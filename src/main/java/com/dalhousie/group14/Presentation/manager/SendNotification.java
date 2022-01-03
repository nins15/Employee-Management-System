/**
 * Author: Aadil Shaikh
 * This displays the screen to send notifications.
 */
package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Notification;
import com.dalhousie.group14.Database.utilities.NotificationManager;

import java.sql.SQLException;
import java.util.Scanner;

public class SendNotification {

  public void display() throws SQLException {
    Scanner scanner = new Scanner(System.in);
    String empID;
    String msg;
    String priority;
    String managerID = "1";
    System.out.println("Enter the employee ID to which you want to  send " +
        "your notification");
    empID = scanner.nextLine();
    System.out.println("Enter the message that you want to send: ");
    msg = scanner.nextLine();
    System.out.println("Enter the priority level of message (HIGH, MEDIUM, " +
        "LOW : ");
    priority = scanner.nextLine();
    Notification n = new Notification(msg, priority);
    NotificationManager nm = new NotificationManager();
    nm.send(n, empID, managerID);
    System.out.println("Successfully sent notification!");
  }
}
