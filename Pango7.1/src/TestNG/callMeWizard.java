package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class callMeWizard {

	
	varClass  a = new varClass();
	varClass VarClass;
	
	
	// @Test(enabled=false)
		@Test(priority = 20)
		public void callMeWizard() throws Exception {
			try {

				TimeUnit.SECONDS.sleep(7);
				// Call me back function.

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

	
	
}
