import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcalcPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @FindBy(xpath = "//input[@class='calculator__display']")
    private WebElement inputCalculatorDisplay;
    @FindBy(xpath = "//button[@class='calculator__key calculator__clear del__button']")
    private WebElement clearButton;
    @FindBy(xpath = "//button[@class='calculator__key calculator__backspace action__button']")
    private WebElement arrowButton;
    @FindBy(xpath = "//button[@class='calculator__key calculator__power action__button']")
    private WebElement squareX;
    @FindBy(xpath = "//button[@value='+']")
    private WebElement plusButton;
    @FindBy(xpath = "//button[@value='/']")
    private WebElement divisionButton;
    @FindBy(xpath = "//button[@value='*']")
    private WebElement multiplyButton;
    @FindBy(xpath = "//button[@value='-']")
    private WebElement minusButton;
    @FindBy(xpath = "//button[@class='calculator__key calculator__key--equal equal__button']")
    private WebElement equalsButton;
    @FindBy(xpath = "//button[@value='.']")
    private WebElement dotButton;
    @FindBy(xpath = "//button[@value='0']")
    private WebElement zeroButton;
    @FindBy(xpath = "//button[@value='1']")
    private WebElement oneButton;
    @FindBy(xpath = "//button[@value='2']")
    private WebElement twoButton;
    @FindBy(xpath = "//button[@value='3']")
    private WebElement threeButton;
    @FindBy(xpath = "//button[@value='4']")
    private WebElement fourButton;
    @FindBy(xpath = "//button[@value='5']")
    private WebElement fiveButton;
    @FindBy(xpath = "//button[@value='6']")
    private WebElement sixButton;
    @FindBy(xpath = "//button[@value='7']")
    private WebElement sevenButton;
    @FindBy(xpath = "//button[@value='8']")
    private WebElement eightButton;

    @FindBy(xpath = "//button[@value='9']")
    private WebElement nineButton;

    public EcalcPage() {
        PageFactory.initElements(driver, this);
    }

    public String getResults() {
        return this.inputCalculatorDisplay.getAttribute("value");
    }

    public void clickOnClearButton() {
        this.clearButton.click();
    }

    public void clickOnArrowButton() {
        this.arrowButton.click();
    }

    public void clickOnSquareXButton() {
        this.squareX.click();
    }

    public void clickOnPlusButton() {
        this.plusButton.click();
    }

    public void clickOnMinusButton() {
        this.minusButton.click();
    }

    public void clickOnDivisionButton() {
        this.divisionButton.click();
    }

    public void clickOnMultiplyButton() {
        this.multiplyButton.click();
    }

    public void clickOnEqualsButton() {
        this.equalsButton.click();
    }

    public void clickOnDotButton() {
        this.dotButton.click();
    }

    public void clickOnZeroButton() {
        this.zeroButton.click();
    }

    public void clickOnOneButton() {
        this.oneButton.click();
    }

    public void clickOnTwoButton() {
        this.twoButton.click();
    }

    public void clickOnThreeButton() {
        this.threeButton.click();
    }

    public void clickOnFourButton() {
        this.fourButton.click();
    }

    public void clickOnFiveButton() {
        this.fiveButton.click();
    }

    public void clickOnSixButton() {
        this.sixButton.click();
    }

    public void clickOnSevenButton() {
        this.sevenButton.click();
    }

    public void clickOnEightButton() {
        this.eightButton.click();
    }

    public void clickOnNineButton() {
        this.nineButton.click();
    }


}
