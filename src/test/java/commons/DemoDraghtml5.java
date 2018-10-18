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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DemoDraghtml5 {
	WebDriver driver;
	@Test
    public void TC_Demo_Html5() throws Exception {
		driver.get("https://html5demos.com/drag/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String source_01 = "//a[@id='one']";
		String source_02 = "//a[@id='two']";
		String source_03 = "//a[@id='three']";
		String target = "//div[@id='bin']";

		Thread.sleep(2000);
		drag_the_and_drop_html5(source_01, target);
		Thread.sleep(2000);
		drag_the_and_drop_html5(source_02, target);
		Thread.sleep(2000);
		drag_the_and_drop_html5(source_03, target);
		Thread.sleep(2000);

	}
    
    public void drag_the_and_drop_html5(String sourceLocator, String targetLocator) throws AWTException {

    	WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

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
		System.out.println("get center distance"+sourceLocation.toString());
		System.out.println("get center distance"+targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 0 + xCentreSource;
		sourceLocation.y += 130 + yCentreSource;
		targetLocation.x += 0 + xCentreTarget;
		targetLocation.y += 130 + yCentreTarget;

		System.out.println("Make Mouse coordinate center of element" +sourceLocation.toString());
		System.out.println("Make Mouse coordinate center of element" +targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);
		robot.mouseMove(targetLocation.x-1, targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
  @BeforeClass
  public void beforeClass() {
		System.setProperty("chromedriver.exe", "D://Sel//chromdriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
  }

}
