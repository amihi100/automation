package TestNG;

import java.io.FileInputStream;
import java.sql.Date;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class varClass {
	public String environmentURL, environment,  panguGUID, carNumber, numberOfDrivers, screenShotPath, filename, insuredName,
			insuredLastName, insuredIdDriver, insuredBirthDate, insuredLicenseIssueYear, city, street, houseNumber,
			email, cellphone, wizardPhone0, wizardPhone1, driver1Name, cardNumber, driver1LastName, driver1Id,
			driver1BirthDate, cardPersonalId, driver1LicenseIssueYear, cardFullName, cardMonth, cardYear;

	public boolean appID;
	public String thankYouURL; 
	public int waitForElement, waitBeforeClick, MILLISECONDS;
	public Dimension windowDimension;
	public ChromeOptions options;
	ChromeDriver driver;
	WebDriverWait wait;
	
	public void setWaitClass(WebDriverWait wait) {
		wait = wait;
	}
	 
	// @Test(priority = 0, groups={"varClass.defineVariables"})
	public void defineVariables(String env) throws Exception {
		try {
			windowDimension = new Dimension(375, 912);

			String dir = System.getProperty("user.dir");
			// System.out.println("current dir = " + dir);
			String rootPath =
			 Thread.currentThread().getContextClassLoader().getResource("").getPath();
			 System.out.println("Root path:"+ rootPath);
			String filePath = MessageFormat.format("{0}\\config.{1}.xml", dir, env);
			Properties varProps = new Properties();
			varProps.loadFromXML(new FileInputStream(filePath));

			carNumber = varProps.getProperty("carNumber");// "5901079"; // Menora car#: 59XXX79.//5901079 //2432773
			// environmentURL =
			// "https://stage.pango-ins.co.il/api/test/url?uid=7ee1878d-556c-4aef-ab25-2e29cbae93d8&ln="
			// + carNumber;

			environmentURL =  "https://" + varProps.getProperty("environment")+ ".pango-ins.co.il/api/test/url?uid="+  "a17240b3-90a5-4817-b269-d097e9a26668"  +"&ln=" + carNumber;
			
			environmentURL =  "https://" + varProps.getProperty("environment")+ ".pango-ins.co.il/api/test/url?ln=" + carNumber + "&ui=" + UUID.randomUUID();
			System.out.println(environmentURL);
			thankYouURL = "https://"  + varProps.getProperty("environment") + " .pango-ins.co.il/thanks";
			// Define resolution - iPhone X (375 x 812).
			//dimension = new Dimension(375, 812);
			// Define Max wait for element and wait before click to next screen (seconds).
			waitForElement = Integer.parseInt(varProps.getProperty("waitForElement"));
			waitBeforeClick = Integer.parseInt(varProps.getProperty("waitBeforeClick"));
			MILLISECONDS = Integer.parseInt(varProps.getProperty("MILLISECONDS"));
			// Define scenario variables
			appID =   Boolean.valueOf(varProps.getProperty("appID"));
			numberOfDrivers = varProps.getProperty("numberOfDrivers");

			insuredName = varProps.getProperty("insuredName");
			insuredLastName = varProps.getProperty("insuredLastName");
			insuredIdDriver = varProps.getProperty("insuredIdDriver");
			insuredBirthDate = varProps.getProperty("insuredBirthDate");
			insuredLicenseIssueYear = varProps.getProperty("insuredLicenseIssueYear");
			city = varProps.getProperty("city");
			street = varProps.getProperty("street");
			houseNumber = varProps.getProperty("houseNumber");
			email = varProps.getProperty("email");
			cellphone = varProps.getProperty("cellphone");
			wizardPhone0 = varProps.getProperty("wizardPhone0");
			wizardPhone1 = varProps.getProperty("wizardPhone1");
			// Driver1 details:
			driver1Name = varProps.getProperty("driver1Name");
			driver1LastName = varProps.getProperty("driver1LastName");
			driver1Id = varProps.getProperty("driver1Id");
			driver1BirthDate = varProps.getProperty("driver1BirthDate");
			driver1LicenseIssueYear = varProps.getProperty("driver1LicenseIssueYear");
			// CreditGaurd details
			cardFullName = varProps.getProperty("cardFullName");
			cardPersonalId = varProps.getProperty("cardPersonalId");
			cardNumber = varProps.getProperty("cardNumber");
			cardMonth = varProps.getProperty("cardMonth");
			cardYear = varProps.getProperty("cardYear");
			// Define path of chromedriver.exe file.
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\amichaito\\Desktop\\Code\\Selenium\\PangoAPP\\chromedriver.exe");
			// Define path to save screenShot of first screen (start date).
			screenShotPath = "c:\\tmp1\\";
			
			
			
			//Map<String, String> mobileEmulation = new HashMap<>();
			//mobileEmulation.put("deviceName", "iPhone X");
			
			//options.setExperimentalOption("mobileEmulation", mobileEmulation);
			
			
			//options.addArguments("--window-size=320,900");
			
			
			
			options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
	
	
			
			driver.get(environmentURL);
			driver.manage().window().setSize(windowDimension);
			
			
			
			
			
			
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
		} catch (Exception e) {
			throw new Exception("Failed by wrong configuration!");
		}
	}

	/**
	 * public void defineVariables(String env) throws Exception { try { String dir =
	 * System.getProperty("user.dir"); //System.out.println("current dir = " + dir);
	 * //String rootPath =
	 * Thread.currentThread().getContextClassLoader().getResource("").getPath();
	 * //System.out.println("Root path:"+ rootPath);
	 * 
	 * String filePath= MessageFormat.format("{0}\\config.{1}.xml", dir, env);
	 * 
	 * Properties varProps = new Properties(); varProps.loadFromXML(new
	 * FileInputStream(filePath));
	 * 
	 * // Define resolution - iPhone X (375 x 812). dimension = new Dimension(375,
	 * 912);
	 * 
	 * // Define Max wait for element and wait before click to next screen
	 * (seconds). waitForElement = 20; waitBeforeClick = 1; MILLISECONDS = 1000; //
	 * Define scenario variables carNumber =
	 * varProps.getProperty("carNumber");//"5901079"; // Menora car#:
	 * 59XXX79.//5901079 //2432773 insuredName = "אין מספר הצעה"; insuredLastName =
	 * "עמיחי"; insuredIdDriver = "00018"; insuredBirthDate = "1988";
	 * insuredLicenseIssueYear = "2006"; city = "אלקנה"; street = "שיר השירים";
	 * houseNumber = "200"; email = "amihi100@gmail.com"; cellphone = "0507202828";
	 * contactCellphone0 = "0507202829"; contactCellphone1 = "0507202830"; //
	 * Driver1 details: driver1Name = "ישראל ישראלי"; driver1LastName = "אזרח מספר
	 * 1"; driver1Id = "330653783"; driver1BirthDate = "1996";
	 * driver1LicenseIssueYear = "2014"; // CreditGaurd details cardFullName =
	 * "עמיחי תורגמן"; cardPersonalId = "890108558"; cardNumber =
	 * "5326120384572410"; cardMonth = "9"; cardYear = "2020"; // environmentURL =
	 * //
	 * "https://stage.pango-ins.co.il/api/test/url?uid=7ee1878d-556c-4aef-ab25-2e29cbae93d8&ln="
	 * // + carNumber; // Environment: //environmentURL =
	 * "https://dev.pango-ins.co.il/api/test/url?ln=" + carNumber; environmentURL =
	 * "https://app.pango-ins.co.il/api/test/url?ln=" + carNumber; //environmentURL
	 * = "https://stage.pango-ins.co.il/api/test/url?ln=" + carNumber;
	 * //environmentURL = "https://proms.assuta.co.il/Portal/Login.aspx";
	 * 
	 * System.out.println(environmentURL); // Define path of chromedriver.exe file.
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\amichaito\\Desktop\\Code\\Selenium\\PangoAPP\\chromedriver.exe");
	 * // Define path to save screenShot of first screen (start date).
	 * screenShotPath = "c:\\tmp1\\";
	 * 
	 * options = new ChromeOptions(); options.addArguments("disable-infobars");
	 * options.addArguments("--incognito"); DesiredCapabilities capabilities =
	 * DesiredCapabilities.chrome();
	 * capabilities.setCapability(ChromeOptions.CAPABILITY, options); driver = new
	 * ChromeDriver(options); driver.get(environmentURL);
	 * driver.manage().window().setSize(dimension);
	 * TimeUnit.SECONDS.sleep(waitBeforeClick);
	 * 
	 * // Extract URL for text. String data =
	 * driver.findElementByTagName("body").getText(); String[] arr =
	 * data.split("https://"); String pango = ""; for (String ss : arr) { pango =
	 * ss; } panguGUID = pango.replaceAll("}", "").replaceAll("\"", ""); // Open URL
	 * with GUID driver.get("https://" + panguGUID); // DATE file format Calendar
	 * cal = Calendar.getInstance(); cal.setTime(Date.from(Instant.now())); //
	 * Create a filename from a format string. filename =
	 * String.format("%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp", cal); } catch (Exception
	 * e) { throw new Exception("Failed by wrong configuration!"); } }
	 * 
	 * 
	 */

}
