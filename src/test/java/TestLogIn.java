import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import webDriver.WebDriverFactory;

public class TestLogIn {
    @Test

    public void testLogInFuncionality() {
        String email = "todorovicmilos2020@gmail.com";
        String password = "123456789";

        //System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        // WebDriver driver = new ChromeDriver();
      WebDriver driver = WebDriverFactory.getDriver();

        driver.get("http://automationpractice.com/index.php");

        try {
            HomePage homePage = new HomePage(driver);

            LogInPage logInPage = homePage.clickSignInLink();

            Thread.sleep(3000);
            logInPage.typeEmail(email)
                    .typePassword(password);
            Thread.sleep(3000);

            driver.findElement(By.id("SubmitLogin")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[@class='account']")).click();
            Thread.sleep(5000);

            String actualUrl = "http://automationpractice.com/index.php?controller=my-account";
            String expectedUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl);
            if (actualUrl.equalsIgnoreCase(expectedUrl)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}