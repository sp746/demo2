package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHomePage;
import pages.SearchResultsPage;

public class GoogleSearchTest {
    WebDriver driver;
    GoogleHomePage googleHomePage;
    SearchResultsPage searchResultsPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
//    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\subra\\eclipse-workspace\\com.demo\\resources\\chromedriver.exe");
//    	WebDriver driver = new ChromeDriver();

        googleHomePage = new GoogleHomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testGoogleSearch() {
        googleHomePage.openHomePage();
        googleHomePage.searchFor("TV Automation Framework");
        Assert.assertTrue(searchResultsPage.isResultPageDisplayed(), "Search results page is not displayed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}