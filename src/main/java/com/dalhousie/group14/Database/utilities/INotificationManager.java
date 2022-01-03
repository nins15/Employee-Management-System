/**
 * Author : Aadil Shaikh
 * This interface is responsible for sending notifications
 * It also gets the notifications for a specific employee.
 */
package com.dalhousie.group14.Database.utilities;

import com.dalhousie.group14.BusinessLogic.utilities.Notification;

public interface INotificationManager {

  void send(Notification notification, String empID, String managerID);

  void getNotifications(String empID);
}
