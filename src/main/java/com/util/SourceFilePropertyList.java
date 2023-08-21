package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.base.Base;

public class SourceFilePropertyList extends Base {

	public static ArrayList<String> sourcePropertyList;

	/**
	 * Gets all source property which is to be compare
	 * 
	 * @return an ArrayList containing source property
	 */
	public ArrayList<String> getSourcePropertyList() {
		sourcePropertyList = new ArrayList<String>();
		Set<Object> propertyFileElements = prop.keySet();

		for (Object propertyFileElement : propertyFileElements) {
			if (propertyFileElement.toString().startsWith("csv.sourceProperty.")) {
				sourcePropertyList.add(propertyFileElement.toString().replace("csv.sourceProperty.", ""));
			}
		}

		return sourcePropertyList;
	}

	public ArrayList<String> getSourcePropertyList(String sourceFileName) {
		sourcePropertyList = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(
					new FileReader(prop.getProperty("csv.sourceFilesFolderPath") + "/" + sourceFileName));
			String header = bufferedReader.readLine();
			List<String> sourcePropertyListWithUniqueId = Arrays.asList(header.split(","));
			sourcePropertyList.addAll(sourcePropertyListWithUniqueId);
			System.out.println(sourcePropertyList);
			sourcePropertyList.remove(prop.get("csv.sourceUniqueId"));
			System.out.println(sourcePropertyList);

		} catch (IOException e) {
			System.out.println("Error in Parsing header property from source files.");
			e.printStackTrace();
		}

		return sourcePropertyList;
	}
}
