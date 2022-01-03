package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.BusinessLogic.employee.ChangeSecurityQuestion;
import com.dalhousie.group14.BusinessLogic.employee.GiveSecurityQuestionAnswer;
import com.dalhousie.group14.BusinessLogic.employee.IChangeSecurityQuestion;
import com.dalhousie.group14.BusinessLogic.employee.IGiveSecurityQuestionAnswer;
import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.Presentation.employee.EmployeeLoginDashBoard;
import com.dalhousie.group14.Presentation.employee.SecurityQuestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author- Jainam Shah(B00883898)
 * This class insert the Security Question with UserName into Database.
 */
public class DBSecurityQuestion implements IDBSecurityQuestion {

  /*This method take username as a parameter and retrive all the data from
   *database.
   */
  public ArrayList<String> getSecurityQuestion(String userName) {

    ArrayList<String> arrayList = new ArrayList<>();
    String question1;
    String question2;
    String question3;

    String query = "select * from securityquestion where UserName= '" + userName + "'";
    Statement stmt;
    ResultSet rs;
    {
      try {
        Connection connection = DbConnection.connectDB();
        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        while (rs.next()) {
          userName = rs.getString("UserName");
          arrayList.add(userName);

          question1 = rs.getString("securityQuestion1");
          arrayList.add(question1);

          question2 = rs.getString("securityQuestion2");
          arrayList.add(question2);

          question3 = rs.getString("securityQuestion3");
          arrayList.add(question3);
        }

      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      return arrayList;
    }
  }

  /* This method Insert the Security Question Into Database.
   */
  public void insertSecurityAnswer(String userName, String answer1, String answer2, String answer3) {

    SecurityQuestion securityQuestion = new SecurityQuestion();
    Statement statement;
    int result;
    String query = ("insert into securityanswer(UserName,securityAnswer1,securityAnswer2,securityAnswer3)" +
        "values('" + userName + "','" + answer1 + "','" + answer2 + "','" + answer3 + "')");
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      result = statement.executeUpdate(query);
      if (result > 0) {
        System.out.println("Successfully Inserted your Answers.");

      } else {
        System.out.println("Answers not inserted!! Please check your userName: ");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /* This method check the security answer given by employee is right or
  wrong. */
  public void employeeValidate(String userName, String answer) {

    Statement statement;
    ResultSet resultSet;
    String query;
    String answer1 = null;
    String answer2 = null;
    String answer3 = null;

    IGiveSecurityQuestionAnswer giveSecurityQuestionAnswer =
        new GiveSecurityQuestionAnswer();
    EmployeeLoginDashBoard employeeLoginDashBoard = new EmployeeLoginDashBoard();

    query = "select * from securityanswer where UserName='" + userName + "'";

    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        answer1 = resultSet.getString("securityAnswer1");
        answer2 = resultSet.getString("securityAnswer2");
        answer3 = resultSet.getString("securityAnswer3");
      }
      if (answer.equalsIgnoreCase(answer1)) {
        employeeLoginDashBoard.employeeLoginDashBoard(userName);
      } else if (answer.equalsIgnoreCase(answer2)) {
        employeeLoginDashBoard.employeeLoginDashBoard(userName);
      } else if (answer.equalsIgnoreCase(answer3)) {
        employeeLoginDashBoard.employeeLoginDashBoard(userName);
      } else {
        System.out.println("Please enter correct value:");
        giveSecurityQuestionAnswer.giveSecurityQuestionAnswer(userName);

      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /* This method update the security Question in their respective row.
   */
  public void updateSecurityQuestion(String userName, String question1, String question2, String question3) {

    int resultSet;
    Statement statement;
    IChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();

    String query = "UPDATE `ems`.`securityquestion` SET `securityQuestion1` = '" + question1 + "', `securityQuestion2` = '" + question2 + "', `securityQuestion3` = '" + question3 + "' WHERE (`UserName` = '" + userName + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      System.out.println("connect");
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Security Question Successfully");
      } else {
        System.out.println("security, not update please check your employee " +
            userName);
        securityQuestion.changeSecurityQuestion();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  /* This method update the security Answer in their respective row.
   */
  public void updateSecurityAnswer(String userName, String answer1, String answer2, String answer3) {

    int resultSet;
    Statement statement;
    IChangeSecurityQuestion securityQuestion = new ChangeSecurityQuestion();
    String query = "UPDATE `ems`.`securityanswer` SET `securityAnswer1` = '" + answer1 + "' ,`securityAnswer2` = '" + answer2 + "' ,`securityAnswer3` = '" + answer3 + "' WHERE (`UserName` = '" + userName + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Security Answer Successfully");
      } else {
        System.out.println("Security Answer not update please check your " +
            "employee name.");
        securityQuestion.changeSecurityQuestion();

      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }



  /*
   * This method take username as a parameter and insert data into database.
   * @param username
   */

  public void setSecurityQuestionFirstTime(String userName) {

    String query;
    Scanner scanner = new Scanner(System.in);
    String question1;
    String question2;
    String question3;
    Statement statement;
    int result;
    System.out.println("Enter your 1 Security Question:");
    question1 = scanner.nextLine();
    System.out.println("Enter your 2 Security Question:");
    question2 = scanner.nextLine();
    System.out.println("Enter your 3 Security Question:");
    question3 = scanner.nextLine();
    SecurityQuestion question = new SecurityQuestion();
    query = ("insert into securityquestion (UserName,securityQuestion1,securityQuestion2,securityQuestion3)" +
        "values('" + userName + "','" + question1 + "','" + question2 + "','" + question3 + "')");

    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();

      result = statement.executeUpdate(query);

      if (result > 0) {
        System.out.println("Successfully Inserted Security Question First " +
            "Time.");
      } else {
        System.out.println("Data not Inserted!! please, check your Username ");

      }
    } catch (Exception e) {
      System.out.println("Exception:" + e);
      question.securityQuestion();
    }
  }

  public void insertTechDetails(int userID, String techLanguage1, String techLanguage2,
                                String techLanguage3) {
    String query;
    Scanner scanner = new Scanner(System.in);
    Statement statement;
    int result;
    query = "INSERT INTO `ems`.`EmployeeTechDetails` (`EmployeeID`,`Languages`)" +
        " VALUES ('" + userID + "', '" + techLanguage1 + " ," + techLanguage2 + " ," + techLanguage3 + "')";
    SecurityQuestion securityQuestion = new SecurityQuestion();
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();

      result = statement.executeUpdate(query);

      if (result > 0) {
        System.out.println("Successfully sampledata First " +
            "Time.");
        securityQuestion.securityQuestion();
      } else {
        System.out.println("Data not Inserted!! please, check your Username ");

      }
    } catch (Exception e) {
      System.out.println("Exception:" + e);

    }
  }

}

