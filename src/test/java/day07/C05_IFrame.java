package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {
    @Test
    public void iframeTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        //tag[.='metin']; Bana bu tagli metni ver
        //tag[text()='metin'];
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));
        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. ilk iframe e switch yapiyoruz

        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1 = "Applications lists";
        Assert.assertEquals(expectedText1, icMetin);

        //Alternatif olarak altdaki secenekler de kullanilabilir
        //Assert.assertTrue(expectedText1.contains(icMetin));
        //Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());


        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        //Ana sayfadaki Povered By yazisini test etmek istiyorum ama driver hala iframin icinde
        //Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame

        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
}
 /*
  1.) Bir sayfadaki toplam iframe sayisini nasil buluruz? Iframeler iframe tagi kullanilarak olusturulur.
       Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
       -driver.findElements(By.tagName("im"));
       -driver.findElements(By:xpath("//iframe"));


   2.) Tekrar ana sayfaya nasil döneriz?
        Iki farkli yol vardir. defaultConted yada parentFrame metotlarini kullanarak gecis yapabiliriz.
        dafaultConted ve parentFrame arasindaki farklar nelerdir?
        Ikiside framain disina cikmamizi saygalar. ama  defaultConted direkt ana sayfaya atlatir,
        parentFrame ise bir üst seviyeye atlatir.


   3.) Bir test case in fail etme sebepleri neler olabilir?
      - Yanlis locator. Cözüm: Tekrar elementi locale etmek. Degisken element var ise ona gore dynamic bir xpath yazariz.
      - Wait/Syncronization/Bekleme problemo. Cözüm: Implicit wait de yeterli süre oldugundan emin oluruz. O süreyi
        arttirabiliriz. 30 saniye verilebilir. Explicit kullanilabilir(sonra gore).
      - Iframe. Cözüm: switch to iframe
      - Alert.  Cözüm: switch to alert
      - New window (Yeni pencere): switch to window



  */