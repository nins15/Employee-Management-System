package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;
import com.dalhousie.group14.Database.employee.IDBSecurityQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Author- Jainam Shah
 * This class take all question form database and logically select one out
 * of three and ask to employee to give answer if answer is correct then
 * allow to redirect Login Dashboard Page.
 */
public class GiveSecurityQuestionAnswer implements IGiveSecurityQuestionAnswer {


  /*
   * This method take all question form database and logically select one out
   * of three and ask to employee to give answer if answer is correct then
   * allow to redirect Login Dashboard Page.
   */

  public void giveSecurityQuestionAnswer(String userName) {

    IDBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, String> hashMap = new HashMap<>();
    ArrayList<String> arrayList;
    String question1, question2, question3;
    int maximum = 3;
    int minimum = 1;
    int randomNumber;
    /* Get all security from database. */
    arrayList = dbSecurityQuestion.getSecurityQuestion(getUserName(userName));

    question1 = arrayList.get(1);
    System.out.println("Question 1:" + question1);
    question2 = arrayList.get(2);
    System.out.println("Question 2:" + question2);
    question3 = arrayList.get(3);
    System.out.println("Question 3:" + question3);

    hashMap.put(1, getUserName(question1));
    hashMap.put(2, getUserName(question2));
    hashMap.put(3, getUserName(question3));
    System.out.println(hashMap);

    /* Generate Random Number */
    randomNumber = random.nextInt((maximum - minimum) + 1) + minimum;
    System.out.println(randomNumber);

    String question = hashMap.get(randomNumber);
    System.out.println("Your Question is:" + getUserName(question));

    System.out.println("Please Write the answer:");
    String answer = scanner.nextLine();

    /*Check Employee is validate or not.*/
    dbSecurityQuestion.employeeValidate(getUserName(userName),
        getUserName(answer));
  }

  private static String getUserName(String userName) {
    return userName;
  }
}
