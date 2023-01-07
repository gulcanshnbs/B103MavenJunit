package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    /*
    MANUAL:
    1. Amazon home sayfasina git
    2. Account & list e uzerinde bekle
    3.Acilan pencerede Account linkine tokla
    4.Acilan sayfanin Title inin, your Account oldugunu dogrula
    */


    @Test
    public void hoverOverTest(){
        driver.get("https:www.amazon.com/");

    //1. Actions Objesi
        Actions actions = new Actions(driver);

    //2. Elemani bul
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);

    //3. Uygun Acttions methodunu kullan. En sinra perform kullanmayi unutma
         actions.moveToElement(accountList).perform();
         waitFor(3);

    //4.Acilan pencerede Account linkine tokla
         driver.findElement(By.id("Account")).click();

    //4. Acilan sayfanin Title inin, your Account oldugunu dogrula
        Assert.assertTrue(driver.getTitle().contains("You Account"));
    }

    //Class: Actions2
    //Method : hoverOver() and test the following scenario:
    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan “Account & Lists” menüsüne git
    //“Account” secenegine tikka
    //Acilan sayfanin Title in “Your Account” icerdigini dogrula
}
