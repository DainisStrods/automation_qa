import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestChrome {
    ChromeDriver driver = new ChromeDriver();

    public static final String GOOGLE_URL = "https://www.google.lv/?hl=en";

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void chromeTest(){

        driver.get(GOOGLE_URL);

        WebElement acceptButton = driver.findElement(By.xpath("//button//div[contains(text(),'Accept all')]"));
        acceptButton.click();

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("acodemy");
        searchField.sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "acodemy - Google Search");
    }
}
