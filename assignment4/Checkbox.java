package week2.day2.assignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Select the languages that you know?
		driver.findElement(By.xpath("//div[@Class='example'][1]/input[1]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][1]/input[3]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][1]/input[4]")).click();
		
		//Confirm Selenium is checked
		boolean selected = driver.findElement(By.xpath("//div[@Class='example'][2]//input")).isSelected();
		if(selected) System.out.println("Selenium is selected");
		
		//DeSelect only checked
		driver.findElement(By.xpath("//div[@Class='example'][3]//input[2]")).click();
		
		//Select all below checkboxes
		driver.findElement(By.xpath("//div[@Class='example'][4]//input[1]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][4]//input[2]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][4]//input[3]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][4]//input[4]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][4]//input[5]")).click();
		driver.findElement(By.xpath("//div[@Class='example'][4]//input[6]")).click();

		
	}

}
