package com.util;

import com.base.Base;

public class TargetFileName extends Base {
	
	/**
	 * Gets the target File name with which source file has to be compared
	 * @param sourceFileName
	 * @return targetFileName
	 */
	public String getTargetFileName(String sourceFileName) {
		
		String targetFileName;
		
		targetFileName = prop.getProperty("csv.sourceFilename."+sourceFileName);
		
		if(targetFileName==null)
		{
			targetFileName = sourceFileName;
		}
		return targetFileName;
	}
}
