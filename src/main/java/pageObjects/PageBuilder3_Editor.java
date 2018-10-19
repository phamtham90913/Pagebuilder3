package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBuilder3_Editor {
	private static WebElement element = null;
	WebDriver driver;

//	public PageBuilder3_Editor(WebDriver driver) {
//		this.driver = driver;
//	}

	public static WebElement btn_Click_To_Edit(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(@class,'click-to-edit')]"));
		return element;
	}

	public static String Editor = "//div[@data-type='Body']";

	public static String iframe_Editor = "//iframe[@id='pagefly-pb-app']";

	public static String iframe_inner_Editor = "//main//iframe[@name='React Portal Frame']";

	/* Top bar */
	public static String txtbx_Page_Title = "//header//input[contains(@placeholder,'Enter Page Title')]";

	public WebElement link_Page_Setting() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement btn_Pick_A_Template() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement cbx_Device_Mode() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement btn_Undo() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement btn_Redo() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement btn_Exit_FullScreen() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement btn_Import_And_Export() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static String btn_View = "//a[text()='View']";

	public static String btn_Close= "";

	public WebElement btn_Save_As_Copy() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public  static String btn_Save = "//a/span[text()='Save']/..";

	/* Left side bar */
	public static String icon_Add_Element = "//a[@id='sidebar-show-catalog-Standard-button']";

	public WebElement icon_Add_Joomla_Element() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement icon_Add_Save_Section() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement icon_Brows_All_Version() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement icon_Show_Page_Outline() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement icon_Open_Pre_Define_Styles_Screen() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement icon_Add_Cutom_Code() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* Elememts group */
	public WebElement link_Layout() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement link_Slideshow() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement link_Heading() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static String link_Paragraph = "//aside//div[text() = 'Paragraph']";

	public WebElement link_Image() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement link_Button() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement link_Icon() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* ..... */

	/* Element items */
	// Layout
	public WebElement img_Full_Section() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement img_Block() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement img_1_2() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	// Paragraph
	public static String img_Paragraph_style_1 = "//img[@id='catalog-elem-01.paragraph']";

	public WebElement img_Paragraph_style_2() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement img_Paragraph_style_3() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement img_Paragraph_style_4() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public WebElement img_Paragraph_style_5() {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* Template library */
	public static String pu_Template_Library = "//header[@content='Template Library']/..";

	public static String btn_Start_From_Blank = "//span[text()='Start from blank']/..";

	public static String btn_Start_With_This_Template = "//span[text()='Start with this template']/..";

	
	
	/*Element in editor*/
	public static String editor_Paragraph = "//section//p[@data-type='Paragraph']";
	
}
