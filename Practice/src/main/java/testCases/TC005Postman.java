package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC005Postman {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		Precondition: Postman chrome download
//
//		1) Open Postman desktop application using Selenium
		Runtime runTime = Runtime.getRuntime();
		runTime.exec("C:\\Users\\BM\\Downloads\\Postman.exe");
		
//		2) Create New Collection as RestLearning
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver66.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@class='btn btn-primary']").click();
		driver.findElementByXPath("//span[text()'Collection']").click();
		driver.findElementByXPath("//input[@class='input input-box collection-modal-name-input']").sendKeys("New1");
		driver.findElementByXPath("//div[text()='Create']").click();
//		3) Check whether the collection already exist
//		4) If exist, delete the existing Collection
//		5) Create new Collection
		
	}

}
