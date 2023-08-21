package com.compare;

import java.util.Arrays;
import java.util.Iterator;

import com.util.SourceFileNames;
import com.util.TargetFileName;

public class CSVCompareApp {

	public static void main(String[] args) {
		SourceFileNames sourceFileNames = new SourceFileNames();
		String[] sourceFiles = sourceFileNames.getSourceFileNames();
		
		Iterator<String> iterate = Arrays.asList(sourceFiles).iterator();

		while(iterate.hasNext())
		{
			String sourceFileName = iterate.next();
			System.out.println(sourceFileName);
			TargetFileName targetFileName = new TargetFileName();
			String targetFilname = targetFileName.getTargetFileName(sourceFileName);
			CompareCSVWithUniqueId compareCSVWithUniqueID = new CompareCSVWithUniqueId();
			compareCSVWithUniqueID.compareCSVWithUniqueId(sourceFileName, targetFilname);
		}
		
	}

}
