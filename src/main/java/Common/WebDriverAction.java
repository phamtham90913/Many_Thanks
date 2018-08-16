package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class WebDriverAction {
	WebDriver dr;
	public WebDriverAction(WebDriver driver) {
		this.dr=driver;
	}
	public WebDriverAction() {

	}
	public By getElement(String locator) {
		By by=null;
		if(locator.startsWith("id=")) {
			locator=locator.substring(3);
			by=By.id(locator);
		}else
			if(locator.startsWith("xpath=")) {
				locator=locator.substring(6);
				by=By.xpath(locator);
			}
		return by;

	}

	public void click(String locator) {
		dr.findElement(getElement(locator)).click();
	}
	public void sendKeys(String locator, String key) {
		dr.findElement(getElement(locator)).sendKeys(key);
	}
	public void draganddrop(String from, String to) {
		Actions act = new Actions(dr);
		act.dragAndDrop(dr.findElement(getElement(from)), dr.findElement(getElement(to))).build().perform();
//		act.dragAndDropBy(source, xOffset, yOffset)

	}
	public void dragandrop(String element, int x, int y) {
		Actions act = new Actions(dr);
		System.out.println("step 2");
		WebElement from = dr.findElement(getElement(element));
		System.out.println("step 23");
		act.dragAndDropBy(from, x, y).build().perform();
	}
	@Test
	public void callDraganddrop() {
		System.setProperty("chromedriver", "C:\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("step 1");
		dr.get("http://demo.guru99.com/test/drag_drop.html");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("step 1");
		Common.WebDriverAction.this.dragandrop("//li[2][@data-id='2']", 600, 600);
	}
}

