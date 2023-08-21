package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Properties;

import com.reader.PropertiesFilesReader;

public class Base {
	
	public Properties prop;
	public Instant start;
	
	public Base() {
		try {
			start = Instant.now();
			prop = new Properties();

			PropertiesFilesReader propFilesReader = new PropertiesFilesReader();
			File[] propertiesFiles = propFilesReader.getAllPropertiesFile();
			
			for(File propertiesFile: propertiesFiles) {
				FileInputStream fis = new FileInputStream(propertiesFile);
				
				prop.load(fis);
				
				
			}
		} catch (IOException e) {
			System.out.println("Error in loading properties file");
			e.printStackTrace();
		}
	}
	

}
