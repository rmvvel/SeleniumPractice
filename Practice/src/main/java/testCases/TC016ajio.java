package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC016ajio extends ProjectSpecificMethods{

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
	public static void main(String[] args) throws InterruptedException, IOException {
	
//	1) Go to https://www.ajio.com/
		TC016ajio tc = new TC016ajio();
		ProjectSpecificMethods psm = new ProjectSpecificMethods();
		psm.killprocess(true, false, false);
		psm.launch("https://www.ajio.com/shop/sale");
		Thread.sleep(4000);
		
		WebElement pop = driver.findElementByXPath("//button[text()='Allow Location']");
		if (pop.isDisplayed()) tc.clickElement(pop);
		
//	2) Enter Bags in the Search field and Select Bags in Women Handbags
		WebElement ele1 = driver.findElementByXPath("//input[@name='searchVal']");
		tc.typetext(ele1, "bag");
		Thread.sleep(200);
		tc.clickElement(driver.findElementByXPath("//button[@class='rilrtl-button']"));
		Thread.sleep(4000);
		tc.clickElement(driver.findElementByXPath("//input[@id='Women']/parent::div//label"));
		Thread.sleep(2000);
		tc.clickElement(driver.findElementByXPath("//input[@id='Women - Handbags']/parent::div//label"));
		Thread.sleep(2000);
		
//	3) Click on five grid and Select SORT BY as "What's New"
		tc.clickElement(driver.findElementByXPath("//div[@class='five-grid-container ']"));
		Thread.sleep(2000);
		
		WebElement ele2 = driver.findElementByXPath("//div[@class='filter-dropdown']");
		Select options = new Select(ele2);
		options.selectByVisibleText("What's New");
		Thread.sleep(2000);
		
//	4) Enter Price Range Min as 2000 and Max as 5000
		tc.clickElement(driver.findElementByXPath("//span[text()='price']"));
		tc.typetext(driver.findElementByXPath("//input[@id='minPrice']"), "2000");
		tc.typetext(driver.findElementByXPath("//input[@id='maxPrice']"), "5000");
		tc.clickElement(driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']"));
		Thread.sleep(2000);
		
//	5) Click on the product "Puma Ferrari LS Shoulder Bag"
		tc.clickElement(driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']"));
		Thread.sleep(3000);
		
		Set<String> winL = driver.getWindowHandles();
		List<String> winH = new ArrayList<String>(winL);
		driver.switchTo().window(winH.get(1));
		
//	6) Verify the Coupon code for the price above 2690 is applicable for your product, if applicable the get the Coupon Code and Calculate the discount price for the coupon
		WebElement ele3 = driver.findElementByXPath("//div[@class='promo-title']");
		if (ele3.isDisplayed())
		{
			String dicpr = driver.findElementByXPath("//div[@class='promo-discounted-price']//span").getText();
			int discp = Integer.parseInt(dicpr.replaceAll("\\D", ""));
			String orgprc = driver.findElementByXPath("//div[@class='prod-sp']").getText();
			int orgpc = Integer.parseInt(orgprc);
			int pay = orgpc - discp;
			System.out.println("Original amount is : " + orgpc);
			System.out.println("Discount amount is : " + discp);
			System.out.println("payable amount is : " + pay);
		}
		
//	7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
		tc.clickElement(driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']"));
		tc.typetext(driver.findElementByXPath("//input[@name='pincode']"), "560043");
		tc.clickElement(driver.findElementByXPath("//button[text()='CONFIRM PINCODE']"));
		
//	8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email
		tc.clickElement(driver.findElementByXPath("//div[text()='Other information']"));
		String info = driver.findElementByXPath("//span[text()='Customer Care Address']/parent::li/span[3]").getText();
		System.out.println("Customer care Info : "+info);
		
//	9) Click on ADD TO BAG and then GO TO BAG
		tc.clickElement(driver.findElementByXPath("//span[text()='ADD TO BAG']"));
		Thread.sleep(1000);
		tc.clickElement(driver.findElementByXPath("//span[text()='GO TO BAG']"));
		
//	10) Check the Order Total before apply coupon
		String ordttl1 = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
		System.out.println("Order Total : "+ordttl1);
		
//	11) Enter Coupon Code and Click Apply
		tc.typetext(driver.findElementByXPath("//input[@id='couponCodeInput']"), "EPIC");
		tc.clickElement(driver.findElementByXPath("//button[text()='Apply']"));
		
//	12) Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated in Product details
		String ordttl2 = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
		System.out.println("Order Total : "+ordttl2);
		
		int t1 = (int) Math.ceil(Double.parseDouble(ordttl1));
		int t2 = (int) Math.ceil(Double.parseDouble(ordttl2));
		
		if (t1 == t2) System.out.println("Amount matches : "+t1 + " : "+t2);
		else System.out.println("Amount not matches : "+t1 + " : "+t2);
		
//	13) Click on Delete and Delete the item from Bag
		tc.clickElement(driver.findElementByXPath("//div[@class='product-delete']/div"));
		tc.clickElement(driver.findElementByXPath("//div[text()='DELETE']"));
		
//	14) Close all the browsers
		driver.close();
		driver.switchTo().window(winH.get(0));
		driver.close();
		System.out.println(" *** Program Ends ***");
	}

}
