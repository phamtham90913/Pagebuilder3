package Common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragbyJs {
	WebDriver dr;
	String url = "http://webmaster1538465051381.demobuilder.joomlashine.com/";
	String username = "admin", pass = "123456";
	String workingDir = System.getProperty("user.dir");
	String jsFile = workingDir + "\\drag_and_drop_helper.js";

//	@Test
	public void f() throws AWTException {
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

		String source = "//*[@id='catalog-elem-02.paragraph']";
		String target = "//div[@data-type='Layout']";

	}

	@Test
	public void TC_05_DragAndDropFile_Elemental_CSS() throws Exception {
		dr.get("http://the-internet.herokuapp.com/drag_and_drop");
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

		String java_script = "";
		String text;

		BufferedReader input = new BufferedReader(new FileReader(jsFile));
		StringBuffer buffer = new StringBuffer();

		while ((text = input.readLine()) != null)
			buffer.append(text + " ");
		java_script = buffer.toString();
		input.close();
		System.out.println("java_script: " + java_script);
		java_script = java_script + "$('div[id=\"column-a\"]').simulateDragDrop({ dropTarget: 'div[id=\"column-b\"]'});";
		System.out.println("java_script: " + java_script);
		((JavascriptExecutor) dr).executeScript(java_script);

		Thread.sleep(10000);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("chromedriver.exe", "D://Sel//chromdriver.exe");
//		System.setProperty("geckodriver.exe", "D://Sel//geckodriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
//		dr.get(url + "/administrator");
//		WebDriverAction myact = new WebDriverAction(dr);
//		myact.sendKeys("id=mod-login-username", username);
//		myact.sendKeys("id=mod-login-password", pass);
//		myact.click("xpath=//input[@id='mod-login-password']/../../../following-sibling::div");
	}

	@AfterClass
	public void afterClass() {
	}

}
