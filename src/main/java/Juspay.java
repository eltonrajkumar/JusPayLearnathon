import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Juspay {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.in");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("twotabsearchtextbox")
                )
        );

        search.click();
        search.sendKeys("Air pump for football");

        driver.findElement(By.id("nav-search-submit-button")).click();

        String originalTab = driver.getWindowHandle();

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='s-image'])[2]"))
        );
        product.click();


        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(By.id("buy-now-button")));
        buy.click();
        driver.findElement(By.id("ap_email_login")).sendKeys("8089264xxxx");
        driver.findElement(By.className("a-button-input")).click();
        driver.findElement(By.id("ap_password")).sendKeys("password");
        driver.findElement(By.id("signInSubmit")).submit();

        WebElement addAddress = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("add-new-address-desktop-sasp-tango-link")
                )
        );

        addAddress.click();

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.id("address-ui-widgets-enterAddressFullName")));
        name.sendKeys("Elton Rajkumar");
        driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("8089264228");
        driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("691504");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Raj castle");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("Punukanoor perumpuzha");
        driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("Elampaloor");
        driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Kollam");
        WebElement stateDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
                )
        );

        Select select = new Select(stateDropdown);

        select.selectByVisibleText("KERALA");


        WebElement useAddress = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[aria-labelledby='checkout-primary-continue-button-id-announce']")
                )
        );

        useAddress.click();


        WebElement cardOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[normalize-space()='Credit or debit card']")
                )
        );

        cardOption.click();
        WebElement clickcard = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[normalize-space()='Add a new credit or debit card']")
                )
        );


        clickcard.click();
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[name='ApxSecureIframe']")
        ));

        WebElement cardNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("addCreditCardNumber"))
        );
        cardNumber.sendKeys("4830 xxxx 3371 xxxx");

        WebElement nickname = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("ppw-accountHolderName"))
        );
        nickname.clear();
        nickname.sendKeys("Elton Rajkumar");


        driver.findElement(
                By.xpath("(//span[contains(@class,'a-dropdown-prompt')])[1]")
        ).click();


        driver.findElement(
                By.xpath("//a[normalize-space()='02']")
        ).click();


        driver.findElement(
                By.xpath("(//span[contains(@class,'a-dropdown-prompt')])[2]")
        ).click();


        driver.findElement(
                By.xpath("//a[normalize-space()='2032']")
        ).click();





        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("ppw-widgetEvent:AddCreditCardEvent")
                )
        );

        continueButton.click();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[name='apx-secure-field-addCreditCardVerificationNumber']")
        ));

        WebElement cvv = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("field"))
        );
        cvv.sendKeys("entercvv");
        driver.switchTo().defaultContent();
        WebElement useAddressButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[data-testid='bottom-continue-button']")
                )
        );
        useAddressButton.click();
        WebElement continueWithoutSaving = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@type='submit' and following-sibling::span[contains(.,'Continue without saving')]]")
                )
        );

        continueWithoutSaving.click();


        WebElement useButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[aria-labelledby='checkout-primary-continue-button-id-announce']")
                )
        );

        useButton.click();
        driver.switchTo().defaultContent();








    }
}
