package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC011SnapDeal extends ProjectSpecificMethods{

	public static void main(String[] args) throws IOException, InterruptedException {

//		1) Go to https://www.snapdeal.com/
			String URL = "https://www.snapdeal.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
//			psm.killprocess(true,true,true);
			psm.launch(URL);
			
//		2) Mouse hover on Toys, Kids Fashion & more and click on Toys
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement ele1 = driver.findElementByXPath("//span[text()=\"Toys, Kids' Fashion & more\"]");
			wait.until(ExpectedConditions.elementToBeClickable(ele1));
			builder.moveToElement(ele1).perform();
			
//		3) Click Educational Toys in Toys & Games
			WebElement ele2 = driver.findElementByXPath("//span[text()='Educational Toys']");
			wait.until(ExpectedConditions.elementToBeClickable(ele2));
			ele2.click();
			Thread.sleep(5000);
			
//		4) Click the customer rating 4 star up
			WebElement ele3 = driver.findElementByXPath("//label[@for='avgRating-4.0']");
			wait.until(ExpectedConditions.elementToBeClickable(ele3));
			ele3.click();
			Thread.sleep(3000);
			
//		5) Click the offer as 40-50
			WebElement ele4 = driver.findElementByXPath("//a[text()=' 40 - 50']/parent::label");
			wait.until(ExpectedConditions.elementToBeClickable(ele4));
			ele4.click();
			Thread.sleep(3000);
			
//		6) Check the availability for the pincode
			WebElement ele5 = driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/input");
			wait.until(ExpectedConditions.elementToBeClickable(ele5));
			ele5.sendKeys("620014");
			driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/button").click();
			Thread.sleep(3000);
			
//		7) Click the Quick View of the first product
			WebElement ele6 = driver.findElementByXPath("(//picture[@class='picture-elem'])[1]");
			wait.until(ExpectedConditions.elementToBeClickable(ele6));
			builder.moveToElement(ele6).perform();
			driver.findElementByXPath("(//picture[@class='picture-elem'])[1]/ancestor::div[@class='product-tuple-image ']//div[contains(text(),'Quick View')]").click();
			Thread.sleep(2000);
			
//		8) Click on View Details
			driver.findElementByXPath("//a[contains(text(),'view details')]").click();
			Thread.sleep(2000);
			
//		9) Capture the Price of the Product and Delivery Charge
			String price = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
			System.out.println("Price is : "+price);
			
//		10) Validate the You Pay amount matches the sum of (price+deliver charge)
			
//		11) Search for Sanitizer
			WebElement ele7 = driver.findElementByXPath("//input[@id='inputValEnter']");
			wait.until(ExpectedConditions.elementToBeClickable(ele7));
			ele7.sendKeys("Sanitizer");
			Thread.sleep(500);
			ele7.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			
//		12) Click on Product "BioAyurveda Neem Power Hand Sanitizer"
			driver.findElementByXPath("//p[contains(text(),'BioAyurveda Neem Power  Hand Sanitizer')]").click();
			Thread.sleep(3000);
			
//		13) Capture the Price and Delivery Charge
			Set<String> winH = driver.getWindowHandles();
			List<String> winL= new ArrayList<String>(winH);
			driver.switchTo().window(winL.get(1));
			String price1 = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
			System.out.println("Price of Sanitizer is : "+price1);
			
//		14) Click on Add to Cart
			driver.findElementByXPath("(//span[text()='ADD TO CART'])[1]").click();
			Thread.sleep(3000);
//		15) Click on Cart 
			driver.findElementByXPath("//div[@class='cartInner']").click();
			Thread.sleep(3000);
			
//		16) Validate the Proceed to Pay matches the total amount of both the products
			
//		17) Close all the windows
			driver.close();
			driver.switchTo().window(winL.get(0));
			driver.close();
			System.out.println(" *** Program Ends ***");
	}

}
