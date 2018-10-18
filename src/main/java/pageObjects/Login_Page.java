package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	private static WebElement element = null;
	private WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement txtbx_UserName(WebDriver driver) {
		element = driver.findElement(By.id("mod-login-username"));
		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {
		element = driver.findElement(By.id("mod-login-password"));
		return element;
	}

	public static WebElement btn_Submit(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='mod-login-password']/../../../following-sibling::div"));
		return element;
	}
}
