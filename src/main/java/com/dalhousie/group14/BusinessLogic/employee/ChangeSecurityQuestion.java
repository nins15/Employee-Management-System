package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;
import com.dalhousie.group14.Database.employee.IDBSecurityQuestion;

import java.util.Scanner;

/* Author- Jainam Shah(B00883898)
 * This class implement the IChangeSecurityQuestion interface.
 * This class employee can change the security question and answer.
 */
public class ChangeSecurityQuestion implements IChangeSecurityQuestion {

  public void changeSecurityQuestion() {

    IDBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();
    String userName;
    String question1;
    String answer1;
    String question2;
    String answer2;
    String question3;
    String answer3;
    boolean decision, answerDecision;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter UserName:");
    System.out.println("Question should grater then 3 characters.");
    System.out.println("Answer should not br null.");

    userName = scanner.nextLine();
    System.out.println("Enter Security Question 1:");
    question1 = scanner.nextLine();
    decision = checkSecurityQuestionValidation(question1);
    if (!decision) {
      System.out.println("Question should not be null and grater than 3 " +
          "characters.");
      System.out.println("Let`s start with beginning..");
      changeSecurityQuestion();
    }

    System.out.println("Enter Answer for Security Question 1:");
    answer1 = scanner.nextLine();
    answerDecision = checkSecurityAnswerValidation(answer1);
    if (!answerDecision) {
      System.out.println("Answer should not be null and grater than 3 " +
          "characters.");
      System.out.println("Let`s start with beginning..");
      changeSecurityQuestion();
    }

    System.out.println("Enter Security Question 2:");
    question2 = scanner.nextLine();
    decision = checkSecurityQuestionValidation(question2);
    if (!decision) {
      System.out.println("Question should not be null and grater than 3 " +
          "characters.");
      System.out.println("Let`s start with beginning..");
      changeSecurityQuestion();
    }

    System.out.println("Enter Answer for Security Question 2:");
    answer2 = scanner.nextLine();
    answerDecision = checkSecurityAnswerValidation(answer2);
    if (!answerDecision) {
      System.out.println("Answer should not be null and grater than 3 " +
          "characters.");
      System.out.println("Let`s start with beginning..");
      changeSecurityQuestion();
    }

    System.out.println("Enter Security Question 3:");
    question3 = scanner.nextLine();
    decision = checkSecurityQuestionValidation(question3);
    if (!decision) {
      System.out.println("Question should not be null and grater than 3 " +
          "characters.");
      System.out.println("Let`s start with beginning..");
      changeSecurityQuestion();
    }

    System.out.println("Enter Answer for Security Question 3:");
    answer3 = scanner.nextLine();
    answerDecision = checkSecurityAnswerValidation(answer3);
    if (!answerDecision) {
      System.out.println("Answer should not be null and grater than 3 " +
          "characters.");
      System.out.println("Let`s start with beginning..");
      changeSecurityQuestion();
    }
    dbSecurityQuestion.updateSecurityQuestion(userName, question1, question2, question3);
    dbSecurityQuestion.updateSecurityAnswer(userName, answer1, answer2, answer3);

  }

  public boolean checkSecurityAnswerValidation(String answer) {
    return answer != null;
  }

  public boolean checkSecurityQuestionValidation(String question) {
    return question != null && question.length() > 3;
  }
}
