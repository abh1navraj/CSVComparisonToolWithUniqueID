package com.reader;

import java.io.File;

public class PropertiesFilesReader {
	/**
	 * Read all properties files present in configuration folder
	 * @return A file array
	 */
	public File[] getAllPropertiesFile(){
		
		File propertyFileFolder = new File("./Configuration");
		File[] propertiesFiles = propertyFileFolder.listFiles();
		
		return propertiesFiles;
	}
	
	
}
