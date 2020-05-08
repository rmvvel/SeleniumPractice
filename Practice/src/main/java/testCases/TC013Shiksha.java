package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.api.ProjectSpecificMethods;

public class TC013Shiksha extends ProjectSpecificMethods{

	public static void main(String[] args) throws IOException, InterruptedException {
		
//		1) Go to https://studyabroad.shiksha.com/
			String URL = "https://studyabroad.shiksha.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.killprocess(true, true, true);
			psm.launch(URL);
			
//		2) Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement ele1 = driver.findElementByXPath("//div[@class='lgn-section']//label[text()='Colleges ']");
			wait.until(ExpectedConditions.elementToBeClickable(ele1));
			builder.moveToElement(ele1).perform();
			
			WebElement ele2 = driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']");
			wait.until(ExpectedConditions.elementToBeClickable(ele2));
			ele2.click();
			
//		3) Select GRE under Exam Accepted and Score 300 & Below
			WebElement ele3 = driver.findElementByXPath("//p[text()='GRE']/parent::label/span");
			wait.until(ExpectedConditions.elementToBeClickable(ele3));
			ele3.click();
			
			WebElement okbtn = driver.findElementByXPath("//div[@class='tar']/a");
			wait.until(ExpectedConditions.elementToBeClickable(okbtn));
			if (okbtn.isDisplayed()) okbtn.click();
			
			WebElement ele4 = driver.findElementByXPath("//p[text()='GRE']/parent::label/parent::li//select");
			Thread.sleep(3000);
			Select options = new Select(ele4);
			options.selectByVisibleText("300 & below");
			Thread.sleep(4000);
			
//		4) Max 10 Lakhs under 1st year Total fees, USA under countries
			WebElement ele5 = driver.findElementByXPath("//p[text()='Max 10 Lakhs']/parent::label");
			wait.until(ExpectedConditions.elementToBeClickable(ele5));
			ele5.click();
//			builder.click(ele5).perform();
			Thread.sleep(4000);
			
			WebElement ele6 = driver.findElementByXPath("//a[text()='USA']/ancestor::label");
			wait.until(ExpectedConditions.elementToBeClickable(ele6));
//			builder.click(ele6).perform();
			ele6.click();
			Thread.sleep(4000);
			
//		5) Select Sort By: Low to high 1st year total fees
			WebElement ele7 = driver.findElementByXPath("//select[@id='categorySorter']");
			wait.until(ExpectedConditions.elementToBeClickable(ele7));
			Select options1 = new Select(ele7);
			options1.selectByVisibleText("Low to high 1st year total fees");
			
//		6) Click Add to compare of the College having least fees with Public University, Scholarship and Accomadation
			List<WebElement> clgs = driver.findElementsByXPath("//div[@class='uni-course-details flLt']//div[3]");
			
			for (int i =0; i< clgs.size(); i++)
			{
				List<WebElement> ptag = clgs.get(i).findElements(By.tagName("p"));
				if ((ptag.get(0).getAttribute("class")).equalsIgnoreCase("non-available") 
							|| (ptag.get(0).getAttribute("class")).equalsIgnoreCase("non-available") 
							|| (ptag.get(0).getAttribute("class")).equalsIgnoreCase("non-available"))
				{
					
				}
				else 
				{
					driver.findElementByXPath("(//p[text()='Add to compare'])["+(i+1)+"]").click();
					Thread.sleep(3000);
					break;
				}
			}
			
//		7) Select the first college under Compare with similar colleges
			driver.findElementByXPath("//ul[@class='sticky-suggestion-list']//li[1]//span").click();
			Thread.sleep(1000);
			
//		8) Click on Compare College>
			driver.findElementByXPath("//strong[text()='Compare Colleges >']").click();
			Thread.sleep(3000);
			
//		9) Select When to Study as 2021
			driver.findElementByXPath("//strong[text()='2021']/ancestor::label/span").click();
			Thread.sleep(3000);
			
//		10) Select Preferred Countries as USA
			driver.findElementByXPath("//div[text()='Preferred Countries']").click();
			Thread.sleep(1000);
			driver.findElementByXPath("//input[contains(@id,'USA_')]/parent::div//span").click();
			Thread.sleep(1000);
			
//		11) Select Level of Study as Masters
			driver.findElementByXPath("//strong[text()='Masters']/ancestor::label/span").click();
			Thread.sleep(3000);
			
//		12) Select Preferred Course as MS
			driver.findElementByXPath("//div[text()='Preferred Course']").click();
			Thread.sleep(1000);
			driver.findElementByXPath("//li[text()='MS']").click();
			Thread.sleep(1000);
			
//		13) Select Specialization as "Computer Science & Engineering"
			driver.findElementByXPath("//div[text()='All specializations']").click();
			Thread.sleep(1000);
			WebElement cse = driver.findElementByXPath("//li[text()='Computer Science & Engineering']");
			builder.moveToElement(cse).perform();
			Thread.sleep(100);
			cse.click();
			Thread.sleep(1000);
			
//		14) Click on Sign Up
			driver.findElementByXPath("//a[@id='signup']").click();
			Thread.sleep(3000);
			
//		15) Print all the warning messages displayed on the screen for missed mandatory fields
			String txt;
			List<WebElement> wrn = driver.findElementsByXPath("//div[@class='helper-text']");
			for (int i = 0; i < wrn.size();i++) 
			{
				txt = wrn.get(i).getText();
				if (txt.contentEquals(""));
				else System.out.println("Warning Message : "+txt);
			}
			
			System.out.println(" *** Program Ends *** ");
	}

}
