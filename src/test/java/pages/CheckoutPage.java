package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCustomerInformation(String first, String last, String zip) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstName)
        ).sendKeys(first);

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(lastName)
        ).sendKeys(last);

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(postalCode)
        ).sendKeys(zip);

        wait.until(
            ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public void finishOrder() {
        wait.until(
            ExpectedConditions.elementToBeClickable(finishButton)
        ).click();
    }

    public String getConfirmationMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(completeHeader)
        ).getText();
    }
}
