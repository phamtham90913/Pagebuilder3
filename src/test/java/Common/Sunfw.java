package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sunfw {
	WebDriver dr;
	String url = "http://bravebits.io/j5",
			username="admin",
			pass="1";
	@Test
	public void addElementonSunfwLayout() throws InterruptedException {

		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.navigate().to(url+"/administrator/index.php?option=com_templates");
		dr.findElement(By.xpath("//a[contains(text(),'JSN Blank 2 - Default')]")).click();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions builder = new Actions(dr);
		builder.clickAndHold(dr.findElement(By.xpath("//div[@id='layout']//i[@class='fa fa-picture-o']/.."))).build().perform();
		WebElement from = dr.findElement(By.xpath("//div[@id='layout']//i[@class='fa fa-picture-o']")),
				to = dr.findElement(By.className("jsn-content-main"));
		//		builder.dragAndDrop(from, to).build().perform();;
		//drag and drop by offset
		builder.dragAndDropBy(from, 300, 200).build().perform();
		System.out.println("get text:\t"+to.getText());
	}
	@BeforeClass
	public void beforeMethod() {
		//		System.setProperty("chromedriver.exe", "D://Sel//chromdriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url+"/administrator");
		dr.findElement(By.id("mod-login-username")).sendKeys(username);
		dr.findElement(By.id("mod-login-password")).sendKeys(pass);
		dr.findElement(By.xpath("//input[@id='mod-login-password']/../../../following-sibling::div")).click();
	}

}
