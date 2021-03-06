package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;
import ru.stqa.pdt.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size() == 0) {
    app.goTo().gotoHomePage();
    app.contact().createContact(new ContactData().withFirstname("Marina").withMiddlename("Viktorovna")
            .withLastname("Arsitova").withCompany("AnchorFree").withAddress("135 Easy street, apt.12")
            .withHomePhone("650-768-45-66").withEmail("mary.arsitova@gmail.com").withTitle("Software Engineer"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Lary").withMiddlename("Johns").withLastname("Itkins").withCompany("AnchorFree").withAddress("718 Castro street").withHomePhone("650-768-45-66").withEmail("mary@gmail.com").withTitle("Software Engineer");
    app.goTo().gotoHomePage();
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
