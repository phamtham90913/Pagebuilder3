package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void createArticle() throws InterruptedException {
		this.dr=Common.dr;
		WebDriverAction myact = new WebDriverAction(dr);
		System.out.println("pass 1");

		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		myact.click("xpath=//ul[@id='menu']//li/a[text()='Content ']");
		System.out.println("pass 2");
		myact.hover("xpath=//li/a[@class='dropdown-toggle menu-article']/..");
		myact.click("linktext=Add New Article");
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	/*	myact.click("xpath=//a[@id='ui-show-catalog-button']/../a[2]");
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		myact.click("xpath=//div[text()='Paragraph']");
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String location1 = dr.findElement(By.xpath("//img[@name='Paragraph']/../img[1]")).getLocation().toString();
		System.out.println("locaiton of image:\t"+location1);
		//		wait for element visible
		WebDriverWait wait = new WebDriverWait(dr, 10);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(myact.getElement("xpath=//img[@name='Paragraph']/../img[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(myact.getElement("xpath=//img[@name='Paragraph']/../img[1]")));
		myact.dragbyOffset("xpath=//img[@name='Paragraph']/../img[1]", -500, 225);
		//	  myact.dragtoElement("xpath=//img[@name='Paragraph']/../img[1]","xpath=//div[@data-type='Body']" );
		String location = dr.findElement(By.xpath("//img[@name='Paragraph']/../img[1]")).getLocation().toString();
		System.out.println("locaiton of image:\t"+location);
		System.out.println("pass all");*/
		dr.findElement(myact.getElement("xpath=//div[@data-type='Body']")).click();
		Thread.sleep(2000);
		String getText = dr.findElement(myact.getElement("xpath=//div[@data-type='Body']/div/div/h3")).getText();
		
		System.out.println("placeholder text is:\t"+getText);
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

	public void drag() {
		System.setProperty("chromedriver.exe", "D://Sel//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		dr.get("http://demo.guru99.com/test/drag_drop.html");		
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//		WebDriverAction myact = new WebDriverAction(dr);
		//		myact.dragandrop("xpath=//li[@id='credit2']/a", 350, 613);
		WebElement from = dr.findElement(By.xpath("//li[@id='credit2']/a"));
		Actions builder = new Actions(dr);
		try {
			dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			builder.clickAndHold(from).moveByOffset(350, 613).release().build();

		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	// @Test
	public void dragtooffset() throws InterruptedException {
		WebDriverAction myact = new WebDriverAction();
		myact.dragbyOffset("xpath=//li[@id='credit2']/a",-308, 226);

	}
	//  @Test
	public void dragtoelement() throws InterruptedException {
		WebDriverAction myact = new WebDriverAction();
		myact.dragtoElement("xpath=//li[@id='credit2']/a","xpath=//ol[@id='bank']");

	}

}
