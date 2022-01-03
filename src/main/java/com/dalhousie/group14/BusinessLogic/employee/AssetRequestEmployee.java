package com.dalhousie.group14.BusinessLogic.employee;
/*AssetRequestEmployee
 *Author:Ninad Nitin Shukla
 *Purpose:-This class implements the IAssetRequestEmployee and is used for
 * applying for the asset
 * */

import com.dalhousie.group14.Database.manager.AssetRequestDB;
import com.dalhousie.group14.Presentation.employee.AssetRequestPresentation;

import java.util.ArrayList;
import java.util.List;

public class AssetRequestEmployee implements IAssetRequestEmployee {

  @Override
  public void applyForAssetRequest(String employeeUserName) {
    List<String> assets = new ArrayList<>();
    AssetRequestPresentation assetRequestPresentation =
        new AssetRequestPresentation();
    assets = assetRequestPresentation.askForAssets();
    AssetRequestDB assetRequestDB = new AssetRequestDB();
    try {
      assetRequestDB.insertNewAssetRequest(employeeUserName, assets.get(0),
          assets.get(1));
    } catch (IndexOutOfBoundsException e) {
      return;
    }


  }

}
