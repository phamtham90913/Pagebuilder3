package commons;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.WebDriverAction;

public class DemoDragDropHTML5 {
	WebDriver dr;
	String url = "http://bravebits.io/j5", username = "admin", pass = "1";

	@Test
	public void TC_Demo_Html5() throws Exception {
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// click menu Content
		dr.findElement(By.xpath("//ul[@id='menu']//li/a[text()='Content ']")).click();
		// hover menu aticle
		Actions act = new Actions(dr);
		act.moveToElement(dr.findElement(By.xpath("//li/a[@class='dropdown-toggle menu-article']/.."))).build().perform();
		// click menu Add new Article
		dr.findElement(By.linkText("Add New Article")).click();
//		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		/* close modal Select template */

		dr.switchTo().frame("pagefly-pb-app");
//		WebDriverWait wait = new WebDriverWait(dr, 2);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@content='Template Library']")));
		Robot robot = new Robot();
		robot.mouseMove(50, 200);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
//		WebDriverWait wait = new WebDriverWait(dr,15);
//		wait.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//*[text()='Start from blank']/.."))));

//		dr.findElement(By.xpath("//*[text()='Start from blank']/..")).click();

		// Actions builder = new Actions(dr);
		// builder.moveToElement(dr.findElement(By.xpath("//div[contains(@class,'template-picker')]")),-15,0).click();

		/* Click on element Pragraph */
		dr.findElement(By.id("sidebar-show-catalog-Standard-button")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.findElement(By.xpath("//div[text()='Paragraph']")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String sourceLocator = "//*[@id='catalog-elem-02.paragraph']";
//		String targetLocator = "//div[@data-type='Layout']";
		String targetLocator = "//div[@data-type='Body']";
		WebElement source = dr.findElement(By.xpath(sourceLocator));
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		WebElement target = dr.findElement(By.xpath(targetLocator));
//		dr.switchTo().defaultContent();
		drag_the_and_drop_html5(source, target);

	}

	public void drag_the_and_drop_html5(WebElement soureElement, WebElement targetElement) throws AWTException, InterruptedException {

//    	WebElement source = dr.findElement(By.xpath(sourceLocator));
		WebElement source = soureElement;
//		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
//		WebElement target = dr.findElement(By.xpath(targetLocator));
		WebElement target = targetElement;
		dr.switchTo().parentFrame();

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		Dimension targetSize = target.getSize();
		dr.switchTo().parentFrame();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		Point targetLocation = target.getLocation();
		dr.switchTo().parentFrame();
		System.out.println("get center distance of source: " + sourceLocation.toString());
		System.out.println("get center distance of tartget: " + targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 0 + xCentreSource;
		sourceLocation.y += 120 + yCentreSource;
		targetLocation.x += 0 + xCentreTarget;
		targetLocation.y += 120 + yCentreTarget;

		System.out.println("make mouse center of source: " + sourceLocation.toString());
		System.out.println("make mouse center of target: " + targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);
//		robot.mouseMove(targetLocation.x-1, targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}

	@BeforeClass
	public void beforeClass() {
//	  System.setProperty("chromedrivergd.exe", "D://Sel//chromdriver.exe");
//		System.setProperty("geckodriver.exe", "D://Sel//geckodriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url + "/administrator");
		WebDriverAction myact = new WebDriverAction(dr);
		myact.sendKeys("id=mod-login-username", username);
		myact.sendKeys("id=mod-login-password", pass);
		myact.click("xpath=//input[@id='mod-login-password']/../../../following-sibling::div");
	}

	@AfterClass
	public void afterClass() {
	}

}
