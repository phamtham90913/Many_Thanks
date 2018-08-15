package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Constant {
	public static String url ="";
	@Test
	public void login() {
		
		System.setProperty("chromedriver", "C:\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://toolsqa.com/selenium-webdriver/how-to-use-geckodriver/");
		
	}

}
