package com.sony.qa.object;

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

	@FindBy(xpath = "(//div[@class='mf_finder_organic_doc_img_wrapper mf_gui_img_frame'])[1]")
	WebElement selectElement;

	private void clicking() {
		cAction.clickElement(searchButton);
	}

	private void inputText(String value) {
		cAction.inputValue(searchElement, value);
	}

	public void hompageSteps(String value) {
		clicking();
		inputText(value);

	}

}
