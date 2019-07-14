package TestNG;

import java.io.FileInputStream;
import java.sql.Date;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class varClass {
	public String environmentURL, environment, panguGUID, carNumber, startInsuranceDate, numberOfDrivers, drivingYears,
			mortgageCar, yearsOfInsurance, claimsIn3Years, howManyClaims, restrictions, screenShotPath, filename,
			insuredName, insuredLastName, insuredIdDriver, genderPolicyOwner, insuredBirthDate, insuredLicenseIssueYear,
			city, street, houseNumber, email, cellphone, wizardPhone0, wizardPhone1, driver1Name, driver1LastName,
			driver1Id, driver1BirthDate, driver2Name, driver2LastName, driver2Id, driver2BirthDate,
			driver2LicenseIssueYear, cardNumber, cardPersonalId, driver1LicenseIssueYear, cardFullName, cardMonth,
			cardYear, localApp, httpOrHttps;

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
			windowDimension = new Dimension(372, 900);

			String dir = System.getProperty("user.dir");
			// System.out.println("current dir = " + dir);
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			System.out.println("Root path:" + rootPath);
			String filePath = MessageFormat.format("{0}\\config.{1}.xml", dir, env);
			Properties varProps = new Properties();
			varProps.loadFromXML(new FileInputStream(filePath));

			carNumber = varProps.getProperty("carNumber");// "5901079"; // Menora car#: 59XXX79.//5901079 //2432773
			// environmentURL =
			// "https://stage.pango-ins.co.il/api/test/url?uid=7ee1878d-556c-4aef-ab25-2e29cbae93d8&ln="
			// + carNumber;
			// environmentURL = "https://" + varProps.getProperty("environment")+
			// ".pango-ins.co.il/api/test/url?uid="+ "a17240b3-90a5-4817-b269-d097e9a26668"
			// +"&ln=" + carNumber;

			// Test in 7.5.2019 - 10.5.2019 if RegisterdAccount is still available for the
			// user
			// carNumber = "5900179";
			// environmentURL = "https://" + varProps.getProperty("environment")+
			// ".pango-ins.co.il/api/test/url?uid="+ "d3e1594d-a5f8-4a01-8dbd-8ccf5d1808e0"
			// +"&ln=" + carNumber;

			// environmentURL = "https://" + varProps.getProperty("environment")+
			// ".pango-ins.co.il/api/test/url?ln=" + carNumber + "&ui=" + UUID.randomUUID();
			environment = varProps.getProperty("environment");

			// System.out.println("First URL: "+ environment);
			if (environment.equals("local")) {
				environmentURL = "http://localhost:26904/api/test/url";
				System.out.println("hi: " + environmentURL);
			} else {
				environmentURL = "https://" + varProps.getProperty("environment") + ".pango-ins.co.il/api/test/url?ln="
						+ carNumber + "&ui=" + UUID.randomUUID();
			}
			System.out.println("Environment is: " + environmentURL);
			thankYouURL = "https://" + varProps.getProperty("environment") + " .pango-ins.co.il/thanks";
			// Define resolution - iPhone X (375 x 812).
			// dimension = new Dimension(375, 812);
			// Define Max wait for element and wait before click to next screen (seconds).
			waitForElement = Integer.parseInt(varProps.getProperty("waitForElement"));
			waitBeforeClick = Integer.parseInt(varProps.getProperty("waitBeforeClick"));
			MILLISECONDS = Integer.parseInt(varProps.getProperty("MILLISECONDS"));
			// Define scenario variables - First offer:
			appID = Boolean.valueOf(varProps.getProperty("appID"));
			startInsuranceDate = varProps.getProperty("startInsuranceDate");
			numberOfDrivers = varProps.getProperty("numberOfDrivers");
			drivingYears = varProps.getProperty("drivingYears");
			mortgageCar = varProps.getProperty("mortgageCar");
			yearsOfInsurance = varProps.getProperty("yearsOfInsurance");
			claimsIn3Years = varProps.getProperty("claimsIn3Years");
			howManyClaims = varProps.getProperty("howManyClaims");
			restrictions = varProps.getProperty("restrictions");
			// Define scenario variables - Second offer:
			// <!-- Policy owner details: -->
			wizardPhone0 = varProps.getProperty("wizardPhone0");
			wizardPhone1 = varProps.getProperty("wizardPhone1");
			insuredName = varProps.getProperty("insuredName");
			insuredLastName = varProps.getProperty("insuredLastName");
			insuredIdDriver = varProps.getProperty("insuredIdDriver");
			genderPolicyOwner = varProps.getProperty("genderPolicyOwner");

			insuredBirthDate = varProps.getProperty("insuredBirthDate");
			insuredLicenseIssueYear = varProps.getProperty("insuredLicenseIssueYear");
			city = varProps.getProperty("city");
			street = varProps.getProperty("street");
			houseNumber = varProps.getProperty("houseNumber");
			email = varProps.getProperty("email");
			cellphone = varProps.getProperty("cellphone");
			// ADditional Driver1 details:
			driver1Name = varProps.getProperty("driver1Name");
			driver1LastName = varProps.getProperty("driver1LastName");
			driver1Id = varProps.getProperty("driver1Id");
			driver1BirthDate = varProps.getProperty("driver1BirthDate");
			driver1LicenseIssueYear = varProps.getProperty("driver1LicenseIssueYear");
			// ADditional Driver2 details:
			driver2Name = varProps.getProperty("driver2Name");
			driver2LastName = varProps.getProperty("driver2LastName");
			driver2Id = varProps.getProperty("driver2Id");
			driver2BirthDate = varProps.getProperty("driver2BirthDate");
			driver2LicenseIssueYear = varProps.getProperty("driver2LicenseIssueYear");
			// CreditGaurd details
			cardFullName = varProps.getProperty("cardFullName");
			cardPersonalId = varProps.getProperty("cardPersonalId");
			cardNumber = varProps.getProperty("cardNumber");
			cardMonth = varProps.getProperty("cardMonth");
			cardYear = varProps.getProperty("cardYear");
			// Define path of chromedriver.exe file.
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\amichaito\\Desktop\\Code\\Selenium\\PangoAPP\\chromedriver.exe");

			// C:\Users\amichaito\Desktop\chromedriver_win32\chromedriver.exe

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\amichaito\\Desktop\\chromedriver2.46\\chromedriver.exe");

			// Define path to save screenShot of first screen (start date).
			screenShotPath = "c:\\tmp1\\";

			// Map<String, String> mobileEmulation = new HashMap<>();
			// mobileEmulation.put("deviceName", "iPhone X");

			// options.setExperimentalOption("mobileEmulation", mobileEmulation);

			// options.addArguments("--window-size=320,900");

			options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);

			driver.get(environmentURL);
			driver.manage().window().setSize(windowDimension);
			driver.manage().deleteAllCookies();
			TimeUnit.SECONDS.sleep(waitBeforeClick);

			// Extract URL for text.

			String data = driver.findElementByTagName("body").getText();

			if (environment.equals("local")) {
				httpOrHttps = "http://";
			} else {
				httpOrHttps = "https://";
			}

			String[] arr = data.split(httpOrHttps);
			String pango = "";
			for (String ss : arr) {
				pango = ss;
			}

			panguGUID = pango.replaceAll("}", "").replaceAll("\"", "");
			// Open URL with GUID
			driver.get(httpOrHttps + panguGUID);

			// DATE file format
			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.from(Instant.now()));
			// Create a filename from a format string.
			filename = String.format("%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp", cal);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed by wrong configuration!");
		}
	}
}