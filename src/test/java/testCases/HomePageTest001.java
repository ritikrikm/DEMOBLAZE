package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;





public class HomePageTest001  extends BaseTest {

@Test
public void homeIcon() {
	HomePage hp = new HomePage(driver);
	boolean isPresent = hp.homeIconPresence();
	int carouselItemCount = hp.carouselItem();
	String title = hp.titleCheck();
	Assert.assertEquals(isPresent, true);
	Assert.assertEquals(carouselItemCount, 3);
	Assert.assertEquals(title, "STORE");
}




}
