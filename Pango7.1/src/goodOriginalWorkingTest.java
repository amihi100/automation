//Java Selenium project for Pango App insurance.  
//amihi100@gmail.com  //rahulonlinetutor@gmail.com
// Version 1.0


import java.io.File;
import java.io.IOException;
import java.sql.Date;

import java.time.Instant;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class goodOriginalWorkingTest {

	static String pangoURL, carNumber, startDateYear, startDateMonth, startDateDay, screenShotPath, filename, userName,
			lastName, idDriver, birthDate, licenseIssueYear, city, street, houseNumber, email, cellphone, cardNumber,
			cardPersonalId, cardFullName, expMonth, expYear;
	static int waitForElement, waitBeforeClick;
	static Dimension d;
	static ChromeOptions options;
	static ChromeDriver driver;
	static WebDriverWait wait;

	public static void pangoAutoTesting() throws InterruptedException, IOException {
		// TODO: Define variables and path before run on different machine
		try {
			// Define resolution iPhone X (375 x 812).
			d = new Dimension(375, 812);
			// Define Max wait for element and wait before click to next screen (seconds).
			waitForElement = 40;
			waitBeforeClick = 1;

			// Define scenario variables
			carNumber = "5930179"; // Menora car#: 59XXX79.
			//int year = Calendar.getInstance().get(Calendar.MONTH);
			
			startDateYear = "2019";
			startDateMonth = "0"; // 0 = January
			startDateDay = "29";
			userName = "ישראל";
			lastName = "ישראלי";
			idDriver = "000000018";
			birthDate = "01/01/1988";
			licenseIssueYear = "2006";
			city = "אופקים";
			street = "אבנר בן נר";
			houseNumber = "1";
			email = "amihi100@mail.com";
			cellphone = "0507202828";
			// CreditGaurd details
			cardFullName = "ישראל אוטומט";
			cardPersonalId = "890108558";
			cardNumber = "5326120384572410";
			expMonth = "09";
			expYear = "20";
			// Define URL.
			pangoURL = "https://dev.pango-ins.co.il/api/test/url?ln=" + carNumber;
			// Define path of chromedriver.exe file.
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\amichaito\\Desktop\\Code\\Selenium\\PangoAPP\\chromedriver.exe");
			// Define path to save screenShot of first screen (start date).
			screenShotPath = "c:\\tmp1\\";

			options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			driver.get(pangoURL);
			driver.manage().window().setSize(d);
			TimeUnit.SECONDS.sleep(waitBeforeClick);

			// Extract URL for text.
			String data = driver.findElementByTagName("body").getText();
			String[] arr = data.split("https://");
			String pango = "";
			for (String ss : arr) {
				pango = ss;
			}
			String panguGUID = pango.replaceAll("}", "").replaceAll("\"", "");

			// Open URL with GUID
			driver.get("https://" + panguGUID);
			// DATE file format
			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.from(Instant.now()));
			// Create a filename from a format string.
			filename = String.format("%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp", cal);

		} catch (Exception e) {
			System.out.println("Failed by wrong configuration!");
		}

		try {
			// Screen1.1: Start insurance date.
			wait = new WebDriverWait(driver, waitForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap-component-selector-2")));
			// Anypicker needs 2 seconds lock user choice.
			TimeUnit.SECONDS.sleep(2);
			// ScreenShot
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Now copy .jpeg to screenShotPath
			FileUtils.copyFile(scrFile, new File(screenShotPath + filename + ".jpeg"));
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
			driver.findElement(By.cssSelector("ul.radio-list>li")).click();
			// Screen1.3: Youngest driver.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap-component-selector-0")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath("/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[3]/button").click();
			// Screen1.4: licenseOfYoungestDriver.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q4-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[4]/div/app-step-content-vertical-options-view/ul/li[4]/label")
					.click();
			// Screen1.5: Mortgaged Vehicle.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q5-0-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			// Screen1.6: Comprehensive insurance.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q6-0-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			// Screen1.7: Claims in 3 years.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7-0-radio-1")));
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
		} catch (Exception e) {
			System.out.println("Failed in FIRST OFFER QUESTIONS.");
		}
		// Proceed to Final Offer screen.
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, waitForElement);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("body > app-root > primary-bid > div > div.bid-content > a")));
			// Final offer needs 6 seconds to load (after element is visible).
			TimeUnit.SECONDS.sleep(6);
			driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/a").click();

		} catch (Exception e) {
			System.out.println("Failed in first FIRST OFFER SCREEN");
			if (3 < 5) {
				System.out.println("You are in RED PATH");

			}
			return;

		}
		// FINAL OFFER SCREENS QUESTIONS.
	//	try {
			// Screen2.1: Policy owner.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-1-q-0-radio-1")));
			// Policy owner screen needs 3 seconds to load (after element is visible).
			TimeUnit.SECONDS.sleep(3);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[1]").click();
			// Screen2.2: Privacy details of policy owner.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-2-birthDate-3")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-2-firstName-0\"]").sendKeys(userName);
			driver.findElementByXPath("//*[@id=\"step-2-lastName-1\"]").sendKeys(lastName);
			driver.findElementByXPath("//*[@id=\"step-2-personalId-2\"]").sendKeys(idDriver);
			// birthDate
		//driver.findElementByXPath(
					//"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/ul/li[4]/question-wrapper/div/div")
			//		.click();
		//	driver.findElementByXPath(
				//	"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/ul/li[4]/question-wrapper/div/div/text-field/div/div/div")
			//		.click();
			//driver.findElementByXPath("//*[@id=\"step-2-birthDate-3\"]").sendKeys("01/01/1980");
		//	TimeUnit.SECONDS.sleep(4);
			//driver.findElementByXPath("//*[@id=\"step-2-birthDate-3\"]").clear();
		//	TimeUnit.SECONDS.sleep(1);
		//	driver.findElementByXPath("//*[@id=\"step-2-birthDate-3\"]").sendKeys(birthDate);
			
			
			TimeUnit.SECONDS.sleep(1);
				//stepTwoBirthPicker
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.stepTwoBirthPicker.setSelectedDate(new Date(1988, 0, 0, 0, 0, 0, 0))");
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"step-2-birthDate-3\"]").click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"ap-button-set\"]").click();
				// licenseIssueYear
			TimeUnit.SECONDS.sleep(1);
			js.executeScript("window.stepTwoLicensePicker.setSelectedDate(new Date(2006, 6, 14, 0, 0, 0, 0))");
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
			// *[@id="step-3-streetID-1"]/div/div/div[2]/input
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
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/ul/li[3]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/div/button[1]").click();
			// Screen2.5: questions for criminal record and policy refuse.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-7-q-0-radio-1")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/div/button[1]").click();
			// Screen2.6: Agreements sign V V V.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[1]/question-wrapper/div/div/single-checkbox/label")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[1]/question-wrapper/div/div/single-checkbox/label")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[2]/question-wrapper/div/div/single-checkbox/label/span")
					.click();
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[3]/question-wrapper/div/div/single-checkbox/label")
					.click();
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[1]").click();
		//} catch (Exception e) {
		//	System.out.println("Failed in FINAL OFFER SCREENS");
		//	return;
	//	}

		// Screen: Final offer!
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/final-bid/div/div[1]/a")));
		TimeUnit.SECONDS.sleep(waitBeforeClick);
		TimeUnit.SECONDS.sleep(waitBeforeClick);
		driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/a").click();
		// Screen: Covers.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]")));
		TimeUnit.SECONDS.sleep(waitBeforeClick);
		driver.findElementByXPath(
				"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]").click();
		// Screen: Payments.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[2]/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")));
		TimeUnit.SECONDS.sleep(waitBeforeClick);
		driver.findElementByXPath(
				"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[2]/div/div[2]/ul/li[2]/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
				.click();
		// Screen: CreditGuard
		try {
			TimeUnit.SECONDS.sleep(7);
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submitBtn\"]/span")));
			TimeUnit.SECONDS.sleep(1);
			driver.findElementByXPath("//*[@id=\"cardNumber\"]").sendKeys(cardNumber);
			driver.findElementByXPath("//*[@id=\"personalId\"]").sendKeys(cardPersonalId);
			driver.findElementByXPath("//*[@id=\"fullName\"]").sendKeys(cardFullName);
			TimeUnit.SECONDS.sleep(1);
			// driver.switchTo().defaultContent();
			Select dropdownYear = new Select(driver.findElement(By.id("expYear")));
			dropdownYear.selectByVisibleText(expYear);
			Select dropdownMonth = new Select(driver.findElement(By.id("expMonth")));
			TimeUnit.SECONDS.sleep(1);
			dropdownMonth.selectByVisibleText(expMonth);
			TimeUnit.SECONDS.sleep(waitBeforeClick);
			driver.findElementByXPath("//*[@id=\"submitBtn\"]").click();
		} catch (Exception e) {
			System.out.println("Failed in Iframe CreditGuard");
			return;
		}

		try {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.))
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submitBtn\"]/span")));
		} catch (Exception e) {
		}
	};

	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO: Define variables and path before run on different machine
		System.out.println("Automated testing started!");
		pangoAutoTesting();
		// pangoAutoTesting1();
		// pangoAutoTesting2();
		Calendar date = Calendar.getInstance();
	//	int year = Calendar.getInstance().get(Calendar.YEAR);

		
		//System.out.println(year);
	
		System.out.println("Automated testing DONE!");

	}

}