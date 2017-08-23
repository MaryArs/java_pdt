package ru.stqa.pdt.addressbook;

import org.testng.annotations.Test;

public class GroupCreationsTests extends TestBase {

  @Test
  public void testGroupCreation() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
