package com.dalhousie.group14.BusinessLogic.employee;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

/*Author- Jainam Shah*/
public class ChangeSecurityQuestionTest {

  @Test
  @DisplayName("This method check validation for question 1 and return true.")
  public void changeSecurityQuestionTrueQuestion1() {
    ChangeSecurityQuestion changeSecurityQuestion = new ChangeSecurityQuestion();
    assertTrue(changeSecurityQuestion.checkSecurityQuestionValidation("what is your " +
        "favourite food?"));
  }

  @Test
  @DisplayName("This method check validation for question 1 and return false.")
  public void changeSecurityQuestionFalseQuestion1() {
    ChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    assertFalse(securityQuestion.checkSecurityQuestionValidation(" "));
  }

  @Test
  @DisplayName("This method check validation for question 1 and return false.")
  public void changeSecurityQuestionFalseQuestion12() {
    ChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    assertFalse(securityQuestion.checkSecurityQuestionValidation(" wh"));
  }

  @Test
  @DisplayName("This method check validation for question 2 and return true.")
  public void changeSecurityQuestionTrueQuestion2() {
    ChangeSecurityQuestion changeSecurityQuestion = new ChangeSecurityQuestion();
    assertTrue(changeSecurityQuestion.checkSecurityQuestionValidation("what " +
        "is your favorite cricketer?"));
  }

  @Test
  @DisplayName("This method check validation for question 2 and return false.")
  public void changeSecurityQuestionFalseQuestion2() {
    ChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    assertFalse(securityQuestion.checkSecurityQuestionValidation(" "));
  }

  @Test
  @DisplayName("This method check validation for question 2 and return false.")
  public void changeSecurityQuestionFalseQuestion21() {
    ChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    assertFalse(securityQuestion.checkSecurityQuestionValidation("we"));
  }

  @Test
  @DisplayName("This method check validation for question 3 and return true.")
  public void changeSecurityQuestionTrueQuestion3() {
    ChangeSecurityQuestion changeSecurityQuestion = new ChangeSecurityQuestion();
    assertTrue(changeSecurityQuestion.checkSecurityQuestionValidation("what " +
        "is your favorite flower?"));
  }

  @Test
  @DisplayName("This method check validation for question 3 and return false.")
  public void changeSecurityQuestionFalseQuestion3() {
    ChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    assertFalse(securityQuestion.checkSecurityQuestionValidation(" "));
  }

  @Test
  @DisplayName("This method check validation for question 3 and return false.")
  public void changeSecurityQuestionFalseQuestion31() {
    ChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    assertFalse(securityQuestion.checkSecurityQuestionValidation("we"));
  }
}