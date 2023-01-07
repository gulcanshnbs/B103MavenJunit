package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown(){
     //https://techproeducation.com
       driver.get("https://techproeducation.com");

    //Sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);

        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


    // Sonra sayfanin üstüne dogru gidelim
    // Yukari cik
    actions.sendKeys(Keys.PAGE_UP).perform();

    //Yukari cik
     actions.sendKeys(Keys.ARROW_UP).perform();
     waitFor(3);









    }
}
