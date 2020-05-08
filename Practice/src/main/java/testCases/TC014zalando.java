package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC014zalando extends ProjectSpecificMethods{

	public void clickElement(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		TC014zalando ce = new TC014zalando();
//	1) Go to https://www.zalando.com/
		String URL = "https://www.zalando.com/";
		ProjectSpecificMethods psm = new ProjectSpecificMethods();
		psm.killprocess(true, true, true);
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_81.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver(options);
		driver.get(URL);
		
//	2) Get the Alert text and print it
		Alert alert = driver.switchTo().alert();
		String alt_txt = alert.getText();
		System.out.println("Alert text is : "+alt_txt);
		
//	3) Close the Alert box and click on Zalando.uk
		alert.accept();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ce.clickElement(driver.findElementByXPath("//a[text()='Zalando.uk']"));
		Thread.sleep(7000);
		
//	4) Click Women--> Clothing and click Coat
		if (driver.findElementByXPath("//button[@class='uc-btn uc-btn-primary']").isDisplayed())
		{
			Thread.sleep(3000);
			ce.clickElement(driver.findElementByXPath("//button[@class='uc-btn uc-btn-primary']"));
		}
		ce.clickElement(driver.findElementByXPath("//a[@class='z-navicat-header_gender']//span[text()='Women']"));
		
		ce.clickElement(driver.findElementByXPath("//span[text()='Clothing']"));
		
//		ce.clickElement(driver.findElementByXPath("//span[text()='Coats']"));
		ce.clickElement(driver.findElementByXPath("//ul[@role='group']//a[text()='Coats']"));
		Thread.sleep(3000);
		
//	5) Choose Material as cotton (100%) and Length as thigh-length
		ce.clickElement(driver.findElementByXPath("//span[@data-label='Material']//parent::button"));
		ce.clickElement(driver.findElementByXPath("//span[text()='cotton (100%)']"));
		ce.clickElement(driver.findElementByXPath("//button[text()='Save']"));
		Thread.sleep(3000);
		
		ce.clickElement(driver.findElementByXPath("//span[@data-label='Length']//parent::button"));
		ce.clickElement(driver.findElementByXPath("//span[text()='thigh-length']"));
		ce.clickElement(driver.findElementByXPath("//button[text()='Save']"));
		Thread.sleep(3000);
		
//	6) Click on Q/S designed by MANTEL - Parka coat
		ce.clickElement(driver.findElementByXPath("//div[text()='Q/S designed by']"));
		
//	7) Check the availability for Color as Olive and Size as 'M'
		String color = driver.findElementByXPath("(//span[contains(text(),'Colour')]/parent::div/span)[2]").getText();
		boolean mtchfnd = false;
		if (color.equalsIgnoreCase("navy"))
		{
			ce.clickElement(driver.findElementByXPath("(//img[@alt='olive'])[2]"));
			Thread.sleep(3000);
			System.out.println("Color is : "+driver.findElementByXPath("(//span[contains(text(),'Colour')]/parent::div/span)[2]").getText());
			if (driver.findElementByXPath("//h2[text()='Out of stock']").isDisplayed())
			{
				System.out.println(driver.findElementByXPath("//h2[text()='Out of stock']").getText());
				ce.clickElement(driver.findElementByXPath("(//img[@alt='navy'])[2]"));
				Thread.sleep(3000);
				if (driver.findElementByXPath("(//span[text()='Standard delivery'])[1]").isDisplayed())
				{
					mtchfnd = true;
					System.out.println(driver.findElementByXPath("(//span[text()='Standard delivery'])[1]").getText());
				}
			}
		}
		
//	8) If the previous preference is not available, check  availability for Color Navy and Size 'M'
		if (mtchfnd == true)
		{
			ce.clickElement(driver.findElementByXPath("//span[text()='Choose your size']/parent::button"));	
			Thread.sleep(1000);
			ce.clickElement(driver.findElementByXPath("//span[text()='M']"));
			Thread.sleep(1000);
//	9) Add to bag only if Standard Delivery is free
			ce.clickElement(driver.findElementByXPath("//span[text()='Add to bag']/parent::button"));
			Thread.sleep(1000);
//	10) Mouse over on Your Bag and Click on "Go to Bag"
			WebElement cart = driver.findElementByXPath("//a[@class='z-navicat-header_navToolItemLink']");
			builder.moveToElement(cart).perform();
			Thread.sleep(1500);
			ce.clickElement(driver.findElementByXPath("//div[text()='Go to bag']/parent::a"));
			Thread.sleep(1000);
			
//	11) Capture the Estimated Deliver Date and print
			WebElement dd = driver.findElementByXPath("//div[@data-id='delivery-estimation']/span");
			System.out.println("Delivery Date : "+dd.getText());
			
//	12) Mouse over on FREE DELIVERY & RETURNS*, get the tool tip text and print
			WebElement tooltip = driver.findElementByXPath("//a[text()='Free delivery & returns*']");
			builder.moveToElement(tooltip).perform();
			Thread.sleep(200);
			String tt = tooltip.getAttribute("title");
			System.out.println("Tool Tip : "+tt);
			ce.clickElement(tooltip);
			Thread.sleep(1000);
			
//	13) Click on Start chat in the Start chat and go to the new window
			ce.clickElement(driver.findElementByXPath("//span[text()='Start chat']"));
			Thread.sleep(9000);
			
			Set<String> winL = driver.getWindowHandles();
			List<String> winH = new ArrayList<String>(winL);
			
			driver.switchTo().window(winH.get(1));
			
//	14) Enter you first name and a dummy email and click Start Chat
			driver.findElementById("prechat_customer_name_id").sendKeys("Mathanvel");
			driver.findElementById("prechat_customer_email_id").sendKeys("mathan@gmail.com");
			ce.clickElement(driver.findElementByXPath("//span[text()='Start Chat']"));
			Thread.sleep(5000);
			
//	15) Type Hi, click Send and print thr reply message and close the chat window.
			driver.findElementByXPath("//textarea[@id='liveAgentChatTextArea']").sendKeys("Hi",Keys.ENTER);
			Thread.sleep(4000);
			List<WebElement> chatopr = driver.findElementsByXPath("//span[@class='operator']//span[@class='messageText']");
			String opr = chatopr.get(chatopr.size()).getText();
			System.out.println("Last Chat : "+opr);
			
			System.out.println(" *** Program Ends ***");
		}
	}

}
