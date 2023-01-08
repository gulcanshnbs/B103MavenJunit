package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        //Start buttonuna tıkla
        //Hello World! Yazının sitede oldugunu test et

    @Test
    public void expicitWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttona tikla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        Assert.assertEquals("Hello World", helloWorldElement.getText());
        //Implicit wait ile test case calismadi
        //cözüm explicit wait de

        // Web<driver objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait objesini kullanarak bekleme problemini cözmeyi calis
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!" , helloWorldText);
    }

}
