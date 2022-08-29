package pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table { 

	
		public static WebDriver accBrawsor(String url) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\selenium\\chromedriver.exe"); 
			WebDriver driver = new ChromeDriver(); 
			driver.get(url); 
			return driver; 	  
		}
		public static void main(String[] args) {
		   WebDriver driver=Table.accBrawsor("https://demo.guru99.com/test/web-table-element.php");
		
		   double price1=0; 
		
		   List<WebElement> A=driver.findElements(By.xpath("//table//tbody//tr//td[4]"));
		   for(int a=1; a<A.size();a++) {
			   WebElement table=A.get(a);
			   String name=  table.getText();
			   double price= Double.parseDouble(name); 

			   if(price>price1) {
				   price1=price;
			   }
		   }
		   System.out.println("Maximum price:"+price1);
		
		   
	   for (int b=1;b<A.size(); b++) {
		      WebElement Minprice=A.get(b);
			  String minPrice=Minprice.getText();
			  double value= Double.parseDouble(minPrice);
		
			  if(value<price1) {
				  price1=value;
				}
		}
	   System.out.println("min value"+price1);
		}  
	}
	


