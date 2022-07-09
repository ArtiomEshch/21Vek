package pages.homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class HomePageTest {
    public static HomePage homePage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        driver.get("https://www.21vek.by/");
    }
    @Test
    public void authorizationTest() {
        homePage.openForm()
                .inputLogin("maza2009i@mail.ru")
                .inputPassword("UserP@ssword")
                .submit();

    }
    @Test
    public void searchTest() {
        homePage.search("Смартфон Apple iPhone 11 64GB / MHDA3 (черный)");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(И))
        WebElement element = driver.findElement(By.xpath("//a[@class='result__link j-ga_track']"));
        assertTrue(element.isDisplayed());
    }

//    @Test
//    public void documentationTest (){
//
//        assertTrue();
//    }
//
//    @Test
//    public void basketTest (){
//
//        assertTrue();
//    }

    @AfterAll
    public static void finish (){
        driver.quit();
    }
}