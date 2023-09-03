package com.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.base.Base;
import com.util.HeaderMapper;
import com.util.TargetFilePropertyList;

public class TargetFileReader extends Base {
	/**
	 * Read the target CSV and put into a HashMap.
	 * @param targetFileName
	 * @return A HashMap<String, HashMap<String, String>> of target CSV data
	 */
	public HashMap<String, HashMap<String, String>> readTargetFile(String targetFileName) {
		HashMap<String, HashMap<String, String>> targetFileData = new HashMap<String, HashMap<String, String>>();

		try {
			File csvData = new File(prop.getProperty("csv.targetFilesPath") + "/" + targetFileName);
			CSVParser parser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).setIgnoreHeaderCase(true).build());
			String targetUniqueId = prop.getProperty("csv.targetUniqueId");

			Map<String, Integer> targetProperties =parser.getHeaderMap();
			targetProperties.remove(targetUniqueId);
//			TargetFilePropertyList targetFilePropList = new TargetFilePropertyList();
//			ArrayList<String> targetProperties = targetFilePropList.getTargetFilePropertyList();
			for (CSVRecord csvRecord : parser) {
				
				
				HashMap<String, String> rowData = new HashMap<String, String> ();
				rowData.put(targetUniqueId, csvRecord.get(targetUniqueId));
				for(String targetProp : targetProperties.keySet())
				{
					
					rowData.put(targetProp, csvRecord.get(targetProperties.get(targetProp)));
					
						
				}
				rowData.put("Flag", "RED");
				targetFileData.put(csvRecord.get(targetUniqueId), rowData);
				
			}

		} catch (IOException e) {
			System.out.println("Unable to Parse Target CSV. Please check the file encoding should be UTF_8");
			e.printStackTrace();
		}
		
		return targetFileData;
	}

}
