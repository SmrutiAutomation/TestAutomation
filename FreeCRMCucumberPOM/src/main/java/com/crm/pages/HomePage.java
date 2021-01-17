package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.util.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath = "//span[contains(text(),'Smruti Ranjan Sahoo')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homeLink;
	
	@FindBy(xpath = "//span[text()='Calendar']")
	WebElement calendarLink;
	
	@FindBy(xpath = "//*[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[text()='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath = "//span[text()='Cases']")
	WebElement casesLink;
	
	@FindBy(xpath = "//span[text()='Calls']")
	WebElement callsLink;
	
	@FindBy(xpath = "//span[text()='Documents']")
	WebElement documentsLink;
	
	@FindBy(xpath = "//span[text()='Email']")
	WebElement emailLink;
	
	@FindBy(xpath = "//span[text()='Campaigns']")
	WebElement campaignsLink;
	
	@FindBy(xpath = "//span[text()='Forms']")
	WebElement formsLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verfyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnHomeLink() throws Exception {
		clickButtonByXpath(homeLink, "Home link");
	}
	
	public void clickOnCalendarLink() throws Exception {
		clickButtonByXpath(calendarLink, "Calendar link");
	}
	
	public void clickOnContactLink() throws Exception {
		clickButtonByXpath(contactsLink, "Contancts link");
	}
	
	public void clickOnCompaniesLink() throws Exception {
		clickButtonByXpath(companiesLink, "Companies link");
	}
	
	public void clickOnDealsLink() throws Exception {
		clickButtonByXpath(dealsLink, "Deals link");
	}
	
	
	public void clickOnTasksLink() throws Exception {
		clickButtonByXpath(tasksLink, "Tasks link");
	}
	
	public void clickOnCasesLink() throws Exception {
		clickButtonByXpath(casesLink, "Cases link");
	}
	
	public void clickOnCallsLink() throws Exception {
		clickButtonByXpath(callsLink, "Calls link");
	}
	
	public void clickOnDocumnetsLink() throws Exception {
		clickButtonByXpath(documentsLink, "Documents link");
	}
	
	public void clickOnEmailLink() throws Exception {
		clickButtonByXpath(emailLink, "Email link");
	}
	
	public void clickOnCampaignsLink() throws Exception {
		clickButtonByXpath(campaignsLink, "Campaigns link");
	}
	
	public void clickOnFormsLink() throws Exception {
		clickButtonByXpath(formsLink, "Forms link");
	}
	
	
	
	
	
}
