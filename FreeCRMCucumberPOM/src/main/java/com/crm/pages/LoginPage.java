package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.util.TestBase;

public class LoginPage extends TestBase{

	HomePage homepage;
	@FindBy(xpath = "//span[@class='icon icon-xs mdi-chart-bar']/..")
	WebElement homeloginBtn;
	
	@FindBy(xpath = "//*[@name='email']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//*[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//*[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "(//*[@class='rd-navbar-brand'])[1]")
	WebElement crmLogo;
	
	@FindBy(xpath = "//div[@role='listbox']/i[@class='settings icon']")
	WebElement settingIcon;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement logoutBtn;
	
	//Initializing the page objects
	public LoginPage() {
		
	PageFactory.initElements(driver, this);	
	}
	
	
	public String validateLoginPageTitle() throws Exception {
		
		return driver.getTitle();
	}
	
	public void ClickHomeLogin() throws Exception {
	try {
		    /*WebDriverWait wait = new WebDriverWait(driver, 15);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='icon icon-xs mdi-chart-bar']/..")));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", homeloginBtn);*/
		clickButtonByXpath(homeloginBtn, "HomeLogin button");
		checkElementIsPresent(loginBtn, "Login button");
	}catch(Exception e) {
		System.out.println(e.getMessage());
			
	}
		
	}
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) throws Exception{
        
		setValueInEditBoxByXpath(emailAddress, un, "Username");
		setValueInEditBoxByXpath(password, pwd, "Password");
		clickButtonByXpath(loginBtn, "Login Button"); 
		WebElement we = driver.findElement(By.xpath("//span[text()='Home']"));
		checkElementIsPresent(we, "Home Page");
		return new HomePage();
	}
	
	
	public HomePage logout() throws Exception {
		  try {
			
				clickButtonByXpath(settingIcon, "Setting Icon");
				clickButtonByXpath(logoutBtn, "Logout button");
				checkElementIsPresent(loginBtn, "Login button");
				driver.quit();
			
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return new HomePage();
	}
	
}
