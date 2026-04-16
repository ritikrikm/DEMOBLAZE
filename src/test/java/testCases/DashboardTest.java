package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import pageObject.Dashboard;
import pageObject.HomePage;

public class DashboardTest extends BaseTest {
	public HomePage hp;
	public Dashboard db;
	
	@BeforeMethod
	public void login() {
		hp = new HomePage(driver);
		hp.loginClick();
		Assert.assertTrue(hp.login("ritikrik", "HelloHello"));
		 db = new Dashboard(driver);
	}
	
//	@Test
//	public void getAllCount() {
//		Assert.assertTrue(db.checkLoggedIn());
//	db.addPhones();
////		db.getAllProducts();
//	}
	@Test
	@Description("Verify the phone count")
	public void phoneCount() throws InterruptedException {
		
		Allure.step("Verifying the loggedin");
		boolean check = db.checkLoggedIn();
		if(check) {
			Allure.step("get the phone count");
			int count = db.getPhonesCount();
			Assert.assertTrue(count>0);
		}
	}
	@Test
	@Description("Verify the laptop count")
	public void laptopCount() throws InterruptedException {
		Allure.step("Verifying the loggedin");
		boolean check = db.checkLoggedIn();
		if(check) {
			Allure.step("get the laptop count");
			int count = db.getLaptopsCount();
			Assert.assertTrue(count>0);
		}
	}
	@Test
	@Description("Verify the mointor count")
	public void mointorCount() throws InterruptedException {
		Allure.step("Verifying the loggedin");
		boolean check = db.checkLoggedIn();
		if(check) {
			Allure.step("get the monitor count");
			int count = db.getMonitorsCount();
			Assert.assertTrue(count>0);
		}
	}


}
