package test;


import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import pojo.LaunchBrowser;
import pom.ForgetPassword;
import pom.ZerodhaLoginPage;
import utility.Parametrization;
@Listeners(utility.Listeners.class)
public class ForgetPasswordTest {
	WebDriver driver;

	@BeforeMethod
		public void launchBrawsor() {
			driver=LaunchBrowser.runBrowserMethod();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		}
@Test(priority=3,enabled=false)
public void enterEmailId() throws EncryptedDocumentException, IOException {
	ForgetPassword forgotpass=new ForgetPassword(driver);
	forgotpass.clickOnRadioButtonNo3();
	String Email=Parametrization.excelData("testdata",4,1);
	forgotpass.enterEmailID(Email);
	forgotpass.enterCaptcha("rtet634");
}
 @Test (enabled=true)
public void passRcoverByVallidUIdEmail() throws EncryptedDocumentException, IOException{
	    ForgetPassword forgotpass=new ForgetPassword(driver);
		forgotpass.KitePassForgotten();
		forgotpass.SwichToNextPage(driver);
	    forgotpass.clickOnRadioButtonNo1();
	    String userID=Parametrization.excelData("testdata",0,1);
		forgotpass.enterUserId(userID);
		String PAN=Parametrization.excelData("testdata",3,1);
		forgotpass.enterPAN(PAN);
		forgotpass.clickOnRadioButtonNo3();
		String Email=Parametrization.excelData("testdata",4,1);
		forgotpass.enterEmailID(Email);
		forgotpass.enterCaptcha("");
		forgotpass.clickOnRestButton();
}
 @Test (enabled=false)
public void passRcoverByWithPanSms() throws EncryptedDocumentException, IOException, InterruptedException{
	 ForgetPassword forgotpass=new ForgetPassword(driver);
		forgotpass.KitePassForgotten();
		forgotpass.SwichToNextPage(driver);
	    WebElement A= driver.findElement(By.xpath("//label[contains(text(),'I forgot my user ID')]"));
    	A.click();
        boolean result= A.isSelected();
        Thread.sleep(1000);
        System.out.print(result);
        SoftAssert softassert= new SoftAssert();
        softassert.assertTrue(result,"Click on radio button"); 
        Thread.sleep(1000);
		String PAN=Parametrization.excelData("testdata",3,1);
		forgotpass.enterPAN(PAN);
		forgotpass.clickOnRadioButtonNo3();
		 Thread.sleep(1000);
		String Email=Parametrization.excelData("testdata",4,1);
		forgotpass.enterEmailID(Email);
		forgotpass.enterCaptcha("weyw5");
		//forgotpass.clickOnRestButton();
}
}
