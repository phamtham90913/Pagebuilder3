package Common;

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

import pageObjects.Login_Page;

public class Common {
	public static WebDriver dr;

	public Common(WebDriver dr) {
		this.dr = dr;
	}

	public void login(String url, String username, String pass) {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get(url + "/administrator");
		Login_Page.txtbx_UserName(dr).sendKeys(username);
		Login_Page.txtbx_Password(dr).sendKeys(pass);
		Login_Page.btn_Submit(dr).click();  
	}

	public void drag_element_to_editor(String sourceLocator, String targetLocator) throws AWTException, InterruptedException {

		WebElement source = dr.findElement(By.xpath(sourceLocator));
		dr.switchTo().frame(dr.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		WebElement target = dr.findElement(By.xpath(targetLocator));
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
//			robot.mouseMove(targetLocation.x-1, targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

	} 
}
