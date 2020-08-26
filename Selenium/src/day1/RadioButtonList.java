package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioButtonList {
	public static boolean is_selected  = false;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

//		//radio button
		List<WebElement> list1 = driver.findElements(By.name("optradio"));
		int count = list1.size();
		for (int i = 0; i < count; i++) {
			String str = list1.get(i).getAttribute("value");
			System.out.println(str);
			if (str.equalsIgnoreCase("male")) {
				list1.get(i).click();
				driver.findElement(By.xpath("//*[@id=\"buttoncheck\"]")).click();
				break;
			}
		}

		List<WebElement> list2 = driver.findElements(By.name("gender"));
		
		int count2 = list2.size();
		for (int i = 0; i < count2; i++) {
			is_selected = list2.get(1).isSelected();
			System.out.println(is_selected);
			String gender = list2.get(i).getAttribute("value");
			if (gender.equalsIgnoreCase("female")) {
				list2.get(i).click();
				break;
			}
		}

		List<WebElement> list3 = driver.findElements(By.name("ageGroup"));
		int count3 = list3.size();
		is_selected = list2.get(1).isSelected();
		System.out.println(is_selected);
		for (int i = 0; i < count3; i++) {
			String ageGroup = list3.get(i).getAttribute("value");
			System.out.println(ageGroup);
			if (ageGroup.equalsIgnoreCase("15 - 50")) {
				list3.get(i).click();
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/button")).click();
				break;
			}
		}
		
		driver.navigate().to("https://crossbrowsertesting.com/?utm_source=seleniumeasy&utm_medium=da&utm_campaign=sedemo");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/header/section/div/div[3]/div/a[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("taikhoan");
		driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("taikhoan");
		driver.findElement(By.xpath("//*[@id=\"remember-me\"]")).click();;
		driver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
		
		

//		WebElement radio1 = driver
//				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/label[1]/input"));

//		WebElement radio2 = driver
//				.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/label[2]/input"));
//		radio2.click();
	}
}
