package com.compare;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.base.Base;
import com.reader.TargetFileReader;
import com.util.SourceFilePropertyList;

public class CompareCSVWithUniqueId extends Base {

	/**
	 * Compare source CSV and target CSV using unique ID.
	 * @param sourceFileName
	 * @param targetFileName
	 * @return An ArrayList<ArrayList<String[]>> containing the comparison results.
	 */
	public ArrayList<ArrayList<String[]>> compareCSVWithUniqueId(String sourceFileName, String targetFileName) {

		ArrayList<ArrayList<String[]>> comparisonResult = new ArrayList<ArrayList<String[]>>();
		System.out.println("I am in the comaprison class");
		try {
			File csvData = new File(prop.getProperty("csv.sourceFilesFolderPath") + "/" + sourceFileName);
			
			CSVParser sourceParser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).setIgnoreHeaderCase(true).build());
			SourceFilePropertyList sourceFilePropertyList = new SourceFilePropertyList();
			ArrayList<String> sourceProperties = (prop.getProperty("csv.headerMappingExist").equalsIgnoreCase("true"))?sourceFilePropertyList.getSourcePropertyList():sourceFilePropertyList.getSourcePropertyList(sourceFileName);
			TargetFileReader targetFileReader = new TargetFileReader();
			HashMap<String, HashMap<String, String>> targetFileData = targetFileReader.readTargetFile(targetFileName);
			int i =0;
			String sourceUniqueId = prop.getProperty("csv.sourceUniqueId");
			String targetUniqueId = prop.getProperty("csv.targetUniqueId");

			System.out.println(sourceUniqueId + " "+ targetUniqueId);
			for (CSVRecord csvSourceRecord : sourceParser) {
				
				System.out.println("comparing:"+ i++);
				ArrayList<String[]> recordComparisonResult = new ArrayList<String[]>();
				
				String[] uniqueIdComparisonResult = new String[3];
				String uniqueKey = csvSourceRecord.get(sourceUniqueId);
				
				uniqueIdComparisonResult[0] = uniqueKey;
				uniqueIdComparisonResult[1] = targetFileData.get(uniqueKey).get(targetUniqueId);
				uniqueIdComparisonResult[2] = uniqueKey
						.equals(targetFileData.get(uniqueKey).get(targetUniqueId)) ? "Pass" : "Fail";
				recordComparisonResult.add(uniqueIdComparisonResult);

				for (String sourceProperty : sourceProperties) {
					String[] propComparisonResult = new String[3];
					propComparisonResult[0] = csvSourceRecord.get(sourceProperty);
					propComparisonResult[1] = targetFileData.get(uniqueKey).get(prop.getProperty("csv.sourceProperty."+sourceProperty));
					propComparisonResult[2] = csvSourceRecord.get(sourceProperty).equals(
							targetFileData.get(uniqueKey).get(prop.getProperty("csv.sourceProperty."+sourceProperty))) ? "Pass" : "Fail";
					recordComparisonResult.add(propComparisonResult);

				}

				comparisonResult.add(recordComparisonResult);

			}
		} catch (Exception e) {
			System.out.println("failed in comparing");
			e.printStackTrace();
			
		}
		for(ArrayList<String[]> comp: comparisonResult)
		{
			for(String[] s: comp)
			{
				for(String st:s)
				{
					System.out.print(st+" ");
				}
				System.out.print(" | ");
			}
		System.out.println();
		}
		return comparisonResult;
	}
}