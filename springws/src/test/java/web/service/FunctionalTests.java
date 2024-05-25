package web.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class FunctionalTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin_ValidCredentials() {
        driver.get("http://localhost:8080/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));

        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");

        WebElement loginButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        loginButton.click();

        WebElement successMessage = driver.findElement(By.tagName("h2"));
        Assert.assertNotNull(successMessage);
    }

    @Test
    public void testLogin_InvalidCredentials() {
        driver.get("http://localhost:8080/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));

        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPass");

        WebElement loginButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div['Incorrect credentials.']"));
        Assert.assertNotNull(errorMessage);
    }

    @Test
    public void testQ1_Add_ValidInputs() {
        driver.get("http://localhost:8080/q1");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement addField = driver.findElement(By.id("result"));
        number1Field.sendKeys("5");
        number2Field.sendKeys("3");
        addField.sendKeys("8");

        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement resultMessage = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(resultMessage.getText().contains("Q2"));
    }

    @Test
    public void testQ1_Add_InvalidInput() {
        driver.get("http://localhost:8080/q1");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement addField = driver.findElement(By.id("result"));
        number1Field.sendKeys("1");
        number2Field.sendKeys("5");
        addField.sendKeys("8");
        
        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement tryagainMessage = driver.findElement(By.xpath("//div['Wrong answer, try again.']"));
        Assert.assertNotNull(tryagainMessage);
    }

    @Test
    public void testQ1_Add_EmptyInput() {
        driver.get("http://localhost:8080/q1");

        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(errorMessage.getText().contains("Whitelabel Error Page"));

    }

    @Test
    public void testQ2_Subtract_ValidInputs() {
        driver.get("http://localhost:8080/q2");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement subtractField = driver.findElement(By.id("result"));
        number1Field.sendKeys("10");
        number2Field.sendKeys("4");
        subtractField.sendKeys("6");
        
        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement resultMessage = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(resultMessage.getText().contains("Q3"));
    }

    @Test
    public void testQ2_Subtract_InvalidInput() {
        driver.get("http://localhost:8080/q2");

        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement subtractField = driver.findElement(By.id("result"));
        number1Field.sendKeys("10");
        number2Field.sendKeys("20");
        subtractField.sendKeys("10");

        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement tryagainMessage = driver.findElement(By.xpath("//div['Wrong answer, try again.']"));
        Assert.assertNotNull(tryagainMessage);
    }

    @Test
    public void testQ2_Subtract_EmptyInput() {
        driver.get("http://localhost:8080/q2");

        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(errorMessage.getText().contains("Whitelabel Error Page"));
    }

    @Test
    public void testFlow_ValidSequence() {
        driver.get("http://localhost:8080/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");
        WebElement loginButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        loginButton.click();

        driver.get("http://localhost:8080/q1");
        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement addField = driver.findElement(By.id("result"));
        number1Field.sendKeys("5");
        number2Field.sendKeys("3");
        addField.sendKeys("8");
        WebElement submitButton1 = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton1.click();

        driver.get("http://localhost:8080/q2");
        WebElement number1FieldQ2 = driver.findElement(By.id("number1"));
        WebElement number2FieldQ2 = driver.findElement(By.id("number2"));
        WebElement subtractField = driver.findElement(By.id("result"));
        number1FieldQ2.sendKeys("10");
        number2FieldQ2.sendKeys("4");
        subtractField.sendKeys("6");
        WebElement submitButton2 = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton2.click();

        WebElement resultMessage = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(resultMessage.getText().contains("Q3"));
    }

    @Test
    public void testFlow_InvalidQ1Input() {
        driver.get("http://localhost:8080/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");
        WebElement loginButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        loginButton.click();

        driver.get("http://localhost:8080/q1");
        WebElement number1Field = driver.findElement(By.id("number1"));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement addField = driver.findElement(By.id("result"));
        number1Field.sendKeys("abc");
        number2Field.sendKeys("3");
        addField.sendKeys("8");
        WebElement submitButton = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(errorMessage.getText().contains("Whitelabel Error Page"));
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
