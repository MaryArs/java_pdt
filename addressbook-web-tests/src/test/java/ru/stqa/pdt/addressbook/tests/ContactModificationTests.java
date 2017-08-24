package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test

  public void testContactModification(){
    app.getContactHelper().gotoContactPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Viktorovna", "Arsitova", "AnchorFree", "718 Castro street", "650-768-45-66", "mary@gmail.com", "Software Engineer"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
  }
}
