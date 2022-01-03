package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Database.utilities.CheckUsernameExists;
import com.dalhousie.group14.Database.utilities.ICheckUsernameExists;
import com.dalhousie.group14.Presentation.utilities.ILogin;
import com.dalhousie.group14.Presentation.utilities.IPrint;
import com.dalhousie.group14.Presentation.utilities.Login;
import com.dalhousie.group14.Presentation.utilities.Print;


import java.util.regex.Pattern;

/**
 * @Author: Ria Shah
 * @NameofFile: UsernameCheck.java
 * @ClassDescription: This class will check whether the
 * entered username by the user is valid or not. If the username is
 * not valid the system will prompt the user again to enter the
 * username until it will be valid.
 * @MethodName: usernameCheck(String name)- This method will take a regex
 * for username and check for it and returns true or false. It will also check
 * whether the username already exists in the table database or not.
 */
public class UsernameCheck implements IUsernameCheck {


  public void usernameCheck(String name) {
    IPrint print = new Print();
    ILogin loginobject = new Login();
    ICheckUsernameExists object = new CheckUsernameExists();

    // regex to check the valid username
    String regex1 = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    //Compile the regex
    Pattern p = Pattern.compile(regex1);
    boolean valid = (name != null) && p.matcher(name).matches();
    String message;
    if (valid) {
      message = "USERNAME IS VALID";
      System.out.println(print.displayMessage(message));
    } else {
      message = "USERNAME IS NOT VALID. PLEASE TRY AGAIN.";
      System.out.println(print.displayMessage(message));
      loginobject.enterUsername();
    }
  }

}
