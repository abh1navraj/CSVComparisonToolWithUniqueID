package com.compare;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.base.Base;
import com.reader.DatePropertyReader;
import com.reader.TargetFileReader;
import com.util.DatesUtil;
import com.util.HeaderMapper;
import com.util.TargetCSVMissingRecord;

public class CompareCSVWithUniqueId extends Base {

	/**
	 * Compare source CSV and target CSV using unique ID.
	 * 
	 * @param sourceFileName
	 * @param targetFileName
	 * @return An ArrayList< ArrayList < String[]>> containing the comparison results.
	 */
	public ArrayList<ArrayList<String[]>> compareCSVWithUniqueId(String sourceFileName, String targetFileName) {

		ArrayList<ArrayList<String[]>> comparisonResult = new ArrayList<ArrayList<String[]>>();
		HashMap<String, HashMap<String, String>> targetFileData = null;
		ArrayList<String> dateProperties = null;
		int recordNo = 0;

		try {
			File csvData = new File(prop.getProperty("csv.sourceFilesFolderPath") + "/" + sourceFileName);

			CSVParser sourceParser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.DEFAULT.builder()
					.setHeader().setSkipHeaderRecord(true).setIgnoreHeaderCase(true).build());

			HeaderMapper headerMapper = new HeaderMapper();
			ArrayList<String> csvcomparisonProperties = headerMapper.getCSVComparisonHeader(sourceFileName);
			if (prop.getProperty("dateFieldPresent").equalsIgnoreCase("true")) {
				DatePropertyReader datePropertyReader = new DatePropertyReader();
				dateProperties = datePropertyReader.readDateProperties();
			}

			HashMap<String, String> headerPropertyMap = headerMapper.getHeaderMapping(sourceFileName);

			TargetFileReader targetFileReader = new TargetFileReader();
			targetFileData = targetFileReader.readTargetFile(targetFileName);

			String sourceUniqueId = prop.getProperty("csv.sourceUniqueId");
			String targetUniqueId = prop.getProperty("csv.targetUniqueId");

			
			for (CSVRecord csvSourceRecord : sourceParser) {

				System.out.println("comparing :::: " + recordNo++);
				ArrayList<String[]> recordComparisonResult = new ArrayList<String[]>();

				String[] uniqueIdComparisonResult = new String[3];
				String uniqueKey = csvSourceRecord.get(sourceUniqueId);
				if (targetFileData.get(uniqueKey) != null) {
					targetFileData.get(uniqueKey).put("Flag", "Green");
					uniqueIdComparisonResult[0] = uniqueKey;
					uniqueIdComparisonResult[1] = targetFileData.get(uniqueKey).get(targetUniqueId);
					uniqueIdComparisonResult[2] = uniqueKey.equals(targetFileData.get(uniqueKey).get(targetUniqueId))
							? "Pass"
							: "Fail";
					recordComparisonResult.add(uniqueIdComparisonResult);

					for (String csvcomparisonProperty : csvcomparisonProperties) {

						String[] propComparisonResult = new String[3];
						if (prop.getProperty("dateFieldPresent").equalsIgnoreCase("true") && dateProperties.contains(csvcomparisonProperty)) {
							propComparisonResult[0] = (csvSourceRecord.isMapped(csvcomparisonProperty))
									? csvSourceRecord.get(csvcomparisonProperty)
									: "";
							propComparisonResult[1] = (targetFileData.get(uniqueKey)
									.get(headerPropertyMap.get(csvcomparisonProperty)) != null)
											? targetFileData.get(uniqueKey).get(
													headerPropertyMap.get(csvcomparisonProperty))
											: "";
							DatesUtil dateUtil = new DatesUtil();
							propComparisonResult[2] = dateUtil.compareDateProperty(propComparisonResult[0], csvcomparisonProperty, propComparisonResult[1], headerPropertyMap.get(csvcomparisonProperty));
									
							recordComparisonResult.add(propComparisonResult);
						} else {
							propComparisonResult[0] = (csvSourceRecord.isMapped(csvcomparisonProperty))
									? csvSourceRecord.get(csvcomparisonProperty)
									: "";
							propComparisonResult[1] = (targetFileData.get(uniqueKey)
									.get(headerPropertyMap.get(csvcomparisonProperty)) != null)
											? targetFileData.get(uniqueKey).get(
													headerPropertyMap.get(csvcomparisonProperty))
											: "";
							propComparisonResult[2] = propComparisonResult[0].equals(propComparisonResult[1]) ? "Pass"
									: "Fail";
							recordComparisonResult.add(propComparisonResult);
						}

					}

					comparisonResult.add(recordComparisonResult);

				} else {

					uniqueIdComparisonResult[0] = uniqueKey;
					uniqueIdComparisonResult[1] = "Record not Found";
					uniqueIdComparisonResult[2] = "Record is not present in Target CSV";
					recordComparisonResult.add(uniqueIdComparisonResult);

					for (String csvcomparisonProperty : csvcomparisonProperties) {

						String[] propComparisonResult = new String[3];
						propComparisonResult[0] = (csvSourceRecord.isMapped(csvcomparisonProperty))
								? csvSourceRecord.get(csvcomparisonProperty)
								: "";
						propComparisonResult[1] = "Record not Found";
						propComparisonResult[2] = "Record is not present in Target CSV";
						recordComparisonResult.add(propComparisonResult);

					}

					comparisonResult.add(recordComparisonResult);

				}
			}

		} catch (Exception e) {
			System.out.println("failed in comparing");
			e.printStackTrace();

		}

		TargetCSVMissingRecord targetCSVMissingRecord = new TargetCSVMissingRecord();
		targetCSVMissingRecord.addTargetCSVMissingRecordToComparisonResult(comparisonResult, targetFileData,
				sourceFileName, recordNo);

		return comparisonResult;
	}
}
