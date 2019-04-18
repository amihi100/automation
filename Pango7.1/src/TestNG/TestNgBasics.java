package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	/**
	 * setup system property for chrome login method launch chrome browser enter URL
	 * Google Title Test log out from app Clsoe Browser Delete All Coockies
	 */

	/**
	 * @BeforeSuite -- setup system property for chrome: I
	 * @BeforeTest -- launch chrome browser: II
	 * @BeforeClass -- login app: III
	 * 
	 * 
	 * 
	 * @BeforeMethod -- enter URL
	 * @Test -- google logo test
	 * @AfterMethod -- log out from app
	 * 
	 * @BeforeMethod -- enter URL
	 * @Test -- Google Title Test
	 * @AfterMethod -- log out from app
	 * 
	 * @BeforeMethod -- enter URL
	 * @Test -- Search Test
	 * @AfterMethod -- log out from app
	 * 
	 * 
	 * 
	 * @AfterClass -- Clsoe Browser
	 * @AfterTest -- Delete All Coockies PASSED: googleLogotTest PASSED:
	 *            googleTitileTest PASSED: searchTe
	 */

	
	
	/**
	
	
// Pre-conditions annotations -- starting with @Before	
	@BeforeSuite // 1
	public void setUp() {
		System.out.println(" @BeforeSuite -- setup system property for chrome");
	}

	@BeforeTest // 2
	public void launchBrowser() {
		System.out.println("@BeforeTest -- launch chrome browser");
	}

	@BeforeClass // 3
	public void login() {
		System.out.println("@BeforeClass -- login app");
	}

	/**
	 * @BeforeMethod
	 * @Test 1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test 2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test 3
	 * @AfterMethod
	 */

	
	
	
	/**
	
	@BeforeMethod // 4
	public void enterURL() {
		System.out.println("@BeforeMethod -- enter URL");
	}

	// testcases -- starting with @Test
	@Test // 5
	public void googleTitileTest() {
		System.out.println("@Test -- Google Title Test");
	}
	@Test // 5.5
	public void searchTest() {
		System.out.println("@Test -- Search Test");
	}
	@Test // 5.6
	public void googleLogotTest() {
		System.out.println("@Test -- google logo test");
	}
	// post conditions -- starting with @After
	@AfterMethod // 6
	public void logOut() {
		System.out.println("@AfterMethod -- log out from app");
	}

	@AfterClass // 7
	public void clsoeBrowser() {
		System.out.println("@AfterClass -- Clsoe Browser");
	}

	@AfterTest // 8
	public void deleteAllCoockies() {
		System.out.println("@AfterTest -- Delete All Coockies");
	}
	
	 @AfterSuite//9 public void generateTestReport() {
	  System.out.println("@AfterSuite -- Generate Test Report"); }
	 

	**/
	
}
