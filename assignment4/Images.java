package week2.day2.assignment4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Am I Broken Image?
		WebElement findElement = driver.findElement(By.xpath("//label[@for='position']/following-sibling::img"));
		if (findElement.getAttribute("naturalWidth").equals("0"))
			System.out.println("Image is broken");
		else
			System.out.println("Image is not broken");

		// Click me using keyboard or Mouse
		driver.findElement(By.xpath("//label[contains(text(),'Mouse')]/following-sibling::img")).click();

		// Click on this image to go home page
		driver.findElement(By.xpath("//div[@Class='large-6 small-12 columns']/img")).click();

	}

}
