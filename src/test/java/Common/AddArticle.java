package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddArticle {
	WebDriver dr;
  @Test
  public void f() {
	  this.dr=Common.dr;
	  WebDriverAction myact = new WebDriverAction(dr);
	  System.out.println("pass 1");
	  dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  myact.click("xpath=//ul[@id='menu']//li/a[text()='Content ']");
	  System.out.println("pass 2");
	  myact.hover("xpath=//li/a[@class='dropdown-toggle menu-article']/..");
	  myact.click("linktext=Add New Article");
	  dr.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	  myact.click("xpath=//a[@id='ui-show-catalog-button']/../a[2]");
	  dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  myact.click("xpath=//div[text()='Paragraph']");
	  dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  myact.draganddrop("xpath=//div[@class='sc-jDwBTQ fkdWmV']/img[3]", "xpath=//div[@data-type='Body']");
	  System.out.println("pass all");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  Common cm = new Common(dr);
	  cm.login("http://bravebits.io/j5", "admin", "1");
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
