package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.api.ProjectSpecificMethods;

public class TC004Hp extends ProjectSpecificMethods{

	public static void main(String[] args) throws InterruptedException {
		
//			1) Go to https://store.hp.com/in-en/
			String URL = "https://store.hp.com/in-en/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			Thread.sleep(3000);
			driver.findElementByXPath("//button[text()='Accept Cookies']").click();
			Thread.sleep(3000);
			
			boolean frm = driver.findElementByXPath("//iframe[@name='ifr_edmpopup']").isDisplayed();
			
			if (frm == true) {
//				driver.switchTo().frame("ifr_edmpopup");
				driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
//				driver.switchTo().defaultContent();
			}
//			2) Mouse over on Laptops menu and click on Pavilion
			WebElement ele1 = driver.findElementByXPath("//a[@role='menuitem']/span[text()='Laptops']");
			builder.moveToElement(ele1).perform();
			driver.findElementByXPath("(//a[@role='menuitem']/span[text()='Pavilion'])[1]").click();
			Thread.sleep(7000);
			
//			3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
			
			
			driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
			driver.findElementByXPath("//span[text()='Intel Core i7']/parent::a/input").click();
			Thread.sleep(5000);
			
//			4) Hard Drive Capacity -->More than 1TB
			driver.findElementByXPath("//span[text()='More than 1 TB']/parent::a/input").click();
			Thread.sleep(3000);
			
//			5) Select Sort By: Price: Low to High
			WebElement sort = driver.findElementByXPath("(//select[@id='sorter'])[1]");
			Select drp = new Select(sort);
			drp.selectByValue("price_asc");
			Thread.sleep(3000);
			
//			6) Print the First resulting Product Name and Price
			String prdName = driver.findElementByXPath("(//li[@class='item product product-item'])[1]//a[@class='product-item-link']").getText();
			String price = driver.findElementByXPath("(//li[@class='item product product-item'])[1]//span[@data-price-type='finalPrice']").getText();
			price = price.replaceAll("\\D", "");
			System.out.println("Product Name : "+prdName + " Price : "+price);
			
//			7) Click on Add to Cart
			driver.findElementByXPath("(//li[@class='item product product-item'])[1]//span[text()='Add To Cart']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']").click();
			Thread.sleep(1000);
//			8) Click on Shopping Cart icon --> Click on View and Edit Cart
			driver.findElementByXPath("//a[@title='Shopping Cart']").click();
			driver.findElementByXPath("//span[text()='View and edit cart']").click();
			Thread.sleep(3000);
			
//			9) Check the Shipping Option --> Check availability at Pincode
			driver.findElementByXPath("//input[@name='pincode']").sendKeys("600126");
			driver.findElementByXPath("//button[@class='primary standard_delivery-button']").click();
			Thread.sleep(3000);
			
//			10) Verify the order Total against the product price
			String total = driver.findElementByXPath("//strong[text()='Order Total']//ancestor::tr//span").getText();
			total = total.replaceAll("\\D", "");
			System.out.println("Total price is : "+total);
			boolean matchFound = false;
			if (Integer.parseInt(price)==Integer.parseInt(total)) matchFound = true;
			else	System.out.println("Prices are not matching");
			
//			11) Proceed to Checkout if Order Total and Product Price matches
			if (matchFound == true) driver.findElementByXPath("(//button[@title='Proceed to Checkout'])[1]").click();
			Thread.sleep(7000);
			
//			12) Click on Place Order
			driver.findElementByXPath("//div[@class='place-order-primary']/button").click();
			Thread.sleep(3000);
			
//			13) Capture the Error message and Print
			String errmsg = driver.findElementByXPath("//div[@class='message notice']/span").getText();
			System.out.println("Error Message is : "+errmsg);
			
//			14) Close Browser
			driver.close();
			
			System.out.println(" *** Program Ends ***");
			
	}

}
