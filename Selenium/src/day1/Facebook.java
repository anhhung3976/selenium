package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("taikhoantestdw123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("TaikhoantestDW123@");

//		List<WebElement> allanswer = driver.findElements(By.xpath(
//				"/html/body/div[1]/div/div[1]/div[1]/div[3]/div/div/div[1]/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div[2]/div/span/div"));
//		System.out.println("size nhắn tin:" + allanswer.size());
//		for (WebElement answer : allanswer) {
//			System.out.println(answer.getText());
//		}

//		Actions builder = new Actions(driver);        
//		builder.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("hao");
		driver.findElement(By.name("firstname")).sendKeys("minh");
		driver.findElement(By.name("reg_email__")).sendKeys("eclora@gothill.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("eclora@gothill.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("test123456#");

		Select sl1 = new Select(driver.findElement(By.name("birthday_day")));
		sl1.selectByValue("12");

		Select sl2 = new Select(driver.findElement(By.name("birthday_month")));
		sl2.selectByValue("5");

		Select sl3 = new Select(driver.findElement(By.name("birthday_year")));
		sl3.selectByValue("1998");

		List<WebElement> listWeb = driver.findElements(By.name("sex"));
		int count = listWeb.size();
		for (int i = 0; i < count; i++) {
			String str = listWeb.get(i).getAttribute("value");
			if (str.equalsIgnoreCase("-1")) {
				listWeb.get(i).click();
				Select sl4 = new Select(driver.findElement(By.name("preferred_pronoun")));
				sl4.selectByValue("6");
				driver.findElement(By.name("custom_gender")).sendKeys("khong noi duoc");
//				driver.findElement(By.name("websubmit")).click();
				break;
			}
		}
		Thread.sleep(2000);

//		driver.findElement(By.xpath("//img[@id='u_i_9']")).click();
		driver.findElement(By.xpath("//img[contains(@src,'geKiQnSG-.png')]")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/div/div[3]/label/input"))
				.sendKeys("trithien.nguyen.14");
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/ul/li[3]/div/a/div"))
				.click();
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Trí Thiện')]"));
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).getText();
			list.get(i).click();
			System.out.println(str);
		}
		System.out.println(list.size());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@src,'6m.png')]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div/div/div/div/div/div/div[1]/div/div/div[1]/span/div/div[1]"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[1]/div/div[1]/div/a[1]"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[4]/div[1]/span/div/div[1]"))
				.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='hu5pjgll m6k467ps sp_goeHjAlsAx- sx_f2693a']"))
		.click();
		

//		driver.findElement(
//				By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[6]/div/div[1]/div[2]/div"))
//				.click();

//		WebElement svgObject = driver.findElement(By.xpath(
//				"/html/body/div[1]/div/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/form/div/div[3]/span[2]/div/svg"));
//		Actions builder = new Actions(driver);
//		builder.click(svgObject).build().perform();

	}

}
