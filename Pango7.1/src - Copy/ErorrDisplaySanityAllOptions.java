
/**
 * Java Selenium project for Pango insurance app.  
 * amihi100@gmail.com
 * Version 1.0
 */

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * import of take screenshot and save a file: import java.io.File; import
 * org.apache.commons.io.FileUtils; import org.openqa.selenium.OutputType;
 * import org.openqa.selenium.TakesScreenshot;
 *
 */

public class ErorrDisplaySanityAllOptions {

	static String environmentURL, devURL, stageURL, panguGUID, carNumber, screenShotPath, filename, insuredName,
			insuredLastName, insuredIdDriver, insuredBirthDate, insuredLicenseIssueYear, city, street, houseNumber,
			email, cellphone, contactCellphone, driver1Name, cardNumber, driver1LastName, driver1Id, driver1BirthDate,
			cardPersonalId, driver1LicenseIssueYear, cardFullName, cardMonth, cardYear;

	static String thankYouURL = "https://dev.pango-ins.co.il/thanks";
	static int waitForElement, waitBeforeClick, MILLISECONDS;
	static Dimension d;
	static ChromeOptions options;
	static ChromeDriver driver;
	static WebDriverWait wait;

	/**
	 * // Screen1.1: Start insurance date. In case we want to use next day month:
	 * date.add(Calendar.DATE, 1); Or just assign the Vars to specific date: static
	 * int startDateYear = 2019; static int startDateMonth = 2; static int
	 * startDateDay = 19;
	 */
	// Start insurance at the same day.
	static int startDateYear = Calendar.getInstance().get(Calendar.YEAR);
	// static int startDateMonth = Calendar.getInstance().get(Calendar.MONTH)+9;
	static int startDateMonth = Calendar.getInstance().get(Calendar.MONTH);
	static int startDateDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

	/**
	 * // Screen1.2 How many drivers: 1 driver: static String howManyDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[1]/label";
	 * 2 drivers: static String howManyDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	 * 3 drivers: static String howManyDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[3]/label";
	 * 4 drivers: static String howManyDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[4]/label";
	 */
	// 1 driver:
	static String howManyDrivers = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[1]/label";

	/**
	 * // Screen1.3: Youngest driver age. All age options {val: 20, label: "17-20"}
	 * {val: 23, label: "21-23"} {val: 26, label: "24-26"} {val: 29, label: "27-29"}
	 * {val: 34, label: "30-34"} {val: 39, label: "35-39"} {val: 46, label: "40-46"}
	 * {val: 49, label: "47-49"} {val: 59, label: "50-59"} {val: 64, label: "60-64"}
	 * {val: 69, label: "65-69"} {val: 74, label: "70-74"} {val: 77, label: "+75"}
	 */
	static String youngestDriverAge = "34";

	/**
	 * // Screen 1.4 Vars: Youngest driver license years old. zeorYearsOldDriver:
	 * static String licenseOfYoungestDriver =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[1]/label";
	 * oneYearOldDriver: static String licenseOfYoungestDriver =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	 * twoNineYearsOldDriver: static String licenseOfYoungestDriver =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[3]/label";
	 * tenFiftenYearsOldDriver: static String licenseOfYoungestDriver =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[4]/label";
	 * sixteenPlusYearsOldDriver: static String licenseOfYoungestDriver =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[5]/label";
	 */
	// tenFiftenYearsOldDriver:
	static String licenseOfYoungestDriver = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[4]/label";
	/**
	 * Screen 1.5 Mortgaged car. Mortgaged NO: static String mortgagedCar =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1];
	 * Mortgaged YES: static String mortgagedCar =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	// Mortgaged YES:
	static String mortgagedCar = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";

	/**
	 * Screen 1.6: 3 years insurance. Yes 3 years insurance: static String
	 * threeYearsInsurance =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 * No 3 years ins static String threeYearsInsurance =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 */
	// Yes 3 years insurance:
	static String threeYearsInsurance = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";

