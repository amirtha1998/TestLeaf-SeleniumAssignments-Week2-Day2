package week2.day2.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {

		// 1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
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

		// 8 Enter first name
		driver.findElement(By.xpath("//div[@Class='x-form-item x-tab-item'][2]//input[@name='firstName']"))
				.sendKeys("Amirthavalli");

		// 9 Click Find leads button
		driver.findElement(By.xpath("//div[@Class='x-panel-footer x-panel-footer-noborder']//button")).click();

		// 10 Click on first resulting lead
		driver.findElement(By.xpath("//div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();

		// 11 Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);

		// 12 Click Edit
		driver.findElement(By.linkText("Edit")).click();

		// 13 Change the company name
		String text2 = driver.findElement(By.xpath("//input[@Id='updateLeadForm_companyName']")).getAttribute("value");
		//System.out.println(text2);

		driver.findElement(By.xpath("//input[@Id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@Id='updateLeadForm_companyName']")).sendKeys("TestLeaf");

		// 14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		String text = driver.findElement(By.xpath("//span[@Id='viewLead_companyName_sp']")).getText();
		// System.out.println(text);

		String result = text.substring(0, 8);
		//System.out.println(result);

		// 15 Confirm the changed name appears
		if (text2 != result)
			System.out.println("Company Name changed");
		else
			System.out.println("Please change the company name");

		// 16 Close the browser (Do not log out)
		driver.close();

	}
}
