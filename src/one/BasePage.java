package one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage 
{
public static WebDriver driver;
	
	//Browser Launch
	public void BLauch(String Driver, String DriverPath)
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Automation training\\chromedriver.exe");

		System.setProperty(Driver, DriverPath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Launch");
				
	}
	
	//Enter URL
	public void URL(String URL, String Text) throws Exception
	{
		driver.navigate().to(URL);
		Thread.sleep(4000);
		
		WebElement HomeText = driver.findElement(By.xpath("(//*[text()='HOME'])[2]"));
		
		String text = HomeText.getText();
		
		if (text.equals(Text))
		{
			System.out.println("URL Enters Successfully");
		}
		else
		{
			System.out.println("URL not entered");
		}
	}
    
	//Enter FirstName
	public void FirstName(String FirstName) throws Throwable
	{
		WebElement first_name = driver.findElement(By.xpath("//*[@name='first_name']"));
		first_name.click();
		first_name.sendKeys(FirstName);
		System.out.println("FirstName entered ");
		Thread.sleep(2000);
	}
	
	//Enter LastName
	public void LastName(String LastName) throws Throwable
	{
		WebElement last_name = driver.findElement(By.xpath("//*[@name='last_name']"));
		last_name.click();
		last_name.sendKeys(LastName);
		System.out.println("LastName entered ");
		Thread.sleep(2000);
	}
	
	//Enter Email ID
	public void EmailID(String EmailID ) throws Throwable
	{
		WebElement emailId = driver.findElement(By.xpath("//*[@name='email' and @placeholder='Email Address']"));
		emailId.click();
		emailId.sendKeys(EmailID);
		System.out.println("EmailID entered ");
		Thread.sleep(2000);
	}
	
	//Enter Mobile Number
	public void MobileNumber(String MobileNumber) throws InterruptedException
	{
		WebElement mobileNumber = driver.findElement(By.xpath("//*[@name='mobile' and @placeholder='Mobile Number']"));
		mobileNumber.click();
		mobileNumber.sendKeys(MobileNumber);
		System.out.println("Mobile Number entered ");
		Thread.sleep(2000);
	}
	
	//Enter DOB By Calendar
	public void EnterDOB() throws InterruptedException
	{
		BasePage base = new BasePage();
		
		//Click on Calendar Tab
		WebElement ICon= driver.findElement(By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']"));
		ICon.click();
			
		//Click on Year 
		driver.findElement(By.xpath("//*[@type='button' and @class='mx-btn mx-btn-text mx-btn-current-year']")).click();
		
		//Click on Pravious Button
		driver.findElement(By.xpath("//*[@class='mx-icon-double-left']")).click();
		driver.findElement(By.xpath("//*[@class='mx-icon-double-left']")).click();
		driver.findElement(By.xpath("//*[@class='mx-icon-double-left']")).click();

		
		//Select BirthYear
		WebElement BirthYear = driver.findElement(By.xpath("//*[@data-year='1999']"));
		BirthYear.click();
		
		//Select BirthMonth
		WebElement BirthMonth = driver.findElement(By.xpath("//*[@data-month='8']"));
		BirthMonth.click();
		
		//Select BirthDate
		WebElement BirthDate = driver.findElement(By.xpath("//*[@title='1999-09-21']"));
		BirthDate.click();
		
		System.out.println("DOB entered successfully");
		Thread.sleep(2000);
	}
	
	//Enter DOB by Direct Enter
	public void DOB(String DOB) throws Throwable
	{
		WebElement dateOFBirth= driver.findElement(By.xpath("//*[@placeholder='DOB']"));
		dateOFBirth.click();
		dateOFBirth.sendKeys(DOB);
		Thread.sleep(2000);
		System.out.println("Date Of Birth Entered");
	}
	
	//Enter Password
	public void Password (String Password) throws Throwable
	{
		WebElement password = driver.findElement(By.xpath("//*[@name='password' and @placeholder='Password']"));
		password.click();
		password.sendKeys(Password);
		System.out.println("Password entered ");
		Thread.sleep(2000);
	}
	
	//Confirm Password
	public void ConfirmPassword(String ConfirmPassword) throws Throwable
	{
		
	//	WebElement confirmPass = driver.findElement(By.xpath("//*[@name='password_confirmation']"));
		WebElement confirmPass = driver.findElement(By.xpath("(//*[@type='password'])[2]"));
		//confirmPass.click();
		confirmPass.sendKeys(ConfirmPassword);
		System.out.println("Confirm Password entered ");
		Thread.sleep(2000);
	}
	
	//Click on RegisterButton
	
	public void RegisterButton() throws Throwable
	{
		System.out.println("Clicking on Register Button");
		//driver.findElement(By.xpath("//*[@type='submit' and text()= 'Register']")).click();
		WebElement  registerButton=driver.findElement(By.xpath("//*[@type='submit' and text()= 'Register']"));
		
		
		registerButton.click();
//		WebElement  abc=		driver.findElement(By.xpath("(//*[text()='Register'])[2]"));
//	   abc.click();
		System.out.println("Clicked on Register button");
		Thread.sleep(3000);
	}
	
	//Close Browser
	public void CloseBrowser() throws Throwable
	{
		Thread.sleep(6000);
		driver.quit();
		System.out.println("Close the Browser");
	}

	public static void main(String[] args) throws Throwable
	{
		BasePage page= new BasePage();
		

		page.BLauch("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Automation training\\chromedriver.exe");
		page.URL("https://meralda.scalenext.io/user/register", "HOME");
		page.FirstName("Abc");
		page.LastName("xyz");
		page.EmailID("jdiowodho@gmail.com");
		page.MobileNumber("5498484111");
		page.DOB("1999-09-21");
		page.Password("kkk425aaa");
		page.ConfirmPassword("kkk425aaa");
	    page.RegisterButton();
		//page.click();
	}

}
