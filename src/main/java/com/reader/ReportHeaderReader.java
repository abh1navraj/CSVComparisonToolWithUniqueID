package com.reader;

import java.util.ArrayList;
import java.util.HashMap;

import com.base.Base;
import com.util.HeaderMapper;

public class ReportHeaderReader extends Base {
	/**
	 * Generate the header of the comparison result excel report.
	 * @return an ArrayList containing compared header
	 */
	public ArrayList<String> getReportHeader(String sourceFileName){
		
		ArrayList<String> reportHeader = new ArrayList<String>();
		reportHeader.add("OverAllStatus");
		reportHeader.add(prop.getProperty("csv.sourceUniqueId"));
		reportHeader.add(prop.getProperty("csv.targetUniqueId"));

		
//		ArrayList<String> sourceProperties = SourceFilePropertyList.sourcePropertyList;
		
//		TargetFilePropertyList targetFilePropList = new TargetFilePropertyList();
//		ArrayList<String> targetProperties = targetFilePropList.getTargetFilePropertyList();
		
		HeaderMapper headerMapper = new HeaderMapper();
		ArrayList<String> csvComparisonHeaders = headerMapper.getCSVComparisonHeader(sourceFileName);
		HashMap<String, String> headerMapping = headerMapper.getHeaderMapping(sourceFileName);
		
		for(String csvComparisonHeader: csvComparisonHeaders)
		{
			reportHeader.add("Source_" + csvComparisonHeader);
			reportHeader.add("Target_" + headerMapping.get(csvComparisonHeader));
		
		}
		
		
		return reportHeader;

	}

}
