package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.demoblaze.com/index.html");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir")+"/screenshots/"+tname;
		File tgt = new File(target);
		src.renameTo(tgt);
		return target;
	}
}
