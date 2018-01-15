package SkladAutotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class FirstTest {

  private static WebDriver driver;

  @BeforeClass
  public static void setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://192.168.1.211:8080/");
  }
  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://192.168.1.211:8080/");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("mydpd");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ghi4765");
    driver.findElement(By.cssSelector("#logon > input.user_submit")).click();
    //driver.findElement(By.cssSelector("input.btn")).click();
  }
  @AfterClass
  public static void tearDown() {
    //WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
    //menuUser.click();
    WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"logon\"]/div[2]/input[2]"));
    logoutButton.click();
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    boolean acceptNextAlert = true;
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

//*[@id="logon"]/div[1]/input