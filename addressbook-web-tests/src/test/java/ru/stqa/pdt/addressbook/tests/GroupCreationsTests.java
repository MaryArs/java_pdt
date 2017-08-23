package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.GroupData;

public class GroupCreationsTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
