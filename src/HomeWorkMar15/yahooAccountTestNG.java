package HomeWorkMar15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.phpTravels;
import pageObjectModel.yahooAccount;

public class yahooAccountTestNG {
	
	WebDriver driver;
	
	yahooAccount ya;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		ya = new yahooAccount(driver);
		
		driver.manage().deleteAllCookies();
		
		Thread.sleep(1000);
		
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		
		Thread.sleep(500);
	}
	
	@Test(priority =1)
	public void validateFirstName() {
		
		WebElement firstName = ya.getFirstName();
		firstName.sendKeys("Thomas");
		boolean display1 = firstName.isDisplayed();
		
		Assert.assertTrue(display1);
		System.out.println("FirstName is displayed = "+display1);
	}
	
	@Test(priority =2)
	public void validateLastName() {
		WebElement lastName = ya.getLastName();
		lastName.sendKeys("Mill");
		boolean display2 = lastName.isDisplayed();
		
		Assert.assertTrue(display2);
		System.out.println("LastName is displayed = "+display2);
	}
	
	@Test(priority =3)
	public void validateId() {
		WebElement emailAddress = ya.getUserId();
		emailAddress.sendKeys("thomasmill193");
		boolean display3 = emailAddress.isDisplayed();
		
		Assert.assertTrue(display3);
		System.out.println("Email address is displayed = "+display3);
	}
	
	@Test(priority =4)
	public void validatePassword() {
		WebElement password = ya.getPassword();
		password.sendKeys("ABcd@12345678");
		boolean display4 = password.isDisplayed();
		
		Assert.assertTrue(display4);
		System.out.println("Password is displayed = "+display4);
		
		
	}
	
	@Test(priority =5)
	public void validatePhone() {
		WebElement phone = ya.getPhone();
		phone.sendKeys("7034857127");
		boolean display5 = phone.isDisplayed();
		
		Assert.assertTrue(display5);
		System.out.println("Mobile Phone Number is displayed = "+display5);
		
		
	}
	
	@Test(priority =6)
	public void validateMonth(){
		
		WebElement month = ya.getMonth();
		Select monthmm = new Select(month);
		monthmm.selectByVisibleText("February");
		boolean display6 = month.isDisplayed();
		
		Assert.assertTrue(display6);
		System.out.println("Month is displayed = "+display6);
		
	}
	
	@Test(priority =7)
	public void validateDate() {
		WebElement date = ya.getDate();
		date.sendKeys("01");
		boolean display7 = date.isDisplayed();
		
		Assert.assertTrue(display7);
		System.out.println("Date is displayed = "+display7);
		
	}
	
	@Test(priority =8)
	public void validateYear() {
		WebElement year = ya.getYear();
		year.sendKeys("1995");
		boolean display8 = year.isDisplayed();
		
		Assert.assertTrue(display8);
		System.out.println("Year is displayed = "+display8);
	}
	
	@Test(priority =9)
	public void validateGender() {
		WebElement gender = ya.getGender();
		gender.sendKeys("Male");
		boolean display9 = gender.isDisplayed();
		
		Assert.assertTrue(display9);
		System.out.println("Gender is displayed = "+display9);
		
		
	}
	
	@Test (priority =10)
	public void validateTerms() {
		
		WebElement terms = ya.validateTerms();
		boolean display10 = terms.isDisplayed();
		
		Assert.assertTrue(display10);
		System.out.println("Terms are displayed = "+display10);
	}
	
	@Test (priority =11)
	public void validatePrivacyPolicy() {
		
		WebElement privacyPolicy = ya.validatePrivacyPolicy();
		boolean display11 = privacyPolicy.isDisplayed();
		
		Assert.assertTrue(display11);
		System.out.println("Privacy Policy is displayed = "+display11);
	}
	
	@Test (priority =12)
	public void validateContinueButton() {
		
		WebElement continueButton = ya.validateContinueButton();
		boolean display12 = continueButton.isDisplayed();
		
		Assert.assertTrue(display12);
		System.out.println("Continue is displayed = "+display12);
	}
	
	@Test (priority =13)
	public void validateSignIn() {
		
		WebElement signIn = ya.validateSignIn();
		boolean display13 = signIn.isDisplayed();
		
		Assert.assertTrue(display13);
		System.out.println("Sign In is displayed = "+display13);
	}
	@AfterTest
	public void afterTest() throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
