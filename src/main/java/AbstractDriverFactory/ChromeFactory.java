package AbstractDriverFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeFactory extends AbstractDriverFactory {
	Boolean remote;
	String remoteURL;

	public ChromeFactory(Boolean remote, String url) {
		this.remote = remote;
		this.remoteURL = url;
	}

	public WebDriver getChromeDriver() throws MalformedURLException {
		WebDriver driver = null;

		if (remote) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL(remoteURL), capabilities);

		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return driver;
	}

}