import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SampleTest {


    @Test
    public void site_header_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue((href.isDisplayed()));
        browser.close();}

    }