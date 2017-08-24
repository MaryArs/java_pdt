package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelitionTests extends TestBase {

  @Test
  public void testContactDelition() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlertWindow();
    app.getContactHelper().returnToContactPage();
  }

}
