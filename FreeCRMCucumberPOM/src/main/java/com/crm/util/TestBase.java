package com.crm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public static final String ConfigFilePath="C:\\Selenium Setup\\FreeCRMCucumberPOM\\src\\main\\java\\com\\crm\\config\\config.properties";
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream fis = new FileInputStream(ConfigFilePath);
			prop.load(fis);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			}
	}
	
	public static void initialization() throws InterruptedException {
		try {
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium Setup\\FreeCRMCucumberPOM\\driver\\chromedriver.exe");
				driver=new ChromeDriver();
				
				
			}else if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium Setup\\FreeCRMCucumberPOM\\driver\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("Testurl"));
			 
			WebElement we = driver.findElement(By.xpath("//span[@class='icon icon-xs mdi-chart-bar']/.."));
			checkElementIsPresent(we, "HomeLogin button");
			
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	
	public static void moveToElementAndClick(WebElement element, String Xpath) {
		try {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
	
	//Click Button using xpath
		public void clickButtonByXpath(WebElement we, String ElementName) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(we));
			try {
				 boolean objPresent=false;
				//we = null;
				   try {
						
					       objPresent=we.isDisplayed();
				  } catch (Exception e) {			
			      }		
				 Thread.sleep(1000);
				 if(objPresent==true){
					//we.click();
					      System.out.println("'"+ElementName+"' is visible peoperly");
					      JavascriptExecutor executor = (JavascriptExecutor)driver;
					      executor.executeScript("arguments[0].click();", we);
				  }else{
					  System.out.println("Element is not clickable");
				
				  }
			   } catch (Exception e) {
				System.out.println(e.getMessage());
				Assert.fail(e.getMessage());
			  }
		}
		
		public void setValueInEditBoxByXpath(WebElement we,String value, String ElementName) throws IOException, InterruptedException {
			try {
			if(we.isDisplayed()){
			we.clear();
			we.sendKeys(value);
				if(we.getAttribute("value").equals(value)) {
				
					System.out.println("Expected Value '"+value+"' is entered successfully");
					//logger.log(LogStatus.INFO, screenShotName, screenShotName +" value is displaying as expected");
				}
				else {
								
				}
			}else {
				System.out.println("'"+ElementName+"' element is not visible on the page");
			}
			}catch(Exception e) {
			   Assert.fail(e.getMessage());
			}
		}
		
		public void setValueInSearchFieldAndSelect(WebElement we, String value) {
			if(we.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+we.getLocation().y+")");
				we.clear();
				we.sendKeys(value); 
				
				
				
			}
			
			
			
		}
		
		public static void checkElementIsPresent(WebElement we, String elementName) throws InterruptedException {
			boolean objPresent=false;
			//we = null;
			   try {
				   WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOf(we)); 
				   objPresent=we.isDisplayed();
			   } catch (Exception e) {
				   
			   }
		     
			 if(objPresent==true){
				//we.click();
				System.out.println("'"+elementName+"' element is displayed");
			
		}
		}
			 
			 
		  public void clickItemFromDropDownList(WebElement we, String elementName, String strName ) throws Exception {
			   try {		
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
			        		we, "color: black; border: 3px solid black;");
			        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
			        		we, "");
			        checkElementIsPresent(we, elementName);
					we.click();
					 
                  List<WebElement> arrDownItems = driver.findElements(By.xpath("//div[@class='visible menu transition']/div/span"));
					
					for (int i = 0; i < arrDownItems.size(); i++) {
						System.out.println(arrDownItems.get(i).getText());
						if (arrDownItems.get(i).getText().equals(strName)) {
							checkElementIsPresent(arrDownItems.get(i), strName+"option");
							arrDownItems.get(i).click();
							//logger.log(LogStatus.INFO, "Clicked expected Item: '"+strName+"' successfully");
							System.out.println("Clicked expected Item: '"+strName+"' successfully");
							Thread.sleep(1000);
							break;
						}
					}
			   }catch(Exception e) {
				   Assert.fail(e.getMessage());
			   }
					
					/*Select se = new Select(we);
					List<WebElement> options = se.getOptions();
					int numberofOptions = options.size();
					for(int i = 0; i<=numberofOptions; i++) {
						String optionValue = options.get(i).getText();
						if(optionValue.equals(strName)) {
							options.get(i).click();
							System.out.println("Clicked expected Item: '"+strName+"' successfully");
						}
					}
					Thread.sleep(1000);
					String xpath2="//"+tagName+"[contains(text(),'"+strName+"')]";
					WebElement we1=driver.findElement(By.xpath(xpath2));
					Thread.sleep(1000);
					if(we1.isDisplayed()){
						we1.click();
						//TakeScreenShot(screenShotName);
					
						//logger.log(LogStatus.INFO, "Select from Dropdown", "Clicked expected Item: '"+strName+"' successfully");
					}else{
						
						we.sendKeys(strName);
						Thread.sleep(1000);
						String checktext =we.getAttribute("value");
						if (checktext.equalsIgnoreCase(strName)) {
							//logger.log(LogStatus.FAIL, "Expected Item was not selected");
							//logger.attachScreenshot(prop.getProperty("screenShotPath")+screenShotName+".png");
							
						}
						else {
							TakeScreenShot(screenShotName,ScreenShotFolderPath);
							//logger.log(LogStatus.FAIL, stepName, "Expected Item was not selected");
							CurrentTestStatus="Fail";
						}
						
					}*/
				
		  
		  }
		
		
	
}
