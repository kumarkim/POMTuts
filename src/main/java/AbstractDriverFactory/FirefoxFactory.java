package AbstractDriverFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxFactory extends AbstractDriverFactory {

	Boolean remote;
	String remoteURL;

	FirefoxFactory(Boolean remote, String url) {
		this.remote = remote;
		this.remoteURL = url;
	}

	public WebDriver getFireFoxDriver() throws MalformedURLException {
		WebDriver driver = null;
		
		if (remote) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL(remoteURL), capabilities);

		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		return driver;
	}

}
