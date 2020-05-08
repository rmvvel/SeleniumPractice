package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC012Carwale extends ProjectSpecificMethods  {

	public static void main(String[] args) throws IOException, InterruptedException {

//		1) Go to https://www.carwale.com/
			String URL = "https://www.carwale.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.killprocess(true,false,true);
			psm.launch(URL);
			
//		2) Click on Used
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement ele1 = driver.findElementByXPath("//li[@data-tabs='usedCars']");
			wait.until(ExpectedConditions.elementToBeClickable(ele1));
			ele1.click();
			
//		3) Select the City as Chennai
			WebElement ele2 = driver.findElementByXPath("//input[@id='usedCarsList']");
			wait.until(ExpectedConditions.elementToBeClickable(ele2));
			ele2.sendKeys("Chennai");
			Thread.sleep(500);
			driver.findElementByXPath("//strong[text()='Chennai']").click();
			
//		4) Select budget min (8L) and max(12L) and Click Search
			WebElement ele3 = driver.findElementByXPath("//input[@id='minInput']");
			wait.until(ExpectedConditions.elementToBeClickable(ele3));
			ele3.sendKeys("8");
			WebElement ele4 = driver.findElementByXPath("//input[@id='maxInput']");
			ele4.sendKeys("12");
			driver.findElementByXPath("//div[@id='usedCars']//button[contains(text(),'Search')]").click();
			
//		5) Select Cars with Photos under Only Show Cars With
			WebElement ele5 = driver.findElementByXPath("//span[text()='Cars with Photos']/parent::li");
			wait.until(ExpectedConditions.elementToBeClickable(ele5));
			ele5.click();
			
//		6) Select Manufacturer as "Hyundai" --> Creta
			WebElement ele6 = driver.findElementByXPath("//span[text()=' Hyundai ']/parent::li");
			wait.until(ExpectedConditions.elementToBeClickable(ele6));
			builder.moveToElement(ele6).perform();
			ele6.click();
			
			WebElement ele7 = driver.findElementByXPath("//span[text()='Creta']/parent::li");
			wait.until(ExpectedConditions.elementToBeClickable(ele7));
			ele7.click();
			
//		7) Select Fuel Type as Petrol
			WebElement ele8 = driver.findElementByXPath("//div[@name='fuel']");
			wait.until(ExpectedConditions.elementToBeClickable(ele8));
			ele8.click();
			
			WebElement ele9 = driver.findElementByXPath("//span[text()='Petrol']/parent::li");
			wait.until(ExpectedConditions.elementToBeClickable(ele9));
			ele9.click();
			
//		8) Select Best Match as "KM: Low to High"
			WebElement ele10 = driver.findElementByXPath("//select[@id='sort']");
			wait.until(ExpectedConditions.elementToBeClickable(ele10));
			Select options = new Select(ele10);
			options.selectByVisibleText("KM: Low to High");
			Thread.sleep(5000);
			
//		9) Validate the Cars are listed with KMs Low to High
			List<WebElement> km = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
			int[] arr1 = new int[km.size()];
			int[] arr2 = new int[km.size()];
			for (int i = 0; i < km.size();i++)
			{
				String kmval = (km.get(i).getText().replaceAll(" km", "")).replaceAll(",", "");
				System.out.println("Km : "+kmval);
				
				arr1[i] = Integer.parseInt(kmval);
				arr2[i] = Integer.parseInt(kmval);
			}
			
			Arrays.sort(arr2);
			
			for (int i = 0; i< arr1.length; i++)
			{
				if (arr1[i] == arr2[i]) System.out.println("Values matches : " + arr1[i] + " - "+arr2[i]);
				else System.out.println("Values not matches : " + arr1[i] + " - "+arr2[i]);
			}
			
//		10) Add the least KM ran car to Wishlist
			for (int i = 0; i < km.size();i++)
			{
				String kmval = (km.get(i).getText().replaceAll(" km", "")).replaceAll(",", "");
				System.out.println("Km : "+kmval);
				if (Integer.parseInt(kmval) == arr2[0])
				{
					driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])["+ (i+1) + "]").click();
					Thread.sleep(2000);
				}
				
			}
//		11) Go to Wishlist and Click on More Details
			driver.findElementByXPath("//li[@class='action-box shortlistBtn']").click();
			
			WebElement ele12 = driver.findElementByXPath("//a[text()='More details »']");
			wait.until(ExpectedConditions.elementToBeClickable(ele12));
			ele12.click();
			Thread.sleep(5000);
			
//		12) Print all the details under Overview
			Set<String> winL = driver.getWindowHandles();
			List<String> winH = new ArrayList<String>(winL);
			
			driver.switchTo().window(winH.get(1));
			
			List<WebElement> overview = driver.findElementsByXPath("//div[@id='overview']//li");
			
			for(int i =0; i < overview.size();i++)
			{
				System.out.print(overview.get(i).findElement(By.xpath("//div[@class='equal-width text-light-grey']")).getText());
				System.out.print(" ---> ");
				System.out.print(overview.get(i).findElement(By.xpath("//div[@class='equal-width dark-text']")).getText());
				System.out.println();
			}
			
//		13) Close the browser.
//			driver.close();
//			driver.switchTo().window(winH.get(0));
//			driver.close();
			
			System.out.println(" *** Program Ends ***");
	}

}
