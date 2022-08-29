package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
 
	public static WebDriver runBrowserMethod() {
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\selenium\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.navigate().to("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		return driver;
		
	} 
	public static void main(String[] args) {
		LaunchBrowser.runBrowserMethod();
		
	} 
	 
}
