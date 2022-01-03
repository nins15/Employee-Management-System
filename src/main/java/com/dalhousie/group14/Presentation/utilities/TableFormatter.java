package com.dalhousie.group14.Presentation.utilities;

import java.util.List;

public class TableFormatter {

  public static String formatAsTable(List<List<String>> tablerows) {
    try {
      int[] lenMAX = new int[tablerows.get(0).size()];

      for (List<String> row : tablerows) {
        for (int i = 0; i < row.size(); i++) {
          lenMAX[i] = Math.max(lenMAX[i], row.get(i).length());
        }
      }

      StringBuilder buildFormat = new StringBuilder();
      for (int maxLength : lenMAX) {
        buildFormat.append("%-").append(maxLength + 2).append("s");
      }
      String format = buildFormat.toString();

      StringBuilder finalTable = new StringBuilder();
      for (List<String> row : tablerows) {
        finalTable.append(String.format(format, row.toArray(new String[0]))).append("\n");
      }
      return finalTable.toString();
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      return null;
    }

  }
}
