package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException {
		// Step 1: Download and set the path

		// Step 2: Launch the chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");

		// Step 4: Maximise the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();

		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-'][1]")).sendKeys("Amirtha");

		// Step 8: Enter the last name
		driver.findElement(By.xpath(
				"//div[@Class='mbm _1iy_ _a4y rfloat _ohf']//div[@Class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']//input"))
				.sendKeys("S");

		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");

		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("1234");

		// Step 11: Handle all the three drop downs
		WebElement eleSource = driver.findElement(By.id("day"));
		Select dd = new Select(eleSource);
		dd.selectByVisibleText("1");

		WebElement element = driver.findElement(By.id("month"));
		Select de = new Select(element);
		de.selectByVisibleText("Jan");

		WebElement eleSrc = driver.findElement(By.id("year"));
		Select df = new Select(eleSrc);
		df.selectByVisibleText("1997");

		// Step 12: Select the radio button "Female"
		driver.findElement(By.xpath("//span[@Class='_5k_2 _5dba'][1]/input")).click();

	}

}
