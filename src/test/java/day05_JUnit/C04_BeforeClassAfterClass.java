package day05_JUnit;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarinin hepsini ayni anda calistirip
    en son @AfterClass'i calistirir
       Ama sadece @Before ve @After kullanirsak her test icin @Befor ve @aafter'i kullanir.
     */
    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce calisti");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
     @AfterClass
    public static void tearDown(){
         System.out.println("Bütün Testlerden sonra calisti");
         System.out.println("------------------------------");
     }
     @Before
     public void setUo01() {
         System.out.println("Her Test`ten önce calisir");
         System.out.println("-------------------------");
     }

     @After
     public void tearDown01(){
         System.out.println("Her Test'den sonra calisir");
         System.out.println("--------------------------");
     }

     @Test
    public void test01(){
         System.out.println("Ilk Test");
         System.out.println("--------------------------");
     }
     @Test
    public void test02(){
         System.out.println("Ikinci Test");
     }

     @Test
     @Ignore
     public void test03(){
         System.out.println("Ücüncü Test");
     }


}
/*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
    ******       ********      ******
    @BeforeClass--->Test01, Test02, Test03....-->@AfterClass
    Before--> Test01---> After
    Before--> Test02---> After
 */