package testCases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.api.ProjectSpecificMethods;

public class TC009CrmCloud extends ProjectSpecificMethods {

	public static void main(String[] args) throws InterruptedException, Exception{
		
//			1) Go to https://demo.1crmcloud.com/
			String URL = "https://demo.1crmcloud.com/";
			ProjectSpecificMethods psm = new ProjectSpecificMethods();
			psm.launch(URL);
			
//			2) Give username as admin and password as admin
			driver.findElementByXPath("//input[@id='login_user']").sendKeys("admin");
			driver.findElementByXPath("//input[@id='login_pass']").sendKeys("admin");
			
			driver.findElementByXPath("//button[@id='login_button']").click();
			Thread.sleep(3000);
			
//			3) Choose theme as Claro Theme
			driver.findElementByXPath("//div[@id='user_theme-input']//span[@class='input-label single']").click();
			Thread.sleep(200);
			driver.findElementByXPath("//div[text()='Claro Theme']").click();
			Thread.sleep(2000);
			
//			4) Click on Sales and Marketting
			driver.findElementByXPath("//div[text()='Sales & Marketing']").click();
			Thread.sleep(2000);
			
//			5) Click Create contact
			driver.findElementByXPath("//div[text()='Create Contact']").click();
			Thread.sleep(5000);
			
//			6) Select Title and type First name, Last Name, Email and Phone Numbers
			driver.findElementByXPath("//div[@id='DetailFormsalutation-input']").click();
			Thread.sleep(200);
			driver.findElementByXPath("//div[text()='Mr.']").click();
			
			driver.findElementByXPath("//input[@id='DetailFormfirst_name-input']").sendKeys("Mathanvel");
			driver.findElementByXPath("//input[@id='DetailFormlast_name-input']").sendKeys("Rathinavelu");
			driver.findElementByXPath("//input[@id='DetailFormemail1-input']").sendKeys("rmvvel@gmail.com");
			driver.findElementByXPath("//input[@id='DetailFormphone_work-input']").sendKeys("9994923354");
			
//			7) Select Lead Source as "Public Relations"
			driver.findElementByXPath("//div[@id='DetailFormlead_source-input']").click();
			Thread.sleep(200);
			driver.findElementByXPath("//div[text()='Public Relations']").click();
			
//			8) Select Business Roles as "Sales"
			driver.findElementByXPath("//div[@id='DetailFormbusiness_role-input']").click();
			Thread.sleep(200);
			driver.findElementByXPath("//div[text()='Sales']").click();
			
//			9) Fill the Primary Address, City, State, Country and Postal Code and click Save
			driver.findElementByXPath("//textarea[@id='DetailFormprimary_address_street-input']").sendKeys("F1, WRM");
			driver.findElementByXPath("//input[@id='DetailFormprimary_address_city-input']").sendKeys("Chennai");
			driver.findElementByXPath("//input[@id='DetailFormprimary_address_state-input']").sendKeys("Tamil Nadu");
			driver.findElementByXPath("//input[@id='DetailFormprimary_address_country-input']").sendKeys("India");
			driver.findElementByXPath("//input[@id='DetailFormprimary_address_postalcode-input']").sendKeys("600126");
			
			driver.findElementByXPath("//span[@id='DetailForm_save2-label']").click();
			Thread.sleep(4000);
			
//			10) Mouse over on Today's Activities and click Meetings
			WebElement ele1 = driver.findElementByXPath("//li[@id='grouptab-0']");
			builder.moveToElement(ele1).perform();
			driver.findElementByXPath("//div[text()='Meetings']").click();
			Thread.sleep(4000);
			
//			11) Click Create
			driver.findElementByXPath("(//span[text()='Create'])[1]").click();
			Thread.sleep(3000);
			
//			12) Type Subject as "Project Status" , Status as "Planned" 
			driver.findElementByXPath("//input[@id='DetailFormname-input']").sendKeys("Project Status");
			String sts = driver.findElementByXPath("//div[@id='DetailFormstatus-input-label']").getText();
			if (sts.equalsIgnoreCase("Planned")) System.out.println("Status is : "+sts);
			else 
				{
				System.out.println("Status is : "+sts);
				driver.findElementByXPath("//div[@id='DetailFormstatus-input-label']").click();
				Thread.sleep(200);
				driver.findElementByXPath("(//div[text()='Planned'])[1]").click();
				Thread.sleep(1000);
				}
			
//			13) Start Date & Time as tomorrow 3 pm and Duration as 1hr
	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));  
		    String oldDate = formatter.format(date);
			Calendar c = Calendar.getInstance();
			//Setting the date to the given date
			try {
				c.setTime(formatter.parse(oldDate));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			//Number of Days to add
			int days = 4;
			c.add(Calendar.DAY_OF_MONTH, days);  
			//Date after adding the days to the given date
			String newDate = formatter.format(c.getTime());  
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);
			
			driver.findElementByXPath("//div[@class='input-label datetime-label text-number']").click();
			Thread.sleep(200);
			driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input").sendKeys(newDate,Keys.ENTER);
			Thread.sleep(200);
			driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input").sendKeys("15:00",Keys.ENTER);
			Thread.sleep(200);
			
//			14) Click Add paricipants, add your created Contact name and click Save
			driver.findElementByXPath("//span[text()=' Add Participants']").click();
			Thread.sleep(200);
			String srchtxt = "Mathanvel";
			driver.findElementByXPath("//div[@id='app-search-text']//input").sendKeys(srchtxt);
			Thread.sleep(200);
			driver.findElementByXPath("(//span[text()='Search Results (Invitees)']/ancestor::div[@class='card-header panel-subheader'])/following-sibling::div//div[contains(text(),'" + srchtxt + "')]").click();
			Thread.sleep(4000);
			driver.findElementByXPath("(//span[text()='Save'])[2]").click();
			Thread.sleep(4000);
			
//			15) Go to Sales and Marketting-->Contacts
			WebElement ele2 = driver.findElementByXPath("//div[text()='Sales & Marketing']");
			builder.moveToElement(ele2).perform();
			Thread.sleep(1000);
			driver.findElementByXPath("//div[text()='Contacts']").click();
			Thread.sleep(1000);
			
//			16) search the lead Name and click the name from the result
			driver.findElementByXPath("//input[@id='filter_text']").sendKeys(srchtxt);
			Thread.sleep(1000);
			driver.findElementByXPath("//input[@id='filter_text']").sendKeys(Keys.ENTER);
			Thread.sleep(1400);
			driver.findElementByXPath("//td[@class='listViewTd']//a[contains(text(),'"+ srchtxt + "')]").click();
			Thread.sleep(4000);
			
//			17) Check weather the Meeting is assigned to the contact under Activities Section.
			List<WebElement> tr = driver.findElementsByXPath("//span[@id='subpanel-activities']//ancestor::div[@class='card-outer panel-outer listview-panel panel-system panel-border']//table//tbody//tr");
			
			for (int i = 0;i<tr.size();i++)
			{
				List<WebElement> td = tr.get(i).findElements(By.tagName("td"));
				System.out.println(td.get(4).getText());
				if (td.get(4).getText().contains("Planned")) System.out.println("Matching");
				else System.out.println("Not Matching");
			}
			
			driver.close();
			
			System.out.println(" *** Program Ends ***");
	}

}
