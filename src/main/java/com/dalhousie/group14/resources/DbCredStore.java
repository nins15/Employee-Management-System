package com.dalhousie.group14.resources;


import com.dalhousie.group14.Presentation.utilities.IDbConfigMessageError;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
/**
 * @author Harjot Singh
 * @NameofFile: DbCredLoad.java
 * @ClassDescription: This class is responsible for retrieving the credentials
 * from the db.properties file.
 */
public class DbCredStore {

  DbCredStore(){
    try (OutputStream output = new FileOutputStream("src/main/java/com" +
        "/dalhousie/group14/resources/db.properties")) {

      Properties dbproperties = new Properties();

      dbproperties.setProperty("DB_URL", "jdbc:mysql://34.134.143.1/ems");
      dbproperties.setProperty("DB_USER", "root");
      dbproperties.setProperty("DB_PASSWORD", "ahjnr5");

      dbproperties.store(output, null);

    } catch (IOException io) {
      IDbConfigMessageError.dbConfigMessage();
    }
  }
}
