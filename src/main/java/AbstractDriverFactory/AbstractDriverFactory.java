package AbstractDriverFactory;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.constants.SeleniumConstants;

import AbstractDriverFactory.DriverFactory;

public class AbstractDriverFactory  implements DriverFactory{

	@Override
	public WebDriver creatDriver(String type, Boolean remote, String remoteURL) throws MalformedURLException {
		
		if(type.equals(SeleniumConstants.CHROME)) {
			DesiredCapabilities cCapabilities = new DesiredCapabilities();
			cCapabilities.setBrowserName(BrowserType.CHROME);
			return new ChromeFactory(remote,remoteURL).getChromeDriver();
		}

		else if(type.equals(SeleniumConstants.FIREFOX)) {
			DesiredCapabilities fcapabilities = new DesiredCapabilities();
			fcapabilities.setBrowserName(BrowserType.FIREFOX);
			return new FirefoxFactory(remote,remoteURL).getFireFoxDriver();
		}	
		else 
		return null;		
	}



}
