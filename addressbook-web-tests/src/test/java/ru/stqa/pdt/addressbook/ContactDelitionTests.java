package ru.stqa.pdt.addressbook;

import org.testng.annotations.Test;

public class ContactDelitionTests extends TestBase {

  @Test
  public void testContactDelition() {
    selectContact();
    deleteSelectedContacts();
  }

}
