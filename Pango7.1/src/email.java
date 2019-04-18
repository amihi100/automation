import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class email {

	
	
	public static void email() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amichaito\\Desktop\\Code\\Selenium\\PangoAPP\\chromedriver.exe");
		ChromeDriver driver;
		driver = new ChromeDriver();
		driver.get("https://outlook.office365.com/owa/");
		driver.findElementByXPath("//*[@id=\"primaryContainer\"]/div[4]/div/div[1]/div/div[4]/div[1]/div/div[1]/div/div/div[2]").click();

		//String twoFactorCode = totp.now(); // <- got 2FA coed at this time!
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		email();

	}

}
