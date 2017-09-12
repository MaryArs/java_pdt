package ru.stqa.pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Viktorovna", "Arsitova", "AnchorFree", "135 Easy street, apt.12", "650-768-45-66", "mary.arsitova@gmail.com", "Software Engineer", "Test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Lary", "Itkins", "Johns", "AnchorFree", "718 Castro street", "650-768-45-66", "mary@gmail.com", "Software Engineer", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
