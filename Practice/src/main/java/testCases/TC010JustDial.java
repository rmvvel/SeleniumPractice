package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC010JustDial extends ProjectSpecificMethods  {

	public static void main(String[] args) throws InterruptedException, IOException{
		
//		1) https://www.justdial.com/
			String URL = "https://www.justdial.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.killprocess(true, false, true);
			psm.launch(URL);
//			implicit wait and delete chromedriver at start of execution
			Thread.sleep(5000);
			
//		2) Set the Location as Chennai
			WebElement ele1 = driver.findElementByXPath("//input[@id='city']");
			ele1.click();
			ele1.sendKeys("Chennai");
			Thread.sleep(1000);
			driver.findElementByXPath("//li[@id='Chennai']").click();
			Thread.sleep(1000);

			
//		3) Click Auto Care in the left menu
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement ele2 = driver.findElementByXPath("//span[text()='Auto care']");
			wait.until(ExpectedConditions.elementToBeClickable(ele2));
			ele2.click();
			
//		4) Click Car Repair
			WebElement ele3 = driver.findElementByXPath("//span[text()='Car Repair']");
			wait.until(ExpectedConditions.elementToBeClickable(ele3));
			ele3.click();
			
//		5) Click Car Brand as Hyundai
			WebElement ele4 = driver.findElementByXPath("//span[@class='redstr']//following-sibling::span[text()='Hyundai']");
			ele4.click();
			
//		6) Click Make as Hyundai Xcent
			WebElement ele5 = driver.findElementByXPath("//span[@class='redstr']//following-sibling::span[text()='Hyundai Xcent']");
			builder.moveToElement(ele5).perform();
			builder.click(ele5).perform();
//			ele5.click();
			Thread.sleep(4000);
			
////		7) Click on Location and Enter Porur
//			WebElement pop = driver.findElementByXPath("//section[@id='best_deal_div']//span[text()='X']");
//			if (pop.isDisplayed()) pop.click();
//			Thread.sleep(400);
//			driver.findElementByXPath("//li[@id='location']//a").click();
//			Thread.sleep(400);
//			
////		8) Select Porur from the dropdown list
//			driver.findElementByXPath("//input[@id='sortbydist']").sendKeys("Porur");
//			Thread.sleep(400);
//			WebElement pl = driver.findElementByXPath("(//span[@id='sbd']//a)[1]");
//			builder.click(pl).perform();
//			Thread.sleep(1400);
//			
////		9) Select Distance starting from 1 km
//			driver.findElementByXPath("//li[@id='distance']").click();
//			Thread.sleep(400);
//			WebElement dt = driver.findElementByXPath("//li[@id='distance']/span/a[text()='1 km']");
//			builder.click(dt).perform();
//			Thread.sleep(1400);
			
//		10) Identify all the Service Center having Ratings >=4.5 and Votes >=50
			List<WebElement> li = driver.findElementsByXPath("//li[@class='cntanr']");
			Map<String,String> service = new HashMap<String,String>();
			
			for (int i = 0; i < li.size();i++)
			{
				
				String name = li.get(i).findElement(By.tagName("h2")).getText();
//				System.out.println("Name is : " + name);
				WebElement el = driver.findElementByXPath("((//li[@class='cntanr'])["+ (i+1) +"])//p[@class='newrtings ']/a/span[1]");
//						li.get(i).findElement(By.xpath("//p[@class='newrtings ']/a/span[1]"));
//				 System.out.println("Rating is : " + el.getText());
				 double rt = Double.parseDouble(el.getText());
				 WebElement el2 = driver.findElementByXPath("((//li[@class='cntanr'])["+ (i+1) +"])//p[@class='newrtings ']//span[@class='rt_count lng_vote']");
//						 li.get(i).findElement(By.xpath("//p[@class='newrtings ']//span[@class='rt_count lng_vote']"));
//				 System.out.println("Vote is : " + el2.getText());
				  int vote = Integer.parseInt(el2.getText().replaceAll(" Votes", ""));
				
				  if (rt >= 4.5d  && vote >=50) {
					  System.out.println("");
					  System.out.print("Name is : " + name);
					  System.out.print(" --- Rating is : " + rt);
					  System.out.print(" --- Vote is : " + vote);
					  service.put(name, "");
				  }
				  
			}
			
//		11) Save all the Service Center name and Phone number matching the above condition in excel
			for (Entry<String, String> eachEntry: service.entrySet())
			{
				eachEntry.getKey();
				eachEntry.getValue();
			}
			
//		12) Close the browser
//			driver.close();
			System.out.println(" *** Program Ends ***");
	}

}
