package HelperFunctions;

import org.openqa.selenium.WebElement;

import JavaMain.BaseClass;
import LogHelper.Loghelp;

public class FrameHelper extends BaseClass {

	public FrameHelper() throws Exception {
		super();
		Loghelp.info("Frame Helper Initialised.......");
	}
	// WebDriver driver= new ChromeDriver();

	
	/**
	  @Author Arun
	  @Description Helps to switch between frames using index
	  @CreatedDate 13-Dec-2020
	  @ModifiedDate
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		Loghelp.info("Switched to Frame By Frame Index" + index);
	}
	/**
	  @Author Arun
	  @Description Helps to switch between frames using nameOrId
	  @CreatedDate 13-Dec-2020
	  @ModifiedDate
	 */
	public void SwitchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
		Loghelp.info("Switched to Frame By Frame Index" + nameOrId);
	}
	/**
	  @Author Arun
	  @Description Helps to switch between frames using WebPage Elements
	  @CreatedDate 13-Dec-2020
	  @ModifiedDate
	 */
	public void SwitchToFrame( WebElement Element) {
		driver.switchTo().frame(Element);
		Loghelp.info("Switched to Frame By Frame Element" + Element.toString());
	}
}
