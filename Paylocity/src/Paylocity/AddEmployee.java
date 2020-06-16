package Paylocity;

import java.util.List;
import java.util.concurrent.TimeUnit;
 
import junit.framework.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddEmployee {

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
		
		
		//Clicks the Add Button on the main Screen
		driver.findElementById("add").click();
		
		//Add First Name Last Name and Dependents.
		WebElement firstName= driver.findElementById("firstName");
		firstName.sendKeys("Demo");		
		WebElement lastName= driver.findElementById("lastName");
		lastName.sendKeys("Employee");
		WebElement dependents= driver.findElementById("dependants");
		dependents.sendKeys("1");
		
		//Clicks Add
		driver.findElementById("addEmployee").click();
		
		//Verifies Text for Employee Added.
		WebElement firstadd= driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr[1]/td[3]");
		if (firstadd.getText().equals("Employee"))
		{
		System.out.println("First Name added correctly!");
		}
		else {
		System.out.println("First Name not added correctly.");
		} 
		
		
		WebElement lastadd= driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr[1]/td[2]");
		if (lastadd.getText().equals("Demo"))
		{
			System.out.println("Last Name Added!");
		}
		else {
			System.out.println("Last Name Not Added.");
		}
		
		WebElement depadded=
		driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr/td[4]");
		if (depadded.getText().equals("1"))
		{
		System.out.println("Correct Number of Dependents added!");
		}
		else {
		System.out.println("Incorrect # of Dependents.");
		}
		
		WebElement salary=
		driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr[1]/td[5]");
		if (salary.getText().equals("52000"))
		{
			System.out.println("Correct Salary Added!");
		}
		else {
			System.out.println("Incorrect Salary Added.");
		}
		
		WebElement gross=
		driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr[1]/td[6]");
		if (gross.getText().equals("2000.00"))
		{
			System.out.println("Correct Gross Pay!");
		}
		else {
			System.out.println("Incorrect Gross Pay.");
		}
		
		WebElement bencost=
		driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr[1]/td[7]");
		if (bencost.getText().equals("57.96"))
		{
			System.out.println("Correct Benefits Cost Added!");
		}
		else {
			System.out.println("Incorrect Benefits Cost Added.");	
		}
		
		WebElement benefitscost=
		driver.findElementByXPath("/html/body/div/main/div[1]/table/tbody/tr[1]/td[8]");
		if (benefitscost.getText().equals("1942.31"))
		{
			System.out.println("Correct Net Pay Added!");
		}
		else {
			System.out.println("Incorrect Net Pay.");
		}
		
		//Deletes the Employee
		driver.findElementByCssSelector("#employeesTable > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9) > i:nth-child(2)").click();
		driver.findElementByXPath("//*[@id=\"deleteEmployee\"]").click();
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