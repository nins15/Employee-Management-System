package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.AssetRequestDB;
import com.dalhousie.group14.Presentation.manager.AssetRequestPresentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Author:-Ninad Nitin Shukla
 * Purpose:- This class is used by manager to view Requests.
 * */
public class AssetRequests implements IAssetRequests {

  @Override
  public void viewRequests(String userName) {
    String exit = "";
    try {

      do {
        List<List<String>> info = new ArrayList<>();
        AssetRequestDB assetRequests = new AssetRequestDB();
        info = assetRequests.getPendingAssetRequestInformation(userName);
        AssetRequestPresentation assetRequestPresentation = new AssetRequestPresentation();
        assetRequestPresentation.allPendingAssetRequests(info);
        int index = assetRequestPresentation.enterRequest();


        Map<String, String> map = new HashMap<>();
        map.put("EmployeeUserName", info.get(index).get(0));
        map.put("Reason", info.get(index).get(1));
        map.put("ApprovdStatus", info.get(index).get(2));
        map.put("item", info.get(index).get(3));

        if (assetRequests.setNewAsset(map.get("EmployeeUserName"), "ApprovdStatus",
            "approved"))
          exit = assetRequestPresentation.wantToExit();


      } while (exit.equals("yes"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
