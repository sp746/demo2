package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class GoogleHomePage {
    private WebDriver driver;
    
    // Locators
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://www.google.com");
    }

    public void searchFor(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchButton).click();
    }
}