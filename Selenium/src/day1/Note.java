package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Note {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("//img[contains(@src,'geKiQnSG-.png')]")).click();
		driver.findElement(By.xpath("//img[contains(@src,'6m.png')]"));
	
		driver.findElement(By.xpath("//button[text()='Automation Tools']"));
		driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
		
		driver.findElements(By.xpath("//*[contains(text(),'Trí Thiện')]"));
	}

}
