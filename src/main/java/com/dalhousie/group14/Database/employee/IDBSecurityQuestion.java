/*Author- Jainam Shah(B00883898)*/
package com.dalhousie.group14.Database.employee;

import java.util.ArrayList;

public interface IDBSecurityQuestion {

  void setSecurityQuestionFirstTime(String userName);

  ArrayList<String> getSecurityQuestion(String userName);

  void insertSecurityAnswer(String userName, String answer1,
                            String answer2, String answer3);

  void employeeValidate(String userName, String answer);

  void updateSecurityQuestion(String userName, String question1,
                              String question2, String question3);

  void updateSecurityAnswer(String userName, String answer1,
                            String answer2, String answer3);

  void insertTechDetails(int userID, String techLanguage1, String techLanguage2,
                         String techLanguage3);
}
