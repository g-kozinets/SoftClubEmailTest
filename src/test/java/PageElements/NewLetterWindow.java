package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс для взаимодействия с окном создания нового сообщения
public class NewLetterWindow {

    private WebDriver driver;
    private InputField addressField;
    private InputField subjectField;
    private InputField textField;
    private static final By SEND_BUTTON = By.cssSelector(".aDh .IZ .btC .gU.Up .J-J5-Ji.btA");
    private static final By ADDRESS_FIELD = By.cssSelector(".oj div textarea");
    private static final By SUBJECT_FIELD = By.cssSelector(".aoD.az6 .aoT");
    private static final By TEXT_FIELD = By.cssSelector(".Ar.Au div");

    public NewLetterWindow(WebDriver driver){
        this.driver = driver;
        addressField = new InputField();
        subjectField = new InputField();
        textField = new InputField();

    }

    public void inputAddress(String address) {
        addressField.sendInput(driver, ADDRESS_FIELD, address);

    }

    public void inputSubject(String subject) {
        subjectField.sendInput(driver, SUBJECT_FIELD, subject);
    }

    public void inputText(String text){
        textField.sendInput(driver, TEXT_FIELD, text);

    }

    public  void clickSend(){
        new Button(driver, SEND_BUTTON).click();

        //Проверка успешной отправки на двух языках
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            Boolean confirmation = wait.until(ExpectedConditions.textToBe(By.cssSelector(".nH .J-J5-Ji .vh .bAq"), "Письмо отправлено."));

        }catch (TimeoutException e){
            Boolean confirmation = wait.until(ExpectedConditions.textToBe(By.cssSelector(".nH .J-J5-Ji .vh .bAq"), "Message sent."));
        }
    }


}
