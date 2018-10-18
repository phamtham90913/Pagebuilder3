package commons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sunfw {
	WebDriver dr;
	String url = "http://bravebits.io/j5", username = "admin", pass = "1";
	String workingDir = System.getProperty("user.dir");
	String jsFile = workingDir + "\\drag_and_drop_helper.js";

	@Test
	public void addElementonSunfwLayout() throws InterruptedException, IOException {

		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.navigate().to(url + "/administrator/index.php?option=com_templates");
		dr.findElement(By.xpath("//a[contains(text(),'JSN Blank 2 - Default')]")).click();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*Actions builder = new Actions(dr);
		builder.clickAndHold(dr.findElement(By.xpath("//div[@id='layout']//i[@class='fa fa-picture-o']/.."))).build()
				.perform();
		WebElement from = dr.findElement(By.xpath("//div[@id='layout']//i[@class='fa fa-picture-o']")),
				to = dr.findElement(By.className("jsn-content-main"));
		// builder.dragAndDrop(from, to).build().perform();;
		// drag and drop by offset
		builder.dragAndDropBy(from, 300, 200).build().perform();
		System.out.println("get text:\t" + to.getText());*/
		Thread.sleep(5000);

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
		java_script = java_script
				+ "$('i[class=\"fa fa-picture-o\"]').simulateDragDrop({ dropTarget: 'div[class=\"jsn-content-main\"]'});";
		((JavascriptExecutor) dr).executeScript(java_script);
		
		System.out.println(java_script);
//		java_script = java_script
//				+ "$('//img[@id='catalog-elem-02.paragraph']').simulateDragDrop({ dropTarget: '//div[@data-type='Layout']'});";
//		((JavascriptExecutor) dr).executeScript(java_script);
		
		
		
		
		
		
		
		
		
	}

	@BeforeClass
	public void beforeMethod() {
		// System.setProperty("chromedriver.exe", "D://Sel//chromdriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url + "/administrator");
		dr.findElement(By.id("mod-login-username")).sendKeys(username);
		dr.findElement(By.id("mod-login-password")).sendKeys(pass);
		dr.findElement(By.xpath("//input[@id='mod-login-password']/../../../following-sibling::div")).click();
	}

}
