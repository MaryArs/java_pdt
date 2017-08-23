package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelitionTests extends TestBase {

  @Test
  public void testContactDelition() {
    app.selectContact();
    app.deleteSelectedContacts();
  }

}
