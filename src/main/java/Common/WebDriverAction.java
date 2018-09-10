package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class WebDriverAction {
	public WebDriver dr;
	public WebDriverAction(WebDriver driver) {
		this.dr=driver;
		  PageFactory.initElements(driver, this);
	}
	public WebDriverAction() {

	}
	public WebDriverAction check(String name) {
		return this;
	}
	public By getElement(String locator) {
		By by=null;
		if(locator.startsWith("id=")) {
			locator=locator.substring(3);
			by=By.id(locator);
		}else
			if(locator.startsWith("xpath=")) {
				locator=locator.substring(6);
				by=By.xpath(locator);
			}else
				if(locator.startsWith("linktext=")) {
					locator=locator.substring(9);
					by=By.linkText(locator);
				}
		return by;

	}

	public void click(String locator) {
		dr.findElement(getElement(locator)).click();
	}
	public void sendKeys(String locator, String key) {
		dr.findElement(getElement(locator)).sendKeys(key);
	}
	public void hover(String locator) {
		Actions act = new Actions(dr);
		act.moveToElement(dr.findElement(getElement(locator))).build().perform();

	}

	public void draganddrop(String from, String to) {

		Actions act = new Actions(dr);
		act.dragAndDrop(dr.findElement(getElement(from)), dr.findElement(getElement(to))).build().perform();

	}
	public void dragandrop(String element, int x, int y) {

		Actions act = new Actions(dr);
		System.out.println("step 2");
		WebElement from = dr.findElement(getElement(element));
		System.out.println("step 23");
		act.dragAndDropBy(from, x, y).release().perform();
	}
	public void dragbyOffset(String locator, int x, int y) throws InterruptedException {
		/*System.setProperty("chromedriver.exe", "D://Sel//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		dr.get("http://demo.guru99.com/test/drag_drop.html");		
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);*/
		WebElement from = dr.findElement(getElement(locator));
		Actions builder = new Actions(dr);
//		try {
			builder.clickAndHold(from).build().perform();
			System.out.println("locator of from:\t"+from.getLocation().toString());
			Thread.sleep(1000);
			builder.moveByOffset(x, y).perform();
			Thread.sleep(2000);
			builder.release().perform();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
	}
	public void dragtoElement(String locatorFrom, String locatorTo) throws InterruptedException {
		/*System.setProperty("chromedriver.exe", "D://Sel//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		dr.get("http://demo.guru99.com/test/drag_drop.html");		
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);*/
		WebElement from = dr.findElement(getElement(locatorFrom)),
				to = dr.findElement(getElement(locatorTo));
		Actions builder = new Actions(dr);
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			builder.clickAndHold(from).build().perform();
			System.out.println("locator of from:\t"+from.getLocation().toString());
			Thread.sleep(1000);
			/*builder.moveByOffset(x, y).perform();*/			
			builder.moveToElement(to).perform();
			Thread.sleep(2000);
			builder.release().perform();
	}

}
