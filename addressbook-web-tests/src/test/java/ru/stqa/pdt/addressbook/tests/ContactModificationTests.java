package ru.stqa.pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if (!app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData().withFirstname("Marina").withMiddlename("Viktorovna").withLastname("Arsitova").withCompany("AnchorFree").withAddress("135 Easy street, apt.12").withPhone("650-768-45-66").withEmail("mary.arsitova@gmail.com").withTitle("Software Engineer").withGroup("Test1"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("Lary").withMiddlename("Itkins").withLastname("Johns").withCompany("AnchorFree").withAddress("718 Castro street").withPhone("650-768-45-66").withEmail("mary@gmail.com").withTitle("Software Engineer");
    app.contact().modify(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
