package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.utilities.QueryExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Harjot Singh
 * @NameofFile: EmployeeProjectPerformance.java
 * @ClassDescription: This class is used for the purpose of providing
 * database interaction for the employee's session, used in Session Evaluation.
 */
public class EmployeeSessions {
    public static final String pattern = "yyyy-MM-dd";
    public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    public static List<List<String>> getEmployeeSessions(Date date, int DAYS){
        ResultSet resultSet =  null;
        Date previous_date = Validations.addDaystoDate(date,-DAYS);
        String query = "Select * from LoginSession where SessionDate between '"
            +sdf.format(previous_date)+"' and '"+sdf.format(date)+"'";
        resultSet = QueryExecutor.readData(query);
        List<List<String>> empSessions = new ArrayList<>();
        if(resultSet == null){
            return null;
        }else{
            try{
                if(resultSet.isBeforeFirst()){
                    while (resultSet.next()){
                        List<String> empSession = new ArrayList<>();
                        String username = resultSet.getString("UserName");
                        String sessionTime = resultSet.getString("Minutes");
                        empSession.add(username);
                        empSession.add(sessionTime);
                        empSessions.add(empSession);
                    }
                }

            }catch (SQLException sqlException){
                return null;
            }
        }
    return empSessions;
    }



    public static List<String> getEmployeeSession(String username, Date date,
                                               int DAYS){
        ResultSet resultSet =  null;
        Date previous_date = Validations.addDaystoDate(date,-DAYS);
        String query = "Select * from LoginSession where SessionDate between '"
            +sdf.format(previous_date)+"' and '"+sdf.format(date)+"' AND UserName='"+username+"'";
        resultSet = QueryExecutor.readData(query);
        List<String> sessions = new ArrayList<>();
        if(resultSet == null){
            return null;
        }else{
            try{
                if(resultSet.isBeforeFirst()){
                    while (resultSet.next()){
                        List<String> empSession = new ArrayList<>();
                        String sessionTime = resultSet.getString("Minutes");
                        sessions.add(sessionTime);
                    }
                }

            }catch (SQLException sqlException){
                return null;
            }
        }
        return sessions;
    }
}
