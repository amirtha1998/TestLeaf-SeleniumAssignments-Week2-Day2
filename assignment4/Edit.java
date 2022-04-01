package week2.day2.assignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter Email Address
		driver.findElement(By.id("email")).sendKeys("amirtha98@gmail.com");
		//Append the text
		driver.findElement(By.xpath("//input[@Value='Append ']")).sendKeys("Text");
		//Get default text entered
		String attribute = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("The default text is: "+attribute);
		//Clear the text
		driver.findElement(By.xpath("//input[@Value='Clear me!!']")).clear();
		//Confirm that edit field is disabled
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		//System.out.println(enabled);
		if(!enabled)	System.out.println("The field is disabled");
	}
	
}
