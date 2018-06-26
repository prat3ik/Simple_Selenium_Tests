import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase {

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get("https://chn-host.neocodesoftware.com/chn-host-family-application/?step=1");

        driver.findElement(By.cssSelector(".new_app.login_or_new")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first_name")))).sendKeys("1");
        driver.findElement(By.id("last_name")).sendKeys("1");
        new Select(driver.findElement(By.name("primary_gender"))).selectByValue("Female");
        new Select(driver.findElement(By.id("primary_age_range"))).selectByValue("20-29");
        driver.findElement(By.id("primary_occupation")).sendKeys("1");
        driver.findElement(By.id("primary_email")).sendKeys((Math.random()*10)+"@111.com");
        driver.findElement(By.id("primary_home_phone_areacode")).sendKeys("111");
        driver.findElement(By.id("primary_home_phone_exchange")).sendKeys("222");
        driver.findElement(By.id("primary_home_phone_line")).sendKeys("3333");
        driver.findElement(By.id("street")).sendKeys("1");
        driver.findElement(By.id("city")).sendKeys("1");
        driver.findElement(By.id("postal_code")).sendKeys("111");
        new Select(driver.findElement(By.cssSelector(".field.province.one-third.first>.required_field"))).selectByValue("BC");
        new Select(driver.findElement(By.cssSelector(".field.region.one-third.second>.required_field"))).selectByIndex(5);
        driver.findElement(By.id("high_school")).sendKeys("1");
        driver.findElement(By.cssSelector(".next-link>.pn-btn")).click();

        WebElement descriptionEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("description"))));
        org.testng.Assert.assertTrue(descriptionEl.isDisplayed());

    }

}
