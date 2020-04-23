package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.api.ProjectSpecificMethods;

public class TC007Honda extends ProjectSpecificMethods {

	public static void main(String[] args) throws InterruptedException {

//			1) Go to https://www.honda2wheelersindia.com/
			String URL = "https://www.honda2wheelersindia.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			Thread.sleep(5000);
			WebElement elep = driver.findElementByXPath("//div[@class='modal-body']//button");
			if (elep.isDisplayed() == true) elep.click();
			Thread.sleep(500);
			
//			2) Click on scooters and click dio
			driver.findElementByXPath("//a[@id='link_Scooter']").click();
			Thread.sleep(500);
			
			driver.findElementByXPath("//img[contains(@src,'dioBS6-icon')]").click();
			Thread.sleep(500);
			
//			3) Click on Specifications and mouseover on ENGINE
			driver.findElementByXPath("//a[text()='Specifications']").click();
			Thread.sleep(500);
			WebElement ele1 = driver.findElementByXPath("//a[text()='ENGINE']");
			builder.moveToElement(ele1).perform();
			Thread.sleep(500);
			
//			4) Get Displacement value
			String displdio = driver.findElementByXPath("//span[text()='Displacement']//following-sibling::span").getText();
			String scname = "Dio";
			System.out.println(displdio);
			
//			5) Go to Scooters and click Activa 125
			driver.findElementByXPath("//a[@id='link_Scooter']").click();
			Thread.sleep(500);
			driver.findElementByXPath("//img[contains(@src,'activa-125new-icon')]").click();
			Thread.sleep(500);
			
//			6) Click on Specifications and mouseover on ENGINE
			driver.findElementByXPath("//a[text()='Specifications']").click();
			Thread.sleep(500);
			WebElement ele2 = driver.findElementByXPath("//a[text()='ENGINE']");
			builder.moveToElement(ele2).perform();
			Thread.sleep(500);
			
//			7) Get Displacement value
			String dispactiva125 = driver.findElementByXPath("//span[text()='Displacement']//following-sibling::span").getText();
			String scname1 = "Activa 125 New";
			System.out.println(dispactiva125);
			
//			8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
			displdio = (displdio.replaceAll(" ", "")).replaceAll("cc", "");
			dispactiva125 = (dispactiva125.replaceAll(" ", "")).replaceAll("cc", "");
			
			float val1 = Float.parseFloat(displdio);
			float val2 = Float.parseFloat(dispactiva125);
			
			System.out.println(scname + " displacement is : "+val1 );
			System.out.println(scname1 + " displacement is : "+val2 );
			
			if (val1 > val2) System.out.println("Scooter Name is : "+scname);
			else System.out.println("Scooter Name is : "+scname1);
			
//			9) Click FAQ from Menu 
			driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();
			Thread.sleep(1500);
			
//			10) Click Activa 125 BS-VI under Browse By Product
			driver.findElementByXPath("(//a[text()='Activa 125 BS-VI'])").click();
			Thread.sleep(1500);
			
//			11) Click  Vehicle Price 
			driver.findElementByXPath("(//a[text()=' Vehicle Price'])").click();
			Thread.sleep(1500);
			
//			12) Make sure Activa 125 BS-VI selected and click submit
			WebElement ele3 = driver.findElementByXPath("//select[@id='ModelID6']");
			Select options = new Select(ele3);
			String opt = options.getFirstSelectedOption().getText();
			System.out.println("Selected option is : "+ opt);
			if (opt.contentEquals("Activa 125 BS-VI")) System.out.println("Activa 125 BS-VI is selected");
			else System.out.println("Activa 125 BS-VI is not selected");
			
			driver.findElementByXPath("(//button[text()='Submit'])[6]").click();
			Thread.sleep(1500);
			
//			13) click the price link
			driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
			Thread.sleep(1500);
			
//			14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
			Set<String> winH = driver.getWindowHandles();
			List <String>winL = new ArrayList<String>(winH);
			driver.switchTo().window(winL.get(1));
			
			WebElement ele4 = driver.findElementByXPath("//select[@name='StateID']");
			Select opt1 = new Select(ele4);
			opt1.selectByVisibleText("Tamil Nadu");
			Thread.sleep(500);
			
			WebElement ele5 = driver.findElementByXPath("//select[@name='CityID']");
			Select opt2 = new Select(ele5);
			opt2.selectByVisibleText("Chennai");
			Thread.sleep(500);
			
//			15) Click Search
			driver.findElementByXPath("//button[text()='Search']").click();
			Thread.sleep(1500);
			
//			16) Print all the 3 models and their prices
			List<WebElement> trow = driver.findElementsByXPath("//table[@id='gvshow']//tbody/tr");
			
			for (int i = 0; i < trow.size();i++)
			{
				WebElement trr = trow.get(i);
				List<WebElement> tcol = trr.findElements(By.tagName("td"));
				
				for (int j = 0; j < tcol.size();j++)
				{
					if (tcol.get(j).getText().equalsIgnoreCase("Chennai") == false) 
						System.out.print(tcol.get(j).getText() + " --- " );
				}
				System.out.println("");
			}
		
//			17) Close the Browser
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(winL.get(0));
			driver.close();
	}

}
