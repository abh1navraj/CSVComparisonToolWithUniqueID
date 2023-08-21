package com.util;

import java.util.ArrayList;
import java.util.Set;

import com.base.Base;

public class TargetFilePropertyList extends Base {

	/**
	 * Gets all target CSV properties mapped to Source CSV Properties
	 * 
	 * @return
	 */
	public ArrayList<String> getTargetPropertyList() {
		ArrayList<String> sourceProperties = new ArrayList<String>();
		ArrayList<String> targetProperties = new ArrayList<String>();
//		if (prop.getProperty("csv.headerMappingExist").equalsIgnoreCase("true")) {
			sourceProperties = SourceFilePropertyList.sourcePropertyList;
			for (String sourceProperty : sourceProperties) {
				targetProperties.add(prop.getProperty("csv.sourceProperty." + sourceProperty));
			}
//		} else {
//
//		}

		return targetProperties;
	}
}
