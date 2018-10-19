package Common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.PageBuilder3_Editor;

public class AbstractPage {
	public void clickElement(String locator, WebDriver driver) {
		driver.findElement(By.xpath(locator)).click();
	}

	public void sendKeys(String locator, String keys, WebDriver driver) {
		driver.findElement(By.xpath(locator)).sendKeys(keys);
	}

	public String getTextofElement(String locator, WebDriver driver) {
		return driver.findElement(By.xpath(locator)).getText();
	}

	public String getSizeofText(String locator, WebDriver driver) {
		return driver.findElement(By.xpath(locator)).getCssValue("color");
	}

	 public void switchToChildWindow(String parent , WebDriver driver) {
         Set<String> allWindows = driver.getWindowHandles();
         for (String runWindow : allWindows) {
                     if (!runWindow.equals(parent)) {
                                 driver.switchTo().window(runWindow);
                                 break;
                     }
         }
}
	public void drag_drop_though_iframes(String element_From, String element_To, WebDriver driver) throws AWTException {

		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_Editor)));
		WebElement source = driver.findElement(By.xpath(element_From));
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_inner_Editor)));
		WebElement target = driver.findElement(By.xpath(element_To));
		driver.switchTo().parentFrame();

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_inner_Editor)));
		Dimension targetSize = target.getSize();
		driver.switchTo().parentFrame();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_inner_Editor)));
		Point targetLocation = target.getLocation();
		driver.switchTo().parentFrame();
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

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}

}
