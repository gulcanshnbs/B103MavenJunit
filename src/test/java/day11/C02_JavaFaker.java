package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javaFakerTest(){
        //1.Faker Objesi olusturulur
        Faker faker = new Faker();
        //2.Faker objesi ile fake data olustur
        faker.name().firstName();

        //first name datasi
        String fName = faker.name().firstName();
        System.out.println(fName);

        //last name datasi
        String lName = faker.name().lastName();
        System.out.println(lName);

        //kullanci adi
        String username = faker.name().username();
        System.out.println(username);

        //meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //full adress
        System.out.println(faker.address().fullAddress());

        // cep no
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());

        //posta codu
        System.out.println(faker.address().zipCode());

        //rastgele 15 haneli numara
        System.out.println(faker.number().digits(15));

        /*
        Test Data: kullanici adi, sifre, tel no,email, sehir, kredi kart no,....
        Test datalari kimden alinir?
        1. BA-Bussines analyst /Acceptance Criteria lari yazar)
        2. Test Lead
        3. Manual Tester
        4. Tech Lead & Team Lead & Dev Lead
        5. Developer
        6. Database
        7. API call lar
        8. Documantasyonlar. Ognegin, API swagger documani
        9. Java Faker da fake data almak icin kullaniyoruz


        Nereden gelmez: kullanicidan, scrum master

         */


    }
}
