package com.util;

import java.io.File;

import com.base.Base;

public class SourceFileNames extends Base{
	/**
	 * This method will read all source CSVs from the sourceFiles folder.
	 * @return A String array containing all source file names present in source folder.
	 */
	public String[] getSourceFileNames(){
		
		String[] sourceFileNames;
		File folder = new File(prop.getProperty("csv.sourceFilesFolderPath"));
		sourceFileNames = folder.list();
		for(String sourceFile: sourceFileNames)
		System.out.println(sourceFile);
		return sourceFileNames;
	}

}
