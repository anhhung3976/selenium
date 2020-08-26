package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[text()='Automation Tools']"));
		action.moveToElement(ele).perform();
		
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
		int size = list.size();
		System.out.println(size);
		for(int i =0; i < size;i++) {
			String str = list.get(i).getAttribute("innerHTML");
			
			// code trong nay kiểm tra link có dùng được hay ko
			Boolean status = list.get(i).isEnabled();
			System.out.println("Tên link: "+ str + ", Link status: "+status);
			
			if(str.equalsIgnoreCase("TestNG")) {
				list.get(i).click();
				break;
			}
		}
		
		//không dùng list mà truy cập trực tiếp
//		driver.findElement(By.xpath("//div[@class='dropdown-content']//a[text()='Selenium']")).click();

	}

}
