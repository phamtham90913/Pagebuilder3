package elements;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Common;
import pageObjects.Joomla_Menu_Bar;
import pageObjects.Login_Page;
import Common.WebDriverAction;
public class Paragraph {
	WebDriver driver;
	Common common = new Common(driver);
	String url = "http://bravebits.io/j5", account = "admin", pass = "1";

	@Test
	public void createNewArticle() {
		Joomla_Menu_Bar.menu_Content(driver).click();
		WebDriverAction.hover(Joomla_Menu_Bar.menu_Articles(driver), driver);
		Joomla_Menu_Bar.menu_Add_New_Articles(driver).click();
		
//		Login_Page.btn_Submit(driver)
		System.out.println("get current url" + driver.getCurrentUrl());
	}

	@BeforeClass
	public void beforeClass() {
		common.login(url, account, pass);
		this.driver = common.dr;

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
