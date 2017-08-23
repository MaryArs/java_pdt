package ru.stqa.pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper {
  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {

    this.wd = wd;
  }

  public void selectContact() {
    if (!wd.findElement(By.id("1")).isSelected()) {
      wd.findElement(By.id("1")).click();
    }
  }

  public void deleteSelectedContacts() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }
}
