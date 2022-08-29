package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
public static TakesScreenshot screenShot(WebDriver driver, String string) throws IOException {
	DateTimeFormatter aa= DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
	LocalDateTime time=LocalDateTime.now(); 
String currnttime=	aa.format(time);
	 String file="asmi";
	     TakesScreenshot shot=((TakesScreenshot)driver);
	    File save= shot.getScreenshotAs(OutputType.FILE);
	    File path= new File("C:\\Users\\hp\\Desktop\\eclipse notes\\KiteZerodha\\screenshot\\zeodha ss sc"+file+currnttime+".jpg");
	FileHandler.copy(save, path);
	return shot;
}
public static void main(String[] args) {}
}  

