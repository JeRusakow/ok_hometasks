package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SimpleTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static FeedPage feedPage;

    private static String userLogin = "technoPol21";
    private static String userPassword = "technoPolis2022";
    private static String userName = "technoPol21 technoPol21";

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jegor\\IdeaProjects\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest(){
        driver.get("https://ok.ru");
        loginPage = new LoginPage(driver);

        loginPage.inputLogin(userLogin);
        loginPage.inputPassword(userPassword);
        loginPage.clickLoginButton();

        feedPage = new FeedPage(driver);
        assert feedPage.getUserName().equals(userName);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
