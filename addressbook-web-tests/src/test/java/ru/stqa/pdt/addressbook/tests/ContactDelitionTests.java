package ru.stqa.pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

import java.util.List;

public class ContactDelitionTests extends TestBase {

  @Test
  public void testContactDelition() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Viktorovna", "Arsitova", "AnchorFree", "135 Easy street, apt.12", "650-768-45-66", "mary.arsitova@gmail.com", "Software Engineer", "Test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlertWindow();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }

}
