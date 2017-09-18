package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationsTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().gotoHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Marina").withMiddlename("Viktorovna").withLastname("Arsitova").withCompany("Anchor").withAddress("135 Easy street, apt.12").withPhone("650-768-45-66").withEmail("mary@gmail.com").withTitle("Software Engineer").withGroup("test1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt());
    before.add(contact);
    assertThat(before, equalTo(after) );
  }
}
