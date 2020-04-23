package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.api.ProjectSpecificMethods;

public class TC006BigBasket extends ProjectSpecificMethods{

	public static void main(String[] args) throws InterruptedException {
		
//			1) Go to https://www.bigbasket.com/
			String URL = "https://www.bigbasket.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			
//			2) mouse over on  Shop by Category 
			WebElement ele1 = driver.findElementByXPath("(//a[text()=' Shop by Category '])[1]");
			builder.moveToElement(ele1).perform();
			Thread.sleep(1000);
			
//			3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
			WebElement ele2 = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
			builder.moveToElement(ele2).perform();
			Thread.sleep(1000);
			WebElement ele3 = driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
			builder.moveToElement(ele3).perform();
			Thread.sleep(1000);
			
//			4) Click on Boiled & Steam Rice
			driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
			Thread.sleep(1000);
			
//			5) Choose the Brand as bb Royal
			driver.findElementByXPath("(//span[text()='bb Royal'])[1]").click();
			Thread.sleep(3000);
			
//			6) Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
			WebElement ele4 = driver.findElementByXPath("(((//a[text()='Ponni Boiled Rice - Super Premium']//parent::div)//following-sibling::div)[1])//button/i");
			builder.click(ele4).perform();
			Thread.sleep(1000);
			
			WebElement ele5 = driver.findElementByXPath("(((((//a[text()='Ponni Boiled Rice - Super Premium']//parent::div)//following-sibling::div)[1])//button)//following-sibling::ul)//span[contains(text(),'5 kg')]");
			builder.click(ele5).perform();
			Thread.sleep(1000);
			
//			7) print the price of Rice
			int ricePrice = Integer.parseInt(driver.findElementByXPath("(((//a[text()='Ponni Boiled Rice - Super Premium']//parent::div)//following-sibling::div)[2])//span[@class='discnt-price']/span").getText());
			System.out.println("Price of Rice : "+ricePrice);
			
//			8) Click Add button
			driver.findElementByXPath("(((//a[text()='Ponni Boiled Rice - Super Premium']//parent::div)//following-sibling::div)[2])//button[text()='Add ']").click();
//			Thread.sleep(1000);
			
//			9) Verify the success message displayed
			System.out.println(driver.findElementByXPath("//div[@class='toast toast-success']//div").getText());
			
//			10) Type Dal in Search field and enter
			driver.findElementByXPath("(//div[@class='input-group'])[1]/input").sendKeys("Dal",Keys.ENTER);
			Thread.sleep(5000);
			
//			12) Go to Toor/Arhar Dal and select 2kg & set Qty 2
			WebElement ele6 = driver.findElementByXPath("((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div)//following-sibling::div)[2]//input[@ng-model='vm.startQuantity']");
			ele6.clear();
			ele6.sendKeys("2");
			Thread.sleep(1000);
			
//			13) Print the price of Dal
			int dalPrice = Integer.parseInt(driver.findElementByXPath("(((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div)//following-sibling::div)[2])//span[@class='discnt-price']/span").getText());
			System.out.println("Dal price is : "+dalPrice);
			
//			14) Click Add button
			driver.findElementByXPath("(((//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div)//following-sibling::div)[2])//button[text()='Add ']").click();
//			Thread.sleep(500);
			System.out.println(driver.findElementByXPath("//div[@class='toast toast-success']//div").getText());
			
//			15) Mouse hover on My Basket
			WebElement ele7 = driver.findElementByXPath("//a[@qa='myBasket']");
			builder.moveToElement(ele7).perform();
			
//			16) Validate the Sub Total displayed for the selected items
			int total = Integer.parseInt(driver.findElementByXPath("//span[@ng-bind='vm.cart.cart_total']").getText());
			
			int total1 = ricePrice + (2 * dalPrice);
			
			if (total == total1) System.out.println("Total is matching : "+ total + " , " +total1);
			else System.out.println("Total is not matching : "+ total + " , " +total1);
			
//			17) Reduce the Quantity of Dal as 1 
			driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal')]//ancestor::div[contains(@class,'item-info')]/following-sibling::div)//button[1]").click();
			Thread.sleep(2000);
			
//			18) Validate the Sub Total for the current items
			total = Integer.parseInt(driver.findElementByXPath("//span[@ng-bind='vm.cart.cart_total']").getText());
			total1 = ricePrice + dalPrice;
			if (total == total1) System.out.println("Total is matching : "+ total + " , " +total1);
			else System.out.println("Total is not matching : "+ total + " , " +total1);
			
//			19) Close the Browser
			driver.close();
	}

}
