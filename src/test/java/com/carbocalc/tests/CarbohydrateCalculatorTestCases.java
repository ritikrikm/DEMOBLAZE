package com.carbocalc.tests;

import org.testng.annotations.Test;

import com.carbocalc.base.BaseTest;
import com.carbocalc.pages.CarbohydrateCalculatorPage;

public class CarbohydrateCalculatorTestCases extends BaseTest {

    @Test(description = "TC-001 Carbohydrate Calculator - male, imperial, maintain", enabled = false)
    public void tc001() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-002 Carbohydrate Calculator - female, imperial, lose", enabled = false)
    public void tc002() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-003 Carbohydrate Calculator - male, metric, gain", enabled = false)
    public void tc003() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-004 Carbohydrate Calculator - sedentary level", enabled = false)
    public void tc004() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-005 Carbohydrate Calculator - super active level", enabled = false)
    public void tc005() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-006 Carbohydrate Calculator - activity level progression", enabled = false)
    public void tc006() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-007 Carbohydrate Calculator - lose vs maintain comparison", enabled = false)
    public void tc007() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }

    @Test(description = "TC-008 Carbohydrate Calculator - gain vs maintain comparison", enabled = false)
    public void tc008() {
        CarbohydrateCalculatorPage calculatorPage = new CarbohydrateCalculatorPage(driver());
    }
}
