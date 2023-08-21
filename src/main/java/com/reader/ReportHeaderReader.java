package com.reader;

import java.util.ArrayList;
import java.util.Set;

import com.base.Base;
import com.util.SourceFilePropertyList;
import com.util.TargetFilePropertyList;

public class ReportHeaderReader extends Base {
	/**
	 * Generate the header of the comparison result excel report.
	 * @return an ArrayList containing compared header
	 */
	public ArrayList<String> getReportHeader(){
		
		ArrayList<String> reportHeader = new ArrayList<String>();
		reportHeader.add("OverAllStatus");
		
		SourceFilePropertyList sourceFilePropList = new SourceFilePropertyList();
		ArrayList<String> sourceProperties = sourceFilePropList.getSourcePropertyList();
		
		TargetFilePropertyList targetFilePropList = new TargetFilePropertyList();
		ArrayList<String> targetProperties = targetFilePropList.getTargetPropertyList();
		for(int i =0; i< sourceProperties.size(); i++)
		{
			reportHeader.add("Source_" + sourceProperties.get(i));
			reportHeader.add("Target_" + targetProperties.get(i));
		
		}
		
		
		return reportHeader;

	}

}
