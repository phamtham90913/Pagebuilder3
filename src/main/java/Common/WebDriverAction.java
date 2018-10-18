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
import org.openqa.selenium.interactions.Actions;

import pageObjects.PageBuilder3_Editor;

public class WebDriverAction {
	public WebDriver driver;
//	PageBuilder3_Editor pb3_Editor = new PageBuilder3_Editor(driver);

	public WebDriverAction(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	public WebDriverAction() {

	}

	public WebDriverAction check(String name) {
		return this;
	}

	public By getElement(String locator) {
		By by = null;
		if (locator.startsWith("id=")) {
			locator = locator.substring(3);
			by = By.id(locator);
		} else if (locator.startsWith("xpath=")) {
			locator = locator.substring(6);
			by = By.xpath(locator);
		} else if (locator.startsWith("linktext=")) {
			locator = locator.substring(9);
			by = By.linkText(locator);
		} else if (locator.startsWith("classname=")) {
			locator = locator.substring(10);
			by = By.className(locator);
		}
		return by;

	}

	public void click(String locator) {
		driver.findElement(getElement(locator)).click();
	}

	public void sendKeys(String locator, String key) {
		driver.findElement(getElement(locator)).sendKeys(key);
	}

	public void hover(String locator) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(getElement(locator))).build().perform();

	}

	public static void hover(WebElement element, WebDriver dr) {
		Actions act = new Actions(dr);
		act.moveToElement(element).build().perform();

	}

	public static void drag_drop_though_iframes(WebElement element_From, WebElement element_To, WebDriver driver) throws AWTException {
		System.out.println("current url driver ");
		System.out.println("current url driver "+driver.getCurrentUrl());
		WebElement source = element_From;
		driver.switchTo().frame(driver.findElement(By.xpath(PageBuilder3_Editor.iframe_Editor)));

		WebElement target = element_To;
		driver.switchTo().parentFrame();

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
//		driver.switchTo().frame(PageBuilder3_Editor.iframe_inner_Editor(driver));
		Dimension targetSize = target.getSize();
		driver.switchTo().parentFrame();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
//		driver.switchTo().frame(PageBuilder3_Editor.iframe_Editor(driver));
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

	public void draganddrop(String from, String to) {

		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(getElement(from)), driver.findElement(getElement(to))).build().perform();

	}

	public void dragandropOfsset(String element, int x, int y) {

		Actions act = new Actions(driver);
		System.out.println("step 2");
		WebElement from = driver.findElement(getElement(element));
		System.out.println("step 23");
		act.dragAndDropBy(from, x, y).release().perform();
	}

	public void dragbyOffset(String locator, int x, int y) throws InterruptedException {
		/*
		 * System.setProperty("chromedriver.exe", "D://Sel//chromedriver.exe"); dr = new
		 * ChromeDriver(); dr.manage().window().maximize();
		 * dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 * dr.get("http://demo.guru99.com/test/drag_drop.html");
		 * dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 */
		WebElement from = driver.findElement(getElement(locator));
		Actions builder = new Actions(driver);
		// try {
		builder.clickAndHold(from).build().perform();
		System.out.println("locator of from:\t" + from.getLocation().toString());
		Thread.sleep(1000);
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		builder.moveByOffset(x, y).perform();
		Thread.sleep(2000);
		builder.release().perform();
		driver.switchTo().defaultContent();
		// }
		// catch(Exception e) {
		// System.out.println(e);
		// }
	}

	public void dragtoElement(String locatorFrom, String locatorTo) throws InterruptedException {
		/*
		 * System.setProperty("chromedriver.exe", "D://Sel//chromedriver.exe"); dr = new
		 * ChromeDriver(); dr.manage().window().maximize();
		 * dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 * dr.get("http://demo.guru99.com/test/drag_drop.html");
		 * dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 */

		WebElement from = driver.findElement(getElement(locatorFrom));
		Actions builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		builder.clickAndHold(from).build().perform();
		System.out.println("locator of from:\t" + from.getLocation().toString());
		Thread.sleep(3000);

		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//form[@name='adminForm']//iframe[@name='React Portal Frame']")));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// System.out.println("get
		// class:\t"+dr.findElement(getElement(locatorTo+"/h3")).getText());
		WebElement to = driver.findElement(getElement(locatorTo));
		builder.moveToElement(to).build().perform();
		Thread.sleep(2000);
		builder.release().perform();
		driver.switchTo().defaultContent();

		/*
		 * WebElement from = dr.findElement(getElement(locatorFrom)); Actions act = new
		 * Actions(dr); act.clickAndHold(from).build().perform(); Thread.sleep(4000); //
		 * dr.switchTo().defaultContent(); System.out.println("pass 1");
		 * dr.switchTo().frame(1); System.out.println("pass 2"); //
		 * System.out.println("show dimension2\t"+dr.findElement(By.xpath(
		 * "//img[@name='Paragraph']/../img[1]")).getSize()); WebElement body =
		 * dr.findElement(getElement(locatorTo)); System.out.println("pass 3");
		 * body.click(); System.out.println("pass 4"); WebElement to =
		 * dr.findElement(getElement(locatorTo)); System.out.println("pass 5");
		 * System.out.println("text in body:\t"+to.getText());
		 * dr.switchTo().defaultContent(); act.clickAndHold(to); dr.switchTo().frame(1);
		 * act.moveToElement(to).release(to).build().perform(); Thread.sleep(2000);
		 * dr.switchTo().defaultContent();
		 */
	}

	public void checkFrame(String locatorItem) {
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i <= size; i++) {
			driver.switchTo().frame(i);
			int total = driver.findElements(getElement(locatorItem)).size();
			System.out.println(total);
			driver.switchTo().defaultContent();
		}
	}

}
/** function to find the index of frame */

/*
 * int size = dr.findElements(By.tagName("iframe")).size(); for(int i=0;
 * i<=size; i++){ dr.switchTo().frame(i); int
 * total=dr.findElements(By.xpath("//div[@data-type='Body']")).size();
 * System.out.println(total); dr.switchTo().defaultContent(); }
 */