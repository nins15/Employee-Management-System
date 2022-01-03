package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;


public class UpdateSecurityAnswer {

    public static void updateSecurityAnswer(String username, String answer1, String answer2, String answer3){

        int resultSet;
        Statement statement;

        String query="UPDATE `ems`.`securityanswer` SET `securityAnswer1` = '"+ answer1 +"' ,`securityAnswer2` = '"+ answer2 +"' ,`securityAnswer3` = '"+ answer3 +"' WHERE (`UserName` = '"+username+"')";
        try{
            Connection connection= DbConnection.connectDB();
            statement=connection.createStatement();
            resultSet=statement.executeUpdate(query);
            if (resultSet>0){
                System.out.println("Update Successfully");
            }
            else {
                System.out.println("Security Answer not update please check your employee id.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
