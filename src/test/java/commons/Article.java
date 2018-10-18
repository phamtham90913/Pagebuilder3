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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Article { 
	WebDriver dr;
	String url = "http://webmaster1537409700986.demobuilder.joomlashine.com",
			username = "admin",
			pass = "123456";
	@Test
	public void createArticle() throws InterruptedException {
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//		click menu Content
		dr.findElement(By.xpath("//ul[@id='menu']//li/a[text()='Content ']")).click();
		//		hover menu aticle
		Actions act = new Actions(dr);
		act.moveToElement(dr.findElement(By.xpath("//li/a[@class='dropdown-toggle menu-article']/.."))).build().perform();
		//		click menu Add new Article
		dr.findElement(By.linkText("Add New Article")).click();
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		/* close modal Select template */

		dr.switchTo().frame("pagefly-pb-app");
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.findElement(By.xpath("//*[text()='Start from blank']/..")).click();
		//		Actions builder = new Actions(dr);
		//		builder.moveToElement(dr.findElement(By.xpath("//div[contains(@class,'template-picker')]")),-15,0).click();


		/*Click on element Pragraph*/
		dr.findElement(By.id("sidebar-show-catalog-Standard-button")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.findElement(By.xpath("//div[text()='Paragraph']")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		/*drag the first element*/
		WebElement from = dr.findElement(By.id("catalog-elem-01.paragraph"));
		Actions builder = new Actions(dr);

		//Drag & drop by offset
		/*builder.clickAndHold(from).build().perform();
		Thread.sleep(1000);
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']"))); 
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		Thread.sleep(1000);
		builder.moveByOffset(100, 200).perform(); 
		Thread.sleep(2000);
		builder.release().perform();
		dr.switchTo().defaultContent();*/





		//Drag & drop by WebElement
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		builder.clickAndHold(from).build().perform();
		Thread.sleep(1000);

		//		dr.switchTo().frame(0);
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement to = dr.findElement(By.xpath("//div[@data-type='Layout']"));
		builder.moveToElement(to).build().perform();	
		Thread.sleep(2000);
		builder.release().perform();

	}
	
	public void drag_the_and_drop_html5(String sourceLocator, String targetLocator) throws AWTException {

    	WebElement source = dr.findElement(By.xpath(sourceLocator));
		WebElement target = dr.findElement(By.xpath(targetLocator));

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		Dimension targetSize = target.getSize();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		Point targetLocation = target.getLocation();
		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 0 + xCentreSource;
		sourceLocation.y += 70 + yCentreSource;
		targetLocation.x += 0 + xCentreTarget;
		targetLocation.y += 70 + yCentreTarget;

		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	
	@BeforeClass
	public void beforeClass() {
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url+"/administrator");
		dr.findElement(By.id("mod-login-username")).sendKeys(username);
		dr.findElement(By.id("mod-login-password")).sendKeys(pass);
		dr.findElement(By.xpath("//*[@class='btn btn-primary btn-block btn-large login-button']")).click();


	}

	@AfterClass
	public void afterClass() {
	}

}
