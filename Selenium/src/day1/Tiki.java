package day1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tiki {
	
	public static WebDriver driver;
	public static Actions action; 
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anhhu\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tiki.vn/");
		driver.manage().window().maximize();
		action = new Actions(driver);
		WebElement ele = driver.findElement(
				By.xpath("//div[@class='Userstyle__Item-sc-6e6am-1 lneWsb']//i[@class='tikicon icon-user']"));
		action.moveToElement(ele).perform();

		// chọn nút đăng nhập = facebook của tiki
//		driver.findElement(By.xpath(
//				"//span[@class='Userstyle__ButtonIcon-sc-6e6am-9 gUdFI']//i[@class='tikicon icon-facebook-white']"))
//				.click();

		List<WebElement> list = driver
				.findElements(By.xpath("//button[@class='Userstyle__UserDropDownButton-sc-6e6am-10 dYkBsI']"));

		int count = list.size();
		for (int i = 0; i < count; i++) {
			String str = list.get(i).getAttribute("innerHTML");
			System.out.println(str);
			if (str.equalsIgnoreCase("Tạo tài khoản")) {
				list.get(i).click();
				break;
			}
		}

//		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elementCancleBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onesignal-slidedown-cancel-button']")));
		elementCancleBtn.click();
		

		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='phone_number']")).sendKeys("0848609874");
//		driver.findElement(By.xpath("//div[@class='UserModalstyle__OtpTrigger-tngk37-9 fuRqvt']")).click();
		driver.findElement(By.xpath("//input[@id='otp_code']")).sendKeys("188796");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("taikhoantest@gmail");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

//		driver.findElement(By.xpath(
//				"/html/body/div[7]/div/div/div/div[2]/div[2]/form/div[6]/span/label[1]")).click();

		List<WebElement> listGender = driver.findElements(By.xpath(
				"//div[@class='UserModalstyle__FormItem-tngk37-6 hUNsqy']//span[1]//label//label[@class='Input__RadioFake-sc-17i9bto-2 kdUEwV']//input[@name='gender']"));
		int countGender = listGender.size();
		System.out.println(countGender);
		for (int i = 0; i < countGender; i++) {
			System.out.println(listGender.get(i).getAttribute("value"));
			String gender = listGender.get(i).getAttribute("value");
			if (gender.equalsIgnoreCase("male")) {
				// div[@class='UserModalstyle__FormItem-tngk37-6 hUNsqy']//span[1]//label[1]
				// và nút radio button của nam, nếu để
				// div[@class='UserModalstyle__FormItem-tngk37-6 hUNsqy']//span[1]//label thì
				// mặc định lấy 2 nút radio button của cả nam và nữ, mà chỉ chạy radio của nam
				driver.findElement(By.xpath(
						"//div[@class='UserModalstyle__FormItem-tngk37-6 hUNsqy']//span[1]//label[1]//label[@class='Input__RadioFake-sc-17i9bto-2 kdUEwV']//span//i[@class='tikicon icon-radio-button-off']"))
						.click();
				break;
			}
			if (gender.equalsIgnoreCase("female")) {
				driver.findElement(By.xpath(
						"//div[@class='UserModalstyle__FormItem-tngk37-6 hUNsqy']//span[1]//label[2]//label[@class='Input__RadioFake-sc-17i9bto-2 kdUEwV']//span//i[@class='tikicon icon-radio-button-off']"))
						.click();
				break;
			}
		}

		Thread.sleep(1000);
		List<WebElement> listDate = driver.findElements(By.xpath("//div[@class='css-1hwfws3']//div[2]//div[1]//input"));
		for (int i = 0; i < listDate.size(); i++) {
			System.out.println(listDate.get(i).getAttribute("id"));
		}

		Robot robot = new Robot();
		driver.findElement(By.xpath("//div[@class='css-1hwfws3']//div[2]//div[1]//input[@id='react-select-2-input']"))
				.sendKeys("12");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//div[@class='css-1hwfws3']//div[2]//div[1]//input[@id='react-select-3-input']"))
				.sendKeys("10");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath(
				"//div[@class='css-1hwfws3']//div[@class='css-1g6gooi']//div[1]//input[@id='react-select-4-input']"))
				.sendKeys("1990");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//button[@class='UserModalstyle__RightButton-tngk37-8 GBpke']")).click();

		Thread.sleep(5000);
		String nameTest = driver.findElement(By.xpath(
				"//div[@class='UserModalstyle__FormItem-tngk37-6 hUNsqy']//div[contains(text(),'Tên phải chứa ít nhất 2 từ')]"))
				.getText();

		if (nameTest.equalsIgnoreCase("Tên phải chứa ít nhất 2 từ")) {
			System.out.println("test case pass");
		} else {
			System.out.println("test case fails");
		}
		
		driver.findElement(By.xpath("//div[@class='UserModalstyle__Root-tngk37-0 lmVrvP']//a[contains(@class,'tngk37')]")).click();

		login();
	}

	private static void login() {
		WebElement ele = driver.findElement(
				By.xpath("//div[@class='Userstyle__Item-sc-6e6am-1 lneWsb']//i[@class='tikicon icon-user']"));
		action.moveToElement(ele).perform();

		List<WebElement> list = driver
				.findElements(By.xpath("//button[@class='Userstyle__UserDropDownButton-sc-6e6am-10 dYkBsI']"));

		int count = list.size();
		for (int i = 0; i < count; i++) {
			String str = list.get(i).getAttribute("innerHTML");
			if (str.equalsIgnoreCase("Đăng nhập")) {
				list.get(i).click();
				break;
			}
		}

		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("auto test");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("autotest");
		 driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div[2]/form/div[3]/button[1]")).click();
		 
	}

}
