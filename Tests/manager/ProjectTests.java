package manager;

import com.dalhousie.group14.BusinessLogic.manager.ProjectAssigner;
import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
import com.dalhousie.group14.Database.manager.ProjectStatusRetrieve;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProjectTests {

  @Test
  public void projectStatusCheck(){
    assertEquals(true, com.dalhousie.group14.Database.manager.ProjectStatus.checkStatus("Initiation"));
  }

  @Test
  public void projectUnassignedTest(){
    ResultSet resultSet = com.dalhousie.group14.Database.manager.ProjectStatus.checkStatus("Initiation");
    IProjectStatusRetrieve projectStatusRetrieve  = new ProjectStatusRetrieve();
    List<String> pendingprojects = projectStatusRetrieve.projectList(resultSet);
    List<String> pendingprojects_test = new ArrayList<>();

    pendingprojects.add("2 Student Management System Java Python HTML 2021-06-26 2021-12-26 Initiation");
    pendingprojects.add("3 Hazmat Analysis Java Python, 2021-07-10 2021-12-11 Initiation");
    pendingprojects.add("4 Marine Analysis Python 2021-07-10 2021-12-12 Initiation");

    assertEquals(pendingprojects_test,pendingprojects);
  }

  @Test
  public void projectssignedTest() {
    ProjectAssigner obj = new ProjectAssigner();
    assertEquals(true,obj.assignProject(""));
  }

}

