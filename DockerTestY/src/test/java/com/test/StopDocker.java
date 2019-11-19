package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {
	
	
	public void stopfile() throws IOException, InterruptedException {
		Boolean flag = false;
		Runtime run=Runtime.getRuntime();
		run.exec("cmd /c start dockerstop.bat");
		
		String f = "C:\\Users\\praveen.subbarao\\Documents\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\DockerTest\\output.txt";
		
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopnow = cal.getTimeInMillis();
		Thread.sleep(4000);
		while(System.currentTimeMillis() < stopnow) {
			
			if(flag){
				break;
				
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String currentline=reader.readLine();
			while(currentline !=null && !flag) {
			
			if(currentline.contains("selenium-hub exited")) {
				System.out.println("Found");
				flag=true;
				break;
			}
			 currentline=reader.readLine();
		}
		reader.close();
		}
		
		Assert.assertTrue(flag);
		File fi = new File("C:\\\\Users\\\\praveen.subbarao\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\DockerTest\\\\output.txt");
		if(fi.delete()) {
			
			System.out.println("File Deleted Successfully");
		}
	}

}
