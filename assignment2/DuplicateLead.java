package week2.day2.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2 Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// 3 Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 4 Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

		// 5 Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// 6 Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// 7 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		// 8 Click on Email
		driver.findElement(By.xpath("//span[@Class='x-tab-strip-inner']/span[text()='Email']")).click();
		// 9 Enter Email
		driver.findElement(By.xpath("//input[@Name='emailAddress']")).sendKeys("amirtha98@gmail.com");
		// 10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// 12 Click First Resulting lead
		driver.findElement(By.xpath("//div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();

		// 11 Capture name of First Resulting lead
		String text = driver.findElement(By.xpath("//span[@Id='viewLead_firstName_sp']")).getText();
		System.out.println(text);
		// 13 Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		// 14 Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();
		System.out.println(title);
		// 15 Click Create Lead
		driver.findElement(By.xpath("//input[@Value='Create Lead']")).click();
		// 16 Confirm the duplicated lead name is same as captured name
		String text2 = driver.findElement(By.xpath("//span[@Id='viewLead_firstName_sp']")).getText();
		System.out.println(text2);
		
		// 17 Close the browser (Do not log out)
		 driver.close();

	}

}
