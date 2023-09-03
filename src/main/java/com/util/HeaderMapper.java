package com.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.base.Base;

public class HeaderMapper extends Base {

//	public static ArrayList<String> extraTargetHeader = null;
//	public static ArrayList<String> csvComparisonHeaders = null;

	/**
	 * Gets all target CSV properties mapped to Source CSV Properties
	 * 
	 * @return
	 */
	public HashMap<String, String> getHeaderMapping(String sourceFileName) {
		HashMap<String, String> headerMapping = new HashMap<String, String>();

		HeaderMapper headerMapper = new HeaderMapper();
		ArrayList<String> csvComparisonHeaders = headerMapper.getCSVComparisonHeader(sourceFileName);

		for (String csvComparisonHeader : csvComparisonHeaders) {

			if (prop.getProperty("csv.sourceProperty." + csvComparisonHeader) != null) {
				headerMapping.put(csvComparisonHeader, prop.getProperty("csv.sourceProperty." + csvComparisonHeader));
			} else {
				headerMapping.put(csvComparisonHeader, csvComparisonHeader);
			}
		}

		
		return headerMapping;
	}

	public ArrayList<String> getCSVComparisonHeader(String sourceFileName) {

		TargetFileName targetfileName = new TargetFileName();
		String targetFileName = targetfileName.getTargetFileName(sourceFileName);

		SourceFilePropertyList sourceFilePropertyList = new SourceFilePropertyList();
		ArrayList<String> sourceFileProperties = sourceFilePropertyList.getSourcePropertyList(sourceFileName);

		TargetFilePropertyList targetFilePropertyList = new TargetFilePropertyList();
		ArrayList<String> targetProperties = targetFilePropertyList.getTargetFilePropertyList(targetFileName);
		
		HeaderMapper headerMapper = new HeaderMapper();
		
		ArrayList<String> csvComparisonHeaders = new ArrayList<String>();
		if (prop.get("csv.ComparisonType").equals("ALL_HEADERS")) {

			for (String sourceProperty : sourceFileProperties) {
				csvComparisonHeaders.add(sourceProperty);
				if (prop.get("csv.sourceProperty." + sourceProperty) != null)
					targetProperties.remove(prop.get("csv.sourceProperty." + sourceProperty));
				else
					targetProperties.remove(sourceProperty);

			}

			for (String targetProperty : targetProperties) {
				csvComparisonHeaders.add(targetProperty);
			}
		}
		if(prop.get("csv.ComparisonType").equals("DEFAULT") || prop.get("csv.ComparisonType").equals("COMMON_HEADERS") || prop.get("csv.ComparisonType").equals(null))
		{
			
			for (String sourceProperty : sourceFileProperties) {
				
				if (prop.get("csv.sourceProperty." + sourceProperty) != null)
				{
					csvComparisonHeaders.add(sourceProperty);
				}
				else if(headerMapper.checkHeaderPropertyExistsInTargetCSV(sourceProperty, targetProperties))
				{
					csvComparisonHeaders.add(sourceProperty);
				}

			}

		}
		
		if(prop.get("csv.ComparisonType").equals("SOURCE_HEADERS_ONLY"))
		{
			
			csvComparisonHeaders = sourceFileProperties;
		}
		
		if(prop.get("csv.ComparisonType").equals("MENTIONED_HEADERS_ONLY"))
		{
			csvComparisonHeaders = sourceFilePropertyList.getSourcePropertyList();
		}

		
		return csvComparisonHeaders;

	}
	
	public boolean checkHeaderPropertyExistsInTargetCSV(String property, ArrayList<String> targetProperties)
	{
		for(String targetProperty: targetProperties)
		{
			if(targetProperty.equals(property))
			{
				return true;
			}
		}
		return false;
	}
}
