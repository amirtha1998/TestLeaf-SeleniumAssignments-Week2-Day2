package week2.day2.assignment4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Select Training Program using Index
		WebElement findElement = driver.findElement(By.xpath("//select[@Id='dropdown1']"));
		Select dd = new Select(findElement);
		dd.selectByIndex(2);

		// Select Training Program using text
		WebElement findElement2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select byText = new Select(findElement2);
		byText.selectByVisibleText("Selenium");

		// Select Training Program using Value
		WebElement findElement3 = driver.findElement(By.xpath("//select[@name='dropdown3']"));
		Select byValue = new Select(findElement3);
		byValue.selectByValue("4");

		// Get the number of options in dropdown
		List<WebElement> count = driver.findElement(By.xpath("//div[@Class='example'][4]/select"))
				.findElements(By.tagName("option"));
		System.out.println(count.size());

		// Select using sendkeys
		driver.findElement(By.xpath("//div[@Class='example'][5]/select")).sendKeys("Appium");

		// Select your programs
		Select result = new Select(driver.findElement(By.xpath("//div[@Class='example'][6]/select")));

		if (result.isMultiple()) {

			result.selectByIndex(1);
			result.selectByIndex(3);

		}
	}
}
