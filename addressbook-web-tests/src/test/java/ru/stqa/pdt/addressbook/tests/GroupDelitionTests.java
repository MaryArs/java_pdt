package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.GroupData;

public class GroupDelitionTests extends TestBase {

  @Test
  public void testGroupDelition() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
