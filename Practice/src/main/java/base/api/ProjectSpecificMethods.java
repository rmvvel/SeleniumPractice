package base.api;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ProjectSpecificMethods {
	public static ChromeOptions options;
	public static ChromeDriver driver;
	public static Actions builder;
	
	public void launch(String url) {
		System.out.println(" *** Program Starts ***");
		String filePath = "C:\\Users\\BM\\AppData\\Local\\Temp";
	      //Creating the File object
	      File file = new File(filePath);
	    tempDelete tmp = new tempDelete();
	    tmp.deleteFolder(file);
	    
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		builder = new Actions(driver);
	}
	
}
