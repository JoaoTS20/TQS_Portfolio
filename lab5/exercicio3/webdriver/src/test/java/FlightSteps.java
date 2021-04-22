import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlightSteps {
    private WebDriver webDriver;

    @When("I navigate to {string}")
    public void iNavigateTo(String arg0) {
        webDriver = new ChromeDriver();
        webDriver.get(arg0);
        webDriver.manage().window().setSize(new Dimension(1920, 1053));
    }

    @And("I choose {string} as the departure city")
    public void iChooseAsTheDepartureCity(String arg0) {
        WebElement dropdown = webDriver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = '"+arg0+"']")).click();

    }

    @And("I choose {string} as the destination city")
    public void iChooseAsTheDestinationCity(String arg0) {
        webDriver.findElement(By.name("fromPort")).click();
        WebElement dropdown = webDriver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = 'Berlin']")).click();
    }

    @And("I click in Find flights")
    public void iClickInFindFlights() {
        webDriver.findElement(By.cssSelector(".btn-primary")).click();

    }

    @And("I choose the {int} th flight")
    public void iChooseTheFlight(int arg0) {
        webDriver.findElement(By.cssSelector("tr:nth-child("+arg0+") .btn")).click();
    }

    @And("I submit the form to purchase the flight")
    public void iSubmitTheFormToPurchaseTheFlight() {
        webDriver.findElement(By.id("inputName")).click();
        webDriver.findElement(By.id("inputName")).sendKeys("André");
        webDriver.findElement(By.id("address")).click();
        webDriver.findElement(By.id("address")).sendKeys("123 ASC");
        webDriver.findElement(By.id("city")).click();
        webDriver.findElement(By.id("city")).sendKeys("Chicago");
        webDriver.findElement(By.id("state")).click();
        webDriver.findElement(By.id("state")).click();
        webDriver.findElement(By.id("state")).sendKeys("Illinois");
        webDriver.findElement(By.id("zipCode")).click();
        webDriver.findElement(By.id("zipCode")).sendKeys("12345");
        webDriver.findElement(By.id("creditCardNumber")).click();
        webDriver.findElement(By.id("creditCardNumber")).sendKeys("123124324");
        webDriver.findElement(By.id("creditCardYear")).click();
        webDriver.findElement(By.id("creditCardYear")).sendKeys("2019");
        webDriver.findElement(By.id("creditCardMonth")).click();
        webDriver.findElement(By.id("creditCardMonth")).sendKeys("12");
        webDriver.findElement(By.id("nameOnCard")).click();
        webDriver.findElement(By.id("nameOnCard")).sendKeys("Josh Smith");
        webDriver.findElement(By.cssSelector(".checkbox")).click();
        webDriver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("Then the page title should start with {string}")
    public void iShouldBeShownResultsIncluding(String arg0) {
        new WebDriverWait(webDriver,2L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("BlazeDemo Confirmation");
            }
        });

    }
    @After()
    public void closeBrowser() {
        webDriver.quit();
    }
}
