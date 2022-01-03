package com.dalhousie.group14.virtualize;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DummySessions {
  public static final String pattern = "yyyy-MM-dd";
  public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

  public static void main(String[] args) {
    DummySessions.createSessions();

  }

  public static void createSessions() {
    String name = "";
    List<String> employees = new ArrayList<>();
    for (int i = 17; i < 20; i++) {
      String emp = name + i;
      employees.add(emp);
    }

    Calendar calendar = Calendar.getInstance();
    String[] minutes = {"360", "350", "355", "350", "360"};

    Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
    Date initial_date = Validations.subtractDaystoDate(final_date, 30);
    for (int i = 0; i < 30; i++) {
      for (int j = 0; j < employees.size(); j++) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        String query = "INSERT INTO LoginSession (SessionDate, Minutes, UserName)" + "Values('" + sdf.format(initial_date) + "','" + minutes[randomNum] + "','" + employees.get(j) + "')";
        QueryExecutor.writeData(query);
      }
      initial_date = Validations.addDaystoDate(initial_date, 1);
    }


  }


}
