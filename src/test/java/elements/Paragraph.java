package elements;

import java.awt.AWTException;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Common.AbstractPage;
import Common.Common;
import Common.WebDriverAction;
import junit.framework.Assert;
import pageObjects.PageBuilder3_Editor;

public class Paragraph extends AbstractPage {
	WebDriver driver;
	Common common = new Common(driver);
//	PageBuilder3_Editor pb3_Editor = new PageBuilder3_Editor(driver);
	WebDriverAction myact = new WebDriverAction(driver);
	String url = "http://bravebits.io/j5", account = "admin", pass = "1";

//	@Test
	public void createNewArticle() throws AWTException, InterruptedException {
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_Editor)));
		clickElement(PageBuilder3_Editor.btn_Start_From_Blank, driver);
		String pageTitle = "page " + common.random_Number();
		sendKeys(PageBuilder3_Editor.txtbx_Page_Title, pageTitle, driver);
		clickElement(PageBuilder3_Editor.icon_Add_Element, driver);
		clickElement(PageBuilder3_Editor.link_Paragraph, driver);
		Thread.sleep(2000);
		String source = PageBuilder3_Editor.img_Paragraph_style_1;
		String target = PageBuilder3_Editor.Editor;
		driver.switchTo().defaultContent();
		drag_drop_though_iframes(source, target, driver);
		driver.findElement(By.xpath("//a[@id='sidebar-show-catalog-Standard-button']")).click();
//		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_Editor)));
		clickElement(PageBuilder3_Editor.btn_Save, driver);
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_Editor)));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageBuilder3_Editor.btn_View)));
		Assert.assertTrue(driver.findElement(By.xpath(PageBuilder3_Editor.btn_View)).isDisplayed());
		clickElement(PageBuilder3_Editor.btn_View, driver);
		switchToChildWindow(parentWindow, driver);
		System.out.println(getTextofElement("//section//span[contains(text(),'Lorem ipsum')]", driver));
		System.out.println("color: " + getSizeofText("//section//span[contains(text(),'Lorem ipsum')]", driver));
		
	}
	public static String hex2Rgb(String colorStr) {
	    Color c = new Color(
	        Integer.valueOf(colorStr.substring(1, 3), 16), 
	        Integer.valueOf(colorStr.substring(3, 5), 16), 
	        Integer.valueOf(colorStr.substring(5, 7), 16));

	    StringBuffer sb = new StringBuffer();
	    sb.append("rgb(");
	    sb.append(c.getRed());
	    sb.append(",");
	    sb.append(c.getGreen());
	    sb.append(",");
	    sb.append(c.getBlue());
	    sb.append(")");
	    return sb.toString();
	}
	@Test
	public void test() {
		String color = "#FFFFFF";
		
		System.out.println("color " + hex2Rgb(color));
	}

//	@BeforeClass
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
