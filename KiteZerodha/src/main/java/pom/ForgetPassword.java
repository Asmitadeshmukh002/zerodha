package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPassword {
	@FindBy (xpath="(//input[@type='text'])[1]") private WebElement UserID;
	@FindBy (xpath="(//form//label) [1]") private WebElement RadioB1;
	@FindBy (xpath="(//form//label) [2]") private WebElement RadioB2;
	@FindBy (xpath="(//input[@type='text'])[2]") private WebElement EnterPAN;
	@FindBy (xpath="(//form//label)[3]") private WebElement EmailRadioB1;
	@FindBy (xpath="(//form//label)[4]") private WebElement SmsRadioB;
	@FindBy (xpath="(//input[@type='text'])[3]") private WebElement EnterEmail;
	@FindBy (xpath="(//input[@type='text'])[4]") private WebElement EnterCapcha;
	@FindBy (xpath="//button[@type='submit']") private WebElement EnterReset;
	@FindBy (xpath="//a[@class='text-light forgot-link']") private WebElement KiteForgottPass;
	
	
	public ForgetPassword(WebDriver driver){ 
		PageFactory.initElements(driver,this);
	}
	public void enterUserId(String ID) {
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
		//wait.until(ExpectedConditions.visibilityOf(UserID));
	//   wait.pollingEvery(Duration.ofMillis(20));
		UserID.sendKeys(ID);
	}
	public void clickOnRadioButtonNo1() {
		RadioB1.click();
	}
	public void clickOnRadioButtonNo2() {
		RadioB2.click();
	}
	public void clickOnRadioButtonNo3() {
		EmailRadioB1.click();
	}
	public void clickOnSmsRadioButtonNo4() {
		SmsRadioB.click(); 
	}
	public void enterPAN(String PAN) {
		EnterPAN.sendKeys(PAN);
	}
	public void enterEmailID(String Email) {
		EnterEmail.sendKeys(Email);
	}
	public void enterCaptcha(String Captcha) {
		EnterCapcha.sendKeys(Captcha);
	}
	public void clickOnRestButton() {
		EnterReset.click();
	}
	public void KitePassForgotten () {
		KiteForgottPass.click();
	}
	
	public void SwichToNextPage(WebDriver driver) { 

	Set <String> handle=driver.getWindowHandles();
	Iterator<String> A=handle.iterator();
	while(A.hasNext()) {
		String Nextpage=A.next();
	
		driver.switchTo().window(Nextpage);
		String title=driver.getTitle();
		if(title.equals("Forgot password / Kite")) {

		break;
		}
}
}
}

