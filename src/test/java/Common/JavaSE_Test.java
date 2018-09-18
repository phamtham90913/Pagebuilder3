package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaSE_Test {
	@Test		
	 public void Login() throws InterruptedException 					
    {		
        WebDriver driver= new ChromeDriver();			
        
      //Maximize window		
        driver.manage().window().maximize();	
        
        //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;		
        		
        //Launching the Site.		
        driver.get("https://jqueryui.com/droppable/");			
     Thread.sleep(3000);
        	
        		
        //Vertical scroll down by 600  pixels		
        js.executeScript("window.scrollBy(0,200)");
        
    
    }	
}
