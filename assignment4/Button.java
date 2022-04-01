package week2.day2.assignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/Button.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//Find position of button (x,y)
	System.out.println("Position of button is: "+driver.findElement(By.id("position")).getLocation());
	//Find button color
	System.out.println("color: "+driver.findElement(By.id("color")).getCssValue("background-color"));
	//Find the height and width
	System.out.println("The size of button is: "+driver.findElement(By.id("size")).getSize());
	//Click button to travel home page
	driver.findElement(By.id("home")).click();
}
}
