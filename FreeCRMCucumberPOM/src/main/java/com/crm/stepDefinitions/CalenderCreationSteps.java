package com.crm.stepDefinitions;

import static org.testng.Assert.fail;

import java.util.List;

import org.junit.Assert;

import com.crm.pages.CalendarPage;
import com.crm.pages.HomePage;
import com.crm.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class CalenderCreationSteps extends CalendarPage{

	HomePage homepage;
	CalendarPage CPage;
	
	@Then("^validate calendar tab and click on that$")
	public void validate_calendar_tab_and_click_on_that() throws Exception {
		try {
			homepage = new HomePage();
			homepage.clickOnCalendarLink();
		}catch(Exception e) {
			
		Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Create A New Calendar From Calendar Tab$")
	public void Create_A_New_Calendar_From_Calendar_Tab(DataTable datatable) {
		try {
			
			List<List<String>> data = datatable.raw(); 
			  clickButtonByXpath(newCalendarlink, "New Calendar button");
			  setValueInEditBoxByXpath(titleTextField, data.get(0).get(0), "Title Field");
			  clickItemFromDropDownList(calendarDropdown, "Calender dropdown", data.get(0).get(1));
			  clickItemFromDropDownList(categoryDropdown, "Category dropdown", data.get(0).get(2));
			
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
		
	}
	
	
	
	
}
