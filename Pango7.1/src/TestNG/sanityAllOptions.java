package TestNG;
/**
 * Java Selenium project for Pango insurance app.  
 * amihi100@gmail.com
 * Version 1.1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
//import com.google.common.base.Stopwatch;

/**
 * import of take screenshot and save a file: import java.io.File; import
 * org.apache.commons.io.FileUtils; import org.openqa.selenium.OutputType;
 * import org.openqa.selenium.TakesScreenshot;
 *
 */

public class sanityAllOptions{
	@Parameters("env")
	public sanityAllOptions(String env)
			throws InvalidPropertiesFormatException, FileNotFoundException, IOException, InterruptedException {
		// TimeUnit.SECONDS.sleep(10);
		VarClass = new varClass();
		try {
			VarClass.defineVariables(env);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	java.util.Date dateTime = new java.util.Date();
	varClass VarClass;
	WebDriverWait waitZ;

	/**
	 * // Screen1.1: Start insurance date. In case we want to use next day month:
	 * date.add(Calendar.DATE, 1); Or just assign the Vars to specific date: static
	 * int startDateYear = 2019; static int startDateMonth = 2; static int
	 * startDateDay = 19;
	 */
	// Start insurance at the same day.
	int startDateYear = Calendar.getInstance().get(Calendar.YEAR);
	// static int startDateMonth = Calendar.getInstance().get(Calendar.MONTH)+9;
	int startDateMonth = Calendar.getInstance().get(Calendar.MONTH);
	int startDateDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

	/**
	 * // Screen1.2 How many drivers: 1 driver: static String numberOfDrivers =
	 * 
	 * 
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[1]/label";
	 * 2 drivers: static String numberOfDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	 * 3 drivers: static String numberOfDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[3]/label";
	 * All drivers: static String numberOfDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[4]/label";
	 */
	// 1 driver:

	/**
	 * public String oneDriver, twoDrivers, threeDrivers, allDrivers;
	 * 
	 * oneDriver =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[1]/label";
	 * twoDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	 * threeDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[3]/label";
	 * allDrivers =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[2]/div/app-step-content-vertical-options-view/ul/li[4]/label";
	 **/

	String numberOfDrivers = "step-0-q4-radio-4";

	/**
	 * // Screen1.3: Youngest driver age. All age options {val: 20, label: "17-20"}
	 * {val: 23, label: "21-23"} {val: 26, label: "24-26"} {val: 29, label: "27-29"}
	 * {val: 34, label: "30-34"} {val: 39, label: "35-39"} {val: 46, label: "40-46"}
	 * {val: 49, label: "47-49"} {val: 59, label: "50-59"} {val: 64, label: "60-64"}
	 * {val: 69, label: "65-69"} {val: 74, label: "70-74"} {val: 77, label: "+75"}
	 */
	String youngestDriverAge = "34";

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
	// String licenseOfYoungestDriver =
	// "VarClass.driver.findElementByXPath("//label[contains(text(),'10')"]).click()";
	/**
	 * Screen 1.5 Mortgaged car. Mortgaged NO: static String mortgagedCar =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1];
	 * Mortgaged YES: static String mortgagedCar =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	// Mortgaged YES:
	String mortgagedCar = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[5]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	/**
	 * Screen 1.6: 3 years insurance. Yes 3 years insurance: static String
	 * threeYearsInsurance =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 * No 3 years ins static String threeYearsInsurance =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 */
	// Yes 3 years insurance:
	String threeYearsInsurance = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[6]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	/**
	 * Screen 1.7: Claims in 3 years. No claims in 3 years: static String
	 * claimsIn3Years =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 * Yes claims in 3 years: static String claimsIn3Years =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	// Yes claims in 3 years:
	String claimsIn3Years = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[7]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";

	/**
	 * Screen 1.8 how many claims 0 claims static String howManyClaims =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[1]/label";
	 * 1 claim static String howManyClaims =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[2]/label";
	 * more than 1 claim static String howManyClaims =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[3]/label";
	 * 
	 * @throws Exception
	 */
	// one claim
	String howManyClaims = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-content-vertical-options-view/ul/li[2]/label";

	/*
	 * Screen 1.9 Restriction in 3 years No restrictions: static String restrictions
	 * =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[9]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 * Yes restrictions: static String restrictions =
	 * "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[9]/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	// No restrictions
	String restrictions = "/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[9]/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";

	/**
	 * Screen 2.1 Gender MALE: static String gender =
	 * "/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]";
	 * FEMALE: static String gender =
	 * "/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";
	 */
	// Female:
	String gender = "/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]";

//	@Test(priority = 1 , dependsOnGroups={"varClass.defineVariables"})
	@Test(priority = 12)
	public void initialOfferQuestions() throws Exception {
		try {
			Instant start = Instant.now();
			// Screen1.1: Start insurance date.
			VarClass.wait = new WebDriverWait(VarClass.driver, VarClass.waitForElement);
			// VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap-component-selector-2")));
			// Anypicker needs 2 seconds lock user choice.

//			 ScreenShot
			File scrFile = ((TakesScreenshot) VarClass.driver).getScreenshotAs(OutputType.FILE);
//			 Now copy .jpeg to screenShotPath
			FileUtils.copyFile(scrFile, new File(VarClass.screenShotPath + VarClass.filename + ".jpeg"));
			JavascriptExecutor js = (JavascriptExecutor) VarClass.driver;
			// VarClass.driver.findElementByXPath("/html/body/app-root/accessibility-menu/div/button[2]").click();
			// TimeUnit.SECONDS.sleep(10);
			js.executeScript("window.pickerInstance.showOrHidePicker()");
			js.executeScript("window.pickerInstance.setSelectedDate(new Date(" + startDateYear + "," + startDateMonth
					+ "," + startDateDay + ", 0, 0, 0, 0))");
			TimeUnit.SECONDS.sleep(1);
			js.executeScript("window.pickerInstance.showOrHidePicker()");
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			JavascriptExecutor js2 = (JavascriptExecutor) VarClass.driver;
			js2.executeScript("$(\".accessibility-menu\").show();");
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			// This is the original:
			// $(".accessibility-menu").show();
			VarClass.driver.findElement(By.xpath("//aw-wizard-step[1]//*[contains(@class,'orange')]")).click();
			// VarClass.driver.findElementByXPath("//*[@id=\"ap-component-selector-1\"]").click();
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			js.executeScript("setTimeout(()=>{document.querySelector('#btn-save-start-date').click()}, 000)");
			// Screen1.2: How many drivers.
			VarClass.wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'ללא הגבלה')]")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//label[contains(text(),'ללא הגבלה')]").click();
			// VarClass.driver.findElementByXPath(numberOfDrivers).click();
			// Screen1.3: Youngest driver.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap-component-selector-0")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//*[@id=\"ap-component-selector-0\"]").click();
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//aw-wizard-step[3]//*[contains(@class,'orange')]").click();
			// Screen1.4: licenseOfYoungestDriver.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q4-radio-1")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//label[contains(text(),'10-15 שנים')]").click();
			// Screen1.5: Mortgaged Vehicle.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q5-0-radio-1")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath(mortgagedCar).click();
			// Screen1.6: 3 years insurance.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q6-0-radio-1")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath(threeYearsInsurance).click();
			// Screen1.7: Claims in 3 years.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7-0-radio-1")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath(claimsIn3Years).click();
			// Screen1.8 how many claims in 3 years.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7.1-radio-2")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath(howManyClaims).click();
			// Screen1.9 Restrictions in 3 years
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7.2-0-radio-1")));
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath(restrictions).click();
			Instant end = Instant.now();
			System.out.println("Method initialOfferQuestions took: " + Duration.between(start, end));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in FIRST OFFER QUESTIONS.");
		}
	}

	
	
	
	
	
	

	

	
	
	
	// @Test(enabled=false)
	@Test(priority = 20)
	public void callMeWizard1() throws Exception {
		try {

			TimeUnit.SECONDS.sleep(7);
			// Call me back function.
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bid-footer")));
			VarClass.driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[2]/ul/li[1]/a/img").click();
			TimeUnit.MILLISECONDS.sleep(VarClass.MILLISECONDS);
			// if running with REAL APP ID:
			if (VarClass.appID) {
				System.out.println(VarClass.appID);
				boolean appPhoneNumber = VarClass.driver
						.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").isDisplayed();
				if (appPhoneNumber) {
					VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").click();
					System.out.println("appPhoneNumber is true");
				}
				TimeUnit.SECONDS.sleep(1);
				VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/input").clear();
				// TimeUnit.SECONDS.sleep(1);
				VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").click();
				TimeUnit.SECONDS.sleep(1);
			}
			// END
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/input")
					.sendKeys(VarClass.wizardPhone0);
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button")));
			VarClass.driver
					.findElementByCssSelector("#modal-call-back > div.modal-dialog > div > div.modal-body > p > button")
					.click();
			TimeUnit.MILLISECONDS.sleep(VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button").click();
			// Need to wait 1500 miliSec for popup click/
			TimeUnit.MILLISECONDS.sleep(1500);
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back-success\"]/div[1]/div/div[1]/button/img")
					.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in ***Call me wizard 1***");
		}
	}

	@Test(priority = 30)
	public void initialOfferScreen() throws Exception {
		try {

			TimeUnit.SECONDS.sleep(2);
			WebDriverWait wait1 = new WebDriverWait(VarClass.driver, this.VarClass.waitForElement);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("body > app-root > primary-bid > div > div.bid-content > a.link-procceed")));
			System.out.println("Count of links on the page: " + VarClass.driver.findElements(By.tagName("a")).size());
			System.out.println(
					"מספר רכב: " + VarClass.driver.findElementByXPath("//*[@id=\"carDetilas\"]/span[2]").getText());
			System.out.println("מחיר הצעה ראשונית: " + VarClass.driver
					.findElementByXPath("//*[@id=\"primary_bid_div\"]/div[1]/div[1]/div[1]/span").getText());
			System.out.println("תאריך תחילת ביטוח: " + VarClass.driver
					.findElementByXPath("//*[@id=\"primary_bid_div\"]/div[1]/div[2]/div[3]").getText());
			// Valid days of proposal:
			System.out.println(VarClass.driver.findElementByXPath("//*[@id=\"primary_bid_div\"]/div[1]/div[4]/span")
					.getText().toString());
			// Check covers:
			VarClass.driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/ul/li[1]/a").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[1]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[1]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[3]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[3]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[5]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[2]/ul/li[5]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-insurance-covers\"]/div[1]/div/div[1]/button/img")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// Protection / Secure level:
			VarClass.driver.findElementByXPath("//*[@id=\"primary_bid_div\"]/div[1]/ul/li[2]/a").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// Printing the secure level from Menora:
			System.out.println(
					"מיגון נדרש: " + VarClass.driver.findElementByClassName("desc-shield").getText().toString());

			VarClass.driver.findElementByXPath("//*[@id=\"modal-shield\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// Terms of condition:
			VarClass.driver.findElementByXPath("//a[contains(text(),'ומדיניות פרטיות')]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//modal-dialog[15]//img[1]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// Privacy policy:

			VarClass.driver
					.findElementByXPath("/html[1]/body[1]/app-root[1]/primary-bid[1]/div[1]/div[1]/div[4]/span[1]/a[2]")
					.click();

			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);

			VarClass.driver.findElementByXPath("//modal-dialog[15]//button[1]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);

			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//*[@id=\"primary_bid_div\"]/div[1]/a[1]").click();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in INITIAL OFFER SCREEN QUESTION");
		}
	}

	@Test(priority = 40)
	public void finalOfferQuestions() throws Exception {
		// FINAL OFFER SCREENS QUESTIONS.
		try {

			// Screen2.1: Privacy details of policy owner.

			this.VarClass.wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("label-for-step-1-birthDate-4")));
			TimeUnit.SECONDS.sleep(1);
			VarClass.driver.findElementByXPath("//*[@id=\"step-1-firstName-0\"]").sendKeys(this.VarClass.insuredName);
			VarClass.driver.findElementByXPath("//*[@id=\"step-1-lastName-1\"]")
					.sendKeys(this.VarClass.insuredLastName);
			VarClass.driver.findElementByXPath("//*[@id=\"step-1-personalId-2\"]")
					.sendKeys(this.VarClass.insuredIdDriver);
			// Gender
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[4]/question-wrapper/div/div/combo-box/div/select")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// Pick female:
			VarClass.driver.findElementByXPath("//select[@id='step-1-gender-3']//option[contains(text(),'נקבה')]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/ul/li[4]/question-wrapper/div/div/combo-box/div/select")
					.click();
			// birthDate

			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// stepTwoBirthPicker
			VarClass.driver.findElementByXPath("//*[@id=\"step-1-birthDate-4\"]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);

			// JavascriptExecutor js = (JavascriptExecutor) VarClass.driver;
//			js.executeScript("window.stepTwoBirthPicker.setSelectedDate(new Date(" + this.VarClass.insuredBirthDate
//					+ ", 1, 0, 0, 0, 0, 0))");
			TimeUnit.SECONDS.sleep(1);
			// VarClass.driver.findElementByXPath("//*[@id=\"step-2-birthDate-3\"]").click();
			VarClass.driver.findElementByXPath("//*[@id=\"ap-button-set\"]").click();
			// licenseIssueYear
			TimeUnit.SECONDS.sleep(2);
//			js.executeScript("window.stepTwoLicensePicker.setSelectedDate(new Date("
//					+ this.VarClass.insuredLicenseIssueYear + ", 6, 14, 0, 0, 0, 0))");
			VarClass.driver.findElementByXPath("//*[@id=\"label-for-step-1-licenseIssueYear-5\"]").click();
			TimeUnit.SECONDS.sleep(2);
			VarClass.driver.findElementByXPath("//*[@id=\"ap-button-set\"]").click();
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver
					.findElementByXPath(
							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[1]")
					.click();
			// Screen2.2: Contact details of policy owner
			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-2-cityID-0"))).click();
			TimeUnit.SECONDS.sleep(1);
			// city:
			VarClass.driver.findElementByXPath("//*[@id=\"step-2-cityID-0\"]/div/div/div[2]/input")
					.sendKeys(this.VarClass.city);
			TimeUnit.SECONDS.sleep(1);
			VarClass.driver.findElement(By.cssSelector("div.ng-dropdown-panel-items>div>div.ng-option")).click();
			TimeUnit.SECONDS.sleep(1);
			// street:
			VarClass.driver.findElementByXPath("//*[@id=\"step-2-streetID-1\"]/div/div/div[2]/input")
					.sendKeys(this.VarClass.street);
			TimeUnit.SECONDS.sleep(1);
			VarClass.driver.findElement(By.cssSelector("div.ng-dropdown-panel-items.scroll-host>div>div.ng-option"))
					.click();
			// houseNumber:
			VarClass.driver.findElementByXPath("//*[@id=\"step-2-houseNumber-2\"]").sendKeys(this.VarClass.houseNumber);
			// Email:
			VarClass.driver.findElementByXPath("//*[@id=\"step-2-email-3\"]").sendKeys(this.VarClass.email);
			// Cellphone:
			VarClass.driver.findElementByXPath("//*[@id=\"step-2-cellphone-4\"]").sendKeys(this.VarClass.cellphone);
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver
					.findElementByXPath(
							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/div/button[1]")
					.click();
			// Screen2.3: 3 questions for driver and policy owner.
			this.VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-3-q-0-radio-1")));
			TimeUnit.SECONDS.sleep(1);
			// All No:
			VarClass.driver.findElementByXPath(

					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/ul/li[3]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(1);
			// All YES:
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/ul/li[3]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver
					.findElementByXPath(
							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/div/button[1]")
					.click();
			// Screen2.4: questions for criminal record and policy refuse.
			this.VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-6-q-0-radio-1")));
			TimeUnit.SECONDS.sleep(1);
			// All YES:
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[1]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(1);
			// All NO:
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/ul/li[1]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/ul/li[2]/question-wrapper/div/div/app-step-content-horizontal-options-view/ul/li[2]/label/span[1]")
					.click();
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver
					.findElementByXPath(
							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[7]/div/div/button[1]")
					.click();
			// Screen2.5: Agreements sign V.
			this.VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chk-step9-q2-lbl")));
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// click V:
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[3]/question-wrapper/div/div/single-checkbox/label")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// open privacy policy:
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[1]/question-wrapper/div/div/plain-text/p/span")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-general-ext\"]/div[1]/div/div[2]/p/span").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// close privacy policy second screen.
			VarClass.driver.findElementByXPath("//*[@id=\"modal-privacy-policy\"]/div[1]/div/div[1]/button/img")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/ul/li[2]/question-wrapper/div/div/plain-text/p/span")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-general-ext\"]/div[1]/div/div[1]/button/img").click();
//			VarClass.driver.findElementByXPath(
//					"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/ul/li[2]/question-wrapper/div/div/plain-text/p/span")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver.findElementByXPath("//*[@id=\"modal-general-ext\"]/div[1]/div/div[1]/button/img").click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);

//			// NOW RETURN ALL STEPS IN FINAL OFFER:
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[9]/div/div/button[2]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[2]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/div/button[2]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/div/button[2]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/div/button[2]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[2]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			// driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/a").click();
//			VarClass.driver.findElementByXPath("/html/body/app-root/primary-bid/div/div[1]/a[2]").click();
//			// NOW FORWARD TO FINAL OFFER:
//			// Policy owner.
//			this.VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-1-q-0-radio-1")));
//			// Policy owner screen needs 2 seconds to load (after element is visible).
//			TimeUnit.SECONDS.sleep(2);
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[1]/div/div/button[1]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[2]/div/div/button[1]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[3]/div/div/button[1]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[4]/div/div/button[1]")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver
//					.findElementByXPath(
//							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[1]")
//					.click();
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver
					.findElementByXPath(
							"/html/body/app-root/external-app-offer/aw-wizard/div/aw-wizard-step[8]/div/div/button[1]")
					.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in FINAL OFFER QUESTIONS");
		}
	}

	@Test(priority = 50)
	public void finalOfferScreen() throws Exception {
		try {
			// Screen: Final offer!
			this.VarClass.wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/app-root/final-bid/div/div[1]/a[2]")));
			// Need to wait 3 seconds for element.
			TimeUnit.SECONDS.sleep(3);
			// Requred covers:
			VarClass.driver.findElementByXPath("//a[contains(text(),'כיסויים כלולים')]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[1]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[1]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[3]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[3]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[5]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-insurance-covers-2\"]/div[1]/div/div[2]/ul/li[5]/panel/div/a")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// Close covers:
			VarClass.driver.findElementByXPath(
					"//modal-dialog[@id='modal-insurance-covers-2']//div[@class='modal-header']//img").click();
			// Takanon sale:
//			VarClass.driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/div[6]/a[2]").click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
//			VarClass.driver.findElementByXPath("//*[@id=\"modal-insurance-takanon\"]/div[1]/div/div[1]/button/img")
//					.click();
//			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);

			System.out.println(VarClass.driver.findElementByXPath("//span[@class='bid-id']").getText().toString());
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("//a[@class='link-procceed']").click();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in FINAL OFFER screen");
		}
	}

	@Test(enabled = false)
	// @Test(priority = 60)
	public void callMeWizard2() throws Exception {
		try {
			// Call me back function Wizard #2.
			VarClass.driver.findElementByXPath("/html/body/app-root/final-bid/div/div[2]/ul/li[1]/a/img").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").click();
			TimeUnit.SECONDS.sleep(1);

			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/input").clear();
			TimeUnit.SECONDS.sleep(1);

			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/a").click();
			TimeUnit.SECONDS.sleep(1);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/input")
					.sendKeys(VarClass.wizardPhone1);
			TimeUnit.SECONDS.sleep(1);
			this.VarClass.wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button")));
			VarClass.driver
					.findElementByCssSelector("#modal-call-back > div.modal-dialog > div > div.modal-body > p > button")
					.click();
			TimeUnit.MILLISECONDS.sleep(VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back\"]/div[1]/div/div[2]/p/button").click();
			// Need to wait 2500 miliSec for popup click.
			TimeUnit.MILLISECONDS.sleep(3000);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-call-back-success\"]/div[1]/div/div[1]/button/img")
					.click();
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath("/html/body/app-root/final-bid/div/div[1]/a[2]").click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in call me wizard #2");
		}
	}

	@Test(priority = 70)
	public void covers() throws Exception {
		try {
			// Screen: Covers.
			this.VarClass.wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[contains(text(),'ביטול השתתפות עצמי')]")));

			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[1]/label")
					.click();

			VarClass.driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[2]/label")
					.click();
			;
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[3]/label")
					.click();
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/horizontal-checkboxes/ul/li[4]/label")
					.click();
			System.out.println("כיסויים כוללים:");
			System.out.println("-------------------------");
			System.out.println(VarClass.driver
					.findElementByXPath("//horizontal-checkboxes[@class='horizontal-checkboxes']//li[1]//label[1]")
					.getText().toString());
			System.out.println("-------------------------");
			System.out.println(VarClass.driver
					.findElementByXPath(" //horizontal-checkboxes[@class='horizontal-checkboxes']//li[2]//label[1]")
					.getText().toString());
			System.out.println("-------------------------");
			System.out.println(VarClass.driver.findElementByXPath("//app-root//li[3]//label[1]").getText().toString());
			System.out.println("-------------------------");
			System.out.println(VarClass.driver.findElementByXPath("//app-root//li[4]//label[1]").getText().toString());
			System.out.println("-------------------------");
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			VarClass.driver.findElementByXPath(
					"/html/body/app-root/offer-payment/aw-wizard/div/aw-wizard-step[1]/div/div[2]/div/button[1]")
					.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in COVERS screen");
		}
	}

	@Test(priority = 80)
	public void payments() throws Exception {
		try {
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
			this.VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//ul[@class='list-questions account']//label[contains(text(),'תשלום אחד')]")));
			VarClass.driver
					.findElementByXPath("//*[@id=\"modal-isAccountOwnerNull\"]/div[1]/div/div/div[2]/div/div/p/span")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//*[@id=\"modal-shield\"]/div[1]/div/div[1]/button/img").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//ul[@class='list-questions account']//label[contains(text(),'2 תשלומים')]")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver
					.findElementByXPath("//ul[@class='list-questions account']//label[contains(text(),'3 תשלומים')]")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);

			WebElement element = VarClass.driver.findElement(
					By.xpath("//ul[@class='list-questions account']//label[contains(text(),'3 תשלומים')]"));

			((JavascriptExecutor)

			VarClass.driver).executeScript("arguments[0].scrollIntoView()", element);
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);

			VarClass.driver
					.findElementByXPath("//ul[@class='list-questions account']//label[contains(text(),'7 תשלומים')]")
					.click();
			TimeUnit.SECONDS.sleep(10);
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);

			if (VarClass.appID) {

				VarClass.driver.findElementByXPath("//li[@class='right-option-disabled']//img[@class='img-default']")
						.click();

			} else {
				// VarClass.driver.findElementByXPath(" //span[contains(text(),'כרטיס אשראי
				// אחר')]").click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in PAYMENTS screen");
		}
	}

	@Test(priority = 85)
	public void returnSteps() throws Exception {
		try {

			VarClass.driver
					.findElementByXPath("//div[@class='account']//button[@class='btn-empty'][contains(text(),'חזרה')]")
					.click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//offer-payment[@class='offer-payment']//button[2]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//a[@class='link-back']").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//aw-wizard-step[8]//div[1]//div[1]//button[2]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//aw-wizard-step[7]//div[1]//div[1]//button[2]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//aw-wizard-step[3]//div[1]//div[1]//button[2]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//aw-wizard-step[2]//div[1]//div[1]//button[2]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//aw-wizard-step[1]//div[1]//div[1]//button[2]").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			VarClass.driver.findElementByXPath("//a[@class='link-back']").click();
			TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
			// return back in first offer:
			// screen 9
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			WebElement element = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[9]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[1]//label[1]//span[1]"));
			WebElement target = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[9]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();

			// screen8

			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			JavascriptExecutor jse = (JavascriptExecutor) VarClass.driver;
			jse.executeScript("document.getElementById('step-0-q7.1-radio-2').focus();");

			JavascriptExecutor js = (JavascriptExecutor) VarClass.driver;
			js.executeScript("$('#media-only').trigger('swipe', {startX: 0.95})");

			VarClass.driver
					.findElementByXPath(
							"/html/body/app-root/app-offer/aw-wizard/div/aw-wizard-step[8]/div/app-step-header/h1")
					.click();

			VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step-0-q7.1-radio-2")));
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);

			WebElement element12 = VarClass.driver.findElement(By.xpath(
					"/html[1]/body[1]/app-root[1]/app-offer[1]/aw-wizard[1]/div[1]/aw-wizard-step[8]/div[1]/app-step-content-vertical-options-view[1]/ul[1]/li[2]/label[1]"));
			WebElement target12 = VarClass.driver.findElement(By.className("accessibility-menu"));
			Thread.sleep(250);
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			(new Actions(VarClass.driver)).dragAndDrop(element12, target12).perform();

			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick + 1);

			// screen7
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			element = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[7]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[1]//label[1]//span[1]"));
			target = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[7]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();
			// screen6
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			element = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[6]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[1]//label[1]//span[1]"));
			target = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[6]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();
			// screen5
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			element = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[5]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[1]//label[1]//span[1]"));
			target = VarClass.driver.findElement(By.xpath(
					"//aw-wizard-step[5]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();
			// screen4
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			element = VarClass.driver.findElement(By.xpath("//label[contains(text(),'10-15 שנים')]"));
			target = VarClass.driver.findElement(By.xpath("//button[@class='btn-toggle-accessibility-menu']//img"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();

			// screen3
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			element = VarClass.driver.findElement(By.xpath("//aw-wizard-step[3]//button[2]"));
			target = VarClass.driver.findElement(By.xpath("//button[@class='btn-toggle-accessibility-menu']//img"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();

			// screen2
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			element = VarClass.driver.findElement(By.xpath("//label[contains(text(),'ללא הגבלה')]"));
			target = VarClass.driver.findElement(By.xpath("//button[@class='btn-toggle-accessibility-menu']//img"));
			(new Actions(VarClass.driver)).dragAndDrop(element, target).perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in moveing BACKWARD");
		}
	}

	@Test(priority = 86)
	public void forwardSteps() throws Exception {
		try {
			// move to screen2
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver
					.findElementByXPath(
							"/html[1]/body[1]/app-root[1]/app-offer[1]/aw-wizard[1]/div[1]/aw-wizard-step[1]/button[1]")
					.click();
			// move to screen3
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);

			VarClass.driver.findElementByXPath(
					"/html[1]/body[1]/app-root[1]/app-offer[1]/aw-wizard[1]/div[1]/aw-wizard-step[2]/div[1]/app-step-content-vertical-options-view[1]/ul[1]/li[4]/label[1]")
					.click();
			// move to screen4
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//aw-wizard-step[3]//button[2]").click();
			// move to screen5
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//label[contains(text(),'10-15 שנים')]").click();
			// move to screen6
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath(
					"//aw-wizard-step[5]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]")
					.click();
			// move to screen7
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath(
					"//aw-wizard-step[6]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]")
					.click();
			// move to screen8
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath(
					"//aw-wizard-step[7]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[2]//label[1]//span[1]")
					.click();
			// move to screen9
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath(
					"//aw-wizard-step[8]//div[1]//app-step-content-vertical-options-view[1]//ul[1]//li[2]//label[1]")
					.click();
			// move to finalOfferScreen
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath(
					"//aw-wizard-step[9]//div[1]//app-step-content-horizontal-options-view[1]//ul[1]//li[1]//label[1]//span[1]")
					.click();
			TimeUnit.SECONDS.sleep(10);
			// move to screen2.1
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//a[@class='link-procceed']").click();
			// move to screen2.2
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//aw-wizard-step[1]//div[1]//div[1]//button[1]").click();
			// move to screen2.3
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//aw-wizard-step[2]//div[1]//div[1]//button[1]").click();
			// screen2.3
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//aw-wizard-step[3]//div[1]//div[1]//button[1]").click();
			// screen2.4
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//aw-wizard-step[7]//div[1]//div[1]//button[1]").click();

			// screen2.5 (Approve V)
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//button[contains(text(),'סיימנו. נעבור לתשלום')]").click();
			TimeUnit.SECONDS.sleep(10);

			// finalOfferScreen:
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//a[@class='link-procceed']").click();

			// coversScreen:
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick + 1);
			VarClass.driver.findElementByXPath("//button[@class='btn-blue']").click();

			// payments screen (scroll down to see 7 payments).
			WebElement element = VarClass.driver.findElement(
					By.xpath("//ul[@class='list-questions account']//label[contains(text(),'3 תשלומים')]"));
			((JavascriptExecutor) VarClass.driver).executeScript("arguments[0].scrollIntoView()", element);
			TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in moveing FORWARD");
		}

		// TODO Swipe back and forward in first offer.
	}

	@Test(priority = 90)
	public void iframeCreditGuard() throws Exception {
		// Screen: CreditGuard
		try {
			TimeUnit.SECONDS.sleep(10);
			// handke with iframe

			// handle with popups alerts
			// Print the alert first:
			// System.out.println(VarClass.driver.switchTo().alert().getText());
			// VarClass.driver.switchTo().accept(); // Accept = ok done yes.
			// VarClass.driver.switchTo().dismiss(); // Dont accept.
			if (VarClass.appID) {
				VarClass.driver.switchTo().frame(0);
				VarClass.driver.findElementByXPath("//*[@id=\"mat-input-0\"]").sendKeys(this.VarClass.cardFullName);
				TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
				VarClass.driver.findElementByXPath("//*[@id=\"mat-checkbox-1\"]/label/div").click();
				TimeUnit.MILLISECONDS.sleep(this.VarClass.MILLISECONDS);
				VarClass.driver.findElementByXPath("//*[@id=\"content\"]/form/button/span").click();

			} else {
				this.VarClass.wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class='account']//button[@class='btn-blue'][contains(text(),'המשך')]")));
				TimeUnit.SECONDS.sleep(1);
				VarClass.driver.findElementByXPath(
						"//div[@class='account']//button[@class='btn-blue'][contains(text(),'המשך')]").click();

				VarClass.driver.findElementByXPath("//*[@id=\"cardNumber\"]").sendKeys(this.VarClass.cardNumber);
				VarClass.driver.findElementByXPath("//*[@id=\"personalId\"]").sendKeys(this.VarClass.cardPersonalId);
				VarClass.driver.findElementByXPath("//*[@id=\"fullName\"]").sendKeys(this.VarClass.cardFullName);
				TimeUnit.SECONDS.sleep(1);
				// driver.switchTo().defaultContent();
				Select dropdownYear = new Select(VarClass.driver.findElement(By.id("expYear")));
				dropdownYear.selectByVisibleText(this.VarClass.cardYear);
				TimeUnit.SECONDS.sleep(1);
				Select dropdownMonth = new Select(VarClass.driver.findElement(By.id("expMonth")));
				TimeUnit.SECONDS.sleep(1);
				dropdownMonth.selectByVisibleText(this.VarClass.cardMonth);
				TimeUnit.SECONDS.sleep(this.VarClass.waitBeforeClick);
				VarClass.driver.findElementByXPath("//*[@id=\"submitBtn\"]").click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in Iframe CreditGuard");
		}
	}

	@Test(priority = 100)
	public void thankYouPage() throws Exception {
		try {
			TimeUnit.SECONDS.sleep(5);
			String URL = VarClass.driver.getCurrentUrl();
			if (URL == this.VarClass.thankYouURL || VarClass.wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("/html/body/app-root/thank-you-page/div/h1")))
					.isDisplayed()) {
				System.out.println("You reached to THANK YOU page!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to display thank you page");
		}
	}

	@Test(priority = 110)
	public void registeredAccount() throws Exception {
		TimeUnit.SECONDS.sleep(3);
		try {
			TimeUnit.SECONDS.sleep(VarClass.waitBeforeClick);
			if (VarClass.appID) {
				VarClass.driver.get(VarClass.environmentURL);
			}
			if (this.VarClass.driver.findElementByXPath("/html/body/app-root/registered-account/div/div[1]/div/img")
					.isDisplayed()
					|| this.VarClass.driver
							.findElementByXPath("/html/body/app-root/registered-account/div/div[2]/ul/li[1]/a/img")
							.isDisplayed()) {
				System.out.println("You reached to Registered Account page!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to display thank you page");
		}
	}
}