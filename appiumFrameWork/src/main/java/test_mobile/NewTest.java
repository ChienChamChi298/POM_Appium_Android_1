package test_mobile;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest { 
	AppiumDriver driver; 
	

//  @Test
//  public void sucessFull() { 
//	  MobileElement userNameTextFld = (MobileElement) driver.findElementsByAccessibilityId("test-Username");
//	  MobileElement passwordTextFld = (MobileElement) driver.findElementsByAccessibilityId("test-Password"); 
//	  MobileElement buttonLogin = (MobileElement) driver.findElementsByAccessibilityId("test-LOGIN"); 
//	  
//	  MobileElement err = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");
//	  userNameTextFld.sendKeys("standard_user"); 
//	  passwordTextFld.sendKeys("secret_sauce"); 
//	  buttonLogin.click(); 
//	  
//	  String actualErrText =  err.getText(); 
//	  String expectErrText = "Username and password do not match any user in this service."; 
//	  Assert.assertEquals(actualErrText, expectErrText);
//  
//  }   
  
  
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException { 
		DesiredCapabilities  capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("deviceName", "Chien Androi Automation Simulator"); 
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app",  "C:\\Users\\CSM\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.3.0.apk"); 
		
		capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");  
		 driver = new AndroidDriver(url, capabilities);
		String sessionId = driver.getSessionId().toString();  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
 
  
  @Test
  public void invaildUser() { 
	  MobileElement userNameTextFld = (MobileElement) driver.findElementByAccessibilityId("test-Username");
	  MobileElement passwordTextFld = (MobileElement) driver.findElementByAccessibilityId("test-Password"); 
	  MobileElement buttonLogin = (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");  
	  
	  userNameTextFld.sendKeys("username_invaild"); 
	  passwordTextFld.sendKeys("serect_sauce"); 
	  buttonLogin.click();  
	  
	  MobileElement err = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

	  
	  String actualErrText =  err.getAttribute("text"); 
	  String expectErrText = "Username and password do not match any user in this service."; 
	  Assert.assertEquals(actualErrText, expectErrText);
  
  }    
  
  @Test
  public void invaildPassword() { 
	  MobileElement userNameTextFld = (MobileElement) driver.findElementByAccessibilityId("test-Username");
	  MobileElement passwordTextFld = (MobileElement) driver.findElementByAccessibilityId("test-Password"); 
	  MobileElement buttonLogin = (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");  
	  
	  userNameTextFld.sendKeys(" standard_user");
	  passwordTextFld.sendKeys("password_invaild"); 
	  buttonLogin.click();  
	  
	  MobileElement err = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

	  
	  String actualErrText =  err.getAttribute("text"); 
	  String expectErrText = "Username and password do not match any user in this service."; 
	  Assert.assertEquals(actualErrText, expectErrText);
  
  }     
  
  @AfterClass
  public void afterClass() { 
	  driver.quit();
  }

}
