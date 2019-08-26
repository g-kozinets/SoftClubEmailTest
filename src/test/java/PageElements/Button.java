package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {

    private WebDriver driver;
    private By BUTTON_ID;

    public Button(WebDriver driver, By BUTTON_ID) {
        this.driver = driver;
        this.BUTTON_ID = BUTTON_ID;
    }

    public void click(){
        WebElement button;

        WebDriverWait wait = new WebDriverWait(driver, 5);
        button = wait.until(ExpectedConditions.elementToBeClickable(BUTTON_ID));
        button.click();

    }

    public void setBUTTON_ID(By BUTTON_ID) {
        this.BUTTON_ID = BUTTON_ID;
    }
}
