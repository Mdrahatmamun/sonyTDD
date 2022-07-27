package com.sony.qa.common;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.sony.qa.reporting.Loggers;

public class CommonAction {

public void clickElement(WebElement element) {
		try {
				element.click();
				Loggers.getLog(element + " : This element has been clicked" );
	
		}catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
}

	public void inputValue(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.getLog(value + " : value passed into ---> " + element);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();

		}

	}

}
