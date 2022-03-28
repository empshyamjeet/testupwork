package tests.groupTests.groupMember;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LinkTest {
	
	@Test
	public void Test1() {
		HttpURLConnection huc = null;
        int respCode = 200;
		System.setProperty("webdriver.chrome.driver", "/Users/shyamjeet/Downloads/vueautomation/drivers/chromedriver 3");
		WebDriver driver = new ChromeDriver();// lunching chrome browser
		driver.manage().window().maximize();
		driver.get("https://appwrk.com/");// open the url in chrome browsers
		
		 By allLink=By.tagName("a");
		 WebDriverWait waitElem=new WebDriverWait(driver, 30);
		
		 waitElem.until(ExpectedConditions.visibilityOfElementLocated(allLink));
		 List<WebElement> allLinks=driver.findElements(allLink);
		 System.out.println(allLinks.size());
		 for (int i=0;i<allLinks.size()-1;i++) {
			 
			 if(allLinks.get(i) == null || allLinks.get(i).getAttribute("href").isEmpty()){
				 System.out.println("email links");
			 }
			 else {
				 try {
		                huc = (HttpURLConnection)(new URL(allLinks.get(i).getAttribute("href")).openConnection());
		                
		                huc.setRequestMethod("HEAD");
		                
		                huc.connect();
		                
		                respCode = huc.getResponseCode();
		                
		                if(respCode >= 400){
		                    System.out.println(allLinks.get(i).getAttribute("href")+" is a broken link");
		                }
		                else{
		                    System.out.println(allLinks.get(i).getAttribute("href")+" is a valid link");
		                }
		                    
		            } catch (MalformedURLException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
			 }
			 
		 }
		 
		}
	
}