	/**
	 * Screen 1.7: Claims in 3 years. No claims in 3 years: static String
	 * claimsIn3Years =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 * Yes claims in 3 years: static String claimsIn3Years =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	// Yes claims in 3 years:
	static String claimsIn3Years = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	
	/**
	 * Screen 1.8 how many claims
	 * 0 claims static String howManyClaims = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[1]/label";
	 * 1 claim 	static String howManyClaims = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	 * more than 1 claim 	static String howManyClaims = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[3]/label";
	 * @throws Exception
	 */
	//one claim
	static String howManyClaims = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	
	/*
	 * Screen 1.9 Restriction in 3 years
	 * No restrictions: 	static String restrictions = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[9]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 * Yes restrictions: 	static String restrictions = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[9]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	//No restrictions
	static String restrictions = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[9]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	
	public static void defineVariables() throws Exception {
	//	try {
			// Define resolution iPhone X (375 x 812).
			d = new Dimension(375, 812);
			// Define Max wait for element and wait before click to next screen (seconds).
			waitForElement = 30;
			waitBeforeClick = 1;
			MILLISECONDS = 500;
			// Define scenario variables
			carNumber = "5901079"; // Menora car#: 59XXX79.//5901079
			insuredName = "עמיחי";
			insuredLastName = "תורגמן";
			insuredIdDriver = "326683455";
			insuredBirthDate = "1988";
			insuredLicenseIssueYear = "2006";
			city = "אלקנה";
			street = "שיר השירים";
			houseNumber = "200";
			email = "amihi100@gmail.com";
			cellphone = "0507202828";
			contactCellphone = "0507202828";
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
			cardMonth = "09";
			cardYear = "2020";

			// STAGE Environment:
			//environmentURL = "https://stage.pango-ins.co.il/api/test/url?ln=" + carNumber;
			// environmentURL =
			// "https://stage.pango-ins.co.il/api/test/url?uid=7ee1878d-556c-4aef-ab25-2e29cbae93d8&ln="
			// + carNumber;
			// DEV Environment:
			environmentURL = "https://dev.pango-ins.co.il/api/test/url?ln=" + carNumber;
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

		//} catch (Exception e) {
	//		throw new Exception("Failed by wrong configuration!");
		//}
	}

	public static void initialOffer() throws Exception {
	//	try {
			// Screen1.1: Start insurance date.
			wait = new WebDriverWait(driver, waitForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap-component-selector-2")));
			// Anypicker needs 2 seconds lock user choice.
			TimeUnit.SECONDS.sleep(2);
			// ScreenShot
			// File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Now copy .jpeg to screenShotPath
			// FileUtils.copyFile(scrFile, new File(screenShotPath + filename + ".jpeg"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.pickerInstance.showOrHidePicker()");
			js.executeScript("window.pickerInstance.setSelectedDate(new Date(" + startDateYear + "," + startDateMonth
					+ "," + startDateDay + ", 0, 0, 0, 0))");
			TimeUnit.SECONDS.sleep(1);
			js.executeScript("window.pickerInstance.showOrHidePicker()");
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"ap-component-selector-1\"]").click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			js.executeScript("setTimeout(()=>{document.querySelector('#btn-save-start-date').click()}, 000)");
			// Screen1.2: How many drivers.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			// driver.findElement(By.cssSelector("ul.radio-list>li")).click();
			driver.findElementByXPath(howManyDrivers).click();
			// Screen1.3: Youngest driver.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap-component-selector-0")));
			TimeUnit.SECONDS.sleep(1);
			js.executeScript("window.ageRangeApo.__changeComponentValue('0'," + youngestDriverAge + ")");
			js.executeScript("window.ageRangeApo.setSelectedAndInvalidValuesForRows(true)");
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath("/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[3]/button").click();
			// Screen1.4: licenseOfYoungestDriver.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q4-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(licenseOfYoungestDriver).click();
			// Screen1.5: Mortgaged Vehicle.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q5-0-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(mortgagedCar).click();
			// Screen1.6: 3 years insurance.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q6-0-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(threeYearsInsurance).click();
			// Screen1.7: Claims in 3 years.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7-0-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(claimsIn3Years).click();
			// Screen1.8 how many claims in 3 years.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7.1-radio-2"))); 
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(howManyClaims).click();
			// Screen1.9  Restrictions in 3 years
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7.2-0-radio-1"))); 
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(restrictions).click();
		

		////} catch (Exception e) {
		//	throw new Exception("Failed in FIRST OFFER QUESTIONS.");
	//	}
	}

	public static void initialOfferScreen() throws Exception {
		// Proceed to Final Offer screen.
	//	try {
			WebDriverWait wait1 = new WebDriverWait(driver, waitForElement);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("body > app-root > primary-bid > div > div.bid-content > a")));
			// Initial offer needs 6 seconds to load (after element is visible).
			TimeUnit.SECONDS.sleep(6);
			driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/ul/li[1]/a").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);

			driver.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[1]/panel/div/div[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);

			driver.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[1]/panel/div/div[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[3]/panel/div/div[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[3]/panel/div/div[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			;
			driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/ul/li[2]/a").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-shield\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			// Call me back function.
			driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[2]/ul/li[1]/a/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/input")
					.sendKeys(contactCellphone);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button")));
			driver.findElementByCssSelector("#modal-call-back > div.modal-dialog > div > div.modal-body > p > button")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button").click();
			// Need to wait 1500 miliSec for popup click.
			TimeUnit.MILLISECONDS.sleep(1500);
			driver.findElementByXPath("//*[@id=\"modal-call-back-success\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/a").click();

		///} catch (Exception e) {
		//	throw new Exception("Failed in ***INITIAL OFFER SCREEN***");
	//	}
	}

	public static void finalOffer() throws Exception {
		// FINAL OFFER SCREENS QUESTIONS.
	//	try {
			// Screen2.1: Policy owner.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-1-q-0-radio-1")));
			// Policy owner screen needs 3 seconds to load (after element is visible).
			TimeUnit.SECONDS.sleep(3);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(500);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(500);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(500);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[1]").click();
			// Screen2.2: Privacy details of policy owner.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-2-birthDate-3")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-2-firstName-0\"]").sendKeys(insuredName);
			driver.findElementByXPath("//*[@id=\"step-2-lastName-1\"]").sendKeys(insuredLastName);
			driver.findElementByXPath("//*[@id=\"step-2-personalId-2\"]").sendKeys(insuredIdDriver);
			// birthDate
			TimeUnit.SECONDS.sleep(1);
			// stepTwoBirthPicker
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"window.stepTwoBirthPicker.setSelectedDate(new Date(" + insuredBirthDate + ", 1, 0, 0, 0, 0, 0))");
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-2-birthDate-3\"]").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"ap-button-set\"]").click();
			// licenseIssueYear
			TimeUnit.SECONDS.sleep(1);
			js.executeScript("window.stepTwoLicensePicker.setSelectedDate(new Date(" + insuredLicenseIssueYear
					+ ", 6, 14, 0, 0, 0, 0))");
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-2-licenseIssueYear-4\"]").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"ap-button-set\"]").click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/div/button[1]").click();
			// Screen2.3: Contact details of policy owner
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-3-cityID-0")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-3-cityID-0\"]/div/div/div[2]/input").sendKeys(city);
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("div.ng-dropdown-panel-items>div>div.ng-option")).click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-3-streetID-1\"]/div/div/div[2]/input").sendKeys(street);
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.cssSelector("div.ng-dropdown-panel-items.scroll-host>div>div.ng-option")).click();
			driver.findElementByXPath("//*[@id=\"step-3-houseNumber-2\"]").sendKeys(houseNumber);
			driver.findElementByXPath("//*[@id=\"step-3-email-3\"]").sendKeys(email);
			driver.findElementByXPath("//*[@id=\"step-3-cellphone-4\"]").sendKeys(cellphone);
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/div/button[1]").click();
			// Screen2.4: 3 questions for driver and policy owner.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-4-q-0-radio-1")));
			TimeUnit.SECONDS.sleep(1);
			// All No:
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[3]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(1);
			// All YES:
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[3]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/div/button[1]").click();

			// Screen2.5: questions for criminal record and policy refuse.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-7-q-0-radio-2")));
			TimeUnit.SECONDS.sleep(1);
			// All YES:
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(1);
			// All NO:
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[1]").click();
			// Screen2.6: Agreements sign V.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/ul/li[3]/question-wrapper/div/div/single-checkbox/label/span")));
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/ul/li[3]/question-wrapper/div/div/single-checkbox/label")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/ul/li[1]/question-wrapper/div/div/plain-text/p/span")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-general-ext\"]/div[1]/div/div[2]/p/span").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-general-ext\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/ul/li[2]/question-wrapper/div/div/plain-text/p/span")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-general-ext\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);

			// NOW RETURN ALL STEPS IN FINAL OFFER:
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/div/button[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/div/button[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/div/button[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/div/button[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/a").click();
			// NOW FORWARD TO FINAL OFFER:
			// Policy owner.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-1-q-0-radio-1")));
			// Policy owner screen needs 2 seconds to load (after element is visible).
			TimeUnit.SECONDS.sleep(2);
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/div/button[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/div/button[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/div/button[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/ul/li[3]/question-wrapper/div/div/single-checkbox/label")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/div/button[1]").click();
		//} catch (Exception e) {
		//	throw new Exception("Failed in FINAL OFFER QUESTIONS");
	//	}
	}

	public static void finalOfferScreen() throws Exception {
		//try {
			// Screen: Final offer!
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/app-root/final-bid/div/div[1]/a")));
			// Need to wait 3 seconds for element.
			TimeUnit.SECONDS.sleep(3);
			driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/div[6]/a[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[1]/panel/div/div[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[1]/panel/div/div[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[3]/panel/div/div[1]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[3]/panel/div/div[1]").click();
			driver.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/div[6]/a[2]").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-insurance-takanon\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			// Call me back function.
			driver.findElementByXPath("/html/body/app-root/final-bid/div/div[2]/ul/li[1]/a/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/input")
					.sendKeys(contactCellphone);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button")));
			driver.findElementByCssSelector("#modal-call-back > div.modal-dialog > div > div.modal-body > p > button")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button").click();
			// Need to wait 1500 miliSec for popup click.
			TimeUnit.MILLISECONDS.sleep(1500);
			driver.findElementByXPath("//*[@id=\"modal-call-back-success\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/a").click();
	//	} catch (Exception e) {
		//	throw new Exception("Failed in FINAL OFFER screen");
	//	}
	}

	public static void covers() throws Exception {
		//try {
			// Screen: Covers.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]")));

			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[1]/label")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[2]/label")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[3]/label")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[4]/label")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick + 1);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]")
					.click();

	//	} catch (Exception e) {
	//		throw new Exception("Failed in COVERS screen");
	//	}
	}

	public static void payments() throws Exception {
		// Screens: Final offer, Covers and payments.
	//	try {
			// Screen: Payments.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[2]/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/div/p/span").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("//*[@id=\"modal-pay-insurance\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[1]/div/span[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-payments\"]/div[1]/div/div[2]/app-step-content-vertical-options-view/ul/li[2]/label")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[1]/div/span[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-payments\"]/div[1]/div/div[2]/app-step-content-vertical-options-view/ul/li[3]/label")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[1]/div/span[1]")
					.click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"//*[@id=\"modal-payments\"]/div[1]/div/div[2]/app-step-content-vertical-options-view/ul/li[4]/label")
					.click();
			TimeUnit.SECONDS.sleep(10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[2]/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")));
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[1]/div/span[1]")
					.click();
			
			driver.findElementByXPath(
					"//*[@id=\"modal-payments\"]/div[1]/div/div[2]/app-step-content-vertical-options-view/ul/li[9]/label")
					.click();
			TimeUnit.SECONDS.sleep(10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[2]/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")));
			// Go back to Final offer:
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/div/button").click();
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[2]")
					.click();
			// Go forward to covers:
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/a").click();
			// Remove cover:
			TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[1]/label")
					.click();
			TimeUnit.SECONDS.sleep(10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]")));
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[2]/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
		//} catch (Exception e) {
		//	throw new Exception("Failed in PAYMENTS screen");
	//	}
	}

	public static void creditGuard() throws Exception {
		// Screen: CreditGuard
	//	try {
			TimeUnit.SECONDS.sleep(10);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submitBtn\"]/span")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"cardNumber\"]").sendKeys(cardNumber);
			driver.findElementByXPath("//*[@id=\"personalId\"]").sendKeys(cardPersonalId);
			driver.findElementByXPath("//*[@id=\"fullName\"]").sendKeys(cardFullName);
			TimeUnit.SECONDS.sleep(1);
			// driver.switchTo().defaultContent();
			Select dropdownYear = new Select(driver.findElement(By.id("expYear")));
			dropdownYear.selectByVisibleText(cardYear);
			TimeUnit.SECONDS.sleep(1);
			Select dropdownMonth = new Select(driver.findElement(By.id("expMonth")));
			TimeUnit.SECONDS.sleep(1);
			dropdownMonth.selectByVisibleText(cardMonth);
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath("//*[@id=\"submitBtn\"]").click();
	//	} catch (Exception e) {
	//		throw new Exception("Failed in Iframe CreditGuard");
	//	}
	}

	public static void thankYou() throws Exception {
	//	try {
			TimeUnit.SECONDS.sleep(1);
			String URL = driver.getCurrentUrl();
			if (URL == thankYouURL || wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("/html/body/app-root/thank-you-page/div/h1")))
					.isDisplayed()) {
				System.out.println("You reached to THANK YOU page!!!");
			}
	//	} catch (Exception e) {
	//		throw new Exception("Failed to display thank you page");
	//	}
	}

	public static void pangoAutomatedTest() throws Exception   {
		//try {

			defineVariables();
			initialOffer();
			initialOfferScreen();
			finalOffer();
			finalOfferScreen();
			covers();
			payments();
			creditGuard();
			thankYou();
	//	} catch (Exception e) {
		//	System.out.println(e.getMessage());
		}
	//}

	public static void main(String[] args) throws Exception  {
		// TODO: Define variables and path before run on different machine
		System.out.println("Automated testing started!");
		pangoAutomatedTest();
		System.out.println("Automated testing DONE!");
	}
}