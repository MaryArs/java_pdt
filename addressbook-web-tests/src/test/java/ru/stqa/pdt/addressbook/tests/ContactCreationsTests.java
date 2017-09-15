package ru.stqa.pdt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Marina").withMiddlename("Viktorovna").withLastname("Arsitova").withCompany("Anchor").withAddress("135 Easy street, apt.12").withPhone("650-768-45-66").withEmail("mary@gmail.com").withTitle("Software Engineer").withGroup("test1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
