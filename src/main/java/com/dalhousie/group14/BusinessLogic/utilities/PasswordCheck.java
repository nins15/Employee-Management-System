package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Presentation.utilities.ILogin;
import com.dalhousie.group14.Presentation.utilities.Login;

/**
 * @Author: Ria Shah
 * @NameofFile: PasswordCheck.java
 * @ClassDescription: This class will check whether the
 * entered password by the user is valid or not. If the password is
 * not valid then the system will prompt the user again to enter the
 * password until it will be valid.
 * @MethodName: passwordCheck(String password)- This method will check
 * whether the password entered contains enough numbers, capital letters,
 * valid characters or the password is short.
 */
public class PasswordCheck implements IPasswordCheck {

  public void passwordCheck(String password) {
    ILogin loginobject = new Login();

    if (password.equals(null)) {
      System.out.println("Password cannot be null");
      loginobject.enterPassword();
    }

    String result;
    int length = 0;
    int numCount = 0;
    int capCount = 0;

    for (int i = 0; i < password.length(); i++) {
      if (password.charAt(i) >= 47 && password.charAt(i) <= 58 || password.charAt(i) >= 64 && password.charAt(i) <= 96 ||
          password.charAt(i) >= 97 && password.charAt(i) <= 122 || password.charAt(i) >= 32 && password.charAt(i) <= 47) {

      } else {
        System.out.println("password contains invalid character");

      }
      if (password.charAt(i) > 47 && password.charAt(i) < 58) {
        numCount++;
      }
      if (password.charAt(i) > 64 && password.charAt(i) < 91) {
        capCount++;
      }
      length = (i + 1);
    }

    if (numCount < 2) {
      result = "password does not contain enough numbers";
      System.out.println(result);
      loginobject.enterPassword();
    } else if (capCount < 2) {
      result = "password does not contain enough capital letters";
      System.out.println(result);
      loginobject.enterPassword();
    } else if (length < 8) {
      result = "password is too short";
      System.out.println(result);
      loginobject.enterPassword();
    } else {
      System.out.println("PASSWORD IS VALID");
      System.out.println("USER LOGIN SUCCESSFUL");
    }


  }

}


