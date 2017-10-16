package ru.stqa.pdt.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pdt.mantis.appmanager.HttpSession;
import ru.stqa.pdt.mantis.model.MailMessage;
import ru.stqa.pdt.mantis.model.UserData;
import ru.stqa.pdt.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends  TestBase {
  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testChangeOfPassword() throws IOException, MessagingException, InterruptedException {
    app.changePasswordRegistration().login("administrator","root");
    app.changePasswordRegistration().panelControl();
    app.changePasswordRegistration().chooseUser();
    Users changeuser = app.db().allUsers();
    UserData userforchanges = changeuser.iterator().next();
    String username = userforchanges.getUsername();
    String password ="root";
    String email = userforchanges.getEmail();
    app.changePasswordRegistration().editUser(userforchanges.getId());
    app.changePasswordRegistration().resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(2,10000);
    String confermationLinK = findConfirmationLinK(mailMessages, email);
    app.registration().finish(confermationLinK, password);
    assertTrue(app.newSession().login(username,password));
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator","root"));
  }

  private String findConfirmationLinK(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}