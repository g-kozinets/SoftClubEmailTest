package PageObjects;

import PageElements.Button;
import PageElements.Letter;
import PageElements.NewLetterWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private Button btnAccountIcon;
    private Button btnSignOut;
    private Button btnNewLetter;
    private NewLetterWindow newLetterWindow;
    private WebElement lettersTable;

    public MainPage(WebDriver driver){
        this.driver = driver;
        btnAccountIcon = new Button(driver, By.cssSelector(".gb_Zc .gb_Ja.gb_hd.gb_Bg.gb_g.gb_Lf .gb_z.gb_Ia.gb_g .gb_Ba.gbii"));
        btnSignOut = new Button(driver, By.id("gb_71"));
        btnNewLetter = new Button(driver, By.cssSelector(".nM .aic .z0 .T-I.J-J5-Ji.T-I-KE.L3"));
    }

    public void doSignOut(){
        waitLoading();
        btnAccountIcon.click();
        btnSignOut.click();
        new LoginPage(driver).doFullSignOut();
    }

    public void sendLetter(String address, String subject, String text) {
        waitLoading();
        btnNewLetter.click();
        newLetterWindow = new NewLetterWindow(driver);
        newLetterWindow.inputAddress(address);
        newLetterWindow.inputSubject(subject);
        newLetterWindow.inputText(text);
        newLetterWindow.clickSend();

    }

    public String getFirstLetter(){
        lettersTable = driver.findElement(By.cssSelector(".UI .aDP"));
        Letter letter = new Letter(lettersTable);

        return letter.toString();
    }

    private void waitLoading(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Boolean loading = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading > div:nth-child(2) > div.msg")));
    }
}
