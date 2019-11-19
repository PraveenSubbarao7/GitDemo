package com.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 {
	
	@BeforeTest
	public void startdocker() throws IOException, InterruptedException {
		
		File fi = new File("C:\\\\Users\\\\praveen.subbarao\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\DockerTest\\\\output.txt");
		if(fi.delete()) {
			
			System.out.println("File Deleted Successfully");
		}
		
		StartDocker start = new StartDocker();
		start.startfile();
		
	}
	
	@AfterTest
	public void stopdocker() throws IOException, InterruptedException {
		
		StopDocker stop = new StopDocker();
		stop.stopfile();
		
	}
	@Test
	public void Test1() throws MalformedURLException {
		//Remote WebDriver Class
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL ur = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(ur,cap);
		driver.manage().window().maximize();
		driver.get("http://google.com");
		System.out.println("The title of the page is  " + driver.getTitle());

	}

}
