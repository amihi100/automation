package TestNG;

import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;



public class PangoV1 {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		
		
		String environmentURL, devURL, stageURL, panguGUID, carNumber, screenShotPath, filename, insuredName,
		insuredLastName, insuredIdDriver, insuredBirthDate, insuredLicenseIssueYear, city, street, houseNumber,
		email, cellphone, contactCellphone0, contactCellphone1, driver1Name, cardNumber, driver1LastName, driver1Id,
		driver1BirthDate, cardPersonalId, driver1LicenseIssueYear, cardFullName, cardMonth, cardYear;

		String thankYouURL = "https://dev.pango-ins.co.il/thanks";
		int waitForElement, waitBeforeClick, MILLISECONDS;
		Dimension d;
		ChromeOptions options;
		ChromeDriver driver;
		WebDriverWait wait;
		
		
		

		// Define resolution iPhone X (375 x 812).
		d = new Dimension(375, 812);
		// Define Max wait for element and wait before click to next screen (seconds).
		waitForElement = 20;
		waitBeforeClick = 1;
		MILLISECONDS = 500;
		// Define scenario variables
		carNumber = "2432773"; // Menora car#: 59XXX79.//5901079
		insuredName = "ראשון בוקרDEV";
		insuredLastName = "עמיחי";
		insuredIdDriver = "00018";
		insuredBirthDate = "1988";
		insuredLicenseIssueYear = "2006";
		city = "אלקנה";
		street = "שיר השירים";
		houseNumber = "200";
		email = "amihi100@gmail.com";
		cellphone = "0507202828";
		contactCellphone0 = "0507202829";
		contactCellphone1 = "0507202830";
		// Driver1 details:
		driver1Name = "ישראל ישראלי";
		driver1LastName = "אזרח מספר 1";
		driver1Id = "330653783";
		driver1BirthDate = "1996";
		driver1LicenseIssueYear = "2014";
		// CreditGaurd details
		cardFullName = "עמיחי תורגמן";
		cardPersonalId = "890108558";
		
		cardNumber = "5326120384572410";
		cardMonth = "9";
		cardYear = "2020";
		
		// environmentURL =
		// "https://stage.pango-ins.co.il/api/test/url?uid=7ee1878d-556c-4aef-ab25-2e29cbae93d8&ln="
		// + carNumber;
		//  Environment:
		environmentURL = "https://dev.pango-ins.co.il/api/test/url?ln=" + carNumber;
		//environmentURL = "https://app.pango-ins.co.il/api/test/url?ln=" + carNumber;
		//environmentURL = "https://stage.pango-ins.co.il/api/test/url?ln=" + carNumber;
		System.out.println(environmentURL);
		// Define path of chromedriver.exe file.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amichaito\\Desktop\\Code\\Selenium\\PangoAPP\\chromedriver.exe");
		// Define path to save screenShot of first screen (start date).
		screenShotPath = "c:\\tmp\\";

		options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.get(environmentURL);
		driver.manage().window().setSize(d);
		TimeUnit.SECONDS.sleep(waitBeforeClick);

		// Extract URL for text.
		String data = driver.findElementByTagName("body").getText();
		String[] arr = data.split("https://");
		String pango = "";
		for (String ss : arr) {
			pango = ss;
		}
		panguGUID = pango.replaceAll("}", "").replaceAll("\"", "");

		// Open URL with GUID
		driver.get("https://" + panguGUID);
		// DATE file format
		Calendar cal = Calendar.getInstance();
		cal.setTime(Date.from(Instant.now()));
		// Create a filename from a format string.
		filename = String.format("%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp", cal);
	}
	
	@Test
	public void googleTitleTest() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(1);
		//boolean c = 
			//	driver.findElementByXPath("/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[1]/div/app-step-header/img");
		//boolean b = driver.findElement(By.xpath("/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[1]/div/app-step-header/img")).isDisplayed();
	}
	
	
	@AfterMethod
	public void tearDwon() {
		//driver.quit();
	}

}
