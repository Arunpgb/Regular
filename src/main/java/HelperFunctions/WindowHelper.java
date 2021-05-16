/**
 * 
 */
package HelperFunctions;

import java.util.Set;

import JavaMain.BaseClass;
import LogHelper.Loghelp;

/**
 * @author Arun
 * @Description Supports to Handle Windows
 */
public class WindowHelper extends BaseClass {

	public WindowHelper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Author Arun
	 * @Description Will access to switch to Parent Window
	 * @CreatedDate 13-Dec-2020
	 * @ModifiedDate Nil
	 * 
	 */
	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
		Loghelp.info("Switched to Parent Window Sucessfully");
	}

	/**
	 * @Author Arun
	 * @Description Will get access to desired Window
	 * @CreatedDate 13-Dec-2020
	 * @ModifiedDate Nil
	 * 
	 */
	public void SwitchToRequiredWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				driver.switchTo().window(window);
				Loghelp.info("Switched to" + index + " Window Sucessfully");
			} else
				i++;
		}

	}

	/**
	 * @Author Arun
	 * @Description Will Close All Window and Switch to Parent Window
	 * @CreatedDate 13-Dec-2020
	 * @ModifiedDate Nil
	 * 
	 */
	public void closeAllWindowAndTabs(int index) {
		String Parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		int i=1;
		for (String window : windows) {
			if (!window.equalsIgnoreCase(Parentwindow)) {
				driver.close();
				Loghelp.info("Closed Child Window No: "+i);
				i++;
			}

		}
		driver.switchTo().window(Parentwindow);
		Loghelp.info("Switched to Parent Window Sucessfully");
	}

}
