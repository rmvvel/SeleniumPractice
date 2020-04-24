package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import base.api.ProjectSpecificMethods;

public class TC008Pepperfry extends ProjectSpecificMethods{

	public static void main(String[] args) throws InterruptedException, IOException {

//			1) Go to https://www.pepperfry.com/
			String URL = "https://www.pepperfry.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			Thread.sleep(4000);
			WebElement popup = driver.findElementByXPath("//div[@id='regPopUp']//a[@class='popup-close']");
			if (popup.isDisplayed() == true) popup.click();
			
//			2) Mouseover on Furniture and click Office Chairs under Chairs
			WebElement ele1 = driver.findElementByXPath("(//a[text()='Furniture'])[1]");
			builder.moveToElement(ele1).perform();
			Thread.sleep(500);
			driver.findElementByXPath("(//a[text()='Office Chairs'])").click();
			Thread.sleep(1000);
			
//			3) click Executive Chairs
			driver.findElementByXPath("(//h5[text()='Executive Chairs'])").click();
			Thread.sleep(1000);
			
//			4) Change the minimum Height as 50 in under Dimensions
			driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").clear();
			driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys("50",Keys.ENTER);
			Thread.sleep(1000);
			
//			5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
			driver.findElementByXPath("//a[text()='Poise Executive Chair in Black Colour']//ancestor::div[@class='clip-dtl-ttl row']/following-sibling::div[@class='row clip-dtl-brand']//a[@id='clip_wishlist_']").click();
			Thread.sleep(1000);
			
//			6) Mouseover on Homeware and Click Pressure Cookers under Cookware
			WebElement ele2 = driver.findElementByXPath("(//a[text()='Homeware'])[1]");
			builder.moveToElement(ele2).perform();
			Thread.sleep(500);
			driver.findElementByXPath("(//a[text()='Pressure Cookers'])").click();
			Thread.sleep(1000);
			
//			7) Select Prestige as Brand
			driver.findElementByXPath("//li[@data-search='Prestige']//label[text()='Prestige']").click();
			Thread.sleep(2000);
			
//			8) Select Capacity as 1-3 Ltr
			driver.findElementByXPath("(//label[text()='1 Ltr - 3 Ltr'])[1]").click();
			Thread.sleep(3000);
			
//			9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
			WebElement ckr = driver.findElementByXPath("(//a[text()='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']//ancestor::div[@class='clip-dtl-ttl row']/following-sibling::div[@class='row clip-dtl-brand']//a[@id='clip_wishlist_'])");
			builder.moveToElement(ckr).perform();
			ckr.click();
			Thread.sleep(1000);
			
//			10) Verify the number of items in Wishlist
			String cnt = driver.findElementByXPath("//div[@class='wishlist_bar']//span").getText();
			int cntt = Integer.parseInt(cnt);
			System.out.println( "Count is : "+cnt);
			if (cntt== 2) System.out.println("Items match in wishlist : "+ cnt);
			else  System.out.println("Items not match in wishlist : "+ cnt);
			
//			11) Navigate to Wishlist
			driver.findElementByXPath("//div[@class='wishlist_bar']//a").click();
			Thread.sleep(1000);
			
//			12) Move Pressure Cooker only to Cart from Wishlist
			WebElement cart = driver.findElementByXPath("//a[contains(text(),'Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr')]//ancestor::div[@class='item_details']//a[text()='Add to Cart']");
			builder.moveToElement(cart).perform();
			builder.click(cart).perform();
			Thread.sleep(1000);
			
//			13) Check for the availability for Pincode 600128
			driver.findElementByXPath("//span[text()='Showing availability at']/following-sibling::input").sendKeys("600126");
			Thread.sleep(1000);
			driver.findElementByXPath("//a[text()='Check']").click();
			Thread.sleep(1000);
			
//			14) Click Proceed to Pay Securely
			driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
			Thread.sleep(3000);
			
//			15 Click Proceed to Pay
			
//			16) Capture the screenshot of the item under Order Item
			WebElement ele4 = driver.findElementByXPath("//a[@class='ck-pro-img-link']/img");
			File src = ele4.getScreenshotAs(OutputType.FILE);
			File dst = new File("./snaps/Cooker.jpg");
			FileUtils.copyFile(src, dst);
			
//			17) Close the browser
			driver.close();
			
			System.out.println(" *** Program Ends ***");
	}

}
