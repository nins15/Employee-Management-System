package com.dalhousie.group14.BusinessLogic.utilities;

public interface Assets {

  public boolean requested(String EmployeeUserName, Assets assets, String reason);

  public boolean allocated(int numAllocated, Assets assets);
}
