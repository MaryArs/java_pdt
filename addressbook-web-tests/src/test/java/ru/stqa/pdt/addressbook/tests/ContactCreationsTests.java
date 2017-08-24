package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Viktorovna", "Arsitova", "AnchorFree", "155 Acalanes drive, apt.12", "650-768-45-66", "mary.arsitova@gmail.com", "Software Engineer"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
  }
}
