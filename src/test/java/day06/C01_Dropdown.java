package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    // Eger test sinifinda birden fazla method olusturulmussa, @Before kullanilir
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void selectByIndexTest(){
        //Given kullanici https://testcentre.techproeducation.com/index.php?page=dropdown sayfasindayken
        //Dogum yilini, ayini ve gününü su seklde secer: 200, January, 10
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //1.LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2.SELECT objesi olustur
        Select yearDropdown = new Select(year);

        //3.Select objecti kullanarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(23);  //SECENEK SIRASI 0 dan baslar. 2000 yili 23.sirada

        // Ay secimi

        //Ay Secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//option in value degeri ile secim yapilabilir. January seceneinin value si 0

        //Gun secimi selectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE -

    }
    @Test
    public void printAllTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //Tüm elayet isimlerini consola yazdiralim
        WebElement state = driver.findElement(By.xpath("//select [@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
        for (WebElement eachState : stateList){
            System.out.println(eachState.getText());
        }
       // stateList.stream().forEach(t-> System.out.println(t.getText()));
    }
        @Test
        public void getSelectedOptionsTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);

        WebElement varsayilanElement = stateDropdown.getFirstSelectedOption();
        String varsiyalnElementText = varsayilanElement.getText();

        String varsiyalText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals("Select a State", varsiyalText);
    }

    //

    /*
    1. Whatdrop nedir? What is Dropdown
    Dropdown liste olusturmak icin kullanilir.
    2. Dropdown nasil automate edilir? How to handle dropdown elements
      - dropdown i locale ederim
      - select objesi olustururum
      -select objesi ile istedigim secenegi secerim
      NOT: select objesi olusturma nedenim, dropdownlarin Selecct class i ile olusturulur
    3.Tum dropdown seceneklerini nasil print ederiz?
      -tum dropdown elementlerini getOptions() methodu ile listeye koyariz
      -sonra secenekleri loop ile yazdirabiliriz
    4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
      Örnek:Gun olarak 10 i secdik ama ya secilmediyse?
            getFirstSelectedOption() secili olan secenegi return eder
     */




}
