package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Constant {
	WebDriver dr;
		public void login(String url, String username, String pass) {
			System.setProperty("chromedriver", "C:\\chromedriver.exe");
			dr = new ChromeDriver();
			WebDriverAction myAction=new WebDriverAction(dr);
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			dr.get(url+"/admin");
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			myAction.sendKeys("id=Login", username);
			myAction.sendKeys("id=Password", pass);
			myAction.click("id=LoginSubmit");
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String a = dr.findElement(By.xpath("//h2[@class='MVukf']")).getText();
			Assert.assertEquals("Welcome to Shopify, Tham.",a);
			System.out.println("string after login:\t"+a);
			dr.navigate().to("https://manythanks.sellersmith.com/editor?shop="+url);
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
}
