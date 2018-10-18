package commons;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.WebDriverAction;

public class DragandDropbyJS {
	WebDriver dr;
	String url = "http://webmaster1538465051381.demobuilder.joomlashine.com/";
	String username = "admin", pass = "123456";
	String workingDir = System.getProperty("user.dir");
	String jsFile = workingDir + "\\drag_and_drop_helper.js";

	@Test
	public void f() throws AWTException, IOException {
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// click menu Content
		dr.findElement(By.xpath("//ul[@id='menu']//li/a[text()='Content ']")).click();
		// hover menu aticle
		Actions act = new Actions(dr);
		act.moveToElement(dr.findElement(By.xpath("//li/a[@class='dropdown-toggle menu-article']/.."))).build().perform();
		// click menu Add new Article
		dr.findElement(By.linkText("Add New Article")).click();

		/* close modal Select template */
		dr.switchTo().frame("pagefly-pb-app");
		dr.findElement(By.xpath("//span[text()='Start from blank']/..")).click();

		/* Click on element Paragraph */
		dr.findElement(By.id("sidebar-show-catalog-Standard-button")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String java_script = "";
		String text;

		BufferedReader input = new BufferedReader(new FileReader(jsFile));
		StringBuffer buffer = new StringBuffer();

		while ((text = input.readLine()) != null)
			buffer.append(text + " ");
		java_script = buffer.toString();
		input.close();

		/*
		 * java_script = java_script +
		 * "$('div[id=\"column-a\"]').simulateDragDrop({ dropTarget: 'div[id=\"column-b\"]'});"
		 * ; ((JavascriptExecutor) dr).executeScript(java_script);
		 */
		System.out.println("java_script: " + java_script);
		java_script = java_script + "$('img[id=\"catalog-elem-02.paragraph\"]').simulateDragDrop({ dropTarget: 'div[data-type=\"Layout\"]'});";
		System.out.println("java_script: " + java_script);
		((JavascriptExecutor) dr).executeScript(java_script);

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("chromedriver.exe", "D://Sel//chromdriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url + "/administrator");
		WebDriverAction myact = new WebDriverAction(dr);
		myact.sendKeys("id=mod-login-username", username);
		myact.sendKeys("id=mod-login-password", pass);
		myact.click("xpath=//input[@id='mod-login-password']/../../../following-sibling::div");
	}

}
