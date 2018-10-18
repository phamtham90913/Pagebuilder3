package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_Inspector {
	private WebElement element = null;
	private WebDriver driver;

	public PO_Inspector(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement btn_Click_To_Edit() {
		element = driver.findElement(By.xpath("//button[contains(@class,'click-to-edit')]"));
		return element;
	}
}
