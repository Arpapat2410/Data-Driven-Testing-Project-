import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC4_UpDown {
    
    private WebDriver driver;
    private String baseUrl;
    private String googleUsername = "644259044@webmail.npru.ac.th";
    private String googlePassword = "1739902024001";
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); // Update the path
        driver = new ChromeDriver();
        baseUrl = "http://localhost:3000";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testClickButtonUp() throws Exception {
        openWebsite();
        verifySignInGoogle();
        viewArticle1();
        clickButtonUp();
    }
    
    @Test
    public void testClickButtonDown() throws Exception {
        openWebsite();
        verifySignInGoogle();
        viewArticle2();
        clickButtonDown();
    }
    
    private void openWebsite() {
        driver.get(baseUrl);
    }

    private void verifySignInGoogle() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/button[1]/a")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button[1]")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(googleUsername);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(googlePassword);
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    private void viewArticle1() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/a[2]")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    private void viewArticle2() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/a[2]")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    private void clickButtonUp() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[4]/div[1]/div[1]/button")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    private void clickButtonDown() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[4]/div[1]/button")).click();
        TimeUnit.SECONDS.sleep(2);
    }
}
