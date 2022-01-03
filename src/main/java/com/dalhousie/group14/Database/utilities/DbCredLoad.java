package com.dalhousie.group14.Database.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Harjot Singh
 * @NameofFile: DbCredLoad.java
 * @ClassDescription: This class is responsible for retrieving the credentials
 * from the db.properties file.
 */
public class DbCredLoad implements IDbCredLoad {
  public static final String DB_FILE_PATH = "src/main/java/com/dalhousie" +
      "/group14/resources/db.properties";

  public List<String> loadCredentials(){
    List<String> credList = new ArrayList<>();
    try (InputStream dbcredfile =
             getClass().getResourceAsStream("/db.properties")) {

      Properties dbproperties = new Properties();

      dbproperties.load(dbcredfile);

      credList.add(dbproperties.getProperty("DB_URL"));
      credList.add(dbproperties.getProperty("DB_USER"));
      credList.add(dbproperties.getProperty("DB_PASSWORD"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    return credList;
  }

}

