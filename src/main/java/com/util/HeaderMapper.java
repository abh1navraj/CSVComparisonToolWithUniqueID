package com.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.base.Base;

public class HeaderMapper extends Base {

	/**
	 * Gets all target CSV properties mapped to Source CSV Properties
	 * 
	 * @return
	 */
	public HashMap<String, String> getHeaderMapping(String sourceFileName) {
			HashMap<String, String> headerMapping = new HashMap<String, String>();
			
			SourceFilePropertyList sourceFilePropertyList = new SourceFilePropertyList();
			ArrayList<String> sourceProperties = (prop.getProperty("csv.compareOnlyMentionedProperty").equalsIgnoreCase("true"))?sourceFilePropertyList.getSourcePropertyList():sourceFilePropertyList.getSourcePropertyList(sourceFileName);
			
			for(String sourceProperty : sourceProperties)
			{
			
				if(prop.getProperty("csv.sourceProperty." + sourceProperty)!=null)
				{
					headerMapping.put(sourceProperty, prop.getProperty("csv.sourceProperty." + sourceProperty));
				}
				else
				{
					headerMapping.put(sourceProperty, sourceProperty);
				}
			}


		return headerMapping;
	}
}
