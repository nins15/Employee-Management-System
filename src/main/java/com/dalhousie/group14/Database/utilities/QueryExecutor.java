package com.dalhousie.group14.Database.utilities;

import com.dalhousie.group14.Presentation.utilities.IDbWriteErrorMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Harjot Singh
 * @NameofFile: QueryExecutor.java
 * @ClassDescription: This class is used for the purpose of executing queries.
 */
public class QueryExecutor {
  public static ResultSet readData(String query) {
    ResultSet resultSet;
    try {
      PreparedStatement preparedStatement = DbConnection.connectDB().prepareStatement(query);
      if (preparedStatement == null) {
        return null;
      } else {
        resultSet = preparedStatement.executeQuery();
        if (resultSet.isBeforeFirst()) {
          return resultSet;
        } else {
          return null;
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return null;
  }

  public static void writeData(String query) {
    try {
      Connection connection = DbConnection.connectDB();
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      if (preparedStatement == null) {
        IDbWriteErrorMessage.displayMessage();
      }else{
        preparedStatement.executeUpdate(query);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}

