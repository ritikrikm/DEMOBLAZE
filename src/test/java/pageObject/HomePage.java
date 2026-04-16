package pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//a[@id='nava']")
	WebElement homeIcon;
	
	@FindBy(xpath="//div[@id='contcar']//li")
	List<WebElement> carousel;
	
	@FindBy(xpath="//a[@id='signin2']")
	WebElement signUpNav;

	@FindBy(xpath="//a[@id='login2']")
	WebElement loginNav;
	
	@FindBy(xpath="//div[@id='signInModal']")
	WebElement checkSignupModal;
	
	@FindBy(xpath="//input[@id='sign-username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='sign-password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Sign up']")
	WebElement signUpbtn;
	
	@FindBy(xpath="//div[@id='logInModal']")
	WebElement checkLoginModal;
	
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement loginUserName;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@id='nameofuser']")
	WebElement welcomeText;
	//actions
	public String titleCheck() {
		String title = driver.getTitle();
		return title;
	}
	public boolean homeIconPresence() {
		wait.until(ExpectedConditions.visibilityOf(homeIcon));
		if(homeIcon.isDisplayed()) {
			System.out.println("Displayed");
			System.out.println(homeIcon);
			return true;
		}
		return false;
	}
	
	public int carouselItem() {
		System.out.println(carousel.size());
		return carousel.size();
	}

	public void signUpClick() {
		wait.until(ExpectedConditions.visibilityOf(signUpNav));
		signUpNav.click();
	}
	

	public String signUp(String username, String pass) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOf(signUpbtn));
		signUpbtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
		
	}

	public void loginClick() {
		wait.until(ExpectedConditions.visibilityOf(loginNav));
		loginNav.click();
	}
	public boolean login(String username, String pass) {
		wait.until(ExpectedConditions.visibilityOf(loginUserName));
		loginUserName.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(loginPassword));
		loginPassword.sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		loginBtn.click();
		
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
		if(welcomeText.getText().startsWith("Welcome ")) {
			return true;
		}
		
		return false;
		
	}
}
