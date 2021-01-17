package com.crm.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.util.TestBase;

import cucumber.api.DataTable;

public class CalendarPage extends TestBase{

	
	public @FindBy(xpath = "//*[@class='ui linkedin button']//*[@class='edit icon']")
	WebElement newCalendarlink;
	
	public @FindBy(xpath = "//label[text()='Title']/../div/input")
	WebElement titleTextField;
	
	public @FindBy(xpath = "//label[text()='Calendar']/..//*[@class='dropdown icon']")
	WebElement calendarDropdown;
	
	public @FindBy(xpath = "//*[text()='Start Date']/..//input")
	WebElement startDatefield;
	
	public @FindBy(xpath = "//*[text()='Category']/../div")
	WebElement categoryDropdown;
	
	public @FindBy(xpath = "//label[text()='Tags']/..//input")
	WebElement tagsSearchField;
	
	public @FindBy(xpath = "//label[text()='Description']/..//textarea")
	WebElement descriptionField;
	
	public @FindBy(xpath = "//label[text()='Location']/..//textarea")
	WebElement locationField;
	
	public @FindBy(xpath = "//label[text()='All Day']/..//input")
	WebElement allDaytoggle;
	
	public @FindBy(xpath = "//label[text()='Deal']/..//input")
	WebElement dealField;
	
	public @FindBy(xpath = "//label[text()='Task']/..//input")
	WebElement taskField;
	
	public @FindBy(xpath = "//label[text()='Case']/..//input")
	WebElement caseField;
	
	public @FindBy(xpath = "//label[text()='Alert Before']/..//*[@class='dropdown icon']")
	WebElement alertBeforeDropdown;
	
	public @FindBy(xpath = "//label[text()='Alert Via']/..//*[@class='dropdown icon']")
	WebElement alertViaDropdown;//label[text()='Reminder Time']/..//input
	
	public @FindBy(xpath = "//label[text()='Reminder Time']/..//input")
	WebElement reminderField;
	
	public @FindBy(xpath = "//label[text()='Assigned To']/..//*[@class='dropdown icon']")
	WebElement assignedToDropdown;
	
	public @FindBy(xpath = "//label[text()='Participants']/..//input")
	WebElement participantsField;
	
	public @FindBy(xpath = "//label[text()='Company']/..//input")
	WebElement companyField;
	
	public @FindBy(xpath = "//label[text()='Identifier']/..//input")
	WebElement identifierField;
	
	public CalendarPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCalender(DataTable datatable) throws Exception {
      List<List<String>> data = datatable.raw();
	  int size = data.size();
	  
	  setValueInEditBoxByXpath(titleTextField, data.get(0).get(0), "Title Field");
	  clickItemFromDropDownList(calendarDropdown, "Calender dropdown", "Sadananda Sahoo");
	  
	  
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
