package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class AccountLogin001 extends BaseTest {
	@Test
	public void accountLogin() {
		HomePage hp = new HomePage(driver);

		hp.loginClick();
		boolean result = hp.login("ritikrik", "HelloHello");
		Assert.assertEquals(result, true);
		
	}
}
