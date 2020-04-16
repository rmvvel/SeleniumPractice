package testCases;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import base.api.ProjectSpecificMethods;

public class TC002Nykaa extends ProjectSpecificMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//			1) Go to https://www.nykaa.com/
			String URL = "https://www.nykaa.com/";
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--disable-notifications");
//			System.setProperty ("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//			ChromeDriver driver = new ChromeDriver(options);
//			driver.get(URL);
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			
//			2) Mouseover on Brands and Mouseover on Popular
//			Actions builder = new Actions(driver);
			WebElement ele1 = driver.findElementByXPath("//a[text()='brands']");
			builder.moveToElement(ele1).perform();
			Thread.sleep(1000);
			
//			3) Click L'Oreal Paris
			driver.findElementByXPath("(//a[contains(text(),'Oreal Paris')])[1]").click();
			Thread.sleep(7000);
			
//			4) Go to the newly opened window and check the title contains L'Oreal Paris
			String title = driver.getTitle();
			if (title.contains("L'Oreal Paris")){
				System.out.println("L'Oreal Paris is present");
			}
			else
			{
				System.out.println("L'Oreal Paris is not present");
			}
//			5) Click sort By and select customer top rated
			driver.findElementByXPath("//div[@class='sort-btn clearfix']").click();
			Thread.sleep(1000);
			driver.findElementByXPath("//span[text()='customer top rated']//following-sibling::div").click();
			Thread.sleep(7000);
			
//			6) Click Category and click Shampoo
			driver.findElementByXPath("//div[@class='filter-sidebar clearfix boundary-top']//div[text()='Category']").click();
			Thread.sleep(5000); 
			System.out.println("Before Checking 1st "+ driver.findElementByXPath("(//span[contains(text(),'Shampoo')]/ancestor::div[@class='control-box'])[1]/input").isSelected());
			System.out.println("Before Checking 2nd "+ driver.findElementByXPath("(//span[contains(text(),'Shampoo')]/ancestor::div[@class='control-box'])[2]/input").isSelected());
			driver.findElementByXPath("((//div[@class='filter-options-list active']//span[contains(text(),'Shampoo')])[1])//following-sibling::div").click();
			Thread.sleep(5000);
			driver.findElementByXPath("((//div[@class='filter-options-list active']//span[contains(text(),'Shampoo')])[2])//following-sibling::div").click();
			Thread.sleep(5000);
			
//			7) check whether the Filter is applied with Shampoo
			boolean chkbx1 = driver.findElementByXPath("(//span[contains(text(),'Shampoo')]/ancestor::div[@class='control-box'])[1]/input").isSelected();
			boolean chkbx2 = driver.findElementByXPath("(//span[contains(text(),'Shampoo')]/ancestor::div[@class='control-box'])[2]/input").isSelected();
			System.out.println("After Checking 1st "+ chkbx1);
			System.out.println("After Checking 2nd "+ chkbx2);
			if (chkbx1 == true) System.out.println("Shampoo is selected");
			else System.out.println("Shampoo is not selected");
			if (chkbx2 == true) System.out.println("Shampoo is selected");
			else System.out.println("Shampoo is not selected");
			
//			8) Click on L'Oreal Paris Colour Protect Shampoo
			driver.findElementByXPath("//span[text()=\"L'Oreal Paris Colour Protect Shampoo\"]").click();
			Thread.sleep(5000);
			
//			9) GO to the new window and select size as 175ml
			Set <String> winSet = driver.getWindowHandles();
			List <String> winLis = new ArrayList<String>(winSet);
			driver.switchTo().window(winLis.get(1));
			
			driver.findElementByXPath("//span[text()='175ml']").click();
			
//			10) Print the MRP of the product
			String mrp = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
			System.out.println("MRP is "+ mrp.replaceAll("\\D", ""));
			
//			11) Click on ADD to BAG
			driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();
			Thread.sleep(2000);
			
//			12) Go to Shopping Bag
			driver.findElementByXPath("//div[@class='AddBagIcon']").click();
			Thread.sleep(3000);
			
//			13) Print the Grand Total amount
			String grandTotal = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
			System.out.println("Grand Total is : "+grandTotal.replaceAll("\\D", ""));
			
//			14) Click Proceed
			driver.findElementByXPath("//span[text()='Proceed']").click();
			Thread.sleep(4000);
			
//			15) Click on Continue as Guest
			driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
			Thread.sleep(2000);
			
//			16) Print the warning message (delay in shipment)
			String wrngmsg = driver.findElementByXPath("//div[@class='message']").getText();
			System.out.println(wrngmsg);
			
//			17) Close all windows
			driver.close();
			driver.switchTo().window(winLis.get(0));
			driver.close();
			
			System.out.println(" *** Program Ends ***");
	}

}
