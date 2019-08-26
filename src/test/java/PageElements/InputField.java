package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputField {

    public void sendInput(WebDriver driver, By INPUT_FIELD_ID, String keys){
        WebElement inputField;

        WebDriverWait wait = new WebDriverWait(driver, 8);
        inputField = wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD_ID));
        inputField.sendKeys(keys);

    }
}
