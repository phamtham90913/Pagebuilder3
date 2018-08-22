package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	WebDriver dr;
	public Common(WebDriver dr) {
		this.dr = dr;
	}
	public void login(String url, String username, String pass) {
		System.setProperty("chromedriver.exe", "D://Sel//chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url+"/administrator");
		WebDriverAction myact = new WebDriverAction(dr);
		myact.sendKeys("id=mod-login-username", username);
		myact.sendKeys("id=mod-login-password", pass);
		myact.click("//input[@id='mod-login-password']/../../../following-sibling::div");
	}

}
