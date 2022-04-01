package week2.day2.assignment4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlink {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Find where am supposed to go without clicking me?
		System.out.println(driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href"));

		// Verify am I broken?
		String attribute = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		// System.out.println(attribute);
		String result = "http://leafground.com/pages/error.html";
		if (attribute.equalsIgnoreCase(result))
			System.out.println("link is broken");

		// How many links are available in this page?
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size() - 1);
		
		// Go to Home Page(Interact with same link name)
		driver.findElement(By.linkText("Go to Home Page")).click();

		// Go to Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();

	}
}
