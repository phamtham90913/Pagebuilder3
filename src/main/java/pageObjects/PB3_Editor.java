package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PB3_Editor {
	private static WebElement element = null;
	WebDriver driver;

	public PB3_Editor(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement btn_Click_To_Edit() {
		element = driver.findElement(By.xpath("//button[contains(@class,'click-to-edit')]"));
		return element;
	}
	public WebElement Editor() {
		element = driver.findElement(By.xpath("//div[@data-type='Body']"));
		return element;
	}

	public WebElement iframe_Editor() {
		element = driver.findElement(By.id("pagefly-pb-app"));
		return element;
	}

	public WebElement iframe_inner_Editor() {
		element = driver.findElement(By.id("//main//iframe[@name='React Portal Frame']"));
		return element;
	}

	/* Top bar */
	public static WebElement txtbx_Page_Title(WebDriver driver) {
		element = driver.findElement(By.xpath("//header//input[contains(@placeholder,'Enter Page Title')]"));
		return element;
	}

	public static WebElement link_Page_Setting(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Pick_A_Template(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement cbx_Device_Mode(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Undo(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Redo(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Exit_FullScreen(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Import_And_Export(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_View(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Close(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Save_As_Copy(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_Save(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* Left side bar */
	public static WebElement icon_Add_Element(WebDriver driver) {
		element = driver.findElement(By.id("sidebar-show-catalog-Standard-button"));
		return element;
	}

	public static WebElement icon_Add_Joomla_Element(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement icon_Add_Save_Section(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement icon_Brows_All_Version(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement icon_Show_Page_Outline(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement icon_Open_Pre_Define_Styles_Screen(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement icon_Add_Cutom_Code(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* Elememts group */
	public static WebElement link_Layout(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement link_Slideshow(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement link_Heading(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement link_Paragraph(WebDriver driver) {
		element = driver.findElement(By.xpath("//aside//div[text() = 'Paragraph']"));
		return element;
	}

	public static WebElement link_Image(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement link_Button(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement link_Icon(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* ..... */

	/* Element items */
	// Layout
	public static WebElement img_Full_Section(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement img_Block(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement img_1_2(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	// Paragraph
	public WebElement img_Paragraph_style_1() {

		element = driver.findElement(By.id("catalog-elem-01.paragraph"));
		return element;
	}

	public static WebElement img_Paragraph_style_2(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement img_Paragraph_style_3(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement img_Paragraph_style_4(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement img_Paragraph_style_5(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	/* Template library */
	public static WebElement pu_Template_Library(WebDriver driver) {
		element = driver.findElement(By.xpath("//header[@content='Template Library']/.."));
		return element;
	}

	public static WebElement btn_Start_From_Blank(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[text()='Start from blank']/.."));
		return element;
	}

	public static WebElement btn_Start_With_This_Template(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[text()='Start with this template']/.."));
		return element;
	}

}
