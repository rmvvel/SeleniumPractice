package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC015airbnb extends ProjectSpecificMethods{

	public void clickElement(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	
	public void typetext(WebElement ele,String txt)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.sendKeys(txt);
	}
	public static void main(String[] args) throws InterruptedException {
		
		TC015airbnb tc = new TC015airbnb();
//	1) Go to https://www.airbnb.co.in/
		ProjectSpecificMethods psm = new ProjectSpecificMethods();
		psm.launch("https://www.airbnb.co.in/");
		Thread.sleep(4000);
		
		WebElement pop = driver.findElementByXPath("//button[@class='optanon-allow-all accept-cookies-button']");
		if (pop.isDisplayed()) tc.clickElement(pop);
		
//	2) Type Coorg in location and Select Coorg, Karnataka
		tc.typetext(driver.findElementByXPath("//input[@id='bigsearch-query-attached-query']"), "Coorg");
		Thread.sleep(1000);
		tc.clickElement(driver.findElementByXPath("//div[text()='Coorg, Karnataka']"));
		Thread.sleep(1000);
		
//	3) Select the Start Date as June 1st and End Date as June 5th
		tc.clickElement(driver.findElementByXPath("//div[text()='June 2020']/parent::div/parent::div//table//div[text()='1']"));
		tc.clickElement(driver.findElementByXPath("//div[text()='June 2020']/parent::div/parent::div//table//div[text()='5']"));
		Thread.sleep(1000);
		
//	4) Select guests as 6 adults, 3 child and Click Search
		tc.clickElement(driver.findElementByXPath("//div[text()='Add guests']"));
		Thread.sleep(400);
		
		for (int i = 1 ; i <=6 ; i++)
		{
			tc.clickElement(driver.findElementByXPath("//div[@id='stepper-adults']//button[@aria-label='increase value']"));
			Thread.sleep(100);
		}
		
		for (int i = 1 ; i <=3 ; i++)
		{
			tc.clickElement(driver.findElementByXPath("//div[@id='stepper-children']//button[@aria-label='increase value']"));
			Thread.sleep(100);
		}
		tc.clickElement(driver.findElementByXPath("//span[text()='Search']"));
		Thread.sleep(3000);
		
//	5) Click Cancellation flexibility and enable the filter and Save
		tc.clickElement(driver.findElementByXPath("(//span[text()='Cancellation flexibility'])[1]"));
		Thread.sleep(2000);
		tc.clickElement(driver.findElementByXPath("//button[@id='filterItem-switch-flexible_cancellation-true']"));
		tc.clickElement(driver.findElementByXPath("//button[@id='filter-panel-save-button']"));
		Thread.sleep(3000);
		
//	6) Select Type of Place as Entire Place and Save
		tc.clickElement(driver.findElementByXPath("(//span[text()='Type of place'])[1]"));
		Thread.sleep(2000);
		tc.clickElement(driver.findElementByXPath("//input[@name='Entire place']//following-sibling::span"));
		tc.clickElement(driver.findElementByXPath("//button[@id='filter-panel-save-button']"));
		Thread.sleep(3000);
		
//	7) Set Min price as 3000 and  max price as 5000
		tc.clickElement(driver.findElementByXPath("(//span[text()='Price'])[1]"));
		Thread.sleep(2000);
		WebElement min = driver.findElementByXPath("//input[@id='price_filter_min']");
		min.clear();
		tc.typetext(min, "3000");
		Thread.sleep(200);
		WebElement max = driver.findElementByXPath("//input[@id='price_filter_max']");
		max.clear();
		tc.typetext(max, "5000");
		tc.clickElement(driver.findElementByXPath("//button[@id='filter-panel-save-button']"));
		Thread.sleep(3000);
		
//	8) Click More Filters and set 3 Bedrooms and 3 Bathrooms
		tc.clickElement(driver.findElementByXPath("(//span[text()='More filters'])[1]"));
		Thread.sleep(2000);
		for (int i = 1 ; i <=3 ; i++)
		{
			tc.clickElement(driver.findElementByXPath("//div[text()='Beds']/parent::div/parent::div//button[@aria-label='increase value']"));
			Thread.sleep(100);
		}
		for (int i = 1 ; i <=3 ; i++)
		{
			tc.clickElement(driver.findElementByXPath("//div[text()='Bedrooms']/parent::div/parent::div//button[@aria-label='increase value']"));
			Thread.sleep(100);
		}
		
//	9) Check the Amenities with Kitchen, Facilities with Free parking on premisses, Property as House and Host Language as English
//	    and click on Stays only when stays available
		tc.clickElement(driver.findElementByXPath("//input[@name='Kitchen']/parent::span//span"));
		Thread.sleep(100);
		tc.clickElement(driver.findElementByXPath("//input[@name='Free parking on premises']/parent::span//span"));
		Thread.sleep(100);
		tc.clickElement(driver.findElementByXPath("//input[@name='House']/parent::span//span"));
		Thread.sleep(100);
		tc.clickElement(driver.findElementByXPath("//input[@name='English']/parent::span//span"));
		Thread.sleep(100);
		String exp = "//button[matches(text(),'Show [1-9]+ stay')]";
		tc.clickElement(driver.findElementByXPath(exp));
		Thread.sleep(3000);
		
//	10) Click Prahari Nivas, the complete house
		tc.clickElement(driver.findElementByXPath("(//a[@aria-label='Prahari Nivas, the complete house'])[1]"));
		Thread.sleep(5000);
		
//	11) Click on "Show all * amenities"
		Set<String> winL = driver.getWindowHandles();
		List<String> winH = new ArrayList<String>(winL);
		driver.switchTo().window(winH.get(1));
		
		tc.clickElement(driver.findElementByXPath("//div[text()='Amenities']//ancestor::section[1]//button"));
		Thread.sleep(2000);
		
//	12) Print all the Not included amenities
		List<WebElement> nincl = driver.findElementsByXPath("//div[text()='Not included']//ancestor::section[1]//del");
		System.out.println("Not Included Amenities : ");
		for (int i =0; i < nincl.size();i++)
		{
			System.out.println(nincl.get(i).getText());
		}
		tc.clickElement(driver.findElementByXPath("(//button[@aria-label='Close'])[2]"));
		Thread.sleep(1000);
		
//	13) Verify the Check-in date, Check-out date and Guests
		String chkin = driver.findElementByXPath("//input[@id='checkin']/parent::div//div").getText();
		String chkout = driver.findElementByXPath("//input[@id='checkout']/parent::div//div").getText();
		
		if (chkin.contentEquals("6/1/2020") && chkout.contentEquals("6/5/2020"))
			System.out.println("Dates matches");
		else System.out.println("Dates doesnt match");
		
		tc.clickElement(driver.findElementByXPath("//span[text()='Guests']//ancestor::div[1]//button//span[contains(text(),'guests')]"));
		Thread.sleep(1000);
		String adult = driver.findElementByXPath("//div[text()='Adults']//ancestor::div[3]//div[@aria-hidden='true']").getText();
		String children = driver.findElementByXPath("//div[text()='Children']//ancestor::div[3]//div[@aria-hidden='true']").getText();
		
		if (Integer.parseInt(adult)== 6 && Integer.parseInt(children)== 3)
			System.out.println("Guest matches");
		else System.out.println("Guest doesnt match");
		
//	14) Read all the Sleeping arrangements and Print
		List<WebElement> slpargn = driver.findElementsByXPath("//div[text()='Sleeping arrangements']/ancestor::section[1]//div[@aria-hidden='true']");
		System.out.println("Sleeping arrangements : ");
		for (int i =0; i < slpargn.size();i++)
		{
			System.out.println(slpargn.get(i).getText());
		}
//	15) Close all the browsers
		driver.close();
		driver.switchTo().window(winH.get(0));
		driver.close();
		System.out.println(" *** Program Ends ***");
	}

}
