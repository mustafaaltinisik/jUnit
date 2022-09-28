package MyPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
     /*1. Tarayıcıyı başlatın
        2. 'http://automationexercise.com' url'sine gidin
        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        6. Adı ve e-posta adresini girin
        7. 'Kaydol' düğmesini tıklayın
        8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        13. 'Hesap Oluştur düğmesini' tıklayın
        14. 'HESAP OLUŞTURULDU!' görünür
        15. 'Devam' düğmesini tıklayın
        16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        17. 'Hesabı Sil' düğmesini tıklayın
        18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın

         */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {//driver.close();
    }

    @Test
    public void method1() throws InterruptedException {
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        driver.findElement(By.tagName("h2")).isDisplayed();

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ali");

        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]")).sendKeys("ali155@gmail.com");

        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        driver.findElement(By.xpath("//b")).isDisplayed();
        // 9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        WebElement titelmr=driver.findElement(By.xpath("//*[@id='id_gender1']"));
        WebElement titelmrs=driver.findElement(By.xpath("//*[@id='id_gender2']"));
        if (!titelmr.isSelected()){
            titelmr.click();
        }
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement day=driver.findElement(By.xpath("//*[@id='days']"));
        day.sendKeys("11");
        WebElement months=driver.findElement(By.xpath("//*[@id='months']"));
        months.sendKeys("May");
        WebElement years=driver.findElement(By.xpath("//*[@id='years']"));
        years.sendKeys("1990");
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        WebElement newsletter=driver.findElement(By.xpath("//*[@id='newsletter']"));
        newsletter.isSelected();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        WebElement ortaklar=driver.findElement(By.xpath("//*[@id='optin']"));
        ortaklar.isSelected();
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstname=driver.findElement(By.xpath("//input[@id='first_name']"));
        firstname.sendKeys("ali", Keys.ENTER);
        Thread.sleep(1000);
        WebElement lastname=driver.findElement(By.xpath("//input[@id='last_name']"));
        lastname.sendKeys("can");
        Thread.sleep(1000);
        WebElement company=driver.findElement(By.xpath("//*[@id='company']"));
        company.sendKeys("alicanlar");
        WebElement adres1=driver.findElement(By.xpath("//*[@id='address1']"));
        adres1.sendKeys("yildiz sokak,21");
        Thread.sleep(1000);

        WebElement adres2=driver.findElement(By.xpath("//*[@id='address2']"));
        adres2.sendKeys("ankara cad,10");
        WebElement country=driver.findElement(By.xpath("//*[@id='country']"));
        country.sendKeys("Canada");
        Thread.sleep(1000);
        WebElement state=driver.findElement(By.xpath("//*[@id='state']"));
        state.sendKeys("ahorn");
        WebElement city=driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("bolu");
        WebElement zipCode=driver.findElement(By.xpath("//*[@id='zipcode']"));
        zipCode.sendKeys("35400");
        Thread.sleep(1000);
        WebElement handy=driver.findElement(By.xpath("//*[@id='mobile_number']"));
        handy.sendKeys("123456789");
       // 13. 'Hesap Oluştur düğmesini' tıklayın
        WebElement createAccount=driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]"));
        createAccount.submit();
        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement AccountCreated=driver.findElement(By.xpath("//b"));
        AccountCreated.isDisplayed();
        Thread.sleep(1000);
        //15. 'Devam' düğmesini tıklayın
        WebElement devam=driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        devam.click();
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement logged=driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        logged.isDisplayed();
        Thread.sleep(1000);
        //17. 'Hesabı Sil' düğmesini tıklayın
        WebElement delete=driver.findElement(By.xpath("//*[@class='fa fa-trash-o']"));
        delete.click();
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        WebElement deleteAccount=driver.findElement(By.xpath("//*[text()='Delete Account'][1]"));
        deleteAccount.isDisplayed();





    }


}



