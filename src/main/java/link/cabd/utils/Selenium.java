package link.cabd.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Selenium {

    public ChromeOptions setUpChromeOptions() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless"); //background mode
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1920,1080");

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 1920);
        deviceMetrics.put("height", 1080);
        deviceMetrics.put("pixelRatio", 3.0);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("resolution", "1920x1080");

        chromeOptions.merge(caps);
        return chromeOptions;
    }
}
