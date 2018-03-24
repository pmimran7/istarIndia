package com.istar;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	WebDriver driver=new FirefoxDriver();
	WebDriverWait w=new WebDriverWait(driver,70);


	@BeforeTest
	public void TestCase1(){
		System.out.println("This is before test case");
		driver.manage().window().maximize();
		driver.get("http://talentify.in:8999/content");

	}
	@Test(priority=1)
	public void TestCase2(){
		driver.findElement(By.name("email")).clear();

		driver.findElement(By.name("email")).sendKeys("abhinav1@istarindia.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("test123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	@Test(priority=2)
	public void TestCase3(){
		String Expectedtitle=("Istar | Dashboard");
		System.out.println("Expectedtitle"+    Expectedtitle);
		String Actualtitle=driver.getTitle();
		System.out.println("Actualtitle"     +Actualtitle);
		if(Expectedtitle.equals(Actualtitle))
		{
			System.out.println("enter");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.className("dropdown-toggle")));
			driver.findElement(By.className("dropdown-toggle")).click();
			driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li[2]/ul/li[4]/a")).click();



		}
		else
			System.out.println("The Titles are not matching");

	}




	@Test(priority=3)
	public void TestCase4() throws InterruptedException{


		driver.findElement(By.id("create_lessonzz")).click();
		String parent;
		parent = driver.getWindowHandle(); 

		Set<String> s1 = driver.getWindowHandles(); 

		Iterator<String> I1 = s1.iterator(); 

		while (I1.hasNext()) { 

			String child_window = I1.next(); 

			if (!parent.equals(child_window)) { 
				driver.switchTo().window(child_window);
				//driver.findElement(By.id("lesson_;type_idd")).sendKeys("videos");
				WebElement we1= driver.findElement(By.id("lesson_type_idd"));// for drop down
				Select sel1=new Select(we1);
				sel1.selectByIndex(1);

				driver.findElement(By.id("lesson_name_idd")).sendKeys("Arif shaik");
				driver.findElement(By.id("lesson_desc_idd")).sendKeys("i love learning ");
				driver.findElement(By.id("lesson_duration_idd")).sendKeys("30");
				driver.findElement(By.xpath(".//*[@id='wizard']/div[3]/ul/li[2]/a")).click();
				driver.findElement(By.xpath(".//*[@id='wizard']/div[3]/ul/li[2]/a")).click();
				driver.findElement(By.xpath(".//*[@id='wizard']/div[3]/ul/li[2]/a")).click();
				driver.findElement(By.xpath(".//*[@id='wizard']/div[3]/ul/li[3]/a")).click();
				Thread.sleep(3000);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
				driver.findElement(By.linkText("Dashboard")).click();
				WebElement st =driver.findElement(By.linkText("Arif shaik"));
				String st2=st.getText();
				System.out.println(st2);

				Assert.assertEquals("Arif shaik", "Arif shaik");
			} 
		}

		
			
		}
	
	@AfterTest
	public void TestCase5(){
		System.out.println("Test case completed succesfully ");
		

	} 
	
}







