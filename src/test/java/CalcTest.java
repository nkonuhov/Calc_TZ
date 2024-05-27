import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CalcTest {
    private WebDriver driver;
    private EcalcPage ecalcPage;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
        ecalcPage = new EcalcPage();
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

    @BeforeMethod
    public void clearCalculator() {
        ecalcPage.clickOnClearButton();
    }

    @Test
    public void clearingTest() {
        ecalcPage.clickOnSevenButton();
        ecalcPage.clickOnTwoButton();
        ecalcPage.clickOnClearButton();
        Assert.assertEquals(ecalcPage.getResults(), "0");
    }

    @Test
    public void divZeroTest() {
        ecalcPage.clickOnFiveButton();
        ecalcPage.clickOnDivisionButton();
        ecalcPage.clickOnZeroButton();
        ecalcPage.clickOnEqualsButton();
        Assert.assertEquals(ecalcPage.getResults(), "1");
    }

    @Test
    public void numSumTest() {
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
    }

    @Test
    public void twiceZeroNegativeTest() {
        ecalcPage.clickOnZeroButton();
        Assert.assertNotEquals(ecalcPage.getResults(), "00");
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
