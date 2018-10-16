package elements;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Common;
import pageObjects.Joomla_Menu_Bar;
import pageObjects.Login_Page;
import Common.WebDriverAction;
import pageObjects.PB3_Editor;
public class Paragraph {
	WebDriver driver;
	Common common = new Common(driver);
	PB3_Editor pb3_Editor = new PB3_Editor(driver);
	String url = "http://bravebits.io/j5", account = "admin", pass = "1";

	@Test
	public void createNewArticle() throws AWTException {
		String pageTitle = "page "+ common.random_Number();
		PB3_Editor.txtbx_Page_Title(driver).sendKeys(pageTitle);
		PB3_Editor.icon_Add_Element(driver).click();
		PB3_Editor.link_Paragraph(driver).click();
		WebDriverAction.drag_drop_though_iframes(pb3_Editor.img_Paragraph_style_1(), pb3_Editor.Editor(),driver);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		common.login(url, account, pass, driver);
		common.create_New_Page_By_Pb3Editor(driver);

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
