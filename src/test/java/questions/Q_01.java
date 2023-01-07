package questions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q_01 extends TestBase {


    @Test
    public void test01(){

    //1) Tarayıcıyı açın
    //2) "http://practice.automationtesting.in/" URL'sini girin
        driver.get("http://practice.automationtesting.in/");

    //3) Mağaza Menüsüne tıklayın

        WebElement shopButton = driver.findElement(By.xpath("//*[id='Shop']"));
        waitFor(3);

    //4) Şimdi Ana menü düğmesine tıklayın


    //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin

    //6) Ana sayfa yalnızca üç Varış içermelidir

    //7) Şimdi Gelenler bölümündeki resme tıklayın

    //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.

    //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.

    //10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın

    //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.

    //12) Şimdi, ödeme sayfasına ilerlemek için gezinen Öğe bağlantısına tıklayın.

    //13) Kullanıcı, kitabı sepete ekledikten sonra, ödeme sayfasına yönlendiren menü öğesindeki Öğe bağlantısına tıklayabilir.



     }
}
