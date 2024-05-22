import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CalcTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    private void loadProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
    }

    private void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(System.getProperty("site.url"));
        EcalcPage.setDriver(driver);
    }

    @Test
    public void clearingTest() {
        EcalcPage ecalcPage = new EcalcPage();

        ecalcPage.clickOnSevenButton();
        ecalcPage.clickOnTwoButton();
        ecalcPage.clickOnClearButton();
        Assert.assertEquals(ecalcPage.getResults(), "0");
    }

    @Test
    public void divZeroTest() {
        EcalcPage ecalcPage = new EcalcPage();

        ecalcPage.clickOnFiveButton();
        ecalcPage.clickOnDivisionButton();
        ecalcPage.clickOnZeroButton();
        ecalcPage.clickOnEqualsButton();
        Assert.assertEquals(ecalcPage.getResults(), "Infinity");
        ecalcPage.clickOnClearButton();
    }

    @Test
    public void numSumTest() {
        EcalcPage ecalcPage = new EcalcPage();

        ecalcPage.clickOnOneButton();
        ecalcPage.clickOnPlusButton();
        ecalcPage.clickOnTwoButton();
        ecalcPage.clickOnThreeButton();
        ecalcPage.clickOnPlusButton();
        ecalcPage.clickOnFourButton();
        ecalcPage.clickOnFiveButton();
        ecalcPage.clickOnSixButton();
        ecalcPage.clickOnEqualsButton();
        Assert.assertEquals(ecalcPage.getResults(), "480");
        ecalcPage.clickOnClearButton();
    }

    @Test
    public void twiceZeroNegativeTest() {
        EcalcPage ecalcPage = new EcalcPage();

        ecalcPage.clickOnZeroButton();
        Assert.assertNotEquals(ecalcPage.getResults(), "00");
        ecalcPage.clickOnClearButton();

    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
