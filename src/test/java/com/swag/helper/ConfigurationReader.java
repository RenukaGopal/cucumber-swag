package com.swag.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	Properties ps;
	public ConfigurationReader() throws IOException {
		File f = new File("C:\\Users\\krishna\\eclipse-workspace\\login\\src\\test\\java\\com\\swag\\helper\\swag.property");
		FileInputStream fin = new FileInputStream(f);
		ps = new Properties();
		ps.load(fin);
	}
	public String launchBrowser() {
		String browsername = ps.getProperty("Browser");
		return browsername;
		
	}
	public String browserUrl() {
		String address = ps.getProperty("Url");
		return address;
		
	}

}
