package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage {
	    @FindBy(xpath="//input[@id='userid']") private WebElement InsertId;
	    @FindBy(xpath="//input[@id='password']") private WebElement InsertPass;
		@FindBy(xpath="//button[@class='button-orange wide']") private WebElement LogIn;
		@FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement ForgotPass;
		@FindBy(xpath="//input[@id='pin']") private WebElement InsertPin;
		@FindBy(xpath="//button[@class='button-orange wide']") private WebElement ConfirmLogin;
		
	public ZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	public void userId(String Id) { 
		InsertId.sendKeys(Id);
	}
	public void password(String Pass) {
		InsertPass.sendKeys(Pass);
	}
	public void login() {
		LogIn.click();
	}
	public void forgotpass() {
		ForgotPass.click();
	} 
	public void pin(String Id) {
		InsertPin.sendKeys(Id);
	}
	public void Clogin() {
		ConfirmLogin.click();
	}
	
}
