package Common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void createArticle() throws InterruptedException, AWTException {
		this.dr = Common.dr;
		WebDriverAction myact = new WebDriverAction(dr);

		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// click menu Content
		myact.click("xpath=//ul[@id='menu']//li/a[text()='Content ']");
		// hover menu aticle
		myact.hover("xpath=//li/a[@class='dropdown-toggle menu-article']/..");
		// click menu Add new Article
		myact.click("linktext=Add New Article");
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		// click btn Click To Edit
		// myact.click("xpath=//button[text()='Click To Edit']");

		/** close modal Select template */
		dr.switchTo().frame("pagefly-pb-app");
		Assert.assertTrue(dr.findElement(By.xpath("//span[text()='Template Library']")).isDisplayed());
		myact.click("xpath=//*[text()='Start from blank']/..");
//		Actions builder = new Actions(dr);
//		builder.moveToElement(dr.findElement(By.xpath("//div[contains(@class,'template-picker')]")),-15,0);

		myact.click("id=sidebar-show-catalog-Standard-button");

		/*
		 * WebElement iframe = dr.findElement(By.tagName("iframe"));
		 * System.out.println("id of iframe2:\t"+ iframe.getAttribute("id").toString());
		 * Actions closemodal= new Actions(dr);
		 * closemodal.moveToElement(dr.findElement(By.xpath("//main/header")),25,87).
		 * click().perform();
		 */

		dr.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		myact.click("xpath=//div[text()='Paragraph']");
		String location1 = dr.findElement(By.id("catalog-elem-01.paragraph")).getLocation().toString();
		System.out.println("locaiton of image:\t" + location1);
		System.out.println("show dimension\t" + dr.findElement(By.id("catalog-elem-01.paragraph")).getSize());
		Thread.sleep(1000);

		/* drag the first element */
		String source = "//*[@id='catalog-elem-02.paragraph']";
		String target = "//div[@data-type='Layout']";
		Common common = new Common(dr);
		common.drag_element_to_editor(source, target);
		myact.click("xpath=//div[text()='Button']");
		String source2 = "//img[@id='catalog-elem-03.button']";
		common.drag_element_to_editor(source2, target);

		/* click to close left sidebar */
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		Robot robot = new Robot();
		robot.setAutoDelay(500);
		robot.mouseMove(784, 532);
		robot.mousePress(InputEvent.BUTTON1_MASK);

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	// 698c9358364e51b0704fd12210823fec
	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		Common cm = new Common(dr);
		cm.login("http://bravebits.io/j5", "admin", "1");
//		cm.login("http://localhost/joomla39pb3", "admin", "1");
	}

	@AfterClass
	public void afterClass() {
		// dr.close();
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

	public void drag() {
		System.setProperty("webdriver.chrome.driver", "D://Sel//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		dr.get("http://demo.guru99.com/test/drag_drop.html");
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// WebDriverAction myact = new WebDriverAction(dr);
		// myact.dragandrop("xpath=//li[@id='credit2']/a", 350, 613);
		WebElement from = dr.findElement(By.xpath("//li[@id='credit2']/a"));
		Actions builder = new Actions(dr);
		try {
			dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			builder.clickAndHold(from).moveByOffset(350, 613).release().build();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// @Test
	public void dragtooffset() throws InterruptedException {
		WebDriverAction myact = new WebDriverAction();
		myact.dragbyOffset("xpath=//li[@id='credit2']/a", -308, 226);

	}

	// @Test
	public void dragtoelement() throws InterruptedException {
		WebDriverAction myact = new WebDriverAction();
		myact.dragtoElement("xpath=//li[@id='credit2']/a", "xpath=//ol[@id='bank']");

	}

}
