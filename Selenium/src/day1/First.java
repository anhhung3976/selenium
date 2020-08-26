package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class First {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://form.jotformpro.com/42382403598964?");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"input_3\"]")).sendKeys("tri thien");
		driver.findElement(By.xpath("//*[@id=\"input_4\"]")).sendKeys("exigue@curlycollection.com");
		
		Select sl1 = new Select(driver.findElement(By.xpath("//*[@id=\"input_7_month\"]")));
		sl1.selectByValue("January");
		
		Select sl2 = new Select(driver.findElement(By.xpath("//*[@id=\"input_7_day\"]")));
		sl2.selectByValue("1");
		
		Select sl3 = new Select(driver.findElement(By.xpath("//*[@id=\"input_7_year\"]")));
		sl3.selectByValue("2020");
		
		driver.findElement(By.xpath("//*[@id=\"input_5_addr_line1\"]")).sendKeys("quang vinh");
		driver.findElement(By.xpath("//*[@id=\"input_5_addr_line2\"]")).sendKeys("quang vinh 2");
		driver.findElement(By.xpath("//*[@id=\"input_5_city\"]")).sendKeys("bien hoa");
		driver.findElement(By.xpath("//*[@id=\"input_5_state\"]")).sendKeys("bien hoa state");
		driver.findElement(By.xpath("//*[@id=\"input_5_postal\"]")).sendKeys("bien hoa postal");
	
		Select sl4 = new Select(driver.findElement(By.xpath("//*[@id=\"input_5_country\"]")));
		sl4.selectByValue("Andorra");
		
		driver.findElement(By.xpath("//*[@id=\"input_2\"]")).click();
		
	
		// 1 số trường hợp dùng index thay vì value
//		Select sl3 = new Select(driver.findElement(By.xpath("//*[@id=\"speed\"]")));
//		sl3.selectByIndex(3);

//		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("16130403@st.hcmuaf.edu.vn");
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("YA617OTT");
//		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/form/div[3]/input[4]")).click();

	}
}
