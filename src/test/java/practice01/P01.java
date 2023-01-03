package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    //-"amazin.com" adresine gidelim
    //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
    //-Ardindan "trendyol.com" adresine gidelim
    //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    //-Bi onceki web sayfamiza geri donelim
    //-sayfayi yenileyelim
    //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa Basligi : "+actualTitle);
        System.out.println("Sayfa Url'i : "+actualUrl);

        Assert.assertFalse(actualTitle.contains("spend") && actualUrl.contains("spend"));

        driver.get("https://trendyol.com");

        String trendyolTitel = driver.getTitle();
        Assert.assertTrue(trendyolTitel.contains("Sitesi"));

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();
        driver.quit();          //Birden fazla sayfa calismis ise quit() method kullanilir


    }

}
