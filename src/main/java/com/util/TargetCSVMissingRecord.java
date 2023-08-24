package com.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.base.Base;

public class TargetCSVMissingRecord extends Base{

	public ArrayList<ArrayList<String[]>> addTargetCSVMissingRecordToComparisonResult(
			ArrayList<ArrayList<String[]>> comparisonResult, HashMap<String, HashMap<String, String>> targetFileData) {

		ArrayList<String> sourceProperties = SourceFilePropertyList.sourcePropertyList;
		String targetUniqueId = prop.getProperty("csv.targetUniqueId");

		for (String key : targetFileData.keySet()) {
			if (targetFileData.get(key).get("Flag").equals("RED")) {
				
				ArrayList<String[]> targetCSVMissingRecord = new ArrayList<String[]>();
				String[] uniqueIdComparisonResult = new String[3];
				uniqueIdComparisonResult[0] = "Record not Found";
				uniqueIdComparisonResult[1] = targetFileData.get(key).get(targetUniqueId);
				uniqueIdComparisonResult[2] = "Record is not present in Source CSV";
				targetCSVMissingRecord.add(uniqueIdComparisonResult);
				
				for (String sourceProperty : sourceProperties) {
					
					String[] propComparisonResult = new String[3];
					propComparisonResult[0] = "Record not Found";
					propComparisonResult[1] = targetFileData.get(key).get(sourceProperty);
					propComparisonResult[2] = "Record is not present in Source CSV";
					targetCSVMissingRecord.add(propComparisonResult);
				}
				
				comparisonResult.add(targetCSVMissingRecord);
			}
		}

		return comparisonResult;
	}

}
