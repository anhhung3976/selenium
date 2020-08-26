package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lazada {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lazada.vn/");
		driver.manage().window().maximize();

//		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[1]/div/div[5]/a")).click();
//		Thread.sleep(2000);
		
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/input"))
//				.sendKeys("taikhoantestdw123@gmail.com");
//		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/input"))
//				.sendKeys("TaikhoantestDW123@");
		
//		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/form/div/div[2]/div[1]/button"))
//				.click();

//		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='q']")).sendKeys("iphone 11 pro max");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement listbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='search-box__popup--3Pf1']//div//a")));

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='search-box__popup--3Pf1']//div//a"));
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getText();
			if (str.equalsIgnoreCase("Iphone 11 pro max cũ")) {
				list.get(i).click();
				break;
			}
		}

		List<WebElement> listProduct = driver.findElements(By.xpath(
				"//div[@class='c1_t2i']//div[@class='c2prKC']//div[@class='c3e8SH c2mzns']//div[@class='c5TXIP']//div[@class='c3KeDq']//div[@class='c16H9d']//a[@age='0']"));
		for (int i = 0; i < listProduct.size(); i++) {
			String str = listProduct.get(i).getText();
			System.out.println(str);
			if (str.equalsIgnoreCase(
					"Besi Apple data line iPhone11 fast charge iPhone mobile phone 7 charging line 6s device 8plus lengthened punch 11pro elbow X short 8P tablet ipad punching 2 meters xs flash charge max The elbow is more durable and lightning fast charging game weapon")) {
				System.out.println("true");
				listProduct.get(i).click();
				break;
			}
		}

		WebDriverWait waitClose = new WebDriverWait(driver, 10);
		WebElement close = waitClose.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='content-block sfo']//span[@class='sfo__close']//i")));
		close.click();

		driver.findElement(By.xpath("//span[@class='next-number-picker-handler-up-inner']//i")).click();
		driver.findElement(By.xpath(
				"//button[@class='add-to-cart-buy-now-btn  pdp-button pdp-button_type_text pdp-button_theme_yellow pdp-button_size_xl']"))
				.click();

	}

}
