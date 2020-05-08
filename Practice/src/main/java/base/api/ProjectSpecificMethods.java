package base.api;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProjectSpecificMethods {
	public static ChromeOptions options;
	public static RemoteWebDriver driver;
	public static Actions builder;
	
	public void launch(String url){
		System.out.println(" *** Program Starts ***");
				
//		--- some important commands
//		taskkill /F /IM chromedriver.exe
//		setTimeout(function(){debugger;},5000)
		
        
//      --- Disabling chrome notifications
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_81.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver(options);
//		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		--- Creating actions object
		builder = new Actions(driver);
//		--- Creating wait object
//		wait = new WebDriverWait(driver,30);
		
	}
	
	public static void killprocess(boolean tkchromedriver, boolean tkchrome, boolean temp) throws IOException
	{
//		To kill choromedriver.exe at start of execution
		if (tkchromedriver) {
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver_81.exe");
		System.out.println("Deleted all chromedriver instances...");
		}
		if (tkchrome) {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		System.out.println("Deleted all chrome instances...");
		}
//		--- To delete temp files ---
		if (temp) {
		String filePath = "C:\\Users\\BM\\AppData\\Local\\Temp";
//	      Creating the File object
	      File file = new File(filePath);
	    tempDelete tmp = new tempDelete();
	    tmp.deleteFolder(file);
	    System.out.println("Deleted %temp% folder ...");
		}
	}
	
	public static void highlighter(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].setAttribute('style','border: 2px solid blue;');", ele);
	}
	public static void dehighlighter(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].setAttribute('style','');", ele);
	}
	
}
