package com.sony.qa.object;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sony.qa.common.CommonAction;

public class HomePage {

	CommonAction cAction;

	public HomePage(WebDriver driver, CommonAction cAction) {
		PageFactory.initElements(driver, this);
		this.cAction = cAction;

	}

	@FindBy(id = "tmpl-header_searchBtn")
	WebElement searchButton;

	@FindBy(xpath = "//input[@placeholder='Search sony.com']")
	WebElement searchElement;

	@FindBy(xpath = "//button[@class='mf_finder_searchBox_submit']")
	WebElement submitElement;

	@FindBy(xpath = "(//img[@alt='capture image'])[1]")
	WebElement selectElement;
	
	private void clicking() {
		cAction.clickElement(searchButton);
	}

	private void inputText(String value) {
		cAction.inputValue(searchElement, value);
	}

	private void submitButton() {
		cAction.clickElement(submitElement);
	}

	private void selectButton() {
		cAction.clickElement(selectElement);
	}

	public void hompageSteps(String value) {
		clicking();
		inputText(value);
		submitButton();
		selectButton();

	}

}
