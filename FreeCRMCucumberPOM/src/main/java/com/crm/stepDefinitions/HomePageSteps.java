package com.crm.stepDefinitions;

import org.testng.Assert;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
		try {
			    // Express the Regexp above with the code you wish you had
				TestBase.initialization();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^user is on login screen$")
	    public void user_is_on_login_screen() throws Exception {
			try {
				
				loginpage = new LoginPage();
				loginpage.ClickHomeLogin();
				String LoginTitle = loginpage.validateLoginPageTitle();
				Assert.assertEquals(LoginTitle, "Cogmento CRM");
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				Assert.fail(e.getMessage());
			}
	   }

	@Then("^user logged in Successfully$")
	public void user_logged_in_Successfully() throws Throwable {
		try {
			    // Express the Regexp above with the code you wish you had
				homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	    
	}
   
	
	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		try {
			    // Express the Regexp above with the code you wish you had
				String homePageTitle = homepage.verifyHomePageTitle();
				Assert.assertEquals(homePageTitle, "Cogmento CRM");
	   
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	
	@Then("^validate logged in username$")
	public void validate_logged_in_username() throws Throwable {
		try {
				homepage = new HomePage();
				boolean flag = homepage.verfyCorrectUsername();
				Assert.assertTrue(flag);
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
		}
		
	
	
	 @Then("^validate user successfully logged out$")
    
    public void validate_user_successfully_logged_out() {
    	
    	try {
    		homepage = loginpage.logout();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		Assert.fail(e.getMessage());
    	}
    }
}
	
