package com.dalhousie.group14.BusinessLogic.employee;

/* Author- Jainam Shah(B00883898)
 * SetSecurityQuestion java class contains three task. One is to ask Security
 * from employee and insert data into database. Second is to ask the answers
 * of this question. And 3rd one is to insert Security Question and Answer in
 *  database.
 */

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;
import com.dalhousie.group14.Database.employee.IDBSecurityQuestion;
import com.dalhousie.group14.Presentation.employee.ISetLanguages;
import com.dalhousie.group14.Presentation.employee.SetLanguages;

import java.util.ArrayList;
import java.util.Scanner;

public class SetSecurityQuestion implements ISetSecurityQuestion {

  /**
   * This method take userName as as parameter and insert Security Question
   * Answer into database.
   *
   * @param userName
   */

  public void setSecurityQuestion(String userName) {

    String question1;
    String question2;
    String question3;
    String answer1;
    String answer2;
    String answer3;

    /*Create Object of DBSecurityQuestion*/
    IDBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();
    ISetLanguages setLanguages = new SetLanguages();
    Scanner scanner = new Scanner(System.in);
    String userId = userName;
    ArrayList<String> arrayList;

    /* take userName and insert Security Question in the with userName and
    questions in the database.
     */
    dbSecurityQuestion.setSecurityQuestionFirstTime(userId);

    /*All security Question Answer stored in arrayList ans we can access it.*/
    arrayList = dbSecurityQuestion.getSecurityQuestion(userId);

    userId = arrayList.get(0);
    System.out.println("Username:" + userId);
    System.out.println("Please Write the answer of questions:");

    question1 = arrayList.get(1);
    System.out.println(question1);
    answer1 = scanner.nextLine();

    question2 = arrayList.get(2);
    System.out.println(question2);
    answer2 = scanner.nextLine();

    question3 = arrayList.get(3);
    System.out.println(question3);
    answer3 = scanner.nextLine();

    /*Insert security Question Answer into database.*/
    dbSecurityQuestion.insertSecurityAnswer(userId, answer1, answer2,
        answer3);

    setLanguages.setLanguages(userId);

  }
}
