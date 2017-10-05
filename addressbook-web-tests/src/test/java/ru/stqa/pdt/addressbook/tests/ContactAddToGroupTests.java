package ru.stqa.pdt.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.addressbook.model.Contacts;
import ru.stqa.pdt.addressbook.model.ContactData;
import ru.stqa.pdt.addressbook.model.GroupData;
import ru.stqa.pdt.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.db().groups().size() == 0) {
      app.goTo().gotoGroupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test").withFooter("test"));
    }
    if (app.db().contacts().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("Marina").withMiddlename("Viktorovna")
              .withLastname("Arsitova").withCompany("AnchorFree").withAddress("135 Easy street, apt.12")
              .withHomePhone("650-768-45-66").withEmail("mary.arsitova@gmail.com").withTitle("Software Engineer"));
    }
  }

  @Test
  public void testContacttsAddtoGroup() {
    app.goTo().gotoHomePage();
    Contacts allContacts = app.db().contacts();
    ContactData addedContact = allContacts.iterator().next();
    //Выбрал произвольный контак
    app.contact().selectContactbyId(addedContact.getId());
    Groups allGroups = app.db().groups();
    // произвольная группа
    GroupData groups = allGroups.iterator().next();
    // Создал множество контактов в выбранной группе до добавления
    //Contacts beforeContacts = groups.getContacts();
    //выбрал произвльную группу
    app.contact().selectGroup(groups);
    app.contact().addtoGroup();
    // создал множество контактов после обновления
    Contacts afterContacts = groups.getContacts();
    //реализовать проверку попал
   // assertThat(afterContacts, equalTo(beforeContacts.withAdded(addedContact)));

  }

}
