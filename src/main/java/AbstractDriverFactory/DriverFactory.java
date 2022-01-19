package AbstractDriverFactory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverFactory {

	public WebDriver creatDriver(String type ,Boolean remote, String url ) throws MalformedURLException;

}
