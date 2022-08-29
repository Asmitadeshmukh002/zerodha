package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	
	@FindBy(xpath="//input[@type='text']") private WebElement Search;
	@FindBy(xpath="//span[@class='tradingsymbol']") private List<WebElement> SearchResult;
	@FindBy(xpath=" //button[@class='button-blue'][1]") private WebElement SearchBuyForReq;
	@FindBy(xpath=" //button[@class='button-orange']") private WebElement SearchSellForReq;
	@FindBy(xpath="//button[@class='button-green']") private WebElement ClickOnAdd;
	@FindBy(xpath="//span[@class='icon icon-trash']") private WebElement ClickOnTrash;
	
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchStock(String Stock, WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(Search));
		Search.sendKeys(Stock); 
	} 
	
    public int listOfSearchResult() {
    	int num=SearchResult.size();
		return num;
    } 
    
    public void selectRequiredStock(String ListOfStock, WebDriver driver) {
    	for(int i=0; i< SearchResult.size(); i++ ) {
    		WebElement list=SearchResult.get(i);
    		String ListStock= list.getText();
    		if(ListStock.equals(ListOfStock)) {
    			Actions action = new Actions(driver);
    			action.moveToElement(list);
    		    action.perform();
    	        break;
    		}
    	}
    }
    
    public void buyReqStock() { 
    	SearchBuyForReq.click();
    }
    
    public void sellReqStock() { 
    	SearchSellForReq.click();
    } 
    public void clickOnAdd() {  
    	ClickOnAdd.click();
    }
    public void clickOnTrash(WebDriver driver) {
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(ClickOnTrash));
    	ClickOnTrash.click();
    }

}
