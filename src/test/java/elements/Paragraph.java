package elements;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.AbstractPage;
import Common.Common;
import Common.WebDriverAction;
import pageObjects.PageBuilder3_Editor;

public class Paragraph extends AbstractPage {
	WebDriver driver;
	Common common = new Common(driver);
//	PageBuilder3_Editor pb3_Editor = new PageBuilder3_Editor(driver);
	WebDriverAction myact = new WebDriverAction(driver);
	String url = "http://bravebits.io/j5", account = "admin", pass = "1";

	@Test
	public void createNewArticle() throws AWTException, InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_Editor)));
		PageBuilder3_Editor.btn_Start_From_Blank(driver).click();
		String pageTitle = "page " + common.random_Number();
		PageBuilder3_Editor.txtbx_Page_Title(driver).sendKeys(pageTitle);
		PageBuilder3_Editor.icon_Add_Element(driver).click();
		PageBuilder3_Editor.link_Paragraph(driver).click();
		Thread.sleep(2000);
//		WebDriverAction.drag_drop_though_iframes(PageBuilder3_Editor.img_Paragraph_style_1(driver), PageBuilder3_Editor.Editor(driver), driver);
//		String source = "//img[@id='catalog-elem-01.paragraph']";
//		String target = "//div[@data-type='Body']";
		String source = PageBuilder3_Editor.img_Paragraph_style_1;
		// "//img[@id='catalog-elem-01.paragraph']";
		String target = PageBuilder3_Editor.Editor;
		driver.switchTo().defaultContent();

		drag_drop_though_iframes(source, target, driver);
//		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_inner_Editor)));
		driver.findElement(By.xpath("//a[@id='sidebar-show-catalog-Standard-button']")).click();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		common.login(url, account, pass, driver);
		common.create_New_Page_By_Pb3Editor(driver);

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.quit();
	}
}
