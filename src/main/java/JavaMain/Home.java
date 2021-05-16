package JavaMain;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import LogHelper.Loghelp;

public class Home extends BaseClass {
	// private WebDriver driver;

	@FindBy(id = "email")
	public WebElement emailreg;

	@FindBy(xpath = "//a[@href='Register.html']")
	public WebElement reglink;

	public Home() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	public Registration pagereg() throws Exception {
		try {
			emailreg.sendKeys("babu@gmail.com");
			reglink.click();
			Loghelp.info("EmailId is passed");
		}

		catch (Exception e) {
			System.out.println("Driver not initialized");
			e.printStackTrace();

		}
		return new Registration();

	}
}
