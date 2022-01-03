package com.dalhousie.group14.Database.manager;
/*Ninad Nitin Shukla*/
import java.util.List;

public interface IAssetRequestDB {

  List<List<String>> getPendingAssetRequestInformation(String managerUserName);

  boolean setNewAsset(String userName, String type,
                      String value);

  void insertNewAssetRequest(String employeeUserName, String item,
                             String reason);
}
