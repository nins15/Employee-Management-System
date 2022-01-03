package com.dalhousie.group14.Presentation.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Name:-Ninad Nitin Shukla
 * */
public class AssetRequestPresentation {


  public List<String> askForAssets() {
    List<String> assets = new ArrayList<>();
    System.out.println("Please Enter the asset you want to access");
    Scanner scanner = new Scanner(System.in);
    String asset = scanner.next();
    System.out.println("Please Enter the reason for the asset.");
    String reason = scanner.next();
    assets.add(asset);
    assets.add(reason);
    return assets;
  }
}
