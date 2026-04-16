package pageObject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "logout2")
    WebElement logoutNav;

    @FindBy(id = "nameofuser")
    WebElement welcomeTextNav;

    @FindBy(xpath = "//a[normalize-space()='Phones']")
    WebElement phoneCategory;

    @FindBy(xpath = "//a[normalize-space()='Laptops']")
    WebElement laptopCategory;

    @FindBy(xpath = "//a[normalize-space()='Monitors']")
    WebElement monitorCategory;

    @FindBy(xpath = "(//a[@class='hrefch'])[1]")
    WebElement firstProductLink;

    private By productsBy = By.xpath("//div[@id='tbodyid']/div");
    private By productNamesBy = By.xpath("//a[@class='hrefch']");

    public boolean checkLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(logoutNav));
        wait.until(ExpectedConditions.visibilityOf(welcomeTextNav));

        return logoutNav.isDisplayed()
                && welcomeTextNav.getText().trim().startsWith("Welcome ");
    }

    public int getAllProducts() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productsBy, 0));
        return driver.findElements(productsBy).size();
    }

    public int getPhonesCount() {
        return getCategoryProductCount(phoneCategory);
    }

    public int getLaptopsCount() {
        return getCategoryProductCount(laptopCategory);
    }

    public int getMonitorsCount() {
        return getCategoryProductCount(monitorCategory);
    }

    public void productClick() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductLink)).click();
    }
    public boolean addPhones() {
    	return addEveryProduct(phoneCategory);
    }
    private boolean addEveryProduct(WebElement categoryElement) {
        wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productNamesBy, 0));

        List<WebElement> initialProducts = driver.findElements(productNamesBy);

        for (WebElement product : initialProducts) {
            String name = product.getText().trim();

            By productByName = By.xpath("//a[@class='hrefch' and normalize-space()='" + name + "']");

            wait.until(ExpectedConditions.elementToBeClickable(productByName)).click();

            ProductPage pp = new ProductPage(driver);
            pp.addToCart();

            driver.navigate().back();
            driver.navigate().back();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productNamesBy, 0));
        }

        return true;
    }
    private int getCategoryProductCount(WebElement categoryElement) {
        List<String> oldNames = getCurrentProductNames();

        wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();

        wait.until(driver -> {
            List<String> newNames = getCurrentProductNames();
            return !newNames.isEmpty() && !newNames.equals(oldNames);
        });

        int count = driver.findElements(productsBy).size();
        System.out.println(categoryElement.getText() + " count = " + count);
        System.out.println("Products = " + getCurrentProductNames());

        return count;
    }

    private List<String> getCurrentProductNames() {
        return driver.findElements(productNamesBy)
                .stream()
                .map(e -> e.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }
}