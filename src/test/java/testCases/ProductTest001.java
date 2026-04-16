package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.Dashboard;
import pageObject.HomePage;
import pageObject.ProductPage;

public class ProductTest001 extends BaseTest {
	private Dashboard dp;
    private ProductPage pp;
	@BeforeMethod
	public void login() {
		HomePage hp = new HomePage(driver);
		
		hp.loginClick();
		hp.login("ritikrik", "HelloHello");
		
		dp = new Dashboard(driver);
		dp.checkLoggedIn();
		Assert.assertTrue(dp.getPhonesCount()>0);
		dp.productClick();
		 pp = new ProductPage(driver);
		
	}
	
	@Test(priority=0)
	public void printing() {
		
		
		pp.printInfo();
		
	}
	
	@Test
	public void addProduct() {
		
		Assert.assertEquals(pp.addToCart(), "Product added.");
	}

}
