package Paylocity;

import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteWorker {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/redfury/Desktop/Drivers/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Logs in to Paylocity !
		WebElement username = driver.findElement(By.xpath("//input[@id='Username']"));
		username.sendKeys("TestUser13");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='Password']"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pwd.sendKeys("m_fpk1;5n>4T");
		driver.findElement(By.className("btn-primary")).click();
		
		WebElement eid=driver.findElementByCssSelector("#employeesTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1)");
				
		//Clicks the Delete on the First row of the table.
		driver.findElementByCssSelector("#employeesTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9) > i:nth-child(2)").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Clicks Cancel 
		driver.findElementByCssSelector("button.btn-secondary:nth-child(2)").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Clicks delete on the first row and deletes worker.
		driver.findElementByCssSelector("#employeesTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9) > i:nth-child(2)").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementByXPath("//*[@id=\"deleteEmployee\"]").click();
		
		driver.findElementByCssSelector("#employeesTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9) > i:nth-child(2)");
		if (eid.getText().equals("7e16fdad-d030-45b6-ad21-4d521ae0b974"))
		{
			System.out.println("Employee not deleted.");
		}
		else {
			System.out.println("Employee Deleted.");
		}
		
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Logout of Paylocity
		driver.findElementByClassName("justify-content-end").click();		
		
	}

}
