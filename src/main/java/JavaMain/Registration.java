package JavaMain;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import LogHelper.Loghelp;

public class Registration extends BaseClass {
	@FindBy(xpath = "//input[@ng-model='FirstName']")
	WebElement Firstname;

	@FindBy(xpath = "//input[@ng-model='LastName']")
	WebElement Lastname;

	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	WebElement Address;

	@FindBy(xpath = "//input[@ng-model='EmailAdress']")
	WebElement EmailAdress;

	@FindBy(xpath = "//input[@ng-model='Phone']")
	WebElement Phone;

	@FindBy(xpath = "//input[@name='radiooptions' and @value='Male']")
	WebElement RadioMale;

	@FindBy(xpath = "//input[@name='radiooptions' and @value='FeMale']")
	WebElement RadioFemale;

	@FindBy(xpath = "//input[@type='checkbox' and @id='checkbox1']")
	WebElement cricket;

	@FindBy(xpath = "//input[@type='checkbox' and @id='checkbox2']")
	WebElement movies;

	@FindBy(xpath = "//input[@type='checkbox' and @id='checkbox3']")
	WebElement hockey;

	@FindBy(xpath = "//input[@id='firstpassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='secondpassword']")
	WebElement confirmpassword;

	@FindBy(xpath = "//button[@id='submitbtn']")
	WebElement submit;

	@FindBy(xpath = "//button[@id='Button1']")
	WebElement refresh;

	@FindBy(xpath = "//div[@id='msdd']")
	WebElement languages;

	@FindBy(id = "Skills")
	WebElement skills;

	@FindBy(id = "countries")
	WebElement countries;

	@FindBy(id = "select2-country-container")
	WebElement dcountries;

	@FindBy(id = "yearbox")
	WebElement dobyear;

	@FindBy(xpath = "//select[@placeholder='Month']")
	WebElement dobmonth;

	@FindBy(id = "daybox")
	WebElement dobday;

	@FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']")
	WebElement multiselectParent;
	
	@FindBy(xpath="//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a")
	WebElement MultiCountry;

	private WebElement generics;
	private WebElement actual;

	private List<WebElement> allvalues;

	public Registration() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	void ListBoxGeneric(WebElement generic) {
		this.generics = generic;
		generics.click();
		Select lb = new Select(generics);
		// Select lb = new Select(//div[@id='msdd']);
		// List<WebElement> li=lb.getOptions();
		if (lb.isMultiple() == true) {

			lb.selectByIndex(1);
			lb.selectByIndex(2);
			lb.selectByIndex(3);

		}

		else {

			lb.selectByIndex(5);
		}

	}

	void ListBoxnontraditionGeneric(WebElement generics,List<WebElement> allvalues)
	{
		multiselectParent.click();
		
		
		
	}

	public void passDatas() throws InterruptedException {
		try {
		Firstname.sendKeys("Arun");
		Lastname.sendKeys("Kumar");
		Thread.sleep(2000);
		Address.sendKeys("Maduravoyal Chennai");
		Thread.sleep(2000);
		EmailAdress.sendKeys("arunpgb16@gmail.com");
		Loghelp.info("EmailId is passed");
		Thread.sleep(2000);
		Phone.sendKeys("9150791572");
		Loghelp.info("Phone is passed");
		Thread.sleep(2000);
		RadioMale.click();
		Thread.sleep(2000);
		cricket.click();
		Thread.sleep(2000);
		movies.click();
		Thread.sleep(2000);
		hockey.click();
		Thread.sleep(2000);
		password.sendKeys("Aa@161093");
		Thread.sleep(2000);
		confirmpassword.sendKeys("Aa@161093");
		Thread.sleep(2000);
		//ListBoxGeneric(languages);
		Thread.sleep(2000);
		ListBoxGeneric(skills);
		Thread.sleep(4000);
		ListBoxGeneric(countries);
		Thread.sleep(4000);
		//ListBoxGeneric(dcountries);
		Thread.sleep(4000);
		ListBoxGeneric(dobyear);
		Thread.sleep(4000);
		ListBoxGeneric(dobmonth);
		Thread.sleep(4000);
		ListBoxGeneric(dobday);
		Thread.sleep(2000);
		submit.click();
		Loghelp.info("Form is submitted");
		Thread.sleep(10000);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
