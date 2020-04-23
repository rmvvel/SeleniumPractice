package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.api.ProjectSpecificMethods;

public class TC003MakeMyTrip  extends ProjectSpecificMethods{

	public static void main(String[] args) throws InterruptedException {

//			1) Go to https://www.makemytrip.com/
			String URL = "https://www.makemytrip.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			
//			2) Click Hotels
			driver.findElementByXPath("//span[text()='Hotels']").click();
			Thread.sleep(3000);
			
//			3) Enter city as Goa, and choose Goa, India
			driver.findElementByXPath("//input[@id='city']").click();
			driver.findElementByXPath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("goa");
			Thread.sleep(3000);
			driver.findElementByXPath("//p[text()='Goa, India']").click();
			Thread.sleep(3000);
			
//			4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5
//			driver.findElementByXPath("//p[@data-cy='checkInDate']").click();
			driver.findElementByXPath("((//div[@class='DayPicker-Month'])[2])//div[text()='15']").click();
			Thread.sleep(1000);
			driver.findElementByXPath("((//div[@class='DayPicker-Month'])[2])//div[text()='20']").click();
			
//			5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
			driver.findElementByXPath("//label[@for='guest']").click();
			
			driver.findElementByXPath("//ul[@data-cy='adultCount']//li[text()='2']").click();
			driver.findElementByXPath("//li[@data-cy='children-1']").click();
			Thread.sleep(100);
			WebElement ele1 = driver.findElementByXPath("//select[@class='ageSelectBox']");
			Select drp = new Select(ele1);
			drp.selectByVisibleText("12");
			driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();
			
//			6) Click Search button
			driver.findElementByXPath("//button[@id='hsw_search_button']").click();
			Thread.sleep(5000);
			//p[text()='Explore Hotels on Map']
//			driver.get(driver.getCurrentUrl());
//			Thread.sleep(1000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,500)");
			
//			7) Select locality as Baga
//			driver.findElementByXPath("(//label[text()='Baga']/parent::span)/input").click();
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			driver.findElementByXPath("//i[@class='we_forward']").click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElementByXPath("//a[@class='mapCont']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//span[@class='mapClose']").click();
			Thread.sleep(2000);
//			driver.findElementByXPath("//p[text()='Explore Hotels on Map']").click();
			
			WebElement baga = driver.findElementByXPath("//label[text()='Baga']");
//			builder.moveByOffset(baga.getLocation().getX(), baga.getLocation().getY()).perform();
			builder.moveToElement(baga).perform();
			baga.click();
			Thread.sleep(3000);
			
//			8) Select 5 start in Star Category under Select Filters
//			driver.findElementByXPath("(//label[text()='5 Star']/parent::span)/input").click();
//			js.executeScript("window.scrollBy(0,1000)");
			WebElement star = driver.findElementByXPath("//label[text()='5 Star']");
			builder.moveToElement(star).perform();
			star.click();
			Thread.sleep(3000);
			
//			9) Click on the first resulting hotel and go to the new window
			driver.findElementById("Listing_hotel_0").click();
			Thread.sleep(3000);
			
			Set<String> winSet = driver.getWindowHandles();
			List<String> winL= new ArrayList<String>(winSet);
			driver.switchTo().window(winL.get(1));
			
//			10) Print the Hotel Name 
			String hotelName = driver.findElementByXPath("//ul[@id='detpg_bread_crumbs']//li[3]/a").getText();
			System.out.println("Hotel Name is : "+hotelName);
			
//			11) Click MORE OPTIONS link and Select 3Months plan and close
			driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//td[text()='3']//following-sibling::td[5]").click();
			Thread.sleep(500);
			driver.findElementByXPath("//span[@class='close']").click();
			
//			12) Click on BOOK THIS NOW
			driver.findElementByXPath("//a[@id='detpg_headerright_book_now']").click();
			Thread.sleep(1500);
			
//			13) Print the Total Payable amount
			String totalpayable = driver.findElementByXPath("//span[@id='revpg_total_payable_amt']//text()[3]").getText();
			System.out.println("Total Payable amount : " + totalpayable.replaceAll("\\D", ""));
//			14) Close the browser
			
			driver.close();
			driver.switchTo().window(winL.get(0));
			driver.close();
			
			System.out.println(" *** Program Ends ***");
	}

}
