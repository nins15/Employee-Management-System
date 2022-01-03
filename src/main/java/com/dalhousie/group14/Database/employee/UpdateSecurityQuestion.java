package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;


public class UpdateSecurityQuestion {
    public static void updateSecurityQuestion(String username, String question1, String question2, String question3) {

        int resultSet;
        Statement statement;

        String query = "UPDATE `ems`.`securityquestion` SET `securityQuestion1` = '" + question1 + "', `securityQuestion2` = '" + question2 + "', `securityQuestion3` = '" + question3 + "' WHERE (`UserName` = '" + username + "')";
        try{
            Connection connection= DbConnection.connectDB();
            statement = connection.createStatement();
            resultSet = statement.executeUpdate(query);
            if (resultSet > 0) {
                System.out.println("Update Successfully");
            } else {
                System.out.println("Password not update please check your employee id.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
