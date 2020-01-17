package testing;
import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Assesment {
	
	public static void takepicture(WebDriver driver,String filename)throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".//Test//"+filename+".png"));
	}
	
	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\Share\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in");
	String tab1=driver.getWindowHandle();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
    
	Thread.sleep(3000);
	
	
	/*WebElement watch = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/71YTe2oLo1L._AC_UL320_ML3_.jpg']"));
	action.moveToElement(watch).click().build().perform();
	*/
	driver.findElement(By.cssSelector("img[data-image-index=\"3\"]")).click();
	
	Thread.sleep(3000);	
	
	ArrayList<String> tab2= new ArrayList<String>(driver.getWindowHandles());
	tab2.remove(tab1);
	driver.switchTo().window(tab2.get(0));
	
	takepicture(driver, "img1");
	
	Thread.sleep(3000);
	
	//driver.close();
	
	
	
	
	
	/*
	
		for (int i=1;i<=4;i++) 
		{
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);	
		}
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);	
		
		takepicture(driver, "img1");
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		
	
		
		*/
		
}
	}
