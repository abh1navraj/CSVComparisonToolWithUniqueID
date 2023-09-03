package com.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.util.SourceFileNames;
import com.util.TargetFileName;
import com.writer.ExcelReportWriter;

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
			ArrayList<ArrayList<String[]>> comparisonResults =compareCSVWithUniqueID.compareCSVWithUniqueId(sourceFileName, targetFilname);
			ExcelReportWriter excelReportWriter = new ExcelReportWriter();
			excelReportWriter.writeComparisonReportInExcel(sourceFileName, comparisonResults);
		}
		
	}

}
