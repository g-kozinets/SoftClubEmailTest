package PageObjects;

import PageElements.Button;
import PageElements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final By LOGIN_INPUT = By.xpath("//*[@id=\"identifierId\"]");
    private static final By PASSWORD_INPUT = By.xpath("//input[@type='password']");
    private static final By SUBMIT_LOGIN_BUTTON = By.xpath("//*[@id=\"identifierNext\"]/span");
    private static final By SUBMIT_PASS_BUTTON = By.xpath("//*[@id=\"passwordNext\"]/span");
    private static final By PROFILE_IDENTIFIER = By.id("profileIdentifier");
    private static final By CHANGE_ACCOUNT = By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div > div > form > span > section > div > div > div > div > ul > li:nth-child(2)");

    private WebDriver driver;
    private InputField inputField = new InputField();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeLogin(String login) {
        inputField.sendInput(driver, LOGIN_INPUT, login);
    }

    public void typePassword(String password) {
        inputField.sendInput(driver, PASSWORD_INPUT, password);
    }

    public void clickSubmit(By buttonType) {
        Button submitButton = new Button(driver, buttonType);
        submitButton.click();
    }



    public void doLogin(String login, String password) {
        typeLogin(login);
        clickSubmit(SUBMIT_LOGIN_BUTTON);
        typePassword(password);
        clickSubmit(SUBMIT_PASS_BUTTON);
    }

    public void doFullSignOut(){
        new Button(driver, PROFILE_IDENTIFIER).click();
        new Button(driver, CHANGE_ACCOUNT).click();

    }


}
