package com.dalhousie.group14.Presentation.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Harjot Singh
 * @NameofFile: userIntValidation.java
 * @ClassDescription: This class is used for validating the user's input with
 * regards to the screen on which he is interacting.
 */
public class userIntValidation implements IuserIntValidation {
  public static final int MIN = 0;
  public static final int ONE = 1;

  public int takeUserinput(Scanner scanner, int MAX_SIZE) {
    int MAX_TRIES = 3;
    int tries = 0;
    int userInput;
    int invalidinput = 0;
    while (tries != MAX_TRIES) {
      try {
        userInput = scanner.nextInt();
        if (userInput > MIN && userInput <= MAX_SIZE) {
          return userInput;
        }else{
          System.out.println("Wrong S.No, enter again.");
          tries++;
          takeUserinput(scanner,MAX_SIZE);
        }
      } catch (InputMismatchException inputMismatchException) {
        tries++;
        if (tries != MAX_TRIES - ONE) {
          System.out.println("Wrong Input Format, " +
              "Please" +
              " enter " +
              "only numerical " +
              "value, according to the requirement.");
          takeUserinput(scanner,MAX_SIZE);
        }
      }
    }
    return invalidinput;
  }
}
