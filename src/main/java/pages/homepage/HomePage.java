package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final String PAGE_URL = "https://www.21vek.by/";
    private final String ACCOUNT_BTN = "//span[@class='userToolsText']";
    private final String SIGNIN_BTN = "//button[@title='Вход']";
    private final String LOGIN_FIELD = "//input[@label='Электронная почта']";
    private final String PASSWORD_FIELD = "//input[@label='Пароль']";

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void open (){
        driver.get(PAGE_URL);
    }
    public HomePage openForm (){
        driver.findElement(By.xpath(ACCOUNT_BTN)).click();
        driver.findElement(By.xpath(SIGNIN_BTN)).click();
        return this;
    }
    public HomePage inputLogin (String login){
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(login);
        return this;
    }

    public HomePage inputPassword (String password){
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
        return this;
    }

    public void search (String request){
        driver.findElement(By.id("catalogSearch"))
                .sendKeys(request);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[@class='Search_searchBtn__3fSOy']"))))
                .click();
    }

    public HomePage openBasket (){

        return this;
    }

    public HomePage openDocumentation (){

        return this;
    }

    public HomePage submit (){
        driver.findElement(By.xpath(PASSWORD_FIELD)).submit();
        return this;
    }

    public void openPublicOffer (){
        driver.findElement(By.xpath("//a[@href='/services/public_offer.html']")).click();
    }

}
