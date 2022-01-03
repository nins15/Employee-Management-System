/**
 * Author: Aadil Shaikh
 * This class is responsible for getting the dates that have events in them.
 * The dates that have events are called special dates.
 */
package com.dalhousie.group14.Database.utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class GetSpecialDates implements IGetSpecialDates, IGetSpecialDatesEmployee {

  private final List<Long> specialDates = new ArrayList<>();
  LocalDate currentDate = LocalDate.now();
  int currentYear = currentDate.getYear();
  int currentMonth = currentDate.getMonth().getValue();

  public List<Long> getSpecialDates() {
    try {
      String query = "SELECT eventDate from `Calendar`";
      ResultSet rs;
      rs = QueryExecutor.readData(query);
      while (rs != null && rs.next()) {
        String date = rs.getString("eventDate");
        int special_year = Integer.parseInt(date.substring(0, 4));
        int special_month = Integer.parseInt(date.substring(5, 7));
        int special_date = Integer.parseInt(date.substring(8, 10));
        if (special_year == currentYear) {
          CRC32 hash = new CRC32();
          hash.reset();
          hash.update(String.format("%d_%d", special_month, special_date).getBytes());
          specialDates.add(hash.getValue());
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return specialDates;
  }

  public List<Long> getSpecialDatesForEmployee(String empID) {
    try {
      String query =
          "SELECT eventDate from `Calendar` WHERE empID = '" + empID + "'";
      ResultSet rs;
      rs = QueryExecutor.readData(query);
      while (rs != null && rs.next()) {
        String date = rs.getString("eventDate");
        int special_year = Integer.parseInt(date.substring(0, 4));
        int special_month = Integer.parseInt(date.substring(5, 7));
        int special_date = Integer.parseInt(date.substring(8, 10));
        if (special_year == currentYear) {
          CRC32 hash = new CRC32();
          hash.reset();
          hash.update(String.format("%d_%d", special_month, special_date).getBytes());
          specialDates.add(hash.getValue());
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return specialDates;
  }
}
