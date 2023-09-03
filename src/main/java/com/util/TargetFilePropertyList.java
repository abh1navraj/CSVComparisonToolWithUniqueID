package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

public class TargetFilePropertyList extends Base{
	
	public ArrayList<String> getTargetFilePropertyList(){
		
		ArrayList<String> targetPropertiesList = new ArrayList<String>();
		
		ArrayList<String> sourceProperties = SourceFilePropertyList.sourcePropertyList;
		
		for(String sourceProperty : sourceProperties)
		{
		
			if(prop.getProperty("csv.sourceProperty." + sourceProperty)!=null)
			{
				targetPropertiesList.add(prop.getProperty("csv.sourceProperty." + sourceProperty));
			}
			else
			{
				targetPropertiesList.add(sourceProperty);
			}
		}
		return targetPropertiesList;
		
	}
	
public ArrayList<String> getTargetFilePropertyList(String targetFileName){
		
	ArrayList<String> targetFileProperties= new ArrayList<String>();
	try {
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(prop.getProperty("csv.targetFilesPath") + "/" + targetFileName));
		String header = bufferedReader.readLine();
		List<String> sourcePropertyListWithUniqueId = Arrays.asList(header.split(","));
		targetFileProperties.addAll(sourcePropertyListWithUniqueId);
		
		targetFileProperties.remove(prop.get("csv.sourceUniqueId"));
	

	} catch (IOException e) {
		System.out.println("Error in Parsing header property from source files.");
		e.printStackTrace();
	}

	return targetFileProperties;
	}


}
