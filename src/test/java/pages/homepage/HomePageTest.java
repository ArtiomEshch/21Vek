package pages.homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    }
    @Test
    public void authorizationTest() {
        driver.get("https://www.21vek.by/");
        homePage.openForm()
                .inputLogin("maza2009i@mail.ru")
                .inputPassword("UserP@ssword")
                .submit();
    }
    @Test
    public void searchTest() {
        driver.get("https://www.21vek.by/");
        homePage.search("Смартфон Apple iPhone 11 64GB / MHDA3 (черный)");
        assertTrue(driver.findElement(By
                .xpath("//div[@id=\"content\"]/div[1]/h1[text()='Результаты поиска']")).isDisplayed());
    }

    @Test
    public void documentationTest (){
        driver.get("https://www.21vek.by/");
        homePage.openPublicOffer();
        assertTrue(driver.findElement(By.xpath("//h1[text()='Договор публичной оферты']")).isDisplayed());
    }

    @Test
    public void changeCityTest (){
        driver.get("https://www.21vek.by/");
        driver.findElement(By.xpath("//span[text()='г. Минск']")).click();
        driver.findElement(By.xpath("//input[@label='Населенный пункт']")).click();
        driver.findElement(By.xpath("//div[text()='Гродно']")).click();
        driver.findElement(By.xpath("//input[@label='Населенный пункт']")).submit();
        assertTrue(driver.findElement(By.xpath("//span[text()='г. Гродно']")).isDisplayed());
    }

    @AfterAll
    public static void finish (){
        driver.quit();
    }
}