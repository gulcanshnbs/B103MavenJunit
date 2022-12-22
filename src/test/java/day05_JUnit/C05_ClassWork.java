package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //verilen web sayfasina gidin
        //https://the-internet.herokuapp.com/chechboxes
        driver.get("https://the-internet.herokuapp.com/chechboxes");

        //Checkbox1 ve checkbox elementlerini locate edin
        WebElement chechbox1 = driver.findElement(By.xpath("//*[@type=\"checkbox\"]"));
        WebElement chechbox2 = driver.findElement(By.xpath("//*[@type=\"checkbox\"][2]"));

        //Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chechbox1.isSelected()){
            chechbox1.click();
        }
        //Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(300);
        if (!chechbox2.isSelected()){
            chechbox2.click();
        }

    }


}
