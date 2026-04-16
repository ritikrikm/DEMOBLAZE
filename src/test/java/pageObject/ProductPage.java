package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='btn btn-success btn-lg']")
	WebElement addCart;
	
	@FindBy(xpath="//div[@id='tbodyid']/h2")
	WebElement productName;
	
	@FindBy(xpath="//div[@id='tbodyid']/h3")
	WebElement productPrice;
	
	@FindBy(xpath="//div[@id='more-information']/p")
	WebElement productDesc;
	
	public void printInfo() {
	wait.until(ExpectedConditions.visibilityOf(productName));
	wait.until(ExpectedConditions.visibilityOf(productPrice));
	wait.until(ExpectedConditions.visibilityOf(productDesc));
	System.out.println(productName.getText() +" ->" + productPrice.getText() +"->" + productDesc.getText() );
	}
	public String addToCart(){
		wait.until(ExpectedConditions.visibilityOf(addCart));
		addCart.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
		
	}

}
