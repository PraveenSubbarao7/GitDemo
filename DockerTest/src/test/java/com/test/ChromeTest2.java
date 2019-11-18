package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2 {
	@Test
	public void Test2() throws MalformedURLException {
		//Remote WebDriver Class
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL ur = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(ur,cap);
		driver.manage().window().maximize();
		driver.get("http://gmail.com");
		System.out.println("The title of the page is  " + driver.getTitle());

	}

}
