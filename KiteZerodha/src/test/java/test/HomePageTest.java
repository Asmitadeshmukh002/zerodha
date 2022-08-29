package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.ScreenShot;
@Listeners(utility.Listeners.class)
public class HomePageTest extends BaseTest {  

	
	@BeforeMethod 
	public void LaunchBrowser() throws InterruptedException, EncryptedDocumentException, IOException {
		driver= LaunchBrowser.runBrowserMethod();
		ZerodhaLoginPage zerodhaLogin=new ZerodhaLoginPage(driver);
		Thread.sleep(3000); 
		String userID= Parametrization.excelData("testdata", 0, 1);
		String pass= Parametrization.excelData("testdata", 1, 1);
		String pin= Parametrization.excelData("testdata", 2, 1);
		zerodhaLogin.userId(userID);
		zerodhaLogin.password(pass); 
		zerodhaLogin.login();
		Thread.sleep(2000);
		zerodhaLogin.pin(pin); 
		zerodhaLogin.Clogin();
	} 
	 
	@Test 
	public void SearchStock() {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("TATA", driver);
		int a=zerodhaHomePage.listOfSearchResult();
		System.out.println(a); 
	} 
	
	@Test 
	public void ClickOnBuyAfterSearch() {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Reliance", driver);
		zerodhaHomePage.selectRequiredStock("RELIANCE", driver);
		zerodhaHomePage.buyReqStock();
		
	} 
	
	@Test 
	public void ClickOnSellAfterSearch() {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("TATA", driver);
		zerodhaHomePage.selectRequiredStock("TATAPOWER", driver);
		zerodhaHomePage.sellReqStock();
		Assert.assertTrue(false);
		
	} 
	@Test 
	public void ClickOnAddAfterSearch() throws InterruptedException, IOException {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("TATA", driver);
		zerodhaHomePage.selectRequiredStock("TATAELXSI", driver);
		zerodhaHomePage.clickOnAdd();
		Thread.sleep(4000);
		zerodhaHomePage.clickOnTrash(driver);
		
		
	}

}
