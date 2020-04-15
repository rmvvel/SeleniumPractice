package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TC001 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//			1) Open https://www.myntra.com/
			String URL = "https://www.myntra.com/";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty ("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver(options);
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//			2) Mouse over on WOMEN (Actions -> moveToElement
			WebElement ele = driver.findElementByXPath("(//a[text()='Women'])[1]");
			Actions builder = new Actions(driver);
			builder.moveToElement(ele).perform();
			
//			3) Click Jackets & Coats
			driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
			Thread.sleep(5000);
			
//			4) Find the total count of item (top) -> getText -> String
//
//				 String str = driver.findElementByClassName("title-count").getText();
//				 split, 
//				 String text = str.replaceAll("\\D","") -> String
//				 Integer.parseInt(text) -> int
			String str = driver.findElementByXPath("//span[@class='title-count']").getText();
			System.out.println(str);
			String txt = str.replaceAll("\\D", "");
			int total = Integer.parseInt(txt);
			
//			5) Validate the sum of categories count matches
			List<WebElement> category = driver.findElementsByXPath("//span[@class='categories-num']");
			int sum = 0;
			for(int i = 0;i < category.size();i++)
			{
				sum = Integer.parseInt(category.get(i).getText());
			}
			
			if (sum == total) System.out.println("Matching : Sum is " + sum + " , Total is : " + total);
			else System.out.println("Not Matching : Sum is " + sum + " , Total is : " + total);
//			6) Check Coats
			driver.findElementByXPath("//input[@value='Coats']//following-sibling::div").click();
			
//			7) Click + More option under BRAND
			driver.findElementByXPath("//div[@class='brand-more']").click();
			Thread.sleep(3000);
			
//			8) Type MANGO and click checkbox
			String brandName = "Mango";
			driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys(brandName);
			Thread.sleep(2000);
			driver.findElementByXPath("//label[@class=' common-customCheckbox']//following-sibling::div").click();
			
//			9) Close the pop-up x
			driver.findElementByClassName("myntraweb-sprite FilterDirectory-close sprites-remove").click();
			
//			10) Confirm all the Coats are of brand MANGO
//			    findElements (brand) -> List<WebElement> 
//			    foreach -> getText of each brand 
//			    compare > if(condition)
			List<WebElement> brand = driver.findElementsByXPath("//h3[@class='product-brand']");
			
			for(int i=0;i<brand.size();i++)
			{
				if (brand.get(i).getText().equalsIgnoreCase(brandName)){
					System.out.println(i + " - is matching");
				}
				else
				{
					System.out.println(i + " - is not matching");
				}
			}
			
//			11) Sort by Better Discount
			WebElement ele1 = driver.findElementByXPath("//div[@class='sort-sortBy']");
			builder.moveToElement(ele1).perform();
			driver.findElementByXPath("(//label[@class='sort-label '])[3]").click();
			Thread.sleep(5000);
			
//			12) Find the price of first displayed item
//			     findElements (price) -> List<WebElement> 
//			     get(0) -> WebElement -> getText -> String -> int
			List<WebElement> price = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
			System.out.println("Price is : " + price.get(0).getText());
			
//			13) Mouse over on size of the first item
			WebElement ele2 = driver.findElementByXPath("(//h3[@class='product-brand'])[1]");
			builder.moveToElement(ele2).perform();
			Thread.sleep(1000);
			WebElement ele3 = driver.findElementByXPath("(//span[@class='product-sizeNoInventoryPresent'])[4]");
			builder.moveToElement(ele3).perform();
			
//			14) Click on WishList Now
			driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
			Thread.sleep(7000);
//			15) Close Browser
			driver.close();
	}

}
