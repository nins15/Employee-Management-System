package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.BusinessLogic.utilities.Notification;

public class NotificationDisplay {
    public void display(Notification n) {
        System.out.println("There's a new notification for you!");
        System.out.println("Message: " + n.getMsg());
        System.out.println("Priority: " + n.getPriority());
        System.out.println("From : " + n.getManagerID());
    }
}
