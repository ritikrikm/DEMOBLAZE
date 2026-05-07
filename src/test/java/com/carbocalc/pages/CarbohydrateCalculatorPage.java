package com.carbocalc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.carbocalc.base.BasePage;

public class CarbohydrateCalculatorPage extends BasePage {

    @FindBy(xpath = "//input[@value='imperial']")
    private WebElement imperialUnitOption;

    @FindBy(xpath = "//input[@value='metric']")
    private WebElement metricUnitOption;

    @FindBy(id = "csex1")
    private WebElement maleOption;

    @FindBy(id = "csex2")
    private WebElement femaleOption;

    @FindBy(id = "cage")
    private WebElement ageInput;

    @FindBy(id = "cheightfeet")
    private WebElement heightFeetInput;

    @FindBy(id = "cheightinch")
    private WebElement heightInchInput;

    @FindBy(id = "cheightmeter")
    private WebElement heightCmInput;

    @FindBy(id = "cpound")
    private WebElement weightPoundsInput;

    @FindBy(id = "ckg")
    private WebElement weightKgInput;

    @FindBy(name = "cactivity")
    private WebElement activityDropdown;

    @FindBy(name = "cgoal")
    private WebElement goalDropdown;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(css = "div[class*='bigtext']")
    private WebElement resultHeader;

    public CarbohydrateCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void chooseImperialUnits() {
        click(imperialUnitOption);
    }

    public void chooseMetricUnits() {
        click(metricUnitOption);
    }

    public void selectMale() {
        click(maleOption);
    }

    public void selectFemale() {
        click(femaleOption);
    }

    public void enterAge(String age) {
        type(ageInput, age);
    }

    public void enterImperialHeight(String feet, String inches) {
        type(heightFeetInput, feet);
        type(heightInchInput, inches);
    }

    public void enterMetricHeight(String centimeters) {
        type(heightCmInput, centimeters);
    }

    public void enterWeightInPounds(String pounds) {
        type(weightPoundsInput, pounds);
    }

    public void enterWeightInKg(String kilograms) {
        type(weightKgInput, kilograms);
    }

    public void chooseActivityLevel(String activityValue) {
        activityDropdown.sendKeys(activityValue);
    }

    public void chooseGoal(String goalValue) {
        goalDropdown.sendKeys(goalValue);
    }

    public void clickCalculate() {
        click(calculateButton);
    }

    public String readResultHeader() {
        return read(resultHeader);
    }
}
