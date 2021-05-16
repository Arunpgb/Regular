package HelperFunctions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import JavaMain.BaseClass;
import LogHelper.Loghelp;

public class BasicHelper extends BaseClass {
	WaitHelper wait;

	public BasicHelper() throws Exception {
		super();
		Loghelp.info("Basic Helper has been initialized....");
		wait = new WaitHelper();
	}

	public boolean isElementDisplayed(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			element.isDisplayed();
			Loghelp.info("Element is Displayed", element);
			return true;

		} catch (Exception e) {
			Loghelp.info("Element is not Displayed the cause is: " + e.getMessage());
			return false;
		}
	}

	public boolean isElementEnabled(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			element.isDisplayed();
			Loghelp.info("Element is Enabled", element);
			return true;

		} catch (Exception e) {
			Loghelp.info("Element is not enabled and  the cause is: " + e.getMessage());
			return false;
		}
	}

	public String getElementText(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed()) {
				Loghelp.info("Element Text is fetched", element);
				return element.getText();
			}

		} catch (Exception e) {
			Loghelp.info("Element's Text not able to fetch and  the cause is: " + e.getMessage());
		}
		return null;
	}

	public void enterdatainField(WebElement element, String data, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true && Objects.nonNull(data)) {
				wait.waitForElement(element, timeOutInSeconds);
				element.click();
				element.clear();
				element.sendKeys(data);
				Loghelp.info("Data is  entered in the Field", element);
			}

		} catch (Exception e) {
			Loghelp.info("Failed to enter the Data in the Field: " + element.getText() + " " + e.getMessage());
		}
	}

	public void cleardata(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true) {
				wait.waitForElement(element, timeOutInSeconds);
				element.click();
				element.clear();
				Loghelp.info("Data is cleared from the Field", element);
			}

		} catch (Exception e) {
			Loghelp.info("Failed to clear the Data in the Field: " + element.getText() + " " + e.getMessage());
		}
	}

	public void clickon(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true) {
				wait.waitForElement(element, timeOutInSeconds);
				element.click();
				Loghelp.info("is clicked", element);
			}

		} catch (Exception e) {
			Loghelp.info("Failed to enter the Data in the Field: " + element.getText() + " " + e.getMessage());
		}
	}

	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename
				+ "_" + dateName + ".png";
		return destination;
	}

	
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}
