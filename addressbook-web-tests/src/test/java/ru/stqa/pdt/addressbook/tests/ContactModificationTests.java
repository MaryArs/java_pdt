package ru.stqa.pdt.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;
import ru.stqa.pdt.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("Marina").withMiddlename("Viktorovna").withLastname("Arsitova").withCompany("AnchorFree").withAddress("135 Easy street, apt.12").withPhone("650-768-45-66").withEmail("mary.arsitova@gmail.com").withTitle("Software Engineer").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Lary").withMiddlename("Johns").withLastname("Itkins").withCompany("AnchorFree").withAddress("718 Castro street").withPhone("650-768-45-66").withEmail("mary@gmail.com").withTitle("Software Engineer");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
  }
}
