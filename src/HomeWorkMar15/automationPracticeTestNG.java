package HomeWorkMar15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.automationPractice;
import pageObjectModel.yahooAccount;

public class automationPracticeTestNG {
	
	
	WebDriver driver;
	automationPractice ap;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		ap = new automationPractice(driver);
		
		driver.manage().deleteAllCookies();
		
		Thread.sleep(500);
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {	
	Thread.sleep(500);
	
	}
	
	
	@Test(priority =1)
	public void validateSpecials() {
		
		ap.getEmailAddress().sendKeys("rokydeg8@yahoo.com");
		
	}
	
	@Test (priority =2)
	public void validateCreateAccount() {
		
		ap.validateCreateAccount().click();
	}
	
	@Test (priority =3)
	public void validateTitleMr() {
		
		ap.validateTitleMr().click();
	}
	
	@Test (priority =4)
	public void validateFirstName() {
		
		ap.validateFirstName().sendKeys("Glen");
		
	}
	
	@Test (priority = 5)
	public void validateLastName() {
		
		ap.validateLastName().sendKeys("McGrath");
	}
	
	@Test (priority = 6)
	public void validatePassword() {
		
		ap.validatePassword().sendKeys("GlenMcg94");
	}
	
	@Test (priority = 7)
	public void validateDate() {
		
		WebElement day = ap.getDate();
		Select daydd = new Select(day);
		daydd.selectByValue("10");
	}
	
	@Test (priority =8)
	public void validateMonth() {
		
		WebElement month = ap.getMonth();
		Select monthmm = new Select (month);
		monthmm.selectByIndex(6);
	}
	@Test (priority = 9)
	public void validateYear() {
		
		WebElement year = ap.getYear();
		Select yearyy = new Select (year);
		yearyy.selectByValue("2000");
	}
	
	@Test (priority =10)
	public void validateNewsLetter() {
		
		ap.validateNewsLetter().click();
	}
	
	@Test (priority =11)
	public void validateSpecialOffers() {
		
		ap.validateSpecialOffers().click();
	}
	
	@Test(priority =12)
	public void validateCompany() {
		
		ap.validateCompany().sendKeys("Agile1Tech");
	}
	
	@Test (priority =13)
	public void validateAddress() {
		
		ap.validateAddress().sendKeys("10400 Eaton Pl Suite # 105");
	}
	
	@Test(priority =14)
	public void validateCity() {
		
		ap.validateCity().sendKeys("Fairfax");
	}
	
	@Test (priority =15)
	public void valdateState() {
		
		WebElement state = ap.validateState();
		
		Select statess = new Select (state);
		statess.selectByVisibleText("Virginia");
	}
	
	@Test (priority = 16)
	public void valdateZipCode() {
		
		ap.validateZipCode().sendKeys("22030");
	}
	
	@Test (priority =17)
	public void validateAdditionalInformation() {
		
		ap.validateAdditionalInformation().sendKeys("Thank you");
	}
	
	@Test (priority = 18)
	public void validateHomePhone() {
		
		ap.validateHomePhone().sendKeys("5716455899");
	}
	
	@Test (priority =19)
	public void validateMobilePhone() {
		
		ap.validateMobilePhone().sendKeys("5716455899");
	}
	
	@Test (priority =20)
	public void validateAlias() {
		
		ap.validateAlias().sendKeys("Agile1Tech");
	}
	
	@Test (priority =21)
	public void validateRegister() {
		
		WebElement register = ap.validateRegister();
		boolean display = register.isDisplayed();
		
		Assert.assertTrue(display);
	}
	
	@Test (priority =22)
	public void validateUrl() {
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
		
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test (priority =23)
	public void validateTitle() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login - My Store";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
