package ru.stqa.pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseHelper {

  protected WebDriver wd;

  public BaseHelper(WebDriver wd){
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected  void type(By locator, String text){
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);

  }

  protected boolean selectedElement() {
    return wd.findElement(By.id("1")).isSelected();
  }
}
