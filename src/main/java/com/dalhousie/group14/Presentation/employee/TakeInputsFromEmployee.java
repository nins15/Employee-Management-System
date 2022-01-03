package com.dalhousie.group14.Presentation.employee;

import java.util.HashMap;
import java.util.Scanner;

public class TakeInputsFromEmployee {

  public HashMap<String, String> getUserNamePassword() {

    String username;
    String password;

    HashMap<String, String> hashMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your UserName:");
    username = scanner.nextLine();
    hashMap.put("UserName", username);

    System.out.println("Enter your New Password:");
    password = scanner.nextLine();
    hashMap.put("Password", password);

    return hashMap;

  }

}
