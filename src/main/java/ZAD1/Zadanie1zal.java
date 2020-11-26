package ZAD1;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Zadanie1zal {

    private WebDriver driver;


    @Given("open browser")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
    }

    @When("user log-in")
    public void loginToMyStore() {

        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.clear();
        inputEmail.sendKeys("cv@v.pl");


        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.clear();
        inputPassword.sendKeys("12345678");
        inputPassword.submit();

        WebElement clickSingIn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span"));
        clickSingIn.click();

        WebElement inputFirstName = driver.findElement(By.name("firstname"));
        inputFirstName.clear();
        inputFirstName.sendKeys("Andrew");

        WebElement inputLastName = driver.findElement(By.name("lastname"));
        inputLastName.clear();
        inputLastName.sendKeys("Golota");
    }

    @And("create new address and input (.*), (.*), (.*), (.*)")
    public void addressInput(String address, String city, String postalCode, String phone) {


        WebElement inputAddress = driver.findElement(By.name("address1"));
        inputAddress.clear();
        inputAddress.sendKeys(address);


        WebElement inputZipcode = driver.findElement(By.name("postcode"));
        inputZipcode.clear();
        inputZipcode.sendKeys(postalCode);

        WebElement inputCity = driver.findElement(By.name("city"));
        inputCity.clear();
        inputCity.sendKeys(city);

        WebElement inputPhone = driver.findElement(By.name("phone"));
        inputPhone.clear();
        inputPhone.sendKeys(phone);


        WebElement findCountry = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]"));
        findCountry.click();

        WebElement submitAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        submitAddress.click();

    }


         }
    //}

   //@After
  // public void tearDown() throws Exception {

   //   driver.quit();
  //  }
