package com.dalhousie.group14.Database.employee;


import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;


public class GetSecurityQuestion {

    public static ArrayList<String> getSecurityQuestion(String username) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String question1, question2, question3;
        String query = "select * from securityquestion where UserName= '" + username + "'";
        Statement stmt;
        ResultSet rs;
        {
            try {
                Connection connection= DbConnection.connectDB();
                stmt = connection.createStatement();
                rs = stmt.executeQuery(query);
                System.out.println("Set Security Question Answer.......First Time User.............");
                while (rs.next()) {
                    username = rs.getString("UserName");
                    arrayList.add(username);

                    question1 = rs.getString("securityQuestion1");
                    arrayList.add(question1);

                    question2 = rs.getString("securityQuestion2");
                    arrayList.add(question2);

                    question3 = rs.getString("securityQuestion3");
                    arrayList.add(question3);
                }
                //System.out.println(arrayList);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return arrayList;
        }
    }
}

