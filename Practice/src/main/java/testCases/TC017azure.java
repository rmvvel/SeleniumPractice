package testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC017azure extends ProjectSpecificMethods{
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
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }
	    return flag;
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {

//	Ref : https://github.com/TestLeafPages/Research/blob/master/PdfFileDownload.java
//	1) Go to https://azure.microsoft.com/en-in/
		TC017azure tc = new TC017azure();
		ProjectSpecificMethods psm = new ProjectSpecificMethods();
		psm.killprocess(true, false, false);
		psm.launch("https://azure.microsoft.com/en-in/");
		Thread.sleep(4000);
		
//	2) Click on Pricing
		tc.clickElement(driver.findElementByXPath("//a[@id='navigation-pricing']"));
		
//	3) Click on Pricing Calculator
		tc.clickElement(driver.findElementByXPath("//a[contains(text(),'Pricing calculator')]"));
		
//	4) Click on Containers
		tc.clickElement(driver.findElementByXPath("//button[text()='Containers']"));
		
//	5) Select Container Instances
		tc.clickElement(driver.findElementByXPath("(//span[@class='product']//span[text()='Container Instances'])[2]"));
		
//	6) Click on Container Instance Added View
		tc.clickElement(driver.findElementByXPath("//div[text()='Container Instances added.']//a"));
		
//	7) Select Region as "South India"
		WebElement rgn = driver.findElementByXPath("//select[@name='region']");
		Select actions = new Select(rgn);
		actions.selectByVisibleText("South India");
		Thread.sleep(3000);
//	8) Set the Duration as 180000 seconds
		WebElement dur = driver.findElementByXPath("//label[text()='Seconds']/parent::div/input");
		dur.clear();
		dur.sendKeys(Keys.CONTROL + "a");
		dur.sendKeys(Keys.DELETE);
		tc.typetext(dur, "180000");
		
//	9) Select the Memory as 4GB
		WebElement mem = driver.findElementByXPath("//select[@name='memory']");
		Select actions1 = new Select(mem);
		actions1.selectByVisibleText("4 GB");
		Thread.sleep(3000);
//	10) Enable SHOW DEV/TEST PRICING
		tc.clickElement(driver.findElementByXPath("//button[@id='devtest-toggler']"));
		
//	11) Select Indian Rupee  as currency
		WebElement curr = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select actions2 = new Select(curr);
		actions2.selectByValue("INR");
		
//	12) Print the Estimated monthly price
		String emp = driver.findElementByXPath("((//h3[text()='Estimated monthly cost']/ancestor::div[2]//div)[2]//span)[4]").getText();
		System.out.println("Estimated monthly price : "+emp);
		
//	13) Click on Export to download the estimate as excel
		tc.clickElement(driver.findElementByXPath("//h3[text()='Estimated monthly cost']/parent::div//button[text()='Export']"));
		Thread.sleep(3000);
		
//	14) Verify the downloded file in the local folder
		boolean fd1 = tc.isFileDownloaded("C:\\Users\\BM\\Downloads\\", "ExportedEstimate.xlsx");
		if (fd1) System.out.println("ExportedEstimate.xlsx - File Downloaded");
		else System.out.println("ExportedEstimate.xlsx - File not Downloaded");
		Thread.sleep(3000);
		
//	15) Navigate to Example Scenarios and Select CI/CD for Containers
		WebElement ele1 = driver.findElementByXPath("//a[text()='Example Scenarios']");
		builder.moveToElement(ele1).perform();
		builder.click(ele1).perform();
		
		tc.clickElement(driver.findElementByXPath("//button[@title='CI/CD for Containers']"));
		Thread.sleep(3000);
//	16) Click Add to Estimate
		WebElement ele2 = driver.findElementByXPath("//button[text()='Add to estimate']");
		builder.moveToElement(ele2).perform();
//		builder.click(ele2).perform();
		ele2.click();
		Thread.sleep(3000);
		
//	17) Change the Currency as Indian Rupee
		WebElement curr1 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		Select actions3 = new Select(curr1);
		actions3.selectByValue("INR");
		
//	18) Enable SHOW DEV/TEST PRICING
		tc.clickElement(driver.findElementByXPath("//button[@id='devtest-toggler']"));
		
//	19) Export the Estimate
		tc.clickElement(driver.findElementByXPath("//h3[text()='Estimated monthly cost']/parent::div//button[text()='Export']"));
		Thread.sleep(3000);
		
//	20) Verify the downloded file in the local folder
		boolean fd2 = tc.isFileDownloaded("C:\\Users\\BM\\Downloads\\", "ExportedEstimate (1).xlsx");
		if (fd2) System.out.println("ExportedEstimate (1).xlsx - File Downloaded");
		else System.out.println("ExportedEstimate (1).xlsx - File not Downloaded");
	}

}
