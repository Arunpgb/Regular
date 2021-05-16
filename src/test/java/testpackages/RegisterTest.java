package testpackages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HelperFunctions.AssertionHelper;
import JavaMain.BaseClass;
import JavaMain.Home;
import JavaMain.Registration;
import reportHelper.ExtentManager;

public class RegisterTest extends BaseClass {

	Home lp;
	Registration reg;
	AssertionHelper Assertion;

	public RegisterTest() throws Exception {
		super();
	}

	@Test
	public void Automate() throws Exception {
		lp.pagereg();
		reg.passDatas();
	}

	@Test
	public void TestPass() {
		AssertionHelper.markPass("Test Pass");
		ExtentManager.test.info("Test Pass");
	}

	@Test
	public void TestFail() {
		AssertionHelper.markFail("Test Fail");
		ExtentManager.test.info("Test Fail");
	}

	@BeforeClass
	public void Fireon() throws Exception {
		initialization();
		lp = new Home();
		reg = new Registration();
	}

	@AfterClass
	public void Teardown() {
		driver.quit();

	}

}
