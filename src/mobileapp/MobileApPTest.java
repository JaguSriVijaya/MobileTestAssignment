package mobileapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileApPTest extends Capability{

	AndroidDriver<AndroidElement> driver;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver= capabilities();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//test case is for verifying the default language option
	@Test(enabled= false)
	public void testcase1() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElements(By.className("android.widget.Button")).get(0).click();
		driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
		driver.findElementByAccessibilityId("Settings").click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Language & region']")).click();
		String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
		System.out.println(country);
		AssertJUnit.assertEquals(country, "India");
		System.out.println("Language option for India is matching");
	}
	//Verifying the hybrid functionality
	@Test
	public void testcase2() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElements(By.className("android.widget.Button")).get(0).click();
		driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
		driver.findElementByAccessibilityId("Settings").click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Privacy policy']")).click();
	//	driver.findElementByAccessibilityId("android:id/text1").click();
        driver.findElement(By.xpath("//*[@text='JUST ONCE']")).click();
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
      driver.context("WEBVIEW_chrome");
        Thread.sleep(5000);
        
	}
}
