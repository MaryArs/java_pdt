package ru.stqa.pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Viktorovna", "Arsitova", "AnchorFree", "135 Easy street, apt.12", "650-768-45-66", "mary@gmail.com", "Software Engineer", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }
}
