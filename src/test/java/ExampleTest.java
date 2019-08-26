import DTO.TestData;
import Drivers.DriverFirefox;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;


public class ExampleTest {

    private TestData testData = new TestData();
    private WebDriver driver;
    private String url = "https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/";
    private String address = testData.email;
    private String subject = testData.subject;
    private String text = testData.text;
    private LoginPage loginPage;
    private String applicationTitle = "Gmail";

    private String login = testData.email;
    private String pass = testData.password;


    @BeforeSuite
    public void setUp() {
        driver = DriverFirefox.getInstance();
        driver.get(url);
        loginPage = new LoginPage(driver);

    }

    //Вход в аккаунт перед тестом на отправку письма и выход из аккаунта
    @BeforeGroups("send and sign out")
    public void signIn() {
        loginPage.doLogin(login, pass);
    }

    //Выход из аккаунта после теста на вход
    @AfterGroups("sign in")
    public void signOut() {
        MainPage mainPage = new MainPage(driver);
        mainPage.doSignOut();
    }


    //Тест на проверку входа в аккаунт
    @Test(groups = "sign in")
    public void shouldSignIn() {
        loginPage.doLogin(login, pass);

        WebElement applicationName = driver.findElement(By.xpath("/html/head/meta[@content='Gmail']"));
        Assert.assertEquals(applicationName.getAttribute("content"), applicationTitle);
    }

    //Тест на проверку выхода из аккаунта
    @Test
    public void shouldSignOut() {
        loginPage.doLogin(login, pass);

        signOut();

        Assert.assertEquals(driver.getTitle(), "Gmail");
    }

    //Тест на проверку отправки письма
    @Test(groups = "send and sign out")
    public void shouldSendLetter() {
        MainPage mainPage = new MainPage(driver);
        mainPage.sendLetter(address, subject, text);

        Assert.assertEquals(mainPage.getFirstLetter(), (address + " " + subject + " - \n" + text));
        signOut();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        DriverFirefox.destroyInstance();
    }

}

