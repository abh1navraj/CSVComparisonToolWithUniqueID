package com.util;

import java.util.ArrayList;

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

}
