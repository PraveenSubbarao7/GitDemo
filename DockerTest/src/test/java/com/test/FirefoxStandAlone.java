package com.test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxStandAlone {

	public static void main(String[] args) throws MalformedURLException {
		//Remote WebDriver Class
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		URL ur = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(ur,cap);
		driver.manage().window().maximize();
		driver.get("http://google.com");
		System.out.println("The title of the page is  " + driver.getTitle());

	}

}
