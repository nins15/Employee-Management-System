package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class InsertSecurityAnswer {

    public static void insertSecurityAnswer(String username, String answer1, String answer2, String answer3) {

        Statement statement;
        int result;
        String query = ("insert into securityanswer(UserName,securityAnswer1,securityAnswer2,securityAnswer3)" +
                "values('" + username + "','" + answer1 + "','" + answer2 + "','" + answer3 + "')");
        try {
            Connection connection= DbConnection.connectDB();
            statement = connection.createStatement();
            result = statement.executeUpdate(query);
            if (result > 0)
                System.out.println("successfully inserted");
            else
                System.out.println("Answers not inserted!! Please check your username: ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
