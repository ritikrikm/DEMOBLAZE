package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class AccountRegister001 extends BaseTest {
	@Test
	public void accountRegister() {
		HomePage hp = new HomePage(driver);
		String randomName = RandomStringUtils.randomAlphabetic(8);
		hp.signUpClick();
		String result = hp.signUp(randomName, "HelloHello");
		Assert.assertEquals(result, "Sign up successful.");

	}
}
