package Common;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.Joomla_Menu_Bar;
import pageObjects.Login_Page;
import pageObjects.PageBuilder3_Editor;

public class Common {
	public static WebDriver driver;

	public Common(WebDriver driver) {
		this.driver = driver;
	}

//	PageBuilder3_Editor pb3_Editor = new PageBuilder3_Editor(driver);
	Joomla_Menu_Bar menu_bar = new Joomla_Menu_Bar(driver);

	public void login(String url, String username, String pass, WebDriver driver) {
		driver.get(url + "/administrator");
		Login_Page.txtbx_UserName(driver).sendKeys(username);
		Login_Page.txtbx_Password(driver).sendKeys(pass);
		Login_Page.btn_Submit(driver).click();
	}

	public void create_New_Page_By_Pb3Editor(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Joomla_Menu_Bar.menu_Content(driver).click();
		Actions act = new Actions(driver);
		act.moveToElement(Joomla_Menu_Bar.menu_Articles(driver)).build().perform();
		Joomla_Menu_Bar.menu_Add_New_Articles(driver).click();
	}

	public void drag_element_to_editor(String sourceLocator, String targetLocator) throws AWTException, InterruptedException {

		WebElement source = driver.findElement(By.xpath(sourceLocator));
		driver.switchTo().frame(driver.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		WebElement target = driver.findElement(By.xpath(targetLocator));
		driver.switchTo().parentFrame();

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		driver.switchTo().frame(driver.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
		Dimension targetSize = target.getSize();
		driver.switchTo().parentFrame();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		driver.switchTo().frame(driver.findElement(By.xpath("//main//iframe[@name='React Portal Frame']")));
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
//			robot.mouseMove(targetLocation.x-1, targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}

	public int random_Number() {
		Random rand = new Random();
		int number = rand.nextInt(999);
		return number;
	}
	public static String hex2Rgb(String hexaColor) {
	    Color c = new Color(
	        Integer.valueOf(hexaColor.substring(1, 3), 16), 
	        Integer.valueOf(hexaColor.substring(3, 5), 16), 
	        Integer.valueOf(hexaColor.substring(5, 7), 16));

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
}
