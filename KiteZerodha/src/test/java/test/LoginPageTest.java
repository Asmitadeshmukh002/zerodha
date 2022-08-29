package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.Parametrization;
import utility.Report;

public class LoginPageTest {
 WebDriver driver; 
 ExtentReports reports;
 ExtentTest test;
 
 @BeforeTest 
 public void addReports() {
	 reports = Report.generateReport();
 }
 
 @BeforeMethod 
 public void launchBrowser(){
	driver= LaunchBrowser.runBrowserMethod(); 
 } 
 @Test 
 public void loginPage() throws EncryptedDocumentException, IOException, InterruptedException {
	 test = reports.createTest("LoginPageTest");
	ZerodhaLoginPage zerodhaLogin= new ZerodhaLoginPage(driver);
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
 
 @AfterMethod 
 public void postTest(ITestResult result) {
	 if (result.getStatus() == ITestResult.FAILURE) 
	 {
		 test.log(Status.FAIL, result.getName());
	 }
	 else if (result.getStatus() == ITestResult.SUCCESS)
	 {
		 test.log(Status.PASS, result.getName());
	 }
	 else 
	 {
		 test.log(Status.SKIP, result.getName());
	 }
 }
 
 @AfterTest 
 public void flushReport() {
	 reports.flush();
 }
}
