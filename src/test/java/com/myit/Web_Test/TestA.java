package com.myit.Web_Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestA {

	String baseUrl="https://demo.opencart.com/"; 
	WebDriver driver;
	String email=TestA.randomEmail();
	
	//Constructor is used to load the chromedriver
	public TestA()  
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\KasunYapa\\Desktop\\Virtusa QA\\Selenium Down\\chromedriver.exe");  
		driver=new ChromeDriver();
		}
	
	
	//This method is used to launch the browser and navigate to the Url
	@BeforeTest
	public void launchBrowser() 	
	{
		
		 driver.navigate().to(baseUrl);  
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);   //WebDriver must wait for a page to completely load before triggering an error default timeout is 300s.
		 driver.manage().window().maximize();
		 String title=driver.getTitle();	  
		 System.out.println(title);
	}
	
	
	//This method is used to generate a random Email for test purposes
	@Test(priority=1)
	public static String randomEmail()	
	{
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
	
	
	//This method is used to register a new user to the app
	@Test(priority=2)
	public void register() throws InterruptedException 		
	{
		  Thread.sleep(2000);
		  WebElement myAcc= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]"));
		  myAcc.click();    //Clicks on the myAcc icon
		 
		  Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click(); //Register acc
 		 
 		 driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Kasun");  //First Name
 		 driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Yapa");    //Last Name
 		 
 		 
 		 driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email); 	//Email
 		 driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("0779673458"); 	//Telephone
 		 
 		 driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test123"); //Pw
 		 driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("test123"); //Pw confirm
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click(); //checkbox
 		 
 	   	 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click(); //Click continue btn on reg page
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click(); //Click continue btn after confirming reg page
 		 
 		 Thread.sleep(1000);
	}
 		
	
 	 //Registration is done After the above step
	
	
	
	//This method is used to Logout from the registered account
	@Test(priority=3)
	public void logout() throws InterruptedException    
	{
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click(); // click on myAcc
 	 	 Thread.sleep(1000); 
 	 	 
 	 	 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click(); //Logout from acc
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click(); // continue btn
 		 
 		 Thread.sleep(1000);
	}
	
	
	
	
	//This method is used to login with valid username & valid password
	@Test(priority=4)   
	public void login() throws InterruptedException 	
	{  
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click(); // click on myAcc
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click(); //Click login from dropdown
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email); 	//Email
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test123"); //Pw
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();//Login
	}
	
	
	
	
	//This method is used to add the selected Item into wishlist,cart and checkout the item
	@Test(priority=5)
	public void buyItem() throws InterruptedException
	{
		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a/i")).click(); //Navigate to Home
 		
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img")).click();//Selects the 1st item from the shop
		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]/i")).click();//Add to wishlist
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click(); //Add to cart
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i")).click(); //Navigate to shopping cart
 		
 		 Thread.sleep(1000);
 		 WebElement quantity=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")); //Change quantity
 		 quantity.clear();
 		 quantity.sendKeys("20");
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]")).click(); //Update the quantity
 		 
 		 Thread.sleep(1000);
 		 driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click(); //Checkout
	 
	}
	
	
	
	//This method is used to terminate the web browser
	@AfterTest
	public void terminateBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		
	}
	
}




