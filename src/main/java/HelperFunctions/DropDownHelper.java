package HelperFunctions;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import JavaMain.BaseClass;
import LogHelper.Loghelp;


public class DropDownHelper extends BaseClass {
		
	public DropDownHelper() throws Exception{
		super();
		Loghelp.info("DropDownHelper object created..");
	}
	
	public void selectUsingValue(WebElement element, String value){
		Select select = new Select(element);
		Loghelp.info("selectUsingValue and value is: "+value);
		select.selectByValue(value);
	}
	
	public void selectUsingIndex(WebElement element, int index){
		Select select = new Select(element);
		Loghelp.info("selectUsingIndex and index is: "+index);
		select.selectByIndex(index);
	}
	
	public void selectUsingVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		Loghelp.info("selectUsingVisibleText and visibleText is: "+visibleText);
		select.selectByVisibleText(visibleText);
	}
	
	public void deSelectUsingValue(WebElement element, String value){
		Select select = new Select(element);
		Loghelp.info("deSelectUsingValue and value is: "+value);
		select.deselectByValue(value);
	}
	
	public void deSelectUsingIndex(WebElement element, int index){
		Select select = new Select(element);
		Loghelp.info("deSelectUsingIndex and index is: "+index);
		select.deselectByIndex(index);
	}
	
	public void deSelectUsingVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		Loghelp.info("deselectByVisibleText and visibleText is: "+visibleText);
		select.deselectByVisibleText(visibleText);
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement ele: elementList){
			Loghelp.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}
}