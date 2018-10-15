package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Joomla_Menu_Bar {
	private static WebElement element = null;

	public static WebElement menu_Menus(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Menus')]"));
		return element;
	}

	/* Group menu contents */
	public static WebElement menu_Content(WebDriver driver) {
		element = driver.findElement(By.xpath("//ul[@id='menu']//a[@class='dropdown-toggle' and contains(text(),'Content')]"));
		return element;
	}

	public static WebElement menu_Articles(WebDriver driver) {
		element = driver.findElement(By.xpath("//li[@class='dropdown-submenu' ]//a[text()='Articles']"));
		return element;
	}

	public static WebElement menu_Add_New_Articles(WebDriver driver) {
		element = driver.findElement(By.xpath("//ul[@id='nav-empty']//a[text()='Add New Article']"));
		return element;
	}

	/* Group components menu */
	public static WebElement menu_Components(WebDriver driver) {
		element = driver.findElement(By.xpath("//ul[@id='menu']//a[contains(text(),'Components')]"));
		return element;
	}

	public static WebElement menu_Extentions(WebDriver driver) {
		element = driver.findElement(By.xpath("//ul[@id='menu']//a[@class='dropdown-toggle' and contains(text(),'Extensions')]"));
		return element;
	}

}
