package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (!app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData().withFirstname("Marina").withMiddlename("Viktorovna").withLastname("Arsitova").withCompany("AnchorFree").withAddress("135 Easy street, apt.12").withHomePhone("650-768-45-66").withMobilePhone("+7 850").withWorkPhone("12 23 45").withEmail("mary.arsitova@gmail.com").withTitle("Software Engineer").withGroup("test1"));
    }
  }

  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
   return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
           .stream().filter((s) -> !s.equals(""))
           .map(ContactPhoneTests:: cleaned)
           .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
