package base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    // Tüm test sınıflarımız bu driver üzerinden çalışır
    public static AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setup() {
        try {
            // JSON dosyasından capabilities bilgilerini okur
            Gson gson = new Gson();
            Map<String, String> caps = gson.fromJson(
                    new FileReader("config/capabilities.json"),
                    new TypeToken<Map<String, String>>() {}.getType()
            );

            // DesiredCapabilities nesnesini oluşturur.
            DesiredCapabilities capabilities = new DesiredCapabilities();
            for (Map.Entry<String, String> entry : caps.entrySet()) {
                capabilities.setCapability(entry.getKey(), entry.getValue());
            }

            // Appium sunucusuna bağlanır. (localhost)
            driver = new AndroidDriver<>(
                    new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities
            );

            // Global timeout süresi (10 saniye)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println("Appium başlatılırken hata oluştu: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        // Her test sonrası driver'ı kapatır
        if (driver != null) {
            driver.quit();
        }
    }
}


