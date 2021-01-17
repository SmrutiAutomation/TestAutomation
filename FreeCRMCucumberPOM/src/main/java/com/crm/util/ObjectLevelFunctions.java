package com.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectLevelFunctions {
       WebDriver driver;

	   public static final String ConfigFilePath=".\\Config\\Config.properties";
  	   public static final String ConfigUIMapFilePath=".\\Config\\Cucumber.properties";
  	   public static Properties prop;
 	   public static Properties propOR;
       public static FileInputStream fs;
 	   public static FileInputStream fsOR;
 	   
  	   public static void gm_LoadORConfigValue() throws IOException {
  		   propOR=new Properties();
  			fsOR = new FileInputStream(ConfigUIMapFilePath);
  			propOR.load(fsOR);
  		   
  	   }
  	   
  	   public static String gm_GetORConfigValue(String propName) throws IOException {
  		   if(propOR==null) {
  			 gm_LoadORConfigValue();
  			 }
  		String PropValue = propOR.getProperty(propName);
		return PropValue;
  	   }
  	   
  	   
  	 public static void gm_LoadCOnfigFile() throws IOException{
 		//Load Config properties file 
 		prop=new Properties();		
 		fs=new FileInputStream(ConfigFilePath);
 		prop.load(fs);
 				
 	}
  	 
  	public static String gm_GetConfigValue(String propName) throws IOException{
		if(prop==null){
			gm_LoadCOnfigFile();
		}
		String PropValue=prop.getProperty(propName);
		return PropValue;
	}
  	   
  	   
	public void IsElementPresent(String Xpath, int time) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void IsElementLocated(String Xpath, int time) {
		
		//WebElement element = driver.findElement(By.xpath(Xpath));
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
	}
	
	public void ScrollToElement(String Xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(Xpath));
		   JavascriptExecutor jse = (JavascriptExecutor)driver;
		   jse.executeScript("arguments[0].scrollIntoView();", element);
		   
		}catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
		
	}
	
	
}
