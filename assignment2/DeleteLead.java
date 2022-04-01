package week2.day2.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) {
		// http://leaftaps.com/opentaps/control/main

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

		// 8 Click on Phone
		driver.findElement(By.xpath("//span[@Class='x-tab-strip-inner']/span[text()='Phone']")).click();
		// 9 Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9874563210");
		// 10 Click find leads button
		driver.findElement(By.xpath("//button[@Class='x-btn-text'][text()='Find Leads']")).click();
		// 11 Capture lead ID of First Resulting lead
		String LeadID = driver.findElement(By.xpath("//div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"))
				.getAttribute("href");
		System.out.println(LeadID);
		String CaptureLeadID = LeadID.substring(LeadID.length() - 5, LeadID.length());
		System.out.println(CaptureLeadID);
		// 12 Click First Resulting lead
		driver.findElement(By.xpath("//div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();

		// 13 Click Delete
		driver.findElement(By.linkText("Delete")).click();

		// 14 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		// 15 Enter captured lead ID
		driver.findElement(By.xpath("//input[@Name='id']")).sendKeys(CaptureLeadID);
		
		// 16 Click find leads button
		driver.findElement(By.linkText("Find Leads")).click();

		// 17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		if(driver.findElement(By.xpath("/div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")) != null)	System.out.println("Record is not Deleted");
		else	System.out.println("No records to display");
		
		// 18 Close the browser (Do not log out)
		driver.close();

	}
}
