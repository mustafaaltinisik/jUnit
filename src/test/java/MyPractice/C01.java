package MyPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
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
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        Thread.sleep(1000);
        driver.findElement(By.tagName("h2")).isDisplayed();Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ali");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]")).sendKeys("ali132@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.tagName("b")).isDisplayed();
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
        newsletter.click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        WebElement ortaklar=driver.findElement(By.xpath("//*[@id='optin']"));
        ortaklar.click();
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstname=driver.findElement(By.xpath("//input[@id='first_name']"));
        firstname.sendKeys("ali", Keys.ENTER);
        WebElement lastname=driver.findElement(By.xpath("//input[@id='last_name']"));
        lastname.sendKeys("can");
        WebElement company=driver.findElement(By.xpath("//*[@id='company']"));
        company.sendKeys("alicanlar");
        WebElement adres1=driver.findElement(By.xpath("//*[@id='address1']"));
        adres1.sendKeys("yildiz sokak,21");














    }
}
