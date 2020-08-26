package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Udemy {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.udemy.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement login = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/div[3]/div[5]/a")));
		login.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("taikhoantestdw123@gmail.com ");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("TaikhoantestDW123@");
		driver.findElement(By.xpath("//*[@id=\"submit-id-submit\"]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("java");

		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(
				"//ul[@class='unstyled-list udlite-block-list js-suggestions udlite-search-form-autocomplete-suggestions']//li"));
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getText();
			if (str.equalsIgnoreCase("java")) {
				list.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);
		List<WebElement> listCourse = driver.findElements(By.xpath(
				"//div[@class='course-list--container--3zXPS']//div[@class='popover--popover--t3rNO popover--popover-hover--14ngr']//a//div//div[2]//div[@class='udlite-focus-visible-target udlite-heading-md course-card--course-title--2f7tE']"));
		for (int i = 0; i < listCourse.size(); i++) {
			String str = listCourse.get(i).getText();
			if (str.equalsIgnoreCase("Learn complete Java - Core Java & JSP & Servlets")) {
				listCourse.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[3]/div[1]/div[3]/div/div/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div[4]/div/button"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//button[@class='udlite-btn udlite-btn-large udlite-btn-primary udlite-heading-md']//span[contains(text(),'Go to Cart')]"))
				.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//div[@class='checkout--new-card-form--JMty5']//div//input[@id='nameOnCard-input']"))
				.sendKeys("selenium");
		driver.findElement(By.xpath(
				"//body//div//form//span//div[@class='CardNumberField-input-wrapper']//span[@class='InputContainer']//input[@aria-label='Credit or debit card number']"))
				.sendKeys("147575");
		driver.findElement(By.xpath("//input[@name='exp-date']")).sendKeys("2020");
		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("2020");

	}

}
