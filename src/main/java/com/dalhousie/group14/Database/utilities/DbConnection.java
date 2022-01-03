package com.dalhousie.group14.Database.utilities;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DbConnection{
    public static final int URL_INDEX = 0;
    public static final int USERNAME_INDEX = 1;
    public static final int PASSWORD_INDEX = 2;


    public static Connection connectDB() {
        // IDbCredLoad obj = new DbCredLoad();

        // List<String> credList = obj.loadCredentials();
//        final String url = credList.get(URL_INDEX);
//        final String username = credList.get(USERNAME_INDEX);
//        final String password = credList.get(PASSWORD_INDEX);
        final String url = "jdbc:mysql://34.134.143.1/ems";
        final String username = "root";
        final String password = "ahjnr5";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            return connection;
        } catch (SQLException sqlException) {

            return null;
        }
    }


}
