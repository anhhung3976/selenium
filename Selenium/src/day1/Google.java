package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com.vn/?hl=vi");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input"))
				.sendKeys("Java");

		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div/div//div[@class='sbl1']"));
		for (WebElement elementWeb : list) {
			String element = elementWeb.getText();
			if (element.equals("java là gì")) {
				elementWeb.click();
				break;
			}
		}
	}

}
