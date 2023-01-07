package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
    // 1. Actions Objesi Olustur
        Actions actions = new Actions(driver);

    // 2. Elementi locale edelim
        WebElement kutu =driver.findElement(By.id("hot-spot"));

    // 3. Kutuya sag tiklayin
        actions.contextClick(kutu).perform();



    //Alert’te cikan yazinin “You selected a context menu” oldugunu
    //Object olusturmak wait gerekdiren durumlarda makul
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

    // Tamam diyerek alert'i kapatin
      driver.switchTo().alert().accept();



    }
    //Class: Actions1
    //Method: rightClick
    //https://the-internet.herokuapp.com/context_menu  sitesine gidin
    //Kutuya sag tıklayın
    //Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edin
    //Tamam diyerek alert’i kapatın

}
