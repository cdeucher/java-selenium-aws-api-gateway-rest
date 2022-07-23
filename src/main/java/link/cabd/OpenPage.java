package link.cabd;

import link.cabd.entity.Title;
import link.cabd.utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static link.cabd.utils.ApiRequest.sendPost;

public class OpenPage {
    private static ChromeDriver driver;
    private static WebDriverWait wait;

    private static Library library = new Library();

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver","/opt/homebrew/bin/geckodriver");
        Selenium selenium = new Selenium();
        ChromeOptions chromeOptions = selenium.setUpChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,120);

        driver.get("https://www.amazon.com.br/s?k=light+novel&sprefix=light+%2Caps%2C183&ref=nb_sb_ss_ts-doa-p_1_6");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("s-ref-price-range")));

        checkPage(library);
        driver.quit();

        sendPost(library.getListOfTitles());
    }

    private static void checkPage(Library library) {
        List<WebElement> page = library.loadPage(driver);
        List<Title> listOfTittles = library.getTitles(page);
        printLog(listOfTittles);
    }

    private static void printLog(List<Title> library) {
        library.forEach(title -> {
            System.out.println(title.getText() + ": " + title.getSymbol()+" "+title.getPrice());
            System.out.println(title.getType() + ": " + title.getUrl());
            System.out.println("-----------------------------------------------------");
        });
    }
}
