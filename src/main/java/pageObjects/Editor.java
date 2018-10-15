package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Editor {
	private static WebElement element = null;

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
	public static WebElement img_Paragraph_style_1(WebDriver driver) {
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

}
