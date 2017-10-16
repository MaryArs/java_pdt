package ru.stqa.pdt.mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePasswordRegistration extends HelperBase {

  public ChangePasswordRegistration(ApplicationManager app){
    super(app);
  }

  public void login (String username, String password) {
    wd.get(app.getProperty("web.urlBase") + "/login_page.php");
    type(By.xpath("//input[@name='username']"),username);
    click(By.xpath("//input[@type='submit']"));
    type(By.xpath("//input[@name='password']"), password);
    click(By.xpath("//input[@type='submit']"));
  }

  public void panelControl() {
    click(By.xpath(".//*[@id='sidebar']/ul/li[6]/a/i"));
  }

  public void chooseUser() {
    click(By.xpath(".//*[@id='main-container']/div[2]/div[2]/div/ul/li[2]/a"));
  }

  public void editUser(int id) {
    click(By.cssSelector("a[href=\"manage_user_edit_page.php?user_id=" + id +"\"]"));
  }

  public void resetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }
}