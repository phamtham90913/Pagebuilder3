package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
				}else
					if(locator.startsWith("classname=")) {
						locator=locator.substring(10);
						by=By.className(locator);
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
	public void dragandropOfsset(String element, int x, int y) {

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
		dr.switchTo().frame(1); 
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		Thread.sleep(5000);
		builder.moveByOffset(x, y).perform(); 
		Thread.sleep(2000);
		builder.release().perform();
		dr.switchTo().defaultContent();
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

		WebElement from = dr.findElement(getElement(locatorFrom));				
		Actions builder = new Actions(dr);
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		builder.clickAndHold(from).build().perform();
		System.out.println("locator of from:\t"+from.getLocation().toString());
		Thread.sleep(3000);

		dr.switchTo().frame(0);
		dr.switchTo().frame(dr.findElement(By.xpath("//form[@name='adminForm']//iframe[@name='React Portal Frame']")));
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//		System.out.println("get class:\t"+dr.findElement(getElement(locatorTo+"/h3")).getText());
		WebElement to = dr.findElement(getElement(locatorTo));
		builder.moveToElement(to).build().perform();	
		Thread.sleep(2000);
		builder.release().perform();
		dr.switchTo().defaultContent();


		/*	WebElement from = dr.findElement(getElement(locatorFrom)); 
		Actions act = new Actions(dr);
		act.clickAndHold(from).build().perform();
		Thread.sleep(4000); 
//		dr.switchTo().defaultContent();                        
		System.out.println("pass 1");
		dr.switchTo().frame(1);      
		System.out.println("pass 2");
//		System.out.println("show dimension2\t"+dr.findElement(By.xpath("//img[@name='Paragraph']/../img[1]")).getSize());
		WebElement body = dr.findElement(getElement(locatorTo));
		System.out.println("pass 3");
		body.click();
		System.out.println("pass 4");
		WebElement to = dr.findElement(getElement(locatorTo));
		System.out.println("pass 5");
		System.out.println("text in body:\t"+to.getText());
		dr.switchTo().defaultContent();
		act.clickAndHold(to);
		dr.switchTo().frame(1);
		act.moveToElement(to).release(to).build().perform();
		Thread.sleep(2000);
		dr.switchTo().defaultContent();      */ 
	}
	public void checkFrame(String locatorItem) {
		int size = dr.findElements(By.tagName("iframe")).size();
		for(int i=0; i<=size; i++){
			dr.switchTo().frame(i);
			int total=dr.findElements(getElement(locatorItem)).size();
			System.out.println(total);
			dr.switchTo().defaultContent();
		}
	}
	//	public void dragdrop(By ByFrom, By ByTo) {
	public void dragdropjs(String from, String to) {
		WebElement LocatorFrom = dr.findElement(getElement(from));
		System.out.println("found from");
		WebElement LocatorTo = dr.findElement(getElement(to));
		System.out.println("found To");
		String xto=Integer.toString(LocatorTo.getLocation().x);
		String yto=Integer.toString(LocatorTo.getLocation().y);
		((JavascriptExecutor)dr).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
				"simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
				LocatorFrom,xto,yto);
	}
}
/**function to find the index of frame */

/*int size = dr.findElements(By.tagName("iframe")).size();
for(int i=0; i<=size; i++){
	dr.switchTo().frame(i);
	int total=dr.findElements(By.xpath("//div[@data-type='Body']")).size();
	System.out.println(total);
	dr.switchTo().defaultContent();
	}*/