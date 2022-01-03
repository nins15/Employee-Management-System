package com.dalhousie.group14.BusinessLogic.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Harjot Singh
 * @NameofFile: ProjectDefinition.java
 * @ClassDescription: This class is responsible for validating the
 * information entered and passed by the user while defining the project.
 */
public class ProjectDefinition implements IProjectDefinition {

  public Date datesetter(String date) {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    sdf.setLenient(false);
    try {
      return sdf.parse(date);
    } catch (ParseException e) {
      return null;
    }

  }

}
