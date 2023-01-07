package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest(){
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);  //User/techproed/IdeaPrjects/B103MavenJUnit

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);

        //logo.jpeg indirip MASAÜSTÜNE kaydedin

        String dosyaYolu = userHome +"/Desktop/logo.jpeg.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(isExist);


    }
}
