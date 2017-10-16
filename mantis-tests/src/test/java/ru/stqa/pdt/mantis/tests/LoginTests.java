package ru.stqa.pdt.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class LoginTests extends  TestBase{

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
